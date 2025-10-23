package com.chikara.jetpackcomposeseries.ui.main

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.chikara.jetpackcomposeseries.ui.arguments.MainActivityArgument

@Composable
fun MainActivityScreen(arg: MainActivityArgument) {
    Text(text = "Hello ${arg.name.ifEmpty { "User" }} (ID: ${arg.userId})")
}
