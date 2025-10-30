import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.chikara.jetpackcomposeseries.R
import com.chikara.jetpackcomposeseries.ui.theme.AppTypography
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*

@Composable
fun CommonOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    keyboardType: KeyboardType = KeyboardType.Text
) {
    val statusBarColor = colorResource(R.color.purple_100)

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(
                text = label,
                color = colorResource(R.color.purple_700),
                style = AppTypography.headlineMedium[14]!!
            )
        },
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = colorResource(R.color.purple_400),
            unfocusedIndicatorColor = colorResource(R.color.purple_400),
            focusedContainerColor = statusBarColor,
            unfocusedContainerColor = statusBarColor,
            focusedLabelColor = colorResource(R.color.purple_400),
            focusedTextColor = colorResource(R.color.purple_400),
            unfocusedTextColor = colorResource(R.color.purple_400)
        ),
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp)
    )
}
