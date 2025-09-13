package com.sedakarana.filmlerapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.sedakarana.filmlerapp.ui.viewModel.HomeViewModel
import filmlerapp.composeapp.generated.resources.Res
import filmlerapp.composeapp.generated.resources.anadoluda
import filmlerapp.composeapp.generated.resources.django
import filmlerapp.composeapp.generated.resources.inception
import filmlerapp.composeapp.generated.resources.interstellar
import filmlerapp.composeapp.generated.resources.thehatefuleight
import filmlerapp.composeapp.generated.resources.thepianist
import kotlinx.serialization.json.Json
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(
    navController: NavController,
    viewModel: HomeViewModel = koinViewModel <HomeViewModel>()
) {


    val images = hashMapOf(
        "anadoluda" to Res.drawable.anadoluda,
        "django" to Res.drawable.django,
        "inception" to Res.drawable.inception,
        "interstellar" to Res.drawable.interstellar,
        "thehatefuleight" to Res.drawable.thehatefuleight,
        "thepianist" to Res.drawable.thepianist
    )
    val movies = viewModel.movieList.collectAsState()

    /*val movieInfo = Json.encodeToString(movie1)
    navController.navigate("detail/$movieInfo")*/


    Scaffold(topBar = {
        TopAppBar(title = {
            Text(
                "Anasayfa",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        })
    }) { paddingValues ->


        LazyVerticalGrid(
            modifier = Modifier.fillMaxSize().padding(paddingValues),
            columns = GridCells.Fixed(2)
        ) {
            items(
                count = movies.value.count(),
                itemContent = {
                    val myMovies = movies.value[it]
                    Card(
                        modifier = Modifier.padding(
                            all = 5.dp

                        ).fillMaxWidth()
                            .wrapContentHeight()
                    ) {
                        Column(
                            modifier = Modifier.fillMaxWidth()
                                .wrapContentHeight()
                                .clickable(onClick = {
                                    val movieInfo = Json.encodeToString(myMovies)
                                    navController.navigate("detail/$movieInfo")
                                })
                        ) {
                            Image(
                                painter = painterResource(images[myMovies.image]!!),
                                contentDescription = "",
                                modifier = Modifier.fillMaxWidth()
                                    .height(300.dp)
                            )

                            Text(
                                modifier = Modifier.padding(all = 5.dp).fillMaxWidth(),
                                text = myMovies.name,
                                textAlign = TextAlign.Center,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Row(
                                modifier = Modifier.fillMaxWidth()
                                    .padding(bottom = 5.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceEvenly
                            ) {
                                Text(
                                    modifier = Modifier.padding(all = 5.dp),
                                    text = myMovies.price.toString() + " ₺",
                                    textAlign = TextAlign.Center,
                                    fontSize = 20.sp,
                                    color = Color.Red,
                                    fontWeight = FontWeight.Bold
                                )
                                OutlinedButton(
                                    onClick = {

                                    },
                                ) { Text(text = "İzle") }
                            }

                        }
                    }
                })

        }

    }

}