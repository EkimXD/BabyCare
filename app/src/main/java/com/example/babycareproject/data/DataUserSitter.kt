package com.example.babycareproject.data

data class DataUserSitter(
    var nombre: String = "",
    var apellido: String = "",
    var pais: String = "",
    var ciudad: String = "",
    var tarifaN: String? = "",
    var tarifaHorasE: String? = "",
    var descripcion: String? = ""
)