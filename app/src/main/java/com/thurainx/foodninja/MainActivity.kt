package com.thurainx.foodninja

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.thurainx.foodninja.core.Routes
import com.thurainx.foodninja.features.splash.SplashScreen
import com.thurainx.foodninja.features.intro.IntroductionOneScreen
import com.thurainx.foodninja.features.intro.IntroductionTwoScreen
import com.thurainx.foodninja.ui.theme.FoodNinjaTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
// Remember a SystemUiController

            FoodNinjaTheme {
                // A surface container using the 'background' color from the theme

                val systemUiController = rememberSystemUiController()
                val useDarkIcons = !isSystemInDarkTheme()
                val background = MaterialTheme.colors.background

                DisposableEffect(systemUiController, useDarkIcons) {
                    // Update all of the system bar colors to be transparent, and use
                    // dark icons if we're in light theme
                    systemUiController.setSystemBarsColor(
                        color = background,
                        darkIcons = useDarkIcons
                    )

                    // setStatusBarColor() and setNavigationBarColor() also exist

                    onDispose {}
                }

                val navController = rememberAnimatedNavController()
                AnimatedNavHost(navController = navController, startDestination = Routes.SplashScreen,
                    enterTransition = {
                        slideIntoContainer(AnimatedContentScope.SlideDirection.Left, animationSpec = tween(700))
                    },
                    popExitTransition = {
                        slideOutOfContainer(AnimatedContentScope.SlideDirection.Right, animationSpec = tween(700))
                    },
                    popEnterTransition = { EnterTransition.None }
                ){
                    composable(route = Routes.SplashScreen){
                        SplashScreen(navController = navController)
                    }
                    composable(route = Routes.IntroductionOneScreen){
                        IntroductionOneScreen(navController = navController)
                    }
                    composable(route = Routes.IntroductionTwoScreen){
                        IntroductionTwoScreen(navController = navController)
                    }
                }

            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun DefaultPreview() {
    FoodNinjaTheme {
        Greeting("Android")
    }
}