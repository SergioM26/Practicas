package com.example.practicas.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.practicas.R


//@Preview
@Composable
fun HomeView(navController: NavController){
    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .background(Color(0xFF0B3B6D))
                    .clickable { /* Navegar a AFC */ },
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.nationalconf),
                    contentDescription = "AFC",
                    modifier = Modifier.size(200.dp)
                )
            }

            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .background(Color(0xFFB71C1C))
                    .clickable { /* Navegar a NFC */ },
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.americanconf),
                    contentDescription = "NFC",
                    modifier = Modifier.size(200.dp)
                )
            }
        }

        Image(
            painter = painterResource(id = R.drawable.nfl_logo),
            contentDescription = "NFL",
            modifier = Modifier
                .align(Alignment.Center)
                .size(50.dp)
        )
    }

}