package com.sedakarana.filmlerapp

import androidx.compose.ui.window.ComposeUIViewController
import com.sedakarana.filmlerapp.data.di.initializeKoin

fun MainViewController() = ComposeUIViewController(configure = { initializeKoin() }) { App() }