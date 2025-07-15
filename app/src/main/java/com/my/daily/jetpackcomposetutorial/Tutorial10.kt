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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.my.daily.jetpackcomposetutorial.vm.Tutorial8VM

class Tutorial10 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val vm = viewModel<Tutorial8VM>()
            MyFlowWithVm(vm)
        }

    }
}

@Composable
fun MyFlowWithVm(vm: Tutorial8VM) {
    val currentValue = vm.myFlow.collectAsState(initial = 1)
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "current value is :${currentValue.value}")

    }
    //flow map operator change the data type as per the requirement e.g int to string
    //flow filter operator add filter as per the requirement
}
