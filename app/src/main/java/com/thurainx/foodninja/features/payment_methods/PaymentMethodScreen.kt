package com.thurainx.foodninja.features.payment_methods

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.thurainx.foodninja.R
import com.thurainx.foodninja.core.Constants
import com.thurainx.foodninja.features.components.FoodPatternBackgroundTriangle
import com.thurainx.foodninja.features.components.GradientButton
import com.thurainx.foodninja.ui.theme.*

@Composable
fun PaymentMethodScreen(navController: NavController) {
    val selectedPayment = remember {
        mutableStateOf("Paypal")
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.background)
    ) {
        FoodPatternBackgroundTriangle()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = MARGIN_MEDIUM_2)
        ) {
            Box(modifier = Modifier.height(MARGIN_MEDIUM_2))

            IconButton(modifier = Modifier
                .size(45.dp)
                .padding(0.dp), onClick = {
                navController.popBackStack()
            }) {
                Image(
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = "",
                    modifier = Modifier.fillMaxSize()
                )
            }
            Box(modifier = Modifier.height(MARGIN_MEDIUM_2))

            Text(
                text = "Payment Method",
                color = MaterialTheme.colors.onPrimary,
                fontWeight = FontWeight.Bold,
                fontSize = TEXT_HEADING_1X,
                lineHeight = 32.sp,
                modifier = Modifier.fillMaxWidth()
            )
            Box(modifier = Modifier.height(MARGIN_LARGE))

            Text(
                text = "This data will be displayed in your\naccount profile for security",
                color = MaterialTheme.colors.onPrimary,
                fontWeight = FontWeight.W400,
                fontSize = TEXT_REGULAR,
                lineHeight = 20.sp,
                modifier = Modifier.fillMaxWidth()
            )
            Box(modifier = Modifier.height(MARGIN_LARGE))

            LazyColumn(modifier = Modifier.weight(1f)) {
                items(Constants.DEFAULT_PAYMENT_LIST) { payment ->
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = MARGIN_MEDIUM_2)
                            .clip(RoundedCornerShape(MARGIN_MEDIUM_2))
                            .border(
                                width = 2.dp,
                                color = if (selectedPayment.value == payment.name) Green else MaterialTheme.colors.surface,
                                shape = RoundedCornerShape(
                                    MARGIN_MEDIUM_2
                                )
                            )
                            .background(color = MaterialTheme.colors.surface)
                            .clickable {
                                selectedPayment.value = payment.name
                            }
                            .padding(vertical = MARGIN_MEDIUM_2)


                    ) {
                        Image(
                            painter = painterResource(id = payment.photo),
                            contentScale = ContentScale.Fit,
                            contentDescription = "",
                            modifier = Modifier
                                .width(80.dp)
                                .height(35.dp)
                                .align(Alignment.Center)
                        )
                    }
                }
            }


//            Box(modifier = Modifier.height(MARGIN_XLARGE))
//            Box(modifier = Modifier.weight(1f))

            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
                GradientButton(text = "Next")
            }
            Box(modifier = Modifier.height(MARGIN_LARGE))


        }
    }

}