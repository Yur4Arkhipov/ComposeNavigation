package com.example.composenavigation.examples

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composenavigation.ui.theme.ComposeNavigationTheme
import kotlinx.serialization.Serializable

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

@Serializable
object StartScreen

@Serializable
object ScreenA

@Serializable
object ScreenB

@Composable
fun BasicNavigationScreen() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        val navController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = StartScreen
        ) {
            composable<StartScreen> {
                StartScreen(navController = navController)
            }
            composable<ScreenA> {
                ScreenA()
            }
            composable<ScreenB> {
                ScreenB()
            }
        }
    }
}

@Composable
fun StartScreen(
    navController: NavHostController
) {
    val counter by remember { mutableIntStateOf(0) }

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

        Text("Counter: $counter")
    }
}

@Composable
fun ScreenA(
//    count: String,
//    onClick: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text("ScreenA")
//        Text("Counter: $count")
//        Button(
//            onClick = onClick
//        ) {
//            Text("+1")
//        }
    }
}

@Composable
fun ScreenB() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text("ScreenB")
    }
}