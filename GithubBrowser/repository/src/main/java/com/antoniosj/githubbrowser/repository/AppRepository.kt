package com.antoniosj.githubbrowser.repository

import com.antoniosj.githubbrowser.githubapi.GitHubApi
import com.antoniosj.githubbrowser.githubapi.model.RepoApiModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppRepository @Inject constructor(private val gitHubApi: GitHubApi) {
    suspend fun getTopRepos(): List<RepoApiModel> {
        return gitHubApi.getTopRepositories().items
    }
}