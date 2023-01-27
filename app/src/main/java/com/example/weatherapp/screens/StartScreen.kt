package com.example.weatherapp.screens

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.weatherapp.R
import com.example.weatherapp.data.WeatherModel
import com.example.weatherapp.getData

@Composable
fun StartScreen(context: Context,
                navController: NavController
                ){
    val daysList = remember {
        mutableStateOf(listOf<WeatherModel>())
    }
    val currentDay = remember {
        mutableStateOf(
            WeatherModel(
            "",
            "",
            "0",
            "",
            "",
            "0",
            "0",
            "",
        )
        )
    }
    getData("Gomel", context, daysList, currentDay)
    Image(
        painter = painterResource(id = R.drawable.weatherapp),
        contentDescription = "im1",
        modifier = Modifier
            .fillMaxSize()
            .alpha(0.5f),
        contentScale = ContentScale.FillBounds,
    )
    Column {
        MainCard(currentDay, navController)
        TabLayout(daysList, currentDay)
    }
}