package com.thurainx.foodninja.features.splash

import android.window.SplashScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.thurainx.foodninja.R
import com.thurainx.foodninja.core.Routes
import com.thurainx.foodninja.features.components.FoodPatternBackground
import com.thurainx.foodninja.features.components.LogoAndText
import com.thurainx.foodninja.ui.theme.*
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(navController: NavController) {

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LogoAndText()
        }
        FoodPatternBackground()

    }

    LaunchedEffect(key1 = Unit){
        delay(2000L)
        navController.popBackStack()
        navController.navigate(Routes.IntroductionOneScreen)
    }

}



@Composable
@Preview(showBackground = true)
fun SplashScreenPreview(navController: NavController = rememberNavController()){
    SplashScreen(navController)
}