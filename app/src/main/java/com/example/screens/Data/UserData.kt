package com.example.screens.Data


data class Usuario(
    val nombre: String,
    val correo: String,
    val profesion: String
)

object ListaUsuarios {
    val usuarios = mutableListOf<Usuario>()

    fun agregarUsuario(usuario: Usuario) {
        usuarios.add(usuario)
    }
}
