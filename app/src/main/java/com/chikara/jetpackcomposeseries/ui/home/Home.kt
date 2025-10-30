import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.chikara.jetpackcomposeseries.R
import com.chikara.jetpackcomposeseries.ui.theme.AppTypography


@Composable
fun Home() {
    val homeItems =
        listOf("Dashboard", "Your Courses", "Progress Report", "Notifications", "Updates")
    Column {
        Text(
            text = "Home",
            style = AppTypography.headlineLarge[28]!!,
            color = colorResource(R.color.purple_700),
        )
        Spacer(modifier = Modifier.height(8.dp))
        LazyColumn {
            items(homeItems) { item ->
                Text(
                    text = item,
                    style = AppTypography.headlineMedium[16]!!,
                    color = colorResource(R.color.gray_A700),
                    modifier = Modifier.padding(vertical = 6.dp)
                )
            }
        }
    }
}
