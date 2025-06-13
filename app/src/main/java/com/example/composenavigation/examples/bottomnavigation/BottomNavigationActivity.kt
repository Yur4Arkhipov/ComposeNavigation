package com.example.composenavigation.examples.bottomnavigation

import android.content.Intent
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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composenavigation.MainActivity
import com.example.composenavigation.ui.theme.ComposeNavigationTheme

class BottomNavigationActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeNavigationTheme {
                BottomNavigation(
                    onStartActivityRunButton = {
                        startActivity(Intent(this@BottomNavigationActivity, MainActivity::class.java))
                        finish()
                    }
                )
            }
        }
    }
}

@Composable
fun BottomNavigation(
    onStartActivityRunButton: () -> Unit
) {

    val navHostController = rememberNavController()

    NavHost(
        navController = navHostController,
        startDestination = Home
    ) {
        composable<Profile> {
            ProfileScreen(
                onStartActivityRunButton = onStartActivityRunButton
            )
        }
        composable<Settings> {
            SettingsScreen(
                onStartActivityRunButton = onStartActivityRunButton
            )
        }
        composable<Home> {
            HomeScreen(
                onStartActivityRunButton = onStartActivityRunButton
            )
        }
    }
}

@Composable
fun HomeScreen(
//    navHostController: NavHostController,
    onStartActivityRunButton: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Button(
            onClick = onStartActivityRunButton
        ) {
            Text("Go to main activity")
        }
        Text("Home screen")
    }
}

@Composable
fun ProfileScreen(
//    navHostController: NavHostController,
    onStartActivityRunButton: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Button(
            onClick = onStartActivityRunButton
        ) {
            Text("Go to main activity")
        }
        Text("Profile screen")
    }
}

@Composable
fun SettingsScreen(
//    navHostController: NavHostController,
    onStartActivityRunButton: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Button(
            onClick = onStartActivityRunButton
        ) {
            Text("Go to main activity")
        }
        Text("Settings screen")
    }
}