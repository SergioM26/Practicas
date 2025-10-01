package com.example.practicas.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.practicas.data.TeamsPage
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HorizontalSlider(
    teams:ArrayList<TeamsPage>,
    pagerState: PagerState,
    modifier: Modifier,
    navController: NavController,
    color: Color,
    icono: Int
){
    Box(modifier=Modifier){
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .background(color)
                ){}
                Image(
                    painter = painterResource(icono),
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


            HorizontalPager(state = pagerState) { page ->
                val team = teams[page]

                Column(
                    modifier = Modifier
                        .padding(20.dp)
                        .fillMaxWidth()
                        .border(
                            width = 2.dp,
                            color = team.color,
                            shape = RoundedCornerShape(12.dp)
                        )
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Nombre
                    Text(
                        text = team.name,
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold,
                        color = team.color
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Logo
                    Image(
                        painter = painterResource(id = team.logo),
                        contentDescription = team.name,
                        modifier = Modifier
                            .size(120.dp)
                            .align(Alignment.CenterHorizontally)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Ciudad y estadio
                    Text(
                        text = "${team.city} • ${team.stadium}",
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Medium
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    // Año de fundación
                    Text(
                        text = "Fundado en ${team.founded}",
                        fontSize = 14.sp,
                        fontStyle = FontStyle.Italic
                    )
                }
            }
            PagerIndicator(size = teams.size,
                currentPage = pagerState.currentPage, color)

        }

    }

}
