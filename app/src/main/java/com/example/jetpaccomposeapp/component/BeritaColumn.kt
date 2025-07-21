package com.example.jetpaccomposeapp.component

import android.content.ClipData.Item
import android.content.Context
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpaccomposeapp.R
import com.example.jetpaccomposeapp.model.BeritaModel
import com.example.jetpaccomposeapp.model.getData
import com.example.jetpaccomposeapp.page.EdukasiDetailActivity
import com.example.jetpaccomposeapp.page.ui.theme.TeksDeskripsi
import com.example.jetpaccomposeapp.page.ui.theme.TeksIsi
import com.example.jetpaccomposeapp.page.ui.theme.TeksJudul

@Composable
fun BeritaContent(berita: BeritaModel) {
    val context = LocalContext.current
    CardBerita(berita) {
        context.startActivity(
            Intent(
                context ,
                EdukasiDetailActivity::class.java
            ).putExtra("detail_berita", berita)
        )
    }
}

@Composable
fun CardBerita(
    berita: BeritaModel,
    navigasiKeDetail: (BeritaModel) -> Unit
    ) {
    Row (verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clickable {
                navigasiKeDetail(berita)
            }
        .padding(10.dp)){
        ImageBerita(berita)
        Spacer(modifier = Modifier
            .width(10.dp))
        Column {
            Text(text = berita.title,
                color = TeksJudul,
                fontWeight = FontWeight.SemiBold,
                fontFamily = FontFamily.Default,
                fontSize = 18.sp,
            )

            Text(text = berita.description,
                color = TeksIsi,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
            )

            Text(text = berita.date,
                color = Color.Gray,
                fontWeight = FontWeight.Medium,
                fontSize = 12.sp,
            )
        }
    }
}

@Composable
private fun ImageBerita(berita: BeritaModel) {
    Image(
        painter = painterResource(id = berita.Image),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(100.dp)
            .clip(shape = RoundedCornerShape(10.dp))
    )
}

@Preview
@Composable
private fun prevImageBerita() {

}

