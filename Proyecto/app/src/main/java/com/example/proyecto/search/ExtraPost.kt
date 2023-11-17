package com.example.proyecto.search

data class ExtraPost(
    val users: List<String>,
    val posts: List<String>
) { 
    fun doesMatchSearchQuery(query: String): Boolean{
        val matchingUser = listOf(
            "${users.toString()}"
        )
        return matchingUser.any{
            it.contains(query, ignoreCase  = true)
        }
    }
}