package com.thurainx.foodninja.features.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.thurainx.foodninja.ui.theme.*

@Composable
@Preview(showBackground = false)
fun GradientButton(modifier: Modifier = Modifier, text: String = "Button", onClick: () -> Unit = {}) {
    Button(
        modifier = modifier.then(Modifier.padding(horizontal = MARGIN_MEDIUM_2, vertical = MARGIN_CARD_MEDIUM_2)),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
        contentPadding = PaddingValues(),
        shape = RoundedCornerShape(MARGIN_MEDIUM_2),
        onClick = onClick
    ) {
        Box(
            modifier = Modifier
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            GreenGradientStart,
                            GreenGradientEnd
                        )
                    )
                )
                .then(modifier)
                .padding(horizontal = MARGIN_XXLARGE, vertical = MARGIN_MEDIUM_2),
            contentAlignment = Alignment.Center
        ) {
            Text(text = text, color = Color.White)
        }
    }
}
