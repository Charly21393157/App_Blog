package com.example.app_blog.ui.home

import com.example.app_blog.core.Resource
import com.example.app_blog.data.model.Post

interface HomeScreenRepo {
    suspend fun getLatestPost(): Resource<List<Post>>
}
