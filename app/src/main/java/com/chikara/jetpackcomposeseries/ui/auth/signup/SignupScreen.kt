package com.chikara.jetpackcomposeseries.ui.main

import CommonOutlinedTextField
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.chikara.jetpackcomposeseries.R
import com.chikara.jetpackcomposeseries.ui.auth.viewModel.AuthViewModel
import com.chikara.jetpackcomposeseries.ui.common.CommonButton
import com.chikara.jetpackcomposeseries.ui.navigation.NavRoutes
import com.chikara.jetpackcomposeseries.ui.theme.AppTypography
import com.chikara.jetpackcomposeseries.utils.Logger

val _kSignupTag = "LoginScreen"

@Composable
fun SignupScreen(
    navController: NavController?,
    authViewModel: AuthViewModel?
) {

    val statusBarColor = colorResource(R.color.purple_100)
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    // Scroll state to allow vertical scrolling when keyboard is visible
    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(statusBarColor)
            // Make space for system bars & keyboard
            .imePadding()
            .navigationBarsPadding()
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Title
            Text(
                text = stringResource(R.string.signup),
                style = AppTypography.headlineLarge[30]!!,
                color = colorResource(R.color.purple_700)
            )

            // Email Field
            CommonOutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = stringResource(R.string.email),
                keyboardType = KeyboardType.Email
            )

            // Password Field
            CommonOutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = stringResource(R.string.password),
                keyboardType = KeyboardType.Password
            )

            Spacer(modifier = Modifier.height(45.dp))

            // Login Button
            CommonButton(
                textResId = R.string.createAccount,
                onClick = {
                    // Call login function
//        authViewModel?.login(email, password) {
//            navController?.navigate("home_screen") {
//                popUpTo("login_screen") { inclusive = true }
//            }
//        }
                }
            )

            Text(
                text = stringResource(R.string.or),
                style = AppTypography.headlineLarge[12]!!,
                color = colorResource(R.color.purple_700),
            )
            // Signup Button
            Text(
                text = stringResource(R.string.login),
                style = AppTypography.headlineLarge[16]!!,
                color = colorResource(R.color.purple_700),
                modifier = Modifier.clickable {
                    Logger.e(_kSignupTag, "You Click Login Button")
                    navController!!.navigate(NavRoutes.LoginScreen.route)
                }
            )
        }
    }
}
