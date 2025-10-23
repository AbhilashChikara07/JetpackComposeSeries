package com.chikara.jetpackcomposeseries.ui.arguments

import kotlinx.serialization.Serializable

/**
 * Created by CHIKARA on 16/10/25.
 */

@Serializable
data class MainActivityArgument(
    val userId: String,
    val name: String
)