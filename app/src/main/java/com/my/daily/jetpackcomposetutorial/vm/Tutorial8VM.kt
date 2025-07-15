package com.my.daily.jetpackcomposetutorial.vm

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

class Tutorial8VM:ViewModel() {
    var count by mutableIntStateOf(0)
    fun increaseCount(){
        count++
    }
    val myFlow = flow {
        for (i in 1..100) {
            emit(i)
            delay(1000L)
        }
    }
}