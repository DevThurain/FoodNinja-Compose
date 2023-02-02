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
import com.thurainx.foodninja.ui.theme.Green
import com.thurainx.foodninja.ui.theme.Viga


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
                modifier = Modifier.size(width = 200.dp, height = 200.dp)
            )
            Text(text = "FoodNinja", style = TextStyle(color = Green, fontSize = 32.sp, fontFamily = Viga))
            Text(text = "Deliver Favorite Food", style = TextStyle(color = MaterialTheme.colors.onPrimary, fontSize = 14.sp, fontWeight = FontWeight.Bold))

        }
    }

}