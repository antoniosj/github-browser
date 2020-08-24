package com.antoniosj.githubbrowser.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.antoniosj.githubbrowser.home.databinding.ScreenHomeBinding

class HomeFragment: Fragment() {

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