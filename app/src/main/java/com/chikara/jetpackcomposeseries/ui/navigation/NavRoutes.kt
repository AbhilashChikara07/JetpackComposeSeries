package com.chikara.jetpackcomposeseries.ui.navigation

sealed class NavRoutes(val route: String) {
    object SplashScreen : NavRoutes("splash_screen")
    object LoginScreen : NavRoutes("login_screen")
    object SignupScreen : NavRoutes("signup_screen")
    object HomeScreen : NavRoutes("home_screen")

    // Base route is "main_activity_screen?arg={arg}"
//    object MainActivityScreen : NavRoutes("main_activity_screen?arg={arg}") {
//        fun createRoute(arg: MainActivityArgument): String {
//            val json = Json.encodeToString(arg)
//            val encoded = URLEncoder.encode(json, "UTF-8")
//
//            // ⭐️ FIX: Changed the hardcoded route from "main_activity" to "main_activity_screen"
//            return "main_activity_screen?arg=$encoded"
//
//            // Alternative cleaner implementation:
//            // return this.route.replace("{arg}", encoded)
//        }
//    }
}