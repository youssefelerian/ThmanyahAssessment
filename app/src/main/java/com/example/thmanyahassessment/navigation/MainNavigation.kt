package com.example.thmanyahassessment.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.thmanyahassessment.navigation.model.Screen
import com.youssef.home.presentation.view.HomeScreen
import com.youssef.search.presentation.view.SearchScreen


@Composable
fun MainNavigation(navController: NavHostController, innerPadding: PaddingValues) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = Modifier.padding(innerPadding)
    ) {
        composable(Screen.Home.route) { HomeScreen(Modifier) }
        composable(Screen.Search.route) { SearchScreen(Modifier) }
    }
}