package com.my.daily.jetpackcomposetutorial

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.my.daily.jetpackcomposetutorial.enums.RedirectEnum
import com.my.daily.jetpackcomposetutorial.ui.theme.JetpackComposeTutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTutorialTheme {
                MyList()
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyList() {
    val items = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(
                        "Jetpack Compose Tutorial",
                        color = Color.White
                    )
                }
            )
        },
    ) {
        LazyColumn(modifier = Modifier.padding(top = 60.dp)) {
            itemsIndexed(items) { index, item ->
                Text(
                    text = item,
                    modifier = Modifier
                        .padding(16.dp)
                        .clickable {
                            redirectToNextPage(context, index)
                        }
                )
            }

        }
    }
}

fun redirectToNextPage(context: Context, index: Int) {
    when (index) {
        RedirectEnum.tutorial1.index -> {
            val intent = Intent(context, Tutorial1::class.java)
            context.startActivity(intent)
        }

        RedirectEnum.tutorial2.index -> {
            val intent = Intent(context, Tutorial2::class.java)
            context.startActivity(intent)
        }
        RedirectEnum.tutorial3.index -> {
            val intent = Intent(context, Tutorial3::class.java)
            context.startActivity(intent)
        }
        RedirectEnum.tutorial4.index -> {
            val intent = Intent(context, Tutorial4::class.java)
            context.startActivity(intent)
        }
        RedirectEnum.tutorial5.index -> {
        val intent = Intent(context, Tutorial5::class.java)
        context.startActivity(intent)
    }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreen() {
    JetpackComposeTutorialTheme {
        MyList()
    }
}


