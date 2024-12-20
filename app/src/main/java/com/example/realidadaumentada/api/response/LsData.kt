package com.example.proyectocafee.api.response

import com.example.realidadaumentada.api.request.ProductsModel

data class LsData(
    val products: List<ProductsModel> = listOf()
)