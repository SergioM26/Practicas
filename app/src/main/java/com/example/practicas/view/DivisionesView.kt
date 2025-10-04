package com.example.practicas.view

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.practicas.R
import com.example.practicas.components.divisionComponent

@Composable
fun DivisionesView(navController: NavController, id:Int){

    val headerIcon: Int
    val headerColor: Color

    // Divisiones
    val division1Nombre: String
    val division1Equipo: String
    val division1Color: Color
    val division1Logo: Int

    val division2Nombre: String
    val division2Equipo: String
    val division2Color: Color
    val division2Logo: Int

    val division3Nombre: String
    val division3Equipo: String
    val division3Color: Color
    val division3Logo: Int

    val division4Nombre: String
    val division4Equipo: String
    val division4Color: Color
    val division4Logo: Int

    if(id == 1) {
        // NFC
        headerIcon = R.drawable.nationalconf
        headerColor = Color(0xFF0B3B6D)

        division1Nombre = "North"
        division1Equipo = "Green Bay\nPackers"
        division1Color = Color(0xFF293E38)
        division1Logo = R.drawable.packers_logo

        division2Nombre = "East"
        division2Equipo = "Philadelphia\nEagles"
        division2Color = Color(0xFF004C54)
        division2Logo = R.drawable.eagles_logo

        division3Nombre = "South"
        division3Equipo = "Carolina\nPanthers"
        division3Color = Color(0xFF0085CA)
        division3Logo = R.drawable.panthers_logo

        division4Nombre = "West"
        division4Equipo = "San Francisco\n49ers"
        division4Color = Color(0xFFAA0000)
        division4Logo = R.drawable.sf_logo
    } else {
        // AFC
        headerIcon = R.drawable.americanconf
        headerColor = Color(0xFFD50A0A)

        division1Nombre = "North"
        division1Equipo = "Cincinnati\nBengals"
        division1Color = Color(0xFFF9551C)
        division1Logo = R.drawable.bengals_logo

        division2Nombre = "East"
        division2Equipo = "Miami\nDolphins"
        division2Color = Color(0xFF099098)
        division2Logo = R.drawable.dolphins_logo

        division3Nombre = "South"
        division3Equipo = "Indianapolis\nColts"
        division3Color = Color(0xFF0B3B6D)
        division3Logo = R.drawable.colts_logo

        division4Nombre = "West"
        division4Equipo = "Kansas City\nChiefs"
        division4Color = Color(0xFFE42340)
        division4Logo = R.drawable.kansas_logo
    }

    Column(modifier = Modifier.fillMaxSize()) {
        // Encabezado con logo
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(headerColor)
            ){}
            Image(
                painter = painterResource(headerIcon),
                contentDescription = "",
                modifier = Modifier
                    .size(80.dp)
                    .offset(y = (100/2).dp)
            )
            IconButton(
                onClick = { navController.popBackStack() },
                modifier = Modifier.align(Alignment.CenterStart).offset(y = 20.dp),// ← solo este se va a la izquierda
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Botón",
                    tint = Color.White
                )
            }        }

        Spacer(modifier = Modifier.height(50.dp)) // Espacio para el logo que sobresale

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            Row (modifier = Modifier.weight(1f)){
                divisionComponent(
                    navController,
                    division1Nombre,
                    division1Equipo,
                    division1Color,
                    division1Logo,
                    id,0)
            }
            Row (modifier = Modifier.weight(1f)){
                divisionComponent(
                    navController,
                    division2Nombre,
                    division2Equipo,
                    division2Color,
                    division2Logo,
                    id,1)
            }
            Row (modifier = Modifier.weight(1f)){
                divisionComponent(
                    navController,
                    division3Nombre,
                    division3Equipo,
                    division3Color,
                    division3Logo,
                    id,2)
            }
            Row (modifier = Modifier.weight(1f)){
                divisionComponent(
                    navController,
                    division4Nombre,
                    division4Equipo,
                    division4Color,
                    division4Logo,
                    id,3)
            }
            Spacer(modifier = Modifier.height(50.dp)) // Espacio para el logo que sobresale
        }

    }
}