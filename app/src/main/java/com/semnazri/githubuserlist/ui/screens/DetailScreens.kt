package com.semnazri.githubuserlist.ui.screens


import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun DetailScreen(navController: NavController, userId: String){
    Text("Detail Screen $userId")
}