package com.thurainx.foodninja.features

import android.window.SplashScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.thurainx.foodninja.R
import com.thurainx.foodninja.ui.theme.*


@Preview(showBackground = true)
@Composable
fun SplashScreen() {

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painterResource(id = R.drawable.app_logo),
                "",
                modifier = Modifier.size(width = SIZE_APP_LOGO, height = SIZE_APP_LOGO)
            )
            Text(
                text = "FoodNinja",
                style = TextStyle(color = Green, fontSize = TEXT_HEADING_2X, fontFamily = Viga)
            )
            Text(
                text = "Deliver Favorite Food",
                style = TextStyle(
                    color = MaterialTheme.colors.onPrimary,
                    fontSize = TEXT_REGULAR,
                    fontWeight = FontWeight.Bold
                )
            )

        }
        BackgroundFoodPattern()

    }

}

@Composable
fun BackgroundFoodPattern() {
    Image(
        painter = painterResource(id = R.drawable.food_pattern),
        contentDescription = "",
        modifier = Modifier
            .fillMaxWidth()
            .height(320.dp)
    )
    Box(
        modifier = Modifier.fillMaxWidth().height(320.dp).background(
            brush = Brush.verticalGradient(
                colors = listOf(
                    Color.Transparent,
                    MaterialTheme.colors.background
                )
            )
        )
    )

}