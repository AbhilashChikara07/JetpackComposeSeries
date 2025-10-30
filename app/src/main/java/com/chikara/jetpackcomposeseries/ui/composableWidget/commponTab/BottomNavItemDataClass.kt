package com.chikara.jetpackcomposeseries.ui.common

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItemDataClass(
    val title: String,
    val icon: ImageVector,
    val route: String = ""
)
