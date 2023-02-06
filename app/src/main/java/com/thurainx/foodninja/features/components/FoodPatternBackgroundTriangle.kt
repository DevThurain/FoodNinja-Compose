package com.thurainx.foodninja.features.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.thurainx.foodninja.R

@Composable
fun FoodPatternBackgroundTriangle() {

    Box(modifier = Modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.food_pattern),
            contentDescription = "",
            contentScale = ContentScale.Fit,

            modifier = Modifier
                .width(300.dp)
                .height(300.dp)
                .align(Alignment.TopEnd)
                .offset(x = 110.dp)
                .offset(y = (-110).dp)
                .rotate(50f)
                .alpha(0.5f)


        )
    }

//    Box(
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(320.dp)
//            .background(
//                brush = Brush.verticalGradient(
//                    colors = listOf(
//                        MaterialTheme.colors.background.copy(alpha = 0.1f),
//                        MaterialTheme.colors.background.copy(alpha = 0.1f),
//
//                        )
//                )
//            )
//    )

}