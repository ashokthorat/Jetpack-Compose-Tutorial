package com.my.daily.jetpackcomposetutorial

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.anushka.composerecyclerview.model.TvShow
import com.my.daily.jetpackcomposetutorial.compose.TvListItems
import com.my.daily.jetpackcomposetutorial.data.TvShowList

class Tutorial5 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // ScrollableColumnDemo()
            //  LazyColumnDemo()
            /* LazyColumnDemo2 {
                 Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
             }*/
            DisplayTvShows {
                Toast.makeText(this, it.name, Toast.LENGTH_SHORT).show()

            }
        }
    }
}

@Composable
fun ScrollableColumnDemo() {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .verticalScroll(scrollState)
            .padding(
                top = 24.dp,
                start = 16.dp,
                end = 16.dp,
                bottom = 16.dp
            )
    ) {
        for (i in 1..100) {
            Text(
                "User name $i",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(10.dp),

                )
            HorizontalDivider(thickness = 3.dp, color = Color.Black)
        }
    }
}

@Composable
private fun LazyColumnDemo() {
    LazyColumn {
        items(100) {
            Text(
                "User name $it",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(10.dp),
            )
            HorizontalDivider(thickness = 3.dp, color = Color.Black)
        }
    }
}

@Composable
private fun LazyColumnDemo2(selectedItem: (String) -> (Unit)) {
    LazyColumn {
        items(100) {
            Text(
                "User name $it",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier
                    .padding(10.dp)
                    .clickable { selectedItem("$it selected") },
            )
            HorizontalDivider(thickness = 3.dp, color = Color.Black)
        }
    }
}

@Composable
private fun DisplayTvShows(selectedItem: (TvShow) -> Unit) {
    val tvShow= remember { TvShowList.tvShows }
    LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)) {
        items(items = tvShow, itemContent = {
            TvListItems(tvShow = it, selectedItem = selectedItem)
        })
    }
}


