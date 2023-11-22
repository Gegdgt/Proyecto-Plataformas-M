package com.example.proyecto.upload_post

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import android.os.Build
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.proyecto.R

@Composable
fun uploadPostScreen(){
    Box{
        Image(
            painter = painterResource(id = R.drawable.bdg),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxWidth()
        )
        val isUploading = remember {
            mutableStateOf(false)
        }
        val context = LocalContext.current
        val img: Bitmap = BitmapFactory.decodeResource(Resources.getSystem(), android.R.drawable.ic_menu_report_image)
        val bitmap = remember { mutableStateOf(img) }

        val launcher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.TakePicturePreview()
        ){
            if (it != null){
                bitmap.value = it
            }
        }

        val launchImage = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.GetContent()
        ) {
            if (Build.VERSION.SDK_INT < 28){
                bitmap.value = MediaStore.Images.Media.getBitmap(context.contentResolver, it)
            }
            else{
                val source = it?.let { it1 ->
                    ImageDecoder.createSource(context.contentResolver, it1)
                }
                bitmap.value = source?.let { it1 ->
                    ImageDecoder.decodeBitmap(it1)
                }!!
            }
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 100.dp)
        ){
            Image(bitmap = bitmap.value.asImageBitmap(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(250.dp)
                    .background(Color.Blue)
                    .border(
                        width = 1.dp,
                        color = Color.White,
                        shape = CircleShape
                    )
            )
        }
        var showDialog by remember {
            mutableStateOf(false)
        }
        Box(
            modifier = Modifier
                .padding(top = 280.dp, start = 260.dp)
        ){
            Image(
                painter = painterResource(id = R.drawable.baseline_add_a_photo_24),
                contentDescription = null,
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Color.Black)
                    .size(50.dp)
                    .padding(10.dp)
                    .clickable { showDialog = true }
                )
        }
        Column {

        }
    }
}