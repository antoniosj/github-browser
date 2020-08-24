package com.antoniosj.githubbrowser.home

import com.antoniosj.githubbrowser.home.repolist.RepoItem

sealed class HomeViewState
object HomeViewStateLoading: HomeViewState()
data class HomeViewStateLoaded(val repos: List<RepoItem>): HomeViewState()
data class HomeViewStateError(val message: String): HomeViewState()