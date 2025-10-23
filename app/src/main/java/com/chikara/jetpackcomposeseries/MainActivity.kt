package com.chikara.jetpackcomposeseries

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.chikara.jetpackcomposeseries.ui.navigation.AppNavigation
import com.chikara.jetpackcomposeseries.ui.theme.JetpackComposeSeriesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeSeriesTheme {
                AppNavigation()
            }
        }
    }
}
