package com.example.proyecto.main_feed_screen

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainFeedScreen() {
    Scaffold (
        topBar = {
            TopBar()
        },
        bottomBar = {

        },
        containerColor = Color.White,

    ) {innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding)
        ){

        }

    }
}

@Preview
@Composable
fun MainFeedScreenPreview() {
    MainFeedScreen()
}