package com.sedakarana.filmlerapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform