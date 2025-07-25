package com.example.jetpaccomposeapp.component

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpaccomposeapp.model.BeritaModel
import com.example.jetpaccomposeapp.model.getData
import com.example.jetpaccomposeapp.page.EdukasiDetailActivity


@Composable
fun BannerBerita(berita: BeritaModel) {
    val context = LocalContext.current
    BannerCard(berita){
        context.startActivity(
            Intent(
                context,
                EdukasiDetailActivity::class.java
            ).putExtra("detail_berita", berita)
        )
    }
}

@Composable
private fun ImageBerita(berita: BeritaModel) {
    Box {
        Image(painter = painterResource(id = berita.Image), contentDescription = "Saving goals",
            modifier = Modifier
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
fun BannerCard(
    berita: BeritaModel,
    navigasiKedetail:(BeritaModel) -> Unit
    )
{
    val MyBlue = Color(0xFF3AB5FE)
    Box(modifier = Modifier
        .clickable {
            navigasiKedetail(berita)
        }) {
        ImageBerita(berita)
        Column (verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .matchParentSize()
                .padding(16.dp)){
            Box (modifier = Modifier
                .clip(shape = RoundedCornerShape(40.dp))
                .background(MyBlue)
                .padding(horizontal = 16.dp, vertical = 10.dp)
            ){

                Text(text = "Financial",
                    color = Color.White,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Medium
                )
            }

            Column {
                Text(text = berita.title,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 30.sp,
                    color = Color.White
                )
                Text(text = berita.date,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                    color = Color.LightGray
                )
            }

        }

    }
}

@Composable
fun IkonSlice(modifier: Modifier = Modifier) {
    Row (modifier = Modifier
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center){
        for(i in 0..5){
            Text(text = ".",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                color = Color.Gray)
        }
    }
}

@Preview
@Composable
private fun prevIcon() {
    IkonSlice()
}