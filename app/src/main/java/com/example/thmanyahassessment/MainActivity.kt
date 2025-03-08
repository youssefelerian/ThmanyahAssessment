package com.example.thmanyahassessment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.thmanyahassessment.navigation.MainNavigation
import com.example.thmanyahassessment.navigation.model.Screen
import com.youssef.ui_core.core.text.TitleLText
import com.youssef.ui_core.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPadding ->
        MainNavigation(navController, innerPadding)
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = listOf(Screen.Home, Screen.Search)
    NavigationBar {
        items.forEach { screen ->
            NavigationBarItem(
                label = { TitleLText(screen.title) },
                selected = screen == Screen.Home,
                onClick = { navController.navigate(screen.route) },
                icon = {
                    Icon(
                        screen.icon,
                        contentDescription = screen.title
                    )
                }
            )
        }
    }
}