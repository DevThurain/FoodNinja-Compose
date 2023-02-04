package com.thurainx.foodninja.features.register

import android.media.tv.TvContract.Channels.Logo
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import com.thurainx.foodninja.R
import com.thurainx.foodninja.features.components.FoodPatternBackground
import com.thurainx.foodninja.features.components.LogoAndText
import com.thurainx.foodninja.ui.theme.*

@Composable
fun RegisterScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        FoodPatternBackground()
        Column(modifier = Modifier.fillMaxSize()) {
            Box(modifier = Modifier.height(MARGIN_XLARGE))
            LogoAndText()
            Box(modifier = Modifier.height(MARGIN_XXLARGE))
            Text(
                text = "Sign Up For Free",
                color = MaterialTheme.colors.onPrimary,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontSize = TEXT_REGULAR_3X,
                modifier = Modifier.fillMaxWidth()
            )
            Box(modifier = Modifier.height(MARGIN_XXLARGE))
            OutlinedTextField(
                value = "",
                placeholder = { Text(text = "Name", color = MaterialTheme.colors.onPrimary, modifier = Modifier.alpha(0.5f)) },
                leadingIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.ic_profile),
                        contentDescription = "",
                        modifier = Modifier.size(
                            MARGIN_LARGE
                        )
                    )
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    disabledBorderColor = GreyBorder,
                    unfocusedBorderColor = MaterialTheme.colors.surface,
                    focusedBorderColor = MaterialTheme.colors.surface,
                    errorBorderColor = Color.Red,
                    cursorColor = Color.Gray,
                    backgroundColor = MaterialTheme.colors.surface,
                ),
                shape = RoundedCornerShape(MARGIN_MEDIUM_2),
                onValueChange = {},
                modifier = Modifier
                    .padding(horizontal = MARGIN_MEDIUM_2)
                    .fillMaxWidth()
            )
            Box(modifier = Modifier.height(MARGIN_MEDIUM_2))
            OutlinedTextField(
                value = "",
                placeholder = { Text(text = "Email", color = MaterialTheme.colors.onPrimary, modifier = Modifier.alpha(0.5f)) },
                leadingIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.ic_email),
                        contentDescription = "",
                        modifier = Modifier.size(
                            MARGIN_LARGE
                        )
                    )
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    disabledBorderColor = GreyBorder,
                    unfocusedBorderColor = MaterialTheme.colors.surface,
                    focusedBorderColor = MaterialTheme.colors.surface,
                    errorBorderColor = Color.Red,
                    cursorColor = Color.Gray,
                    backgroundColor = MaterialTheme.colors.surface,
                ),
                shape = RoundedCornerShape(MARGIN_MEDIUM_2),
                onValueChange = {},
                modifier = Modifier
                    .padding(horizontal = MARGIN_MEDIUM_2)
                    .fillMaxWidth()
            )


        }
    }
}