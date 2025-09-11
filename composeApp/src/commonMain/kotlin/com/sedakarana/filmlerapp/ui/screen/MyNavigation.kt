package com.sedakarana.filmlerapp.ui.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.sedakarana.filmlerapp.data.entity.Movies
import kotlinx.serialization.json.Json

@Composable
fun MyNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") { Home(navController) }
        composable(
            "detail/{movie}",
            arguments = listOf(
                navArgument("movie") { type = NavType.StringType }
            ))
        {
            val movieValue = it.arguments?.getString("movie")!!
            val movie = Json.decodeFromString<Movies>(movieValue)
            Detail(navController, movie)
        }
    }
}