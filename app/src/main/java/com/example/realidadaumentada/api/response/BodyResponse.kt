package com.example.proyectocafee.api.response

data class BodyResponse(
    val status: Boolean = false,
    val message: String = "",
    val lsData : LsData = LsData()
)

fun toSuccess(lsData: LsData) = BodyResponse(
    true,"Consulta correcta", lsData
)

fun toError(message: String) = BodyResponse(
    false,message, LsData()
)