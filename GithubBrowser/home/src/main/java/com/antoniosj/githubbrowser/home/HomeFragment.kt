package com.antoniosj.githubbrowser.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.antoniosj.githubbrowser.di.viewmodel.AppViewModelFactory
import com.antoniosj.githubbrowser.home.databinding.ScreenHomeBinding
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
        return binding.root
    }
}