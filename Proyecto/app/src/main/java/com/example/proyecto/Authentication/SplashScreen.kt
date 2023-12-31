package com.example.proyecto.Authentication


import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.proyecto.R
import com.example.proyecto.navigation.AppScreens
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun BreakSplashScreen(navController: NavController, coroutineScope: CoroutineScope) {
    val scale = remember {
        androidx.compose.animation.core.Animatable(0f)
    }
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 1.2f,
            animationSpec = tween(durationMillis = 800, easing = { OvershootInterpolator(8f).getInterpolation(it) }),
        )
        delay(1500L)

        // Utilizamos la coroutineScope proporcionada para manejar la lógica asíncrona
        coroutineScope.launch {
            if (FirebaseAuth.getInstance().currentUser?.email.isNullOrEmpty()) {
                navController.navigate(AppScreens.SignInScreen.route)
            } else {
                navController.navigate(AppScreens.MainFeedScreen.route) {
                    popUpTo(AppScreens.SplashScreen.route) {
                        Firebase.auth.signOut()
                        inclusive = true
                    }
                }
            }
        }
    }

    val imagePainter = painterResource(id = R.drawable.break_open)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .width(IntrinsicSize.Max)
            .fillMaxHeight()
            .graphicsLayer(scaleX = scale.value, scaleY = scale.value)
            .scale(scale.value),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = imagePainter,
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .scale(scale.value)
                .align(Alignment.Center)
        )
    }
}
