package com.example.app_blog.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.app_blog.R
import com.example.app_blog.core.Resource
import com.example.app_blog.data.model.Post
import com.example.app_blog.data.remote.HomeScreenDataSource
import com.example.app_blog.databinding.FragmentHomeScreenBinding
import com.example.app_blog.domain.HomeScreenRepoImplement
import com.example.app_blog.presentation.HomeScreenViewModel
import com.example.app_blog.presentation.HomeScreenViewModelFactory
import com.example.app_blog.ui.home.adapter.HomeScreenAdapter
import com.google.firebase.Timestamp

class HomeScreenFragment : Fragment(R.layout.fragment_home_screen) {
    private lateinit var binding: FragmentHomeScreenBinding
    private val viewModel by viewModels<HomeScreenViewModel> {
        HomeScreenViewModelFactory(HomeScreenRepoImplement(
            HomeScreenDataSource()
        ))}
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeScreenBinding.bind(view)
        viewModel.fetchLatestPosts().observe(viewLifecycleOwner, Observer
        { result ->
            when (result) {
                is Resource.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }

                is Resource.Success -> {
                    binding.progressBar.visibility = View.GONE
                    binding.rvHome.adapter = HomeScreenAdapter(result.data)
                }

                is Resource.Error -> {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(
                        requireContext(),
                        "Ocurrió un error: ${result.exception}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

        })
    }    //despues de crea la lista arriba
}
