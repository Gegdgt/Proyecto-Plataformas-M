package com.example.proyecto.main_feed_screen

import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyecto.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(
        title = {
            Text(
                modifier = Modifier.offset(y = 5.dp),
                text = "Break",
                fontSize = 35.sp,
                color = Color.Black
            )
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_add_24) ,
                    contentDescription = "Add Post",
                    tint = Color.Black,
                    modifier = Modifier.size(25.dp)
                )
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.profile_pic) ,
                    contentDescription = "Profile Button",
                    tint = Color.Black,
                    modifier = Modifier.size(20.dp).clip(CircleShape)
                )
            }
        }
    )
}

@Preview
@Composable
fun TopBarPreview() {
    TopBar()
}