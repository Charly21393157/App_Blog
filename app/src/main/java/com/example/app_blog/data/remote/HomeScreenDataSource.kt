package com.example.app_blog.data.remote

import com.example.app_blog.core.Resource
import com.example.app_blog.data.model.Post
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class HomeScreenDataSource {
    suspend fun getLatestPost(): Resource<List<Post>> = withContext(Dispatchers.IO) {
        val postList= mutableListOf<Post>()
        val querySnapshot= FirebaseFirestore.getInstance().collection("posts").get().await()
        for (post in querySnapshot.documents){
            post.toObject(Post::class.java)?.let { fbPost ->
                postList.add(fbPost)
            }
        }
        return@withContext Resource.Success(postList)
    }
}
