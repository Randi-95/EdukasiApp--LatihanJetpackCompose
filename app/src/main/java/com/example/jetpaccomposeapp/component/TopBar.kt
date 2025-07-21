package com.example.jetpaccomposeapp.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpaccomposeapp.R
import com.example.jetpaccomposeapp.ui.theme.Typography


val MyBlue = Color(0xFF3AB5FE)
val HitamBackground = Color(0xFF0D0D0D)

@Composable
fun TopBarComponent(modifier: Modifier = Modifier) {
    Row (modifier = Modifier
        .background(color = Color.Black)
        .padding(horizontal = 10.dp)
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,) {
        Image(painter = painterResource(id = R.drawable.logo_app), contentDescription = "logo",
            modifier = Modifier
                .size(90.dp))

        Icon(imageVector = Icons.Outlined.MoreVert, contentDescription = null,
            modifier = Modifier
                .size(30.dp),
            tint = Color.White)
    }
}

@Preview (showBackground = true)
@Composable
private fun prevTopBar() {
    TopBarComponent()
}