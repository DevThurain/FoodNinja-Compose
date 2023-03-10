package com.thurainx.foodninja.features.register

import android.media.tv.TvContract.Channels.Logo
import android.widget.ImageButton
import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.relocation.bringIntoViewRequester
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.thurainx.foodninja.R
import com.thurainx.foodninja.core.Routes
import com.thurainx.foodninja.features.components.FoodPatternBackground
import com.thurainx.foodninja.features.components.GradientButton
import com.thurainx.foodninja.features.components.LogoAndText
import com.thurainx.foodninja.ui.theme.*
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RegisterScreen(navController: NavController) {
    val textPassword = remember {
        mutableStateOf("")
    }
    val isVisiblePassword = remember {
        mutableStateOf(false)
    }
    val isCheckedKeepSignIn = remember {
        mutableStateOf(false)
    }
    val isCheckSpecialPricing = remember {
        mutableStateOf(false)
    }

    val focusManager = LocalFocusManager.current
    val coroutineScope = rememberCoroutineScope()
    val bringIntoViewRequester = BringIntoViewRequester()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        FoodPatternBackground()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
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
                placeholder = {
                    Text(
                        text = "Name",
                        color = MaterialTheme.colors.onPrimary,
                        modifier = Modifier.alpha(0.5f)
                    )
                },
                leadingIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.ic_profile),
                        contentDescription = "",
                        modifier = Modifier.size(
                            MARGIN_LARGE
                        )
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
                    .padding(horizontal = MARGIN_MEDIUM_2)
                    .fillMaxWidth()
            )
            Box(modifier = Modifier.height(MARGIN_MEDIUM_2))

            OutlinedTextField(
                value = "",
                placeholder = {
                    Text(
                        text = "Email",
                        color = MaterialTheme.colors.onPrimary,
                        modifier = Modifier.alpha(0.5f)
                    )
                },
                leadingIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.ic_email),
                        contentDescription = "",
                        modifier = Modifier.size(
                            MARGIN_LARGE
                        )
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
                    .padding(horizontal = MARGIN_MEDIUM_2)
                    .fillMaxWidth()
            )
            Box(modifier = Modifier.height(MARGIN_MEDIUM_2))

            OutlinedTextField(
                value = textPassword.value,
                placeholder = {
                    Text(
                        text = "Password",
                        color = MaterialTheme.colors.onPrimary,
                        modifier = Modifier.alpha(0.5f)
                    )
                },
                visualTransformation = if (isVisiblePassword.value) VisualTransformation.None else PasswordVisualTransformation(),
                leadingIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.ic_password),
                        contentDescription = "",
                        modifier = Modifier.size(
                            MARGIN_LARGE
                        )
                    )
                },
                trailingIcon = {
                    IconButton(onClick = {
                        isVisiblePassword.value = !isVisiblePassword.value
                    }) {
                        Image(
                            painter = if (isVisiblePassword.value) painterResource(id = R.drawable.ic_password_visible) else painterResource(
                                id = R.drawable.ic_password_invisible
                            ),
                            contentDescription = "",
                            modifier = Modifier
                                .size(MARGIN_LARGE)
                        )
                    }
                },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(onDone = {
                    focusManager.clearFocus()
                }),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    disabledBorderColor = GreyBorder,
                    unfocusedBorderColor = MaterialTheme.colors.surface,
                    focusedBorderColor = MaterialTheme.colors.surface,
                    errorBorderColor = Color.Red,
                    cursorColor = Color.Gray,
                    backgroundColor = MaterialTheme.colors.surface,
                ),
                shape = RoundedCornerShape(MARGIN_MEDIUM_2),
                onValueChange = {
                    textPassword.value = it
                },
                modifier = Modifier
                    .padding(horizontal = MARGIN_MEDIUM_2)
                    .fillMaxWidth()
                    .onFocusEvent { event ->
                        if (event.isFocused) {
                            coroutineScope.launch {
                                bringIntoViewRequester.bringIntoView()
                            }
                        }
                    },

                )
            Box(modifier = Modifier.height(MARGIN_MEDIUM_2 + MARGIN_SMALL))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = MARGIN_MEDIUM_2),
                verticalAlignment = Alignment.CenterVertically
            ) {
                CustomCheckBox(onCheckChanged = {
                    isCheckedKeepSignIn.value = !isCheckedKeepSignIn.value
                }, isChecked = isCheckedKeepSignIn.value)
                Box(modifier = Modifier.width(MARGIN_MEDIUM_2))
                Text(
                    text = "Keep Me Signed In",
                    color = MaterialTheme.colors.onPrimary,
                    fontWeight = FontWeight.W300,
                    style = TextStyle(letterSpacing = 0.7.sp),
                    modifier = Modifier.clickable(
                        interactionSource = MutableInteractionSource(),
                        indication = null,
                        onClick = {
                            isCheckedKeepSignIn.value = !isCheckedKeepSignIn.value
                        }
                    )
                )
            }
            Box(modifier = Modifier.height(MARGIN_MEDIUM_2))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = MARGIN_MEDIUM_2),
                verticalAlignment = Alignment.CenterVertically
            ) {
                CustomCheckBox(onCheckChanged = {
                    isCheckSpecialPricing.value = !isCheckSpecialPricing.value
                }, isChecked = isCheckSpecialPricing.value)
                Box(modifier = Modifier.width(MARGIN_MEDIUM_2))
                Text(
                    text = "Email Me About Special Pricing",
                    color = MaterialTheme.colors.onPrimary,
                    fontWeight = FontWeight.W300,
                    style = TextStyle(letterSpacing = 0.7.sp),
                    modifier = Modifier.clickable(
                        interactionSource = MutableInteractionSource(),
                        indication = null,
                        onClick = {
                            isCheckSpecialPricing.value = !isCheckSpecialPricing.value
                        }
                    ),
                )
            }
            Box(modifier = Modifier.height(MARGIN_XLARGE))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                GradientButton(text = "Create Account"){
                    navController.navigate(Routes.BioScreen)
                }
            }
            Box(modifier = Modifier.height(MARGIN_MEDIUM))

            Text(
                text = "already have an account?",
                color = Green,
                textAlign = TextAlign.Center,
                fontSize = TEXT_SMALL,
                modifier = Modifier.fillMaxWidth().bringIntoViewRequester(bringIntoViewRequester)
            )
            Box(modifier = Modifier.height(MARGIN_XLARGE))


        }
    }
}

@Composable
fun CustomCheckBox(isChecked: Boolean, onCheckChanged: (Boolean) -> Unit) {


    IconButton(
        modifier = Modifier.size(MARGIN_LARGE - MARGIN_SMALL),
        onClick = {
            onCheckChanged(isChecked)

        }) {
        if (!isChecked) {
            Box(
                modifier = Modifier
                    .size(MARGIN_LARGE - MARGIN_SMALL)
                    .background(color = Color.Transparent, shape = CircleShape)
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colors.onPrimary,
                        shape = CircleShape
                    )
            )
        } else {
            Image(
                painter = painterResource(id = R.drawable.ic_checked),
                contentDescription = "",
                modifier = Modifier
                    .size(MARGIN_LARGE - MARGIN_SMALL)
            )
        }

    }
}