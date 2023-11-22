package com.example.proyecto.model

data class Users(
    val id: String?,
    val userId: String,
    val displayName: String,
    val posts: List<Posts> = emptyList()
){
    fun toMap(): MutableMap<String, Any>{
        return mutableMapOf(
            "user_id" to this.userId,
            "display_name" to this.displayName,
            "posts" to posts.map { it.toMap() }
        )
    }
}
