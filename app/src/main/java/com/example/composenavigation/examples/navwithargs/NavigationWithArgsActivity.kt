package com.example.composenavigation.examples.navwithargs

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composenavigation.MainActivity
import com.example.composenavigation.ui.theme.ComposeNavigationTheme

class NavigationWithArgsActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeNavigationTheme {
                NavigationWithArgsScreen(
                    onStartActivityRunButton = {
                        startActivity(Intent(this@NavigationWithArgsActivity, MainActivity::class.java))
                        finish()
                    }
                )
            }
        }
    }
}

@Composable
fun NavigationWithArgsScreen(
    onStartActivityRunButton: () -> Unit
) {

    val navController = rememberNavController()
    val sharedViewModel: SharedViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = StartScreen()
    ) {
        composable<StartScreen> { backStackEntry ->
//            val startScreenObject: StartScreen = backStackEntry.toRoute()
            StartScreen(
                navController = navController,
                count = sharedViewModel.count.value,
                onStartActivityRunButton = onStartActivityRunButton
            )
        }
        composable<ScreenA> { backStackEntry ->
//            val screenAObject: ScreenA = backStackEntry.toRoute()
            ScreenA(
                navController,
                onIncrementCount = { sharedViewModel.increment() },
                count = sharedViewModel.count.value
            )
        }
        composable<ScreenB> {
            ScreenB(navController)
        }
    }
}

@Composable
fun StartScreen(
    navController: NavHostController,
    count: Int,
    onStartActivityRunButton: () -> Unit
) {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Button(
            onClick = { navController.navigate(ScreenA()) }
        ) {
            Text("Go to A screen")
        }
        Button(
            onClick = { navController.navigate(ScreenB) }
        ) {
            Text("Go to B screen")
        }

        Spacer(Modifier.height(8.dp))
        Text("Count: $count")
        Spacer(Modifier.height(8.dp))

        Button(
            onClick = onStartActivityRunButton
        ) {
            Text("Go to main activity")
        }
    }
}

@Composable
fun ScreenA(
    navController: NavHostController,
    onIncrementCount: () -> Unit,
    count: Int
) {
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
                    navController.popBackStack()
                }
        )
        Text("ScreenA")
        Button(
            onClick = onIncrementCount
        ) {
            Text("+1")
        }
        Text("Count: $count")
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
                    navController.navigate(StartScreen())
                }
        )
        Text("ScreenB")
    }
}