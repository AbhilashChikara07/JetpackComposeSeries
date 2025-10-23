package com.chikara.jetpackcomposeseries.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.chikara.jetpackcomposeseries.ui.arguments.MainActivityArgument
import com.chikara.jetpackcomposeseries.ui.main.MainActivityScreen
import com.chikara.jetpackcomposeseries.ui.splash.SplashScreen
import kotlinx.serialization.json.Json
import java.net.URLDecoder

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavRoutes.SplashScreen.route
    ) {
        // Splash Screen
        composable(NavRoutes.SplashScreen.route) {
            SplashScreen(navController)
        }

        // Main Screen with optional argument
        composable(
            route = NavRoutes.MainActivityScreen.route,
            arguments = listOf(
                navArgument("arg") {
                    type = NavType.StringType
                    defaultValue = "" // safe default
                    nullable = true
                }
            )
        ) { backStackEntry ->
            val encoded = backStackEntry.arguments?.getString("arg").orEmpty()

            val arg = if (encoded.isNotEmpty()) {
                val decoded = URLDecoder.decode(encoded, "UTF-8")
                Json.decodeFromString<MainActivityArgument>(decoded)
            } else {
                MainActivityArgument(userId = "", name = "")
            }

            MainActivityScreen(arg)
        }
    }
}
