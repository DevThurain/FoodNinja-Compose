package com.thurainx.foodninja.features.intro

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.thurainx.foodninja.R
import com.thurainx.foodninja.core.Routes
import com.thurainx.foodninja.features.components.GradientButton
import com.thurainx.foodninja.ui.theme.*

@Composable
fun IntroductionTwoScreen(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painterResource(id = R.drawable.intro_food_2),
            "",
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.58f),
            contentScale = ContentScale.Fit
        )
        Text(
            text = "Food Ninja is Where Your\nComfort Food Lives",
            style = TextStyle(
                color = MaterialTheme.colors.onPrimary,
                fontSize = TEXT_REGULAR_3X,
                fontFamily = Bentonsans
            ),
            textAlign = TextAlign.Center,
            lineHeight = TEXT_HEADING_1X
        )
        Box(modifier = Modifier.height(MARGIN_LARGE))
        Text(
            text = "Enjoy a fast and smooth food delivery at\nyour doorstep",
            style = TextStyle(
                color = MaterialTheme.colors.onPrimary,
                fontSize = TEXT_REGULAR,
                textAlign = TextAlign.Center,
                lineHeight = TEXT_REGULAR_3X
            )
        )
        Box(modifier = Modifier.height(MARGIN_LARGE))
        GradientButton(text = "Next", modifier = Modifier.wrapContentWidth()){
            navController.navigate(Routes.RegisterScreen)
        }
    }
}

@Composable
@Preview(showBackground = true)
fun IntroductionTwoScreenPreview(navController: NavController = rememberNavController()){
    IntroductionTwoScreen(navController = navController)
}