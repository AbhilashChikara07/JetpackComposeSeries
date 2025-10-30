import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.dp
import com.chikara.jetpackcomposeseries.R
import com.chikara.jetpackcomposeseries.ui.theme.AppTypography

@Composable
fun CommonOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    keyboardType: KeyboardType = KeyboardType.Text
) {
    val statusBarColor = colorResource(R.color.purple_100)

    // 👁 For toggling password visibility
    var passwordVisible by remember { mutableStateOf(false) }

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
        singleLine = true,
        shape = RoundedCornerShape(8.dp),
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),

        // 🔒 Hide password if keyboardType is Password
        visualTransformation = if (keyboardType == KeyboardType.Password && !passwordVisible)
            PasswordVisualTransformation()
        else
            VisualTransformation.None,

        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = colorResource(R.color.purple_400),
            unfocusedIndicatorColor = colorResource(R.color.purple_400),
            focusedContainerColor = statusBarColor,
            unfocusedContainerColor = statusBarColor,
            focusedLabelColor = colorResource(R.color.purple_400),
            unfocusedLabelColor = colorResource(R.color.purple_400),
            focusedTextColor = colorResource(R.color.purple_400),
            unfocusedTextColor = colorResource(R.color.purple_400),
            cursorColor = colorResource(R.color.purple_400)
        ),
        modifier = Modifier.fillMaxWidth(),

        // 👁 Add trailing icon for show/hide password
//        trailingIcon = {
//            if (keyboardType == KeyboardType.Password) {
//                val image = if (passwordVisible)
//                    painterResource(id = R.drawable.ic_visibility)
//                else
//                    painterResource(id = R.drawable.ic_visibility_off)
//
//                IconButton(onClick = { passwordVisible = !passwordVisible }) {
//                    Icon(
//                        painter = image,
//                        contentDescription = if (passwordVisible) "Hide password" else "Show password",
//                        tint = colorResource(R.color.purple_400)
//                    )
//                }
//            }
//        }
    )
}
