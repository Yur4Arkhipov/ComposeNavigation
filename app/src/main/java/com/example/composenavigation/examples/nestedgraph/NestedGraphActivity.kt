package com.example.composenavigation.examples.nestedgraph

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.composenavigation.ui.theme.ComposeNavigationTheme

class NestedGraphActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeNavigationTheme {
                NestedGraphNavigation()
            }
        }
    }
}

@Composable
fun NestedGraphNavigation() {

    val navHostController = rememberNavController()

    NavHost(
        navController = navHostController,
        startDestination = Auth
    ) {
        navigation<Auth> (startDestination = Login) {
            composable<Login> { LoginScreen(navHostController) }
            composable<Register> { RegisterScreen(navHostController) }
        }

        navigation<Main> (startDestination = Home) {
            composable<Home> { HomeScreen(navHostController) }
            composable<Details> { DetailsScreen(navHostController) }
        }
    }
}

@Composable
fun LoginScreen(navController: NavHostController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text("Login Screen")

        Button(onClick = {
            // После логина, переход в home-граф
            navController.navigate(Main) {
                popUpTo(Auth) { inclusive = true } // Удаляем auth-граф из backstack
            }
        }) {
            Text("Login")
        }

        Button(onClick = {
            navController.navigate(Register)
        }) {
            Text("Go to Register")
        }
    }
}

@Composable
fun RegisterScreen(navController: NavHostController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text("Register Screen")

        Button(onClick = {
            navController.popBackStack() // Вернуться к логину
        }) {
            Text("Back to Login")
        }
    }
}

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text("Home Screen")

        Button(onClick = {
            navController.navigate(Details)
        }) {
            Text("Go to Details")
        }

        Button(onClick = {
            navController.navigate(Auth) {
                popUpTo("main") { inclusive = true }
            }
        }) {
            Text("Logout")
        }
    }
}

@Composable
fun DetailsScreen(navController: NavHostController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text("Details Screen")

        Button(onClick = {
            navController.popBackStack()
        }) {
            Text("Back to Home")
        }
    }
}

