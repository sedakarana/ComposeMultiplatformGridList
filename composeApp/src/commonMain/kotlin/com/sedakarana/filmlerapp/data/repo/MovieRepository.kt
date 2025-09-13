package com.sedakarana.filmlerapp.data.repo

import com.sedakarana.filmlerapp.data.datasource.MovieDataSource
import com.sedakarana.filmlerapp.data.entity.Movies

class MovieRepository(var movieDataSource: MovieDataSource) {

    suspend fun moviesUpload(): List<Movies> = movieDataSource.moviesUpload()
}