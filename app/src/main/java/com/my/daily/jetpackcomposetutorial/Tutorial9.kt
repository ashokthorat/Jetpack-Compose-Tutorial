package com.my.daily.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class Tutorial9 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val myFlow = flow {
            for (i in 1..100) {
                emit(i)
                delay(1000L)
            }
        }
        setContent {
            MyFlowTextView(myFlow)
        }
    }
}

@Composable
fun MyFlowTextView(myFlow: Flow<Int>) {
    val currentValue = myFlow.collectAsState(initial = 1)
    Column(verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "current value is :${currentValue.value}")

    }
}
