

package com.example.screens.Screen.nav

sealed class Screens(val route: String) {
    object ScreenA : Screens("pantalla_a")
    object ScreenB : Screens("pantalla_b/{nombre}/{correo}/{profesion}") {
        fun createRoute(nombre: String, correo: String, profesion: String): String {
            return "pantalla_b/$nombre/$correo/$profesion"
        }
    }
}
