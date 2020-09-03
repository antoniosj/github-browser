package com.antoniosj.githubbrowser.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.antoniosj.githubbrowser.di.viewmodel.AppViewModelFactory
import com.antoniosj.githubbrowser.home.databinding.ScreenHomeBinding
import com.antoniosj.githubbrowser.home.repolist.HomeRepoAdapter
import javax.inject.Inject

class HomeFragment: Fragment() {

    @Inject lateinit var appViewModelFactory: AppViewModelFactory

    private val homeViewModel: HomeViewModel by lazy {
        ViewModelProvider(this, appViewModelFactory)[HomeViewModel::class.java]
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        inject()
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //return super.onCreateView(inflater, container, savedInstanceState)
        val binding = ScreenHomeBinding.inflate(inflater, container, false)
        binding.rvRepoList.apply {
            adapter = HomeRepoAdapter(homeViewModel::onRepoSelected)
            layoutManager = LinearLayoutManager(context) // this = view, not fragment
            addItemDecoration(DividerItemDecoration(context,DividerItemDecoration.VERTICAL))
        }

        homeViewModel.viewStateUpdates.observe(viewLifecycleOwner, Observer { state ->
            when (state) {
                is HomeViewStateLoading -> handleLoadingState(binding)
                is HomeViewStateLoaded -> handleLoadedState(state, binding)
                is HomeViewStateError -> handleErrorState(state, binding)
            }
        })
        return binding.root
    }

    private fun handleErrorState(state: HomeViewStateError, binding: ScreenHomeBinding) {
        binding.pbLoadingIndicator.visibility = View.GONE
        binding.rvRepoList.visibility = View.GONE

        binding.tvError.visibility = View.VISIBLE
        binding.tvError.text = state.message
    }

    private fun handleLoadedState(state: HomeViewStateLoaded, binding: ScreenHomeBinding) {
        binding.tvError.visibility = View.GONE
        binding.pbLoadingIndicator.visibility = View.GONE

        binding.rvRepoList.visibility = View.VISIBLE
        (binding.rvRepoList.adapter as HomeRepoAdapter).setRepoItems(state.repos)
    }

    private fun handleLoadingState(binding: ScreenHomeBinding) {
        binding.rvRepoList.visibility = View.GONE
        binding.tvError.visibility = View.GONE
        binding.pbLoadingIndicator.visibility = View.VISIBLE
    }
}