package com.example.composenavigation.examples.basicnavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composenavigation.ui.theme.ComposeNavigationTheme

class BasicNavigationActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeNavigationTheme {
                BasicNavigationScreen()
            }
        }
    }
}

@Composable
fun BasicNavigationScreen() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = StartScreen
    ) {
        composable<StartScreen> {
            StartScreen(navController = navController)
        }
        composable<ScreenA> {
            ScreenA(navController)
        }
        composable<ScreenB> {
            ScreenB(navController)
        }
    }
}

@Composable
fun StartScreen(navController: NavHostController) {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Button(
            onClick = { navController.navigate(ScreenA) }
        ) {
            Text("Go to A screen")
        }
        Button(
            onClick = { navController.navigate(ScreenB) }
        ) {
            Text("Go to B screen")
        }
    }
}

@Composable
fun ScreenA(navController: NavHostController) {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Icon(
            imageVector = Icons.Default.Close,
            contentDescription = null,
            modifier = Modifier
                .clickable {
                    navController.navigate(StartScreen)
                }
        )
        Text("ScreenA")
    }
}

@Composable
fun ScreenB(navController: NavHostController) {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Icon(
            imageVector = Icons.Default.Close,
            contentDescription = null,
            modifier = Modifier
                .clickable {
                    navController.navigate(StartScreen)
                }
        )
        Text("ScreenB")
    }
}