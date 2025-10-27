package com.chikara.jetpackcomposeseries.ui.common

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.chikara.jetpackcomposeseries.R
import com.chikara.jetpackcomposeseries.ui.theme.AppTypography

@Composable
fun CommonButton(
    textResId: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    containerColor: Int = R.color.purple_700,
    textColor: Int = R.color.white,
    heightDp: Int = 50,
    cornerRadius: Int = 12
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(heightDp.dp),
        shape = RoundedCornerShape(cornerRadius.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(containerColor),
            contentColor = colorResource(textColor)
        )
    ) {
        Text(
            text = stringResource(id = textResId),
            style = AppTypography.labelLarge[18]!!,
            color = colorResource(textColor)
        )
    }
}
