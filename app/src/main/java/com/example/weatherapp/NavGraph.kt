package com.example.weatherapp

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.weatherapp.screens.Screen
import com.example.weatherapp.screens.SearchScreen
import com.example.weatherapp.screens.StartScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    context: Context
){
    NavHost(
        navController =  navController,
        startDestination = Screen.Home.route
    ){
        composable(
            route = Screen.Home.route
        ){
            StartScreen(context, navController)
        }
        composable(
            route = Screen.Search.route
        ){
            SearchScreen(navController)
        }
    }
}