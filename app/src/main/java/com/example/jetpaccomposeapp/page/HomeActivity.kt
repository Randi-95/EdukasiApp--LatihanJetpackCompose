package com.example.jetpaccomposeapp.page

import BottomNavigationBar
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.jetpaccomposeapp.component.BannerBerita
import com.example.jetpaccomposeapp.component.BeritaContent
import com.example.jetpaccomposeapp.component.IkonSlice
import com.example.jetpaccomposeapp.component.JudulEdukasiSection
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
                           TopBarComponent()
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
                        .background(color = ColorBg)
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
                                val textState = remember {
                                    mutableStateOf(TextFieldValue(""))
                                }

                                Column (modifier = Modifier
                                    .background(color = ColorBg)
                                    ) {
                                    SearchView(state = textState, placeholder = "Cari disini...", modifier = Modifier)
                                }

                                val searchText = textState.value.text

                                LazyColumn( modifier = Modifier
                                    .background(color = ColorBg)) {
                                   items(
                                       items = berita.filter {
                                           it.title.contains(searchText, ignoreCase = true)
                                       },
                                       key = {it}
                                   ){ item ->
                                        EdukasiContent(item)
                                   }
                                }



                            }
                            2 -> {
                            }
                            3 -> {}
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun SearchView(
    modifier: Modifier = Modifier,
    state: MutableState<TextFieldValue>,
    placeholder: String
) {
    TextField(
        value = state.value,
        onValueChange = {value ->
            state.value = value
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clip(RoundedCornerShape(30.dp))
            .border(1.dp, Color.White, RoundedCornerShape(30.dp)),
        leadingIcon = {
            Icon(imageVector = Icons.Filled.Search, contentDescription = "ikon cari")
                      },
        trailingIcon = {
            if (state.value.text.isNotEmpty()) {
                IconButton(onClick = {state.value = TextFieldValue("") }) {
                    Icon(imageVector = Icons.Filled.Clear, contentDescription = "ikon clear")
                }
            }
        },
        placeholder = {
            Text(text = placeholder)
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = ColorBg,
            focusedIndicatorColor = ColorBg,
            unfocusedContainerColor = ColorBg,
            disabledContainerColor = ColorBg
        ),
        textStyle = TextStyle(
            color = Color.White
        ),
        maxLines = 1,
        singleLine = true,
    )
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
