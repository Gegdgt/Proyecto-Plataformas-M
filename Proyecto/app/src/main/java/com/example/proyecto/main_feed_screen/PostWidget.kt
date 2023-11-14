package com.example.proyecto.main_feed_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.proyecto.R
import com.example.proyecto.model.User
import com.example.proyecto.navigation.AppScreens

@Composable
fun PostWidget(
    user: User,
    navController: NavController
){
    Column(
        modifier = Modifier.fillMaxWidth()
    ){
        Row(
        
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .clickable {  navController.navigate(AppScreens.VisitProfile.route)},
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Row {
                Image(
                    painter = user.profilePic,
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    Text(
                        text = user.username,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                    Text(
                        text = user.location,
                        fontSize = 14.sp
                    )
                }
            }
        }
        Image(
            modifier = Modifier.fillMaxWidth(),
            painter = user.postPic,
            contentDescription = "Post Picture",
            contentScale = ContentScale.FillWidth
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Row{
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_insert_comment_24),
                        contentDescription = "Comment Post",
                        tint = Color.Black,
                        modifier = Modifier.size(25.dp)
                    )
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_send_24),
                        contentDescription = "Send Post",
                        tint = Color.Black,
                        modifier = Modifier.size(25.dp)
                    )
                }
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_bookmark_24),
                    contentDescription = "Save Post",
                    tint = Color.Black,
                    modifier = Modifier.size(25.dp)
                )
            }
        }
        Column(
            modifier = Modifier.padding(horizontal = 10.dp)
        ){
            Text(text = "${user.likeCount} likes")
            Text(text = buildAnnotatedString {
                append(
                    AnnotatedString(
                        text = "${user.username} ",
                        spanStyle = SpanStyle(fontWeight = FontWeight.Bold)
                    )
                )
                append(
                    user.caption
                )
            })
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = "Desplegar ${user.commentCount} comentarios",
                color = Color.Green,
                fontSize = 12.sp
            )
        }
    }
}

@Preview
@Composable
fun PostWidgetPreview() {
    val navController = rememberNavController()
    PostWidget(
        User(
            profilePic = painterResource(R.drawable.profile_pic),
            username = "gt_proms",
            postPic = painterResource(R.drawable.promo7),
            location = "Guatemala City",
            likeCount = 4585,
            caption = "Nuevo evento!!",
            commentCount = 1987
        ),
        navController = navController
    )
}