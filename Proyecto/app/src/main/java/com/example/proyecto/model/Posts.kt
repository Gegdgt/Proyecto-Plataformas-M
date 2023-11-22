package com.example.proyecto.model

data class Posts(
    val postId: String,
    val imageUrl: String,

) {
    fun toMap(): Map<String, Any>{
        return mapOf(
            "post_id" to postId,
            "image_url" to imageUrl
        )
    }
}
