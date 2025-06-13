package com.example.composenavigation.examples.navwithargs

import kotlinx.serialization.Serializable

@Serializable
data class StartScreen(val count: Int = 0)

@Serializable
data class ScreenA(var count: Int = 100)

@Serializable
data object ScreenB