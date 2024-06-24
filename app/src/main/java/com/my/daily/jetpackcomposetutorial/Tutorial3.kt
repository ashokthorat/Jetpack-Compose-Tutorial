package com.my.daily.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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

class Tutorial3 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            rowDemo()
        }
    }
}

@Composable
fun Greeting2(name: String) {
    Text(
        text = "$name!",
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
fun GreetingPreview2() {
    JetpackComposeTutorialTheme {
       rowDemo()
    }
}
@Composable
fun rowDemo()
{
    Row(modifier = Modifier
        .background(color = Color.Gray)
        .fillMaxSize()
        .padding(16.dp)
        .fillMaxWidth()
        .fillMaxHeight(),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Greeting2("ABC")
        Greeting2("Xyz")

    }
}