package com.example.app_blog.data.remote

import com.example.app_blog.core.Resource
import com.example.app_blog.data.model.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HomeScreenDataSource {
    suspend fun getLatestPost(): Resource<List<Post>> = withContext(Dispatchers.IO) {
        try {
            // Simulamos una llamada a una base de datos o API remota aquí
            val postList = listOf(
                Post("https://cdn-icons-png.freepik.com/256/16429/16429645.png", "Jonathan", null, "https://example.com/sample_image.jpg")
            )
            Resource.Success(postList)
        } catch (e: Exception) {
            Resource.Error(e)
        }
    }
}
