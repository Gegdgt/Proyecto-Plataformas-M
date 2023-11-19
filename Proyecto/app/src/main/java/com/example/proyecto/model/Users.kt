package com.example.proyecto.model

data class Users(
    val id: String?,
    val userId: String,
    val displayName: String,
    val avatarUrl: String,
    val caption: String
){
    fun toMap(): MutableMap<String, Any>{
        return mutableMapOf(
            "user_id" to this.userId,
            "display_name" to this.displayName,
            "avatarUrl" to this.avatarUrl,
            "caption" to this.caption
        )
    }
}
