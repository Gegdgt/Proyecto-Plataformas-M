package com.example.proyecto.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarSS() {
    val viewModel = viewModel<MainViewModel>()
    val searchText by viewModel.searchText.collectAsState()
    val users by viewModel.users.collectAsState()
    val isSearching by viewModel.isSearching.collectAsState()
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ){
        TextField(
            value = searchText,
            onValueChange = viewModel :: onSearchTextChange,
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(
                    text = "Buscar Perfil"
                )
            }
        )
        Spacer(modifier = Modifier.height(1.dp))
        LazyColumn(modifier =  Modifier.fillMaxWidth()){
            items(users){ ExtraPost ->
                Text(
                    text = "${ExtraPost.users}",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 1.dp)
                )

            }
        }
    }
}