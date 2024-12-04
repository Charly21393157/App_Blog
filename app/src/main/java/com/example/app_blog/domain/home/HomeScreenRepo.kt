package com.example.app_blog.domain.home

import com.example.appblog.core.Result
import com.example.appblog.data.model.Post

interface HomeScreenRepo {
    suspend fun getLatestPosts(): Result<List<Post>>
}