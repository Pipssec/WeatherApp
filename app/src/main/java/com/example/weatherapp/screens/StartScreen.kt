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
import com.example.weatherapp.R
import com.example.weatherapp.data.WeatherModel
import com.example.weatherapp.getData

@Composable
fun StartScreen(context: Context){
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
    val dialogText = remember{
        mutableStateOf("Жлобин")
    }
    val daysList = remember {
        mutableStateOf(listOf<WeatherModel>())
    }
    val dialogState = remember {
        mutableStateOf(false)
    }
    if(dialogState.value){
        DialogSearch(dialogState,
                    dialogText,
                    onSubmit = {
                        getData(it, context, daysList, currentDay)
                })
    }
    if(dialogText.value.length > 5){
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