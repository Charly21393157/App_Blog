package com.example.app_blog.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.app_blog.R
import com.example.app_blog.databinding.FragmentHomeScreenBinding
import com.google.firebase.Timestamp
import com.example.app_blog.data.model.Post
import com.example.app_blog.ui.home.adapter.HomeScreenAdapter

class HomeScreenFragment : Fragment(R.layout.fragment_home_screen) {
    private lateinit var binding: FragmentHomeScreenBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeScreenBinding.bind(view)

        val postList = listOf(
            Post("https://cdn-icons-png.freepik.com/256/16429/16429645.png", "Jonathan", Timestamp.now(), "https://example.com/sample_image.jpg"),
            Post("https://cdn-icons-png.freepik.com/256/16429/16429645.png", "Jonathan", Timestamp.now(), "https://example.com/sample_image.jpg"),
            Post("https://cdn-icons-png.freepik.com/256/16429/16429645.png", "Jonathan", Timestamp.now(), "https://example.com/sample_image.jpg")
        )

        binding.rvHome.adapter = HomeScreenAdapter(postList)
    }
}
