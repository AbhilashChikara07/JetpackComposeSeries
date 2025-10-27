package com.chikara.jetpackcomposeseries.ui.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.chikara.jetpackcomposeseries.ui.auth.viewModel.AuthViewModel
import com.chikara.jetpackcomposeseries.ui.main.HomeScreen
import com.chikara.jetpackcomposeseries.ui.main.LoginScreen
import com.chikara.jetpackcomposeseries.ui.main.SignupScreen
import com.chikara.jetpackcomposeseries.ui.splash.SplashScreen

@Composable
fun AppNavigation(authViewModel: AuthViewModel) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavRoutes.SplashScreen.route
    ) {

        // Splash Screen
        composable(
            route = NavRoutes.SplashScreen.route,
            enterTransition = {
                slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Left)
            },
            exitTransition = {
                slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Left)
            }
        ) {
            SplashScreen(navController)
        }

        // Login Screen
        composable(
            route = NavRoutes.LoginScreen.route,
            enterTransition = {
                slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Left)
            },
            exitTransition = {
                slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Left)
            },
            popEnterTransition = {
                slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Right)
            },
            popExitTransition = {
                slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Right)
            }
        ) {
            LoginScreen(navController, authViewModel)
        }

        // Signup Screen
        composable(
            route = NavRoutes.SignupScreen.route,
            enterTransition = {
                slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Left)
            },
            exitTransition = {
                slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Left)
            },
            popEnterTransition = {
                slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Right)
            },
            popExitTransition = {
                slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Right)
            }
        ) {
            SignupScreen(navController, authViewModel)
        }


        // Home Screen
        composable(
            route = NavRoutes.HomeScreen.route,
            enterTransition = {
                slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Left)
            },
            exitTransition = {
                slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Left)
            }
        ) {
            HomeScreen(navController, authViewModel)
        }


        // Main Screen with optional argument
//        composable(
//            route = NavRoutes.MainActivityScreen.route,
//            arguments = listOf(
//                navArgument("arg") {
//                    type = NavType.StringType
//                    defaultValue = "" // safe default
//                    nullable = true
//                }
//            )
//        ) { backStackEntry ->
//            val encoded = backStackEntry.arguments?.getString("arg").orEmpty()
//
//            val arg = if (encoded.isNotEmpty()) {
//                val decoded = URLDecoder.decode(encoded, "UTF-8")
//                Json.decodeFromString<MainActivityArgument>(decoded)
//            } else {
//                MainActivityArgument(userId = "", name = "")
//            }
//
//            LoginScreen(arg)
//        }
    }
}
