package com.antoniosj.githubbrowser.githubapi

import com.antoniosj.githubbrowser.githubapi.model.RepoApiModel
import com.antoniosj.githubbrowser.githubapi.model.UserApiModel
import javax.inject.Inject
import javax.inject.Singleton

interface GitHubApi {

    fun getTopRepositories(): List<RepoApiModel>
}

@Singleton
class MockGitHubApi @Inject constructor(): GitHubApi {
    override fun getTopRepositories(): List<RepoApiModel> {
        return listOf(
            RepoApiModel(id = 1L,
                name = "Mock repo",
                description = "mock description",
                owner = (UserApiModel(1L, "dagger")),
                stargazersCount = 1,
                forksCount = 1,
                contributorsUrl = "",
                createdDate = "1/1/2020",
                updatedDate = "1/1/2020"
            )
        )
    }
}