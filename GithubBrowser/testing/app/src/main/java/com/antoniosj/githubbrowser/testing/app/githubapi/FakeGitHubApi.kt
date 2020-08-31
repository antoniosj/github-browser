package com.antoniosj.githubbrowser.testing.app.githubapi

import com.antoniosj.githubbrowser.githubapi.GitHubApi
import com.antoniosj.githubbrowser.githubapi.TopReposSearchResult
import com.antoniosj.githubbrowser.githubapi.model.ContributorApiModel
import com.antoniosj.githubbrowser.githubapi.model.RepoApiModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FakeGitHubApi @Inject constructor() : GitHubApi {

    var topRepos = listOf<RepoApiModel>()
    var singleRepoResult: RepoApiModel? = null
    var contributorsResult = listOf<ContributorApiModel>()

    override suspend fun getTopRepositories(): TopReposSearchResult {
        return TopReposSearchResult(topRepos)
    }

    override suspend fun getContributors(
        repoOwner: String,
        repoName: String
    ): List<ContributorApiModel> {
        return contributorsResult
    }

    override suspend fun getRepo(repoOwner: String, repoName: String): RepoApiModel {
        return singleRepoResult ?: throw NullPointerException("singleRepoResult was not set")
    }
}