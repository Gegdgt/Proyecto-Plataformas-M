package com.example.proyecto.search

data class ExtraPost(
    val users: String,
    val posts: List<String>
) { 
    fun doesMatchSearchQuery(query: String): Boolean{
        val matchingCombination = listOf(
            users,
            "${users.first()}"
        )
        return matchingCombination.any{
            it.contains(query, ignoreCase  = true)
        }
    }
}