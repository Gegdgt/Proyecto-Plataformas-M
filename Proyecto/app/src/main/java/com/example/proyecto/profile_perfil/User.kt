package com.example.proyecto.profile_perfil

data class User(
    val username: String,
    val profileImagen: String,
    val postCount: Int,
    val followers: Int,
    val following: Int,
    val name: String,
    val description: String,
    val posts: List<String>
)
