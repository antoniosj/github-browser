package com.antoniosj.githubbrowser.testing.app.githubapi

import com.antoniosj.githubbrowser.githubapi.GitHubApi
import com.antoniosj.githubbrowser.githubapi.TopReposSearchResult
import com.antoniosj.githubbrowser.githubapi.model.RepoApiModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FakeGitHubApi @Inject constructor() : GitHubApi {

    var repos = listOf<RepoApiModel>()

    override suspend fun getTopRepositories(): TopReposSearchResult {
        return TopReposSearchResult(repos)
    }
}