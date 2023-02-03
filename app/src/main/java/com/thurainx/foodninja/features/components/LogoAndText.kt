package com.thurainx.foodninja.features.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.thurainx.foodninja.R
import com.thurainx.foodninja.ui.theme.*

@Composable
fun LogoAndText() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painterResource(id = R.drawable.app_logo),
            "",
            modifier = Modifier.size(width = SIZE_APP_LOGO, height = SIZE_APP_LOGO),
            contentScale = ContentScale.Crop
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
}