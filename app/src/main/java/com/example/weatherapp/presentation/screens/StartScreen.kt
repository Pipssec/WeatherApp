package com.example.weatherapp.presentation.screens

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
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.weatherapp.R
import com.example.weatherapp.data.model.WeatherModel
import com.example.weatherapp.getData
import com.example.weatherapp.presentation.WeatherViewModel

@Composable
fun StartScreen(
    context: Context,
    weatherModel: WeatherViewModel = hiltViewModel()
                ) {
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
    val dialogText = remember {
        mutableStateOf("Washington")
    }
    val daysList = remember {
        mutableStateOf(listOf<WeatherModel>())
    }
    val dialogState = remember {
        mutableStateOf(false)
    }
    if (dialogState.value) {
        DialogSearch(dialogState,
            dialogText,
            onSubmit = {
                getData(it, context, daysList, currentDay)
            })
    }
    if(dialogText.value.length > 9){
        getData(dialogText.value, context, daysList, currentDay)
    }
    Image(
        painter = painterResource(id = R.drawable.weatherapp),
        contentDescription = "im1",
        modifier = Modifier
            .fillMaxSize()
            .alpha(0.5f),
        contentScale = ContentScale.FillBounds,
    )
    Column {
        MainCard(currentDay,
            onClickSync = {
                getData(dialogText.value, context, daysList, currentDay)
            },
            onClickSearch = {
                dialogState.value = true
                dialogText.value = ""
            }
        )
        TabLayout(daysList, currentDay)
    }
}