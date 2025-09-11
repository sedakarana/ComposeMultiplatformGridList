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
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.sedakarana.filmlerapp.data.entity.Movies
import filmlerapp.composeapp.generated.resources.Res
import filmlerapp.composeapp.generated.resources.anadoluda
import filmlerapp.composeapp.generated.resources.django
import filmlerapp.composeapp.generated.resources.inception
import filmlerapp.composeapp.generated.resources.interstellar
import filmlerapp.composeapp.generated.resources.thehatefuleight
import filmlerapp.composeapp.generated.resources.thepianist
import kotlinx.serialization.json.Json
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(navController: NavController) {

    var movies = remember { mutableStateListOf<Movies>() }

    val images = hashMapOf(
        "anadoluda" to Res.drawable.anadoluda,
        "django" to Res.drawable.django,
        "inception" to Res.drawable.inception,
        "interstellar" to Res.drawable.interstellar,
        "thehatefuleight" to Res.drawable.thehatefuleight,
        "thepianist" to Res.drawable.thepianist
    )


    val movie1 = Movies(1, "Anadoluda", "anadoluda", "Anadolu’da (2023), Nuri Bilge Ceylan’ın yönettiği, başrollerinde Deniz Celiloğlu ve Merve Dizdar’ın yer aldığı bir filmdir; taşra kasabasında görev yapan edebiyat öğretmeni Samet’in İstanbul’a atanma hayali kurarken yaşadığı sıkışmışlık, öğrencileriyle ve çevresindeki insanlarla kurduğu ilişkiler üzerinden içsel çatışmalarını konu alır ve Ceylan’ın uzun diyaloglara, doğa manzaralarına ve insan ruhunun derinliklerine odaklanan sinema üslubunu yansıtır.", 100.0)
    val movie2 = Movies(2, "Django", "django", "Django (1966), Sergio Corbucci’nin yönettiği ve Franco Nero’nun başrolünde yer aldığı kült bir Spagetti Western filmidir; tabut sürükleyerek kasabaya gelen yalnız silahşör Django’nun, acımasız çeteler arasındaki kanlı mücadelede adalet arayışını konu alır ve şiddet dozu yüksek sahneleri ile türün en unutulmaz yapımlarından biri olmuştur.", 150.0)
    val movie3 = Movies(3, "Inception", "inception", "Inception (2010), Christopher Nolan’ın yazıp yönettiği ve Leonardo DiCaprio’nun başrolde olduğu bilim kurgu-gerilim filmidir; insanların rüyalarına girerek bilinçaltından bilgi çalan Dom Cobb’un, bu kez bir fikri hedefin zihnine yerleştirme göreviyle çıktığı yolculukta gerçeklik ile rüya arasındaki sınırların giderek belirsizleşmesini konu alır.", 200.0)
    val movie4 = Movies(4, "Interstellar", "interstellar", "Interstellar (2014), Christopher Nolan’ın yönettiği ve Matthew McConaughey ile Anne Hathaway’in başrollerinde yer aldığı epik bilim kurgu filmidir; yaşanamaz hale gelen Dünya’yı terk ederek insanlık için yeni bir yaşam alanı arayan bir grup astronotun, solucan deliğinden geçerek farklı galaksilere yolculuğunu ve bu süreçte zaman, sevgi ve fedakârlık temalarını derinlemesine işleyişini konu alır.", 350.0)
    val movie5 = Movies(5, "The Hateful Eight", "thehatefuleight", "The Hateful Eight (2015), Quentin Tarantino’nun yazıp yönettiği western türündeki filmdir; iç savaş sonrası karlı bir fırtınada dağ kulübesinde bir araya gelen ödül avcıları, suçlular ve gizemli yolcuların arasındaki gerilimin giderek artmasıyla ihanet, şiddet ve sırların açığa çıkışını anlatır.", 300.0)
    val movie6 = Movies(6, "The Pianist", "thepianist", "The Pianist (2002), Roman Polanski’nin yönettiği ve Adrien Brody’nin başrolünde oynadığı biyografik savaş filmidir; II. Dünya Savaşı sırasında Nazi işgali altındaki Varşova’da hayatta kalmaya çalışan ünlü Polonyalı piyanist Władysław Szpilman’ın gerçek yaşam öyküsünü, müzik ve direniş arasındaki güçlü bağ üzerinden etkileyici bir şekilde aktarır.", 350.0)

    movies.add(movie1)
    movies.add(movie2)
    movies.add(movie3)
    movies.add(movie4)
    movies.add(movie5)
    movies.add(movie6)


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
                count = movies.count(),
                itemContent = {
                    val myMovies = movies[it]
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