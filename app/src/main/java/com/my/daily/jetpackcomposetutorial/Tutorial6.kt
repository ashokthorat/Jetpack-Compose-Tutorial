package com.my.daily.jetpackcomposetutorial

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.my.daily.jetpackcomposetutorial.ui.theme.JetpackComposeTutorialTheme

class Tutorial6 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeTutorialTheme {
                Column(modifier = Modifier
                    .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    MyButton()
                }
            }
        }
    }
}

@Preview
@Composable
fun MyButton() {
    var count= remember { mutableStateOf(0) }

    val contest = LocalContext.current
    Button(
        onClick = {
            count.value++
            Toast.makeText(contest, "Count is ${count.value}", Toast.LENGTH_SHORT).show()
        },
        contentPadding = PaddingValues(10.dp),
        border = BorderStroke(5.dp, Color.Black),
        colors = ButtonDefaults.textButtonColors(
            containerColor = Color.Black,
            contentColor = Color.White
        )

    ) {
        Text(text = "Count is ${count.value}", modifier = Modifier.padding(5.dp))
    }
}