package com.example.jetpaccomposeapp.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpaccomposeapp.page.ui.theme.TeksJudul


@Composable
fun JudulEdukasiSection(modifier: Modifier = Modifier) {
    Text(text = "Edukasi Keuangan",
        modifier = Modifier
            .padding(start = 10.dp),
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
        color = TeksJudul)
}

@Preview (showBackground = true)
@Composable
private fun prevJudulEdukasi() {
    JudulEdukasiSection()
}