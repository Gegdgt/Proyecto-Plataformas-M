package com.example.proyecto.main_feed_screen

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
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
import com.example.proyecto.model.User

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
            commentCount = 5698
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
            TopBar()
        },
        bottomBar = {
            BottomBar()
        },
        containerColor = Color.White,

    ) {innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding)
        ){
            item{Divider()}
            items(users) {
                user ->
                PostWidget(user = user)
                Spacer(modifier = Modifier.height(15.dp))
            }
        }
    }
}

@Composable
fun BottomBar(){
    BottomAppBar{
        NavigationBarItem(
            selected = true,
            onClick = {/*TODO*/},
            icon = {
                Icon(
                    painter = painterResource(R.drawable.baseline_home_24),
                    contentDescription = "Home Screen",
                    tint = Color.Black,
                    modifier = Modifier.size(35.dp)
                )
            }
        )
        NavigationBarItem(
            selected = false,
            onClick = {/*TODO*/},
            icon = {
                Icon(
                    painter = painterResource(R.drawable.baseline_search_24),
                    contentDescription = "Search Screen",
                    tint = Color.Black,
                    modifier = Modifier.size(35.dp)
                )
            }
        )
        NavigationBarItem(
            selected = false,
            onClick = {/*TODO*/},
            icon = {
                Icon(
                    painter = painterResource(R.drawable.baseline_person_24),
                    contentDescription = "Profile",
                    tint = Color.Black,
                    modifier = Modifier.size(35.dp)
                )
            }
        )
    }
}
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

