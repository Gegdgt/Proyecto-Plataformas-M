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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.proyecto.R
import com.example.proyecto.navigation.AppScreens
import com.google.firebase.auth.FirebaseAuth

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(navController: NavController) {
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
            IconButton(onClick = { navController.navigate(route = AppScreens.UploadPostScreen.route) }) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_add_24) ,
                    contentDescription = "Add Post",
                    tint = Color.Black,
                    modifier = Modifier.size(25.dp)
                )
            }
            IconButton(onClick = { navController.navigate(route = AppScreens.SignInScreen.route){
                popUpTo(AppScreens.MainFeedScreen.route){
                    inclusive=true

                }
            }
            }) {

                Icon(
                    painter = painterResource(id = R.drawable.poder) ,
                    contentDescription = "Desloguearse",
                    modifier = Modifier.size(20.dp).clip(CircleShape)
                )
            }
        }
    )
}
