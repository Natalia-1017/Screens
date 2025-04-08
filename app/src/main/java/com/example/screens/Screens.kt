package com.example.screens

sealed class Screens(val route: String) {

    object ScreenA : Screens("screenA")

    object ScreenB : Screens("screenB/{nombre}/{correo}/{profesion}") {
        fun createRoute(nombre: String, correo: String, profesion: String): String {
            return "screenB/$nombre/$correo/$profesion"
        }
    }

    object ScreenC : Screens("screenC")

}
