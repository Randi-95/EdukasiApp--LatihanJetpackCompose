package com.example.jetpaccomposeapp.page

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpaccomposeapp.R
import com.example.jetpaccomposeapp.model.BeritaModel
import com.example.jetpaccomposeapp.page.ui.theme.ColorBg
import com.example.jetpaccomposeapp.page.ui.theme.TeksJudul


@Composable
fun EdukasiContent(berita: BeritaModel) {
    val context = LocalContext.current
   cardEdukasi(berita) {
       context.startActivity(
           Intent(
               context,
               EdukasiDetailActivity::class.java
           ).putExtra("detail_berita", berita)
       )
   }
}






@Composable
fun cardEdukasi(
    berita: BeritaModel,
    navigasiKeDetai: (BeritaModel) -> Unit ) {

    Column(modifier = Modifier
        .clickable {
            navigasiKeDetai(berita)
        }
        .padding(10.dp)) {
        Image(painter = painterResource(id = berita.Image), contentDescription = berita.title,
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(10.dp))
        )

        Spacer(modifier = Modifier
            .height(10.dp))

        Column (modifier = Modifier
            .padding(10.dp)){
            Text(text = "Keuangan",
                fontSize = 14.sp,
                color = TeksJudul)
            Text(text = berita.title,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
                color = TeksJudul)
            Text(text = berita.date,
                fontSize = 12.sp,
                color = Color.Gray)
        }
    }
}

