package com.chikara.jetpackcomposeseries.ui.main

import Chat
import More
import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.chikara.jetpackcomposeseries.R
import com.chikara.jetpackcomposeseries.ui.auth.viewModel.AuthViewModel
import com.chikara.jetpackcomposeseries.ui.common.BottomNavItemDataClass
import com.chikara.jetpackcomposeseries.ui.common.CommonBottomNavigationBar
import com.example.app.ui.movies.MoviesScreen

@Composable
fun HomeScreen(navController: NavController?, authViewModel: AuthViewModel?) {
    val statusBarColor = colorResource(R.color.purple_100)
    val context = LocalContext.current
    val activity = context as? Activity
    var selectedTab by remember { mutableStateOf(0) }

    val bottomItems = listOf(
        BottomNavItemDataClass("Movie", icon = Icons.Default.Home),
        BottomNavItemDataClass("Chat", icon = Icons.Default.Email),
        BottomNavItemDataClass("More", icon = Icons.Default.Settings)
    )

    BackHandler { activity?.finishAffinity() }

    Scaffold(
        bottomBar = {
            CommonBottomNavigationBar(
                items = bottomItems,
                selectedTab = selectedTab,
                onTabSelected = { selectedTab = it }
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(statusBarColor)
                .padding(paddingValues)
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            when (selectedTab) {
                0 -> MoviesScreen()
                1 -> Chat()
                2 -> More(navController = navController, authViewModel = authViewModel)
            }
        }
    }
}
