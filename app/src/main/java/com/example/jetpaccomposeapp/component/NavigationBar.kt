import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.jetpaccomposeapp.page.ui.theme.MyBlue

@Composable
fun BottomNavigationBar(
    onItemIndex: (selectedItemIndex: Int) -> Unit
) {
    var selectedItemIndex by remember {
        mutableStateOf(0)
    }

    val navigationListItem = listOf(
        NavigationItem(
            "Beranda",
            Icons.Outlined.Home,
            Icons.Filled.Home
        ),
        NavigationItem(
            "Cari",
            Icons.Outlined.Search,
            Icons.Filled.Search
        ),
        NavigationItem(
            "Notifikasi",
            Icons.Outlined.Notifications,
            Icons.Filled.Notifications
        ),
        NavigationItem(
            "Profile",
            Icons.Outlined.Person,
            Icons.Filled.Person
        )
    )

    NavigationBar (containerColor = Color.Black){
        navigationListItem.forEachIndexed { index, navigationItem ->
            NavigationBarItem(
                selected = index == selectedItemIndex
                ,
                onClick = {
                    selectedItemIndex = index
                    onItemIndex(selectedItemIndex)
                },
                icon = {
                    Icon(imageVector =
                        if(selectedItemIndex == index) navigationItem.IkonAktif
                        else navigationItem.Ikon,
                        contentDescription = navigationItem.title
                    )
                },
                label = {
                    Text(text = navigationItem.title)
                },
                colors = NavigationBarItemColors(
                    selectedIconColor = MyBlue,
                    selectedTextColor = MyBlue,
                    selectedIndicatorColor = Color(0xFF242424),
                    unselectedIconColor = Color.White,
                    unselectedTextColor = Color.White,
                    disabledIconColor = Color.DarkGray,
                    disabledTextColor = Color.DarkGray
                )
            )
        }
    }





}

data class NavigationItem(
    val title: String,
    val Ikon: ImageVector,
    val IkonAktif: ImageVector
)