package com.sedakarana.filmlerapp.ui.viewModel

import androidx.lifecycle.ViewModel
import com.sedakarana.filmlerapp.data.entity.Movies
import com.sedakarana.filmlerapp.data.repo.MovieRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(var movieRepository: MovieRepository) : ViewModel() {

    var movieList = MutableStateFlow<List<Movies>>(listOf())

    init {
        moviesUpload()
    }

    fun moviesUpload() {
        CoroutineScope(Dispatchers.Main).launch {
            movieList.value = movieRepository.moviesUpload()
        }
    }
}