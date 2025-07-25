package com.example.jetpaccomposeapp.page

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpaccomposeapp.R
import com.example.jetpaccomposeapp.component.BannerBerita
import com.example.jetpaccomposeapp.component.BannerCard
import com.example.jetpaccomposeapp.component.BeritaContent
import com.example.jetpaccomposeapp.component.HitamBackground
import com.example.jetpaccomposeapp.component.IkonSlice
import com.example.jetpaccomposeapp.component.JudulEdukasiSection
import com.example.jetpaccomposeapp.component.TopBarComponent
import com.example.jetpaccomposeapp.model.BeritaModel
import com.example.jetpaccomposeapp.page.ui.theme.ColorBg
import com.example.jetpaccomposeapp.page.ui.theme.JetpacComposeAppTheme
import com.example.jetpaccomposeapp.page.ui.theme.TeksDeskripsi
import com.example.jetpaccomposeapp.page.ui.theme.TeksIsi

class EdukasiDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val berita: BeritaModel = intent.getSerializableExtra("detail_berita") as BeritaModel
        Log.d("Berita", "Isi Berita ${berita.toString()}")
        setContent {
            JetpacComposeAppTheme {
                Scaffold (modifier = Modifier,
                    topBar = { }) { innerPadding ->
                    LazyColumn(modifier = Modifier
                        .background(color = ColorBg)
                        .padding(innerPadding)) {
                        item {
                            JudulDetail(berita = berita)
                        }
                        
                        item {
                            isiDeskripsi(berita = berita)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ButtonBack(navigasiKeBeranda: () -> Unit) {
    val context = LocalContext.current
    Row (horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
        .padding(horizontal = 4.dp)
        .fillMaxWidth()){
        Icon(imageVector = Icons.Outlined.ArrowBack, contentDescription = "tombol kembali",
            modifier = Modifier
                .clickable { navigasiKeBeranda() }
                .size(30.dp),
            tint = Color.White,)
        Image(painter = painterResource(id = R.drawable.baseline_link_24), contentDescription = "Link Website",
            modifier = Modifier
                .clickable {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://financial-tracker-capstone.vercel.app/blogs"))
                    context.startActivity(intent)
                }
                .size(30.dp))
    }
}

@Composable
fun JudulDetail(berita: BeritaModel
    ) {
    val context = LocalContext.current
    val MyBlue = Color(0xFF3AB5FE)
    Box {
        ImageDetail(berita)
        Column (verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .matchParentSize()
                .padding(16.dp)){

            ButtonBack(){
                context.startActivity(
                    Intent(
                        context,
                        HomeActivity::class.java
                    )
                )
            }

            Column {
                Box (modifier = Modifier
                    .clip(shape = RoundedCornerShape(40.dp))
                    .background(MyBlue)
                    .padding(horizontal = 14.dp, vertical = 6.dp)
                ){

                    Text(text = "Financial",
                        color = Color.White,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
                Text(text = berita.title,
                    fontWeight = FontWeight.Medium,
                    fontSize = 25.sp,
                    color = Color.White
                )
                Text(text = berita.date,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                    color = Color.LightGray
                )
            }

            Spacer(modifier = Modifier
                .width(4.dp))
        }

    }
}

@Composable
fun ImageDetail(berita: BeritaModel) {
    Box {
        Image(painter = painterResource(id = berita.Image), contentDescription = "Saving goals",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(420.dp)
                .width(400.dp)
        )

        Box(
            modifier = Modifier
                .matchParentSize()
                .size(300.dp)
                .background(HitamBackground.copy(alpha = 0.7f))
        )

    }
}

@Composable
fun isiDeskripsi(berita: BeritaModel) {
    Column(modifier = Modifier
        .offset(y = -120.dp)
        .fillMaxWidth()
        .background(color = ColorBg, shape = RoundedCornerShape(30.dp))) {
        Text(text = berita.description,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            lineHeight = 25.sp,
            textAlign = TextAlign.Justify,
            color = TeksDeskripsi,
            modifier = Modifier
                .padding(vertical = 26.dp, horizontal = 10.dp))
    }
}



@Preview (showBackground = true)
@Composable
private fun prevJudulDetail() {

}