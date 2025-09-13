package com.sedakarana.filmlerapp

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.sedakarana.filmlerapp.ui.screen.MyNavigation
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext

@Composable
@Preview
fun App() {
    MaterialTheme {
        KoinContext {
            MyNavigation()
        }
    }
}