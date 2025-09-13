package com.sedakarana.filmlerapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.sedakarana.filmlerapp.data.entity.Movies
import filmlerapp.composeapp.generated.resources.Res
import filmlerapp.composeapp.generated.resources.anadoluda
import filmlerapp.composeapp.generated.resources.back
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Detail(navController: NavController, movies: Movies) {
    val images = hashMapOf(
        "anadoluda" to Res.drawable.anadoluda,
        "django" to Res.drawable.anadoluda,
        "inception" to Res.drawable.anadoluda,
        "interstellar" to Res.drawable.anadoluda,
        "thehatefuleight" to Res.drawable.anadoluda,
        "thepianist" to Res.drawable.anadoluda
    )

    Scaffold(topBar = {
        TopAppBar(title = {
            Text(
                text = movies.name
            )
        }, navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    painter = painterResource(Res.drawable.back), contentDescription = ""
                )
            }
        }

        )
    }) { paddingValues ->

        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(images[movies.image]!!),
                contentDescription = "",
                modifier = Modifier.fillMaxWidth().height(400.dp)
                    .clip(RoundedCornerShape(10.dp))
            )

            Text(
                text = movies.description.toString(),
                modifier = Modifier.padding(5.dp),
                textAlign = TextAlign.Center,
                fontSize = 15.sp,
                fontStyle = FontStyle.Italic
            )
        }

    }

}