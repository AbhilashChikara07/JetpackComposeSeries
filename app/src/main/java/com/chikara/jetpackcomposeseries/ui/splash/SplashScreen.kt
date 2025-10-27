package com.chikara.jetpackcomposeseries.ui.splash

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.chikara.jetpackcomposeseries.R
import com.chikara.jetpackcomposeseries.ui.arguments.MainActivityArgument
import com.chikara.jetpackcomposeseries.ui.navigation.NavRoutes
import com.chikara.jetpackcomposeseries.ui.theme.AppTypography
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    val scale = remember { Animatable(0.1f) }
    val statusBarColor = colorResource(R.color.purple_100)
    val systemUiController = rememberSystemUiController()

    // ✅ Change the system status bar color
    LaunchedEffect(Unit) {
        systemUiController.setStatusBarColor(
            color = statusBarColor,
            darkIcons = true // set false if your background is dark
        )
    }

    LaunchedEffect(Unit) {
        scale.animateTo(
            targetValue = 1f,
            animationSpec = tween(durationMillis = 1200)
        )
        delay(1000)

        navController.navigate(NavRoutes.LoginScreen.route) {
//            popUpTo(NavRoutes.SplashScreen.route) { inclusive = true }
        }


//        val mainActivityArgument = MainActivityArgument(userId = "chikara007", name = "Chikara")
//        navController.navigate(NavRoutes.MainActivityScreen.createRoute(mainActivityArgument)) {
//            popUpTo(NavRoutes.SplashScreen.route) { inclusive = true }
//        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(statusBarColor),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Jetpack Compose Series",
            color = colorResource(R.color.purple_700),
            style = AppTypography.headlineMedium[30]!!
        )
    }
}
