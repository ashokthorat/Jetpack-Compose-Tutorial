package com.my.daily.jetpackcomposetutorial.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.anushka.composerecyclerview.model.TvShow

class ListDetailsPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ViewMoreInfo(tvShow = tvShow)
        }
    }

    companion object {
        private const val tvShowId = "tvShowId"

        fun intent(context: Context, tvShow: TvShow): Intent? {
            val intent = Intent(context, ListDetailsPage::class.java)
            intent.putExtra(tvShowId, tvShow)
            return intent
        }


    }
    private val tvShow: TvShow by lazy {
        intent?.getSerializableExtra(tvShowId) as TvShow
    }
}

@Composable
fun ViewMoreInfo(tvShow: TvShow) {
    val scrollState = rememberScrollState()
    Card(
        modifier = Modifier.padding(10.dp),
        elevation = 10.dp,
        shape = RoundedCornerShape(corner = CornerSize(10.dp))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(scrollState)
                .padding(10.dp)
        )
        {
            Image(
                painter = painterResource(tvShow.imageId),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(4.dp)),
                contentScale = ContentScale.Fit

            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = tvShow.name,
                style = MaterialTheme.typography.h3
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = tvShow.overview,
                style = MaterialTheme.typography.h5
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Release years:${tvShow.year}",
                style = MaterialTheme.typography.h5
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "User Rading:${tvShow.rating}",
                style = MaterialTheme.typography.h5
            )

        }
    }
}
