package com.my.daily.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.my.daily.jetpackcomposetutorial.ui.theme.JetpackComposeTutorialTheme

class Tutorial2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Column(modifier = Modifier
                .background(color = Color.Gray)
                .fillMaxSize()
                .padding(16.dp),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {

                Greeting1("Android1")
                Greeting1("Android2")
                Greeting1("Android3")
                Greeting1("Android4")

            }
        }
    }
}

@Composable
fun Greeting1(name: String) {

    Text(
        text = "Hello $name!",
        fontSize = dimensionResource(id = R.dimen.sp32).value.sp,
        fontWeight = FontWeight.Bold,
        color= colorResource(id = R.color.red),
        textAlign = TextAlign.Center,
        modifier = Modifier
            .border(2.dp, Color.Red)
            .background(Color.Gray)
            .padding(32.dp)
        )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview1() {
    JetpackComposeTutorialTheme {
        Greeting("Android")
    }
}