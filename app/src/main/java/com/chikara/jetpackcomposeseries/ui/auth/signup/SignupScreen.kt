package com.chikara.jetpackcomposeseries.ui.main

import CommonOutlinedTextField
import LoadingIndicator
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.chikara.jetpackcomposeseries.R
import com.chikara.jetpackcomposeseries.ui.auth.viewModel.AuthState
import com.chikara.jetpackcomposeseries.ui.auth.viewModel.AuthViewModel
import com.chikara.jetpackcomposeseries.ui.common.CommonButton
import com.chikara.jetpackcomposeseries.ui.navigation.NavRoutes
import com.chikara.jetpackcomposeseries.ui.theme.AppTypography
import com.chikara.jetpackcomposeseries.utils.Logger

val _kSignupTag = "LoginScreen"

@Composable
fun SignupScreen(
    navController: NavController?,
    authViewModel: AuthViewModel
) {
    val statusBarColor = colorResource(R.color.purple_100)
    val scrollState = rememberScrollState()

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val snackbarHostState = remember { SnackbarHostState() }

    // Observe the ViewModel state
    val authState by authViewModel.authState.observeAsState(AuthState.UnAuthenticated)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(statusBarColor)
            .imePadding()
            .navigationBarsPadding()
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        // Signup Form
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

            // Signup Button
            CommonButton(
                textResId = R.string.createAccount,
                onClick = {
                    if (email.isNotEmpty() && password.isNotEmpty()) {
                        authViewModel.createSignup(email, password)
                    }
                }
            )

            Text(
                text = stringResource(R.string.or),
                style = AppTypography.headlineLarge[12]!!,
                color = colorResource(R.color.purple_700),
            )

            Text(
                text = stringResource(R.string.login),
                style = AppTypography.headlineLarge[16]!!,
                color = colorResource(R.color.purple_700),
                modifier = Modifier.clickable {
                    navController?.navigate(NavRoutes.LoginScreen.route)
                }
            )
        }

        // Snackbar Host at the bottom
        SnackbarHost(
            hostState = snackbarHostState,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp)
        )

        // Show loading indicator
        if (authState is AuthState.Loading) {
            LoadingIndicator()
        }

        // Handle Auth State Changes
        LaunchedEffect(authState) {
            when (authState) {
                is AuthState.Authenticated -> {
                    navController?.navigate(NavRoutes.HomeScreen.route) {
                        popUpTo(NavRoutes.SignupScreen.route) { inclusive = true }
                    }
                }

                is AuthState.onError -> {
                    val errorMsg = (authState as AuthState.onError).error
                    snackbarHostState.showSnackbar(message = errorMsg)
                }

                else -> {}
            }
        }

    }
}
