package com.example.app_blog.domain

import com.example.app_blog.core.Resource
import com.example.app_blog.data.model.Post
import com.example.app_blog.data.remote.HomeScreenDataSource
import com.example.app_blog.ui.home.HomeScreenRepo

class HomeScreenRepoImplement(private val dataSource: HomeScreenDataSource) : HomeScreenRepo {
    override suspend fun getLatestPost(): Resource<List<Post>> {
        return dataSource.getLatestPost()
    }
}
