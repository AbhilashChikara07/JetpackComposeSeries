import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.chikara.jetpackcomposeseries.R
import com.chikara.jetpackcomposeseries.ui.auth.viewModel.AuthViewModel
import com.chikara.jetpackcomposeseries.ui.common.CommonButton
import com.chikara.jetpackcomposeseries.ui.theme.AppTypography

@Composable
fun More(navController: NavController?, authViewModel: AuthViewModel?) {
    Column(horizontalAlignment = Alignment.Start) {
        Text(
            text = "Profile Info",
            style = AppTypography.headlineLarge[28]!!,
            color = colorResource(R.color.purple_700),
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text("Name: Abhilash Chikara", style = AppTypography.headlineMedium[16]!!)
        Text("Email: abhilash@example.com", style = AppTypography.headlineMedium[16]!!)
        Text("Password: ********", style = AppTypography.headlineMedium[16]!!)

        Spacer(modifier = Modifier.height(45.dp))

        CommonButton(
            textResId = R.string.loginOut,
            onClick = {
                authViewModel?.signOut()
                navController?.navigate("login") {
                    popUpTo("home") { inclusive = true }
                }
            }
        )
    }
}