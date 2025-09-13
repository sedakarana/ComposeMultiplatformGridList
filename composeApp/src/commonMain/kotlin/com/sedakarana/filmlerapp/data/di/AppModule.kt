package com.sedakarana.filmlerapp.data.di

import com.sedakarana.filmlerapp.data.datasource.MovieDataSource
import com.sedakarana.filmlerapp.data.repo.MovieRepository
import com.sedakarana.filmlerapp.ui.viewModel.HomeViewModel
import org.koin.compose.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

val appModule = module {
    single { MovieDataSource() }
    single { MovieRepository(get()) }

    viewModel { HomeViewModel(get()) }
}

fun initializeKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(appModule)
    }
}
