package com.thurainx.foodninja.features.intro

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.thurainx.foodninja.R
import com.thurainx.foodninja.core.Routes
import com.thurainx.foodninja.features.components.GradientButton
import com.thurainx.foodninja.ui.theme.*

@Composable
fun IntroductionOneScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painterResource(id = R.drawable.intro_food_1),
            "",
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.58f),
            contentScale = ContentScale.Fit
        )
        Text(
            text = "Find your Comfort\nFood Here",
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
            text = "Here You Can find a chef or dish for every\ntaste and color. Enjoy!",
            style = TextStyle(
                color = MaterialTheme.colors.onPrimary,
                fontSize = TEXT_REGULAR,
                textAlign = TextAlign.Center,
                lineHeight = TEXT_REGULAR_3X
            )
        )
        Box(modifier = Modifier.height(MARGIN_LARGE))
        GradientButton(text = "Next", modifier = Modifier.wrapContentWidth()){
            navController.navigate(Routes.IntroductionTwoScreen)
        }
    }
}


//@Composable
//@Preview(showBackground = true)
//fun IntroductionOneScreenPreview(navController: NavController = rememberNavController()){
//    IntroductionOneScreen(navController = navController)
//}