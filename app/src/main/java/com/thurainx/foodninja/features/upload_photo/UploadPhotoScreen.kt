package com.thurainx.foodninja.features.upload_photo

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage
import com.thurainx.foodninja.R
import com.thurainx.foodninja.features.components.FoodPatternBackgroundTriangle
import com.thurainx.foodninja.ui.theme.*

@Composable
fun UploadPhotoScreen(navController: NavController) {
    var selectedPhoto by remember {
        mutableStateOf<Uri?>(null)
    }
    val galleryLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = { uri ->
            selectedPhoto = uri
        })

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
                text = "Upload Your Photo\nProfile",
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

            if (selectedPhoto == null) {
                PickPhotoSection(
                    onTapGallery = {
                        galleryLauncher.launch(
                            PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                        )
                    },
                    onTapCamera = {}
                )
            } else {
                Box(modifier = Modifier.height(MARGIN_MEDIUM_2))
                ShowPictureSection(selectedPhoto = selectedPhoto!!, onRemovePhoto = {
                    selectedPhoto = null
                })
            }

        }
    }
}

@Composable
fun PickPhotoSection(onTapGallery: () -> Unit, onTapCamera: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(modifier = Modifier.height(MARGIN_MEDIUM_2))
        ImageCardWithText(
            image = R.drawable.ic_gallery,
            text = "From Gallery",
            onClicked = onTapGallery
        )
        Box(modifier = Modifier.height(MARGIN_MEDIUM_2))
        ImageCardWithText(
            image = R.drawable.ic_camera,
            text = "Take Photo",
            onClicked = onTapCamera
        )
    }
}

@Composable
fun ShowPictureSection(selectedPhoto: Uri, onRemovePhoto: () -> Unit) {
    Box(modifier = Modifier.fillMaxWidth()) {
        Box(modifier = Modifier.align(alignment = Alignment.Center)) {
            GlideImage(
                imageModel = { selectedPhoto },
                imageOptions = ImageOptions(
                    alignment = Alignment.Center,
                    contentScale = ContentScale.Crop
                ),
                modifier = Modifier
                    .size(200.dp)
                    .clip(RoundedCornerShape(MARGIN_MEDIUM_2))
                    .align(alignment = Alignment.Center)
            )

            IconButton(onClick = onRemovePhoto, modifier = Modifier.align(Alignment.TopEnd)) {
                Image(
                    painter = painterResource(id = R.drawable.ic_remove_photo),
                    contentDescription = "Remove",
                    modifier = Modifier
                        .padding(MARGIN_MEDIUM)
                        .size(32.dp)
                )
            }
        }
    }
}

@Composable
fun ImageCardWithText(image: Int, text: String, onClicked: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(MARGIN_MEDIUM_2))
            .border(
                width = 2.dp,
                color = MaterialTheme.colors.surface,
                shape = RoundedCornerShape(
                    MARGIN_MEDIUM_2
                )
            )
            .background(color = MaterialTheme.colors.surface)
            .clickable {
                onClicked()
            }
            .padding(vertical = MARGIN_MEDIUM_2)
    ) {
        Image(
            painter = painterResource(id = image),
            contentScale = ContentScale.Fit,
            contentDescription = "",
            modifier = Modifier
                .width(50.dp)
        )
        Text(
            text = text,
            color = MaterialTheme.colors.onPrimary,
            fontWeight = FontWeight.Bold,
            fontSize = TEXT_REGULAR,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = MARGIN_MEDIUM_2)
        )
    }
}