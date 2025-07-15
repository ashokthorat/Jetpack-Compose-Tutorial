package com.my.daily.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.my.daily.jetpackcomposetutorial.ui.theme.JetpackComposeTutorialTheme
import com.my.daily.jetpackcomposetutorial.vm.Tutorial8VM

class Tutorial8 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val vm = viewModel<Tutorial8VM>()
            JetpackComposeTutorialTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    val count = vm.count
                    MyStateAndFlowButtonUsingVm(count) { vm.increaseCount() }
                }
            }
        }
    }
}

@Composable
fun MyStateAndFlowButtonUsingVm(count: Int, updateCount: (Int) -> Unit) {

    Button(
        onClick = {
            updateCount(count)
        },
        contentPadding = PaddingValues(10.dp),
        border = BorderStroke(5.dp, Color.Black),
        colors = ButtonDefaults.textButtonColors(
            containerColor = Color.Black,
            contentColor = Color.White
        )

    ) {
        Text(text = "Count is $count", modifier = Modifier.padding(5.dp))
    }
}