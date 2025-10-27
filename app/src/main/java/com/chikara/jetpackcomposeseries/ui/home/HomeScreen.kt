package com.chikara.jetpackcomposeseries.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.chikara.jetpackcomposeseries.R
import com.chikara.jetpackcomposeseries.ui.arguments.MainActivityArgument
import com.chikara.jetpackcomposeseries.ui.auth.viewModel.AuthViewModel
import com.chikara.jetpackcomposeseries.ui.theme.AppTypography

@Composable
fun HomeScreen(navController: NavController?, authViewModel: AuthViewModel?) {
    val statusBarColor = colorResource(R.color.purple_100)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(statusBarColor)
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Text(
                text = "Home",
                style = AppTypography.headlineLarge[30]!!,
                color = colorResource(R.color.purple_700)
            )
        }
    }
}


