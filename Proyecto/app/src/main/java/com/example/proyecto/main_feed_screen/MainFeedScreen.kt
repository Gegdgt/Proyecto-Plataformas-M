package com.example.proyecto.main_feed_screen

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.proyecto.R
import com.example.proyecto.model.User
import com.example.proyecto.navigation.AppScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainFeedScreen(navController: NavController) {

    val users = listOf(
        User(
            profilePic = painterResource(R.drawable.profile_pic),
            username = "promos_live",
            postPic = painterResource(R.drawable.promo1),
            location = "Guatemala City",
            likeCount = 11909,
            caption = "Nuevo evento!!",
            commentCount = 5698,
        ),
        User(
            profilePic = painterResource(R.drawable.profile_pic),
            username = "eventosgt",
            postPic = painterResource(R.drawable.promo2),
            location = "Guatemala City",
            likeCount = 5698,
            caption = "Nuevo evento!!",
            commentCount = 2356
        ),
        User(
            profilePic = painterResource(R.drawable.profile_pic),
            username = "asap_promotions",
            postPic = painterResource(R.drawable.promo3),
            location = "Guatemala City",
            likeCount = 45823,
            caption = "Nuevo evento!!",
            commentCount = 12563
        ),
        User(
            profilePic = painterResource(R.drawable.profile_pic),
            username = "eventos_en_directo",
            postPic = painterResource(R.drawable.promo4),
            location = "Guatemala City",
            likeCount = 56985,
            caption = "Nuevo evento!!",
            commentCount = 2356
        ),
        User(
            profilePic = painterResource(R.drawable.profile_pic),
            username = "promogt",
            postPic = painterResource(R.drawable.promo5),
            location = "Guatemala City",
            likeCount = 56989,
            caption = "Nuevo evento!!",
            commentCount = 5451
        ),
        User(
            profilePic = painterResource(R.drawable.profile_pic),
            username = "promoguate",
            postPic = painterResource(R.drawable.promo6),
            location = "Guatemala City",
            likeCount = 4512,
            caption = "Nuevo evento!!",
            commentCount = 1256
        ),
        User(
            profilePic = painterResource(R.drawable.profile_pic),
            username = "gt_proms",
            postPic = painterResource(R.drawable.promo7),
            location = "Guatemala City",
            likeCount = 4585,
            caption = "Nuevo evento!!",
            commentCount = 1987
        )
    )

    Scaffold (
        topBar = {
            TopBar(navController)
        },
        bottomBar = {
            BottomBar(navController)
        },
        containerColor = Color.White,

    ) {innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding)
        ){
            item{Divider()}
            items(users) {
                user ->
                PostWidget(user = user,navController)
                Spacer(modifier = Modifier.height(15.dp))
            }
        }
    }
}
