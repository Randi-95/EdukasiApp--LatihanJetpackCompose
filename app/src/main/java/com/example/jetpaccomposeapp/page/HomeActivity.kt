package com.example.jetpaccomposeapp.page

import BottomNavigationBar
import android.content.ClipData.Item
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.jetpaccomposeapp.R
import com.example.jetpaccomposeapp.component.BannerBerita
import com.example.jetpaccomposeapp.component.BeritaContent
import com.example.jetpaccomposeapp.component.CardBerita
import com.example.jetpaccomposeapp.component.IkonSlice
import com.example.jetpaccomposeapp.component.JudulEdukasiSection
import com.example.jetpaccomposeapp.component.M3SearchBarDemo
import com.example.jetpaccomposeapp.component.TopBarComponent
import com.example.jetpaccomposeapp.model.BeritaModel
import com.example.jetpaccomposeapp.model.getData
import com.example.jetpaccomposeapp.page.ui.theme.ColorBg
import com.example.jetpaccomposeapp.page.ui.theme.JetpacComposeAppTheme

class HomeActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        val berita: List<BeritaModel> = getData()


        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            var selectedItemIndex by remember {
                mutableStateOf(0)
            }
            installSplashScreen()
            JetpacComposeAppTheme {
                Scaffold (modifier = Modifier
                    .fillMaxSize(),
                    topBar = { TopAppBar(
                       title = {
                           Image(painter = painterResource(id = R.drawable.logo_app), contentDescription = "logo",
                               modifier = Modifier
                                   .height(32.dp))
                       },
                        colors = TopAppBarColors(containerColor = Color.Black, scrolledContainerColor = Color.Black, navigationIconContentColor = Color.Black, titleContentColor = Color.Black, actionIconContentColor = Color.Black)
                    ) },
                    bottomBar = { BottomNavigationBar(
                        onItemIndex = { actualIndex ->
                            selectedItemIndex = actualIndex
                        }
                    ) }

                ) { innerPadding ->
                    Column(modifier = Modifier
                        .padding(innerPadding)) {
                        when(selectedItemIndex) {
                            0 -> {LazyColumn(modifier = Modifier.background(color = ColorBg)) {

                                item { LazyRow {
                                    items(berita) { berita ->
                                        BannerBerita(berita)
                                    }
                                }
                                }
                                item { IkonSlice() }
                                item {Spacer(modifier = Modifier
                                    .height(16.dp))}
                                item {JudulEdukasiSection() }

                                items(berita) {berita ->
                                    BeritaContent(berita)
                                }

                            }}
                            1 -> {
                                Text(text = "Cari")
                            }
                            2 -> {}
                            3 -> {}
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun HomePage(modifier: Modifier = Modifier) {
    val berita: List<BeritaModel> = getData()

    Scaffold (modifier = Modifier
        .fillMaxSize(),
        topBar = { TopBarComponent() }) { innerPadding ->
        LazyColumn(modifier = Modifier.padding(innerPadding)) {
            item { LazyRow {
                items(berita) { berita ->
                    BannerBerita(berita)
                }
            }
            }
            item { IkonSlice() }
            item {Spacer(modifier = Modifier
                .height(16.dp))}
            item {JudulEdukasiSection() }

            items(berita) {berita ->
                BeritaContent(berita)
            }

        }
    }
}


@Preview (showBackground = true)
@Composable
private fun prevHomePage() {
    HomePage()
}


@Preview
@Composable
private fun prevTopBar() {
    TopBarComponent()
}



@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
