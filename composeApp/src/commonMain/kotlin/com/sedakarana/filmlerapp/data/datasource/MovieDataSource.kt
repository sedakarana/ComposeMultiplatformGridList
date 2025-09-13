package com.sedakarana.filmlerapp.data.datasource

import com.sedakarana.filmlerapp.data.entity.Movies
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext

class MovieDataSource {
    suspend fun moviesUpload(): List<Movies> = withContext(Dispatchers.IO) {
        var movies = ArrayList<Movies>()
        val movie1 = Movies(
            1,
            "Anadoluda",
            "anadoluda",
            "Anadolu’da (2023), Nuri Bilge Ceylan’ın yönettiği, başrollerinde Deniz Celiloğlu ve Merve Dizdar’ın yer aldığı bir filmdir; taşra kasabasında görev yapan edebiyat öğretmeni Samet’in İstanbul’a atanma hayali kurarken yaşadığı sıkışmışlık, öğrencileriyle ve çevresindeki insanlarla kurduğu ilişkiler üzerinden içsel çatışmalarını konu alır ve Ceylan’ın uzun diyaloglara, doğa manzaralarına ve insan ruhunun derinliklerine odaklanan sinema üslubunu yansıtır.",
            100.0
        )
        val movie2 = Movies(
            2,
            "Django",
            "django",
            "Django (1966), Sergio Corbucci’nin yönettiği ve Franco Nero’nun başrolünde yer aldığı kült bir Spagetti Western filmidir; tabut sürükleyerek kasabaya gelen yalnız silahşör Django’nun, acımasız çeteler arasındaki kanlı mücadelede adalet arayışını konu alır ve şiddet dozu yüksek sahneleri ile türün en unutulmaz yapımlarından biri olmuştur.",
            150.0
        )
        val movie3 = Movies(
            3,
            "Inception",
            "inception",
            "Inception (2010), Christopher Nolan’ın yazıp yönettiği ve Leonardo DiCaprio’nun başrolde olduğu bilim kurgu-gerilim filmidir; insanların rüyalarına girerek bilinçaltından bilgi çalan Dom Cobb’un, bu kez bir fikri hedefin zihnine yerleştirme göreviyle çıktığı yolculukta gerçeklik ile rüya arasındaki sınırların giderek belirsizleşmesini konu alır.",
            200.0
        )
        val movie4 = Movies(
            4,
            "Interstellar",
            "interstellar",
            "Interstellar (2014), Christopher Nolan’ın yönettiği ve Matthew McConaughey ile Anne Hathaway’in başrollerinde yer aldığı epik bilim kurgu filmidir; yaşanamaz hale gelen Dünya’yı terk ederek insanlık için yeni bir yaşam alanı arayan bir grup astronotun, solucan deliğinden geçerek farklı galaksilere yolculuğunu ve bu süreçte zaman, sevgi ve fedakârlık temalarını derinlemesine işleyişini konu alır.",
            350.0
        )
        val movie5 = Movies(
            5,
            "The Hateful Eight",
            "thehatefuleight",
            "The Hateful Eight (2015), Quentin Tarantino’nun yazıp yönettiği western türündeki filmdir; iç savaş sonrası karlı bir fırtınada dağ kulübesinde bir araya gelen ödül avcıları, suçlular ve gizemli yolcuların arasındaki gerilimin giderek artmasıyla ihanet, şiddet ve sırların açığa çıkışını anlatır.",
            300.0
        )
        val movie6 = Movies(
            6,
            "The Pianist",
            "thepianist",
            "The Pianist (2002), Roman Polanski’nin yönettiği ve Adrien Brody’nin başrolünde oynadığı biyografik savaş filmidir; II. Dünya Savaşı sırasında Nazi işgali altındaki Varşova’da hayatta kalmaya çalışan ünlü Polonyalı piyanist Władysław Szpilman’ın gerçek yaşam öyküsünü, müzik ve direniş arasındaki güçlü bağ üzerinden etkileyici bir şekilde aktarır.",
            350.0
        )

        movies.add(movie1)
        movies.add(movie2)
        movies.add(movie3)
        movies.add(movie4)
        movies.add(movie5)
        movies.add(movie6)
        return@withContext movies

    }
}