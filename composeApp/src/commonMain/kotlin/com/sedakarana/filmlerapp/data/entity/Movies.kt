package com.sedakarana.filmlerapp.data.entity

import kotlinx.serialization.Serializable

@Serializable
data class Movies(
    var id: Int,
    var name: String,
    var image: String,
    var description: String,
    var price: Double
)