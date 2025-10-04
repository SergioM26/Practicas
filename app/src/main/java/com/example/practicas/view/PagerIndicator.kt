package com.example.practicas.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun PagerIndicator(size:Int, currentPage:Int, color: Color){
   Row(
       horizontalArrangement = Arrangement.SpaceBetween,
       modifier=Modifier.padding(top=60.dp)
   ){
       repeat(times = size) {
           Indicator(isSelect = it == currentPage, color)
       }
   }
}

@Composable
fun Indicator(isSelect:Boolean, color: Color){
    Box(
        modifier= Modifier
            .padding(5.dp)
            .height(25.dp)
            .width(25.dp)
            .clip(CircleShape)
            .background(color=if(isSelect) color else Color.Gray)
    ){

    }
}