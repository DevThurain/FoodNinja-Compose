package com.thurainx.foodninja.features.register

import android.media.tv.TvContract.Channels.Logo
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.thurainx.foodninja.features.components.FoodPatternBackground
import com.thurainx.foodninja.features.components.LogoAndText

@Composable
fun RegisterScreen(navController: NavController) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colors.background)) {
        FoodPatternBackground()
        Column(modifier = Modifier.fillMaxSize()) {
                LogoAndText()
            }
    }
}