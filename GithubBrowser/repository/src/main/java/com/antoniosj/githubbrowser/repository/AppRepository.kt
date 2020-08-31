package com.antoniosj.githubbrowser.repository

import com.antoniosj.githubbrowser.githubapi.GitHubApi
import com.antoniosj.githubbrowser.githubapi.model.ContributorApiModel
import com.antoniosj.githubbrowser.githubapi.model.RepoApiModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppRepository @Inject constructor(private val gitHubApi: GitHubApi) {

    private val cachedRepos = mutableListOf<RepoApiModel>()

    suspend fun getTopRepos(): List<RepoApiModel> {

        if (cachedRepos.isEmpty()) {
            cachedRepos.addAll(gitHubApi.getTopRepositories().items)
        }
        return cachedRepos
    }
    // get from cache, otherwise call api
    suspend fun getRepo(repoOwner: String, repoName: String): RepoApiModel {
        return getRepoFromCache(repoOwner, repoName) ?: gitHubApi.getRepo(repoOwner, repoName)
    }

    private fun getRepoFromCache(repoOwner: String, repoName: String): RepoApiModel? {
        return cachedRepos.firstOrNull { repo -> repo.owner.login == repoOwner
                && repo.name == repoName
        }
    }

    suspend fun getContributors(repoOwner: String, repoName: String): List<ContributorApiModel> {
        return gitHubApi.getContributors(repoOwner, repoName)
    }



}