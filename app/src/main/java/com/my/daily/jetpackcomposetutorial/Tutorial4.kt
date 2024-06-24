package com.my.daily.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
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

class Tutorial4 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BoxExmaple1()
        }
    }
}

@Composable
fun BoxExmaple1() {
    Box(
        modifier = Modifier
            .background(Color.Green)
            .size(180.dp, 300.dp)
    )
    {
        Box(
            modifier = Modifier
                .background(Color.Yellow)
                .size(125.dp, 100.dp)
        )
        {
            Text(
                text = "Welcome",
                modifier = Modifier
                    .background(Color.Gray)
                    .fillMaxHeight(0.5f)
                    .fillMaxWidth(),
                style = MaterialTheme.typography.bodyLarge
            )
        }

    }
}

@Preview
@Composable
fun BoxExample() {
    BoxExmaple1()
}
/*
   Button(
    onClick = { /*TODO*/ },
    colors = ButtonDefaults.buttonColors(
       contentColor = Color.White,
       containerColor = Color.Black
    )
){

}
 Button(
    onClick = { /*TODO*/ },
    colors = ButtonDefaults.buttonColors(
       contentColor = Color.White,
       containerColor = Color.Black
    )
){

}

 */

