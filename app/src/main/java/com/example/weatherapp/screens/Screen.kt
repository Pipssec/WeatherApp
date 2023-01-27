package com.example.weatherapp.screens

sealed class Screen(val route: String){
    object Home: Screen(route = "main_screen")
    object Search: Screen(route = "search_screen")
}
