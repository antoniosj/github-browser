package com.antoniosj.githubbrowser.testing.app.githubapi

import com.antoniosj.githubbrowser.githubapi.GitHubApi
import dagger.Binds
import dagger.Module

@Module
interface TestGitHubApiModule {

    @Binds
    fun bindGitHubApi(fakeGitHubApi: FakeGitHubApi): GitHubApi
}