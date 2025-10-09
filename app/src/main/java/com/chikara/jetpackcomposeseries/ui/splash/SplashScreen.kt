package com.chikara.jetpackcomposeseries.ui.splash

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.IntOffset
import kotlinx.coroutines.delay
import androidx.compose.animation.core.Animatable
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import com.chikara.jetpackcomposeseries.R
import com.chikara.jetpackcomposeseries.ui.theme.AppTypography

class SplashScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SplashScreenComponent()
        }
    }
}

@Composable
fun SplashScreenComponent() {
    val scale = remember { Animatable(0.1f) }

    LaunchedEffect(Unit) {
        // Animate scale from 0.1f to 1f
        scale.animateTo(
            targetValue = 1f,
            animationSpec = tween(
                durationMillis = 1200
            )
        )
        // Optional: wait before navigating
        delay(1000)
        // TODO: Navigate to main screen
    }

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = stringResource(R.string.jetpack_compose_text),
            style = AppTypography.displayMedium[32]!!,
            color = colorResource(R.color.purple_700),
            modifier = Modifier.scale(scale.value)
        )
    }
}
