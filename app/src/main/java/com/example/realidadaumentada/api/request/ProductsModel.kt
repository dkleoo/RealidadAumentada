package com.example.realidadaumentada.api.request

data class ProductsModel(
    val name: String,
    val description: String,
    val price: Double,
    val image: String,
    val model: String
)
