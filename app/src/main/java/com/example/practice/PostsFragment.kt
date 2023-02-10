package com.example.practice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import com.example.practice.databinding.PostsPageBinding
import com.example.practice.overview.OverviewViewModel
import com.example.practice.overview.PhotoGridAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView

class PostsFragment: androidx.fragment.app.Fragment() {

    private var _binding: PostsPageBinding? = null
    private val binding get() = _binding
    private val navController = NavController

    private val viewModel: OverviewViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = PostsPageBinding.inflate(inflater,container,false)
        val root = binding?.root

        val view = requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        view.visibility = View.VISIBLE

        binding?.lifecycleOwner = this

        binding?.viewModel = viewModel

        binding?.postsList?.adapter = PhotoGridAdapter()

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}