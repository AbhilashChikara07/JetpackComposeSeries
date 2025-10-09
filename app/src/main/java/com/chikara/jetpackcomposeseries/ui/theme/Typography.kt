package com.chikara.jetpackcomposeseries.ui.theme

/**
 * Created by CHIKARA on 09/10/25.
 */

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.chikara.jetpackcomposeseries.R

// Outfit font family
val OutfitFontFamily = FontFamily(
    Font(R.font.outfit_thin, FontWeight.W100),
    Font(R.font.outfit_extra_light, FontWeight.W200),
    Font(R.font.outfit_light, FontWeight.W300),
    Font(R.font.outfit_regular, FontWeight.W400),
    Font(R.font.outfit_medium, FontWeight.W500),
    Font(R.font.outfit_semi_bold, FontWeight.W600),
    Font(R.font.outfit_bold, FontWeight.W700),
    Font(R.font.outfit_extra_bold, FontWeight.W800),
    Font(R.font.outfit_black, FontWeight.W900)
)

// List of font sizes you want
val fontSizes = listOf(12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 42, 44)

// Base font weights for each TextStyle
val baseWeights = mapOf(
    "displayLarge" to FontWeight.W700,
    "displayMedium" to FontWeight.W600,
    "displaySmall" to FontWeight.W500,
    "headlineLarge" to FontWeight.W700,
    "headlineMedium" to FontWeight.W600,
    "headlineSmall" to FontWeight.W500,
    "bodyLarge" to FontWeight.W400,
    "bodyMedium" to FontWeight.W400,
    "bodySmall" to FontWeight.W400,
    "labelLarge" to FontWeight.W500,
    "labelMedium" to FontWeight.W500,
    "labelSmall" to FontWeight.W500
)

// Object to hold all TextStyles with multiple sizes
object AppTypography {

    // Corrected: return TextStyle explicitly
    val displayLarge: Map<Int, TextStyle> = fontSizes.associateWith { size ->
        TextStyle(
            fontFamily = OutfitFontFamily,
            fontWeight = baseWeights["displayLarge"]!!,
            fontSize = size.sp
        )
    }

    val displayMedium: Map<Int, TextStyle> = fontSizes.associateWith { size ->
        TextStyle(
            fontFamily = OutfitFontFamily,
            fontWeight = baseWeights["displayMedium"]!!,
            fontSize = size.sp
        )
    }

    val displaySmall: Map<Int, TextStyle> = fontSizes.associateWith { size ->
        TextStyle(
            fontFamily = OutfitFontFamily,
            fontWeight = baseWeights["displaySmall"]!!,
            fontSize = size.sp
        )
    }

    val headlineLarge: Map<Int, TextStyle> = fontSizes.associateWith { size ->
        TextStyle(
            fontFamily = OutfitFontFamily,
            fontWeight = baseWeights["headlineLarge"]!!,
            fontSize = size.sp
        )
    }

    val headlineMedium: Map<Int, TextStyle> = fontSizes.associateWith { size ->
        TextStyle(
            fontFamily = OutfitFontFamily,
            fontWeight = baseWeights["headlineMedium"]!!,
            fontSize = size.sp
        )
    }

    val headlineSmall: Map<Int, TextStyle> = fontSizes.associateWith { size ->
        TextStyle(
            fontFamily = OutfitFontFamily,
            fontWeight = baseWeights["headlineSmall"]!!,
            fontSize = size.sp
        )
    }

    val bodyLarge: Map<Int, TextStyle> = fontSizes.associateWith { size ->
        TextStyle(
            fontFamily = OutfitFontFamily,
            fontWeight = baseWeights["bodyLarge"]!!,
            fontSize = size.sp
        )
    }

    val bodyMedium: Map<Int, TextStyle> = fontSizes.associateWith { size ->
        TextStyle(
            fontFamily = OutfitFontFamily,
            fontWeight = baseWeights["bodyMedium"]!!,
            fontSize = size.sp
        )
    }

    val bodySmall: Map<Int, TextStyle> = fontSizes.associateWith { size ->
        TextStyle(
            fontFamily = OutfitFontFamily,
            fontWeight = baseWeights["bodySmall"]!!,
            fontSize = size.sp
        )
    }

    val labelLarge: Map<Int, TextStyle> = fontSizes.associateWith { size ->
        TextStyle(
            fontFamily = OutfitFontFamily,
            fontWeight = baseWeights["labelLarge"]!!,
            fontSize = size.sp
        )
    }

    val labelMedium: Map<Int, TextStyle> = fontSizes.associateWith { size ->
        TextStyle(
            fontFamily = OutfitFontFamily,
            fontWeight = baseWeights["labelMedium"]!!,
            fontSize = size.sp
        )
    }

    val labelSmall: Map<Int, TextStyle> = fontSizes.associateWith { size ->
        TextStyle(
            fontFamily = OutfitFontFamily,
            fontWeight = baseWeights["labelSmall"]!!,
            fontSize = size.sp
        )
    }
}
