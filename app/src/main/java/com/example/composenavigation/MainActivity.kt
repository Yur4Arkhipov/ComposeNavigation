package com.example.composenavigation

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composenavigation.examples.basicnavigation.BasicNavigationActivity
import com.example.composenavigation.examples.navwithargs.NavigationWithArgsActivity
import com.example.composenavigation.ui.theme.ComposeNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeNavigationTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(
                        onClick = { startActivity(Intent(this@MainActivity,
                            BasicNavigationActivity::class.java))
                        }
                    ) {
                        Text("1. Базовая навигация")
                    }
                    Spacer(Modifier.height(8.dp))
                    Button(
                        onClick = { startActivity(Intent(this@MainActivity,
                            NavigationWithArgsActivity::class.java)) }
                    ) {
                        Text("2. Передача аргументов")
                    }
                }
            }
        }
    }
}