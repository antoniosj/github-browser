package com.antoniosj.githubbrowser.githubapi

import dagger.Binds
import dagger.Module

@Module
interface GitHubApiModule {

    @Binds
    fun bindGitHubApi(mockGitHubApi: MockGitHubApi): GitHubApi
}