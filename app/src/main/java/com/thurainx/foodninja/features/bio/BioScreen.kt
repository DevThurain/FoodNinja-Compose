package com.thurainx.foodninja.features.bio

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.thurainx.foodninja.R
import com.thurainx.foodninja.features.components.FoodPatternBackground
import com.thurainx.foodninja.features.components.FoodPatternBackgroundTriangle
import com.thurainx.foodninja.features.components.GradientButton
import com.thurainx.foodninja.ui.theme.*

@Composable
fun BioScreen(navController: NavController) {

    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = MaterialTheme.colors.background)) {
        FoodPatternBackgroundTriangle()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = MARGIN_MEDIUM_2)
        ) {
            Box(modifier = Modifier.height(MARGIN_MEDIUM_2))

            IconButton(modifier = Modifier
                .size(45.dp)
                .padding(0.dp), onClick = { }) {
                Image(
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = "",
                    modifier = Modifier.fillMaxSize()
                )
            }
            Box(modifier = Modifier.height(MARGIN_MEDIUM_2))

            Text(
                text = "Fill in your bio to get\nstarted",
                color = MaterialTheme.colors.onPrimary,
                fontWeight = FontWeight.Bold,
                fontSize = TEXT_HEADING_1X,
                lineHeight = 32.sp,
                modifier = Modifier.fillMaxWidth()
            )
            Box(modifier = Modifier.height(MARGIN_LARGE))

            Text(
                text = "This data will be displayed in your account\nprofile for security",
                color = MaterialTheme.colors.onPrimary,
                fontWeight = FontWeight.W400,
                fontSize = TEXT_REGULAR,
                lineHeight = 20.sp,
                modifier = Modifier.fillMaxWidth()
            )
            Box(modifier = Modifier.height(MARGIN_LARGE))

            OutlinedTextField(
                value = "",
                placeholder = {
                    Text(
                        text = "First Name",
                        color = MaterialTheme.colors.onPrimary,
                        modifier = Modifier.alpha(0.5f)
                    )
                },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
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
                    .fillMaxWidth()
            )
            Box(modifier = Modifier.height(MARGIN_MEDIUM_2))

            OutlinedTextField(
                value = "",
                placeholder = {
                    Text(
                        text = "Last Name",
                        color = MaterialTheme.colors.onPrimary,
                        modifier = Modifier.alpha(0.5f)
                    )
                },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
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
                    .fillMaxWidth()
            )
            Box(modifier = Modifier.height(MARGIN_MEDIUM_2))

            OutlinedTextField(
                value = "",
                placeholder = {
                    Text(
                        text = "Mobile Number",
                        color = MaterialTheme.colors.onPrimary,
                        modifier = Modifier.alpha(0.5f)
                    )
                },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done,
                    keyboardType = KeyboardType.Number
                ),
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
                    .fillMaxWidth()
            )
            Box(modifier = Modifier.height(MARGIN_XLARGE))
            Box(modifier = Modifier.weight(1f))

            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
                GradientButton(text = "Next")
            }
            Box(modifier = Modifier.height(MARGIN_LARGE))


        }
    }

}