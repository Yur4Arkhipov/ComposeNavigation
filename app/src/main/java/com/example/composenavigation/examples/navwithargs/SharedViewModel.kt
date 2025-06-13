package com.example.composenavigation.examples.navwithargs

import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.State

class SharedViewModel : ViewModel() {
    private val _count = mutableIntStateOf(0)
    val count: State<Int> get() = _count

    fun increment() {
        _count.intValue++
    }
}
