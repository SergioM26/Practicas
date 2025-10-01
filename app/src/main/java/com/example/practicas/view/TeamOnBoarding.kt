package com.example.practicas.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.example.practicas.data.TeamsPage
import com.example.practicas.R
import com.google.accompanist.pager.rememberPagerState
@OptIn(ExperimentalPagerApi::class,
    ExperimentalFoundationApi::class)

@Composable

fun TeamOnBoarding(navController: NavController, id: Int, start:Int) {
    val items = ArrayList<TeamsPage>()

    if (id == 1) {
        // NFC
        items.add(
            TeamsPage(
                logo = R.drawable.packers_logo,
                name = "Green Bay Packers",
                city = "Green Bay",
                stadium = "Lambeau Field",
                color = Color(0xFF293E38),
                founded = 1919
            )
        )

        items.add(
            TeamsPage(
                logo = R.drawable.eagles_logo,
                name = "Philadelphia Eagles",
                city = "Philadelphia",
                stadium = "Lincoln Financial Field",
                color = Color(0xFF004C54),
                founded = 1933
            )
        )

        items.add(
            TeamsPage(
                logo = R.drawable.panthers_logo,
                name = "Carolina Panthers",
                city = "Charlotte",
                stadium = "Bank of America Stadium",
                color = Color(0xFF0085CA),
                founded = 1995
            )
        )

        items.add(
            TeamsPage(
                logo = R.drawable.sf_logo,
                name = "San Francisco 49ers",
                city = "San Francisco",
                stadium = "Levi's Stadium",
                color = Color(0xFFAA0000),
                founded = 1946
            )
        )
    } else {
        // AFC
        items.add(
            TeamsPage(
                logo = R.drawable.bengals_logo,
                name = "Cincinnati Bengals",
                city = "Cincinnati",
                stadium = "Paycor Stadium",
                color = Color(0xFFF9551C),
                founded = 1968
            )
        )

        items.add(
            TeamsPage(
                logo = R.drawable.dolphins_logo,
                name = "Miami Dolphins",
                city = "Miami",
                stadium = "Hard Rock Stadium",
                color = Color(0xFF099098),
                founded = 1966
            )
        )

        items.add(
            TeamsPage(
                logo = R.drawable.colts_logo,
                name = "Indianapolis Colts",
                city = "Indianapolis",
                stadium = "Lucas Oil Stadium",
                color = Color(0xFF0B3B6D),
                founded = 1953
            )
        )
    items.add(
        TeamsPage(
            logo = R.drawable.kansas_logo,
            name = "Kansas City Chiefs",
            city = "Kansas City",
            stadium = "Arrowhead Stadium",
            color = Color(0xFFE42340),
            founded = 1960
        )
    )
}
        val pagerState  = rememberPagerState(
            pageCount=items.size,
            initialOffscreenLimit =2,
            infiniteLoop=true,
            initialPage=start
        )
        HorizontalSlider(
            teams = items,pagerState = pagerState,modifier= Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Color.White),
            navController, if(id == 1) {
                Color(0xFF0B3B6D)
            } else Color(0xFFD50A0A),
            if(id == 1) {
                R.drawable.nationalconf
            } else R.drawable.americanconf
        )

}
