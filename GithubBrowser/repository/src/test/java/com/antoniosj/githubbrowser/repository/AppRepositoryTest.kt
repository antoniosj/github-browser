package com.antoniosj.githubbrowser.repository

import com.antoniosj.githubbrowser.githubapi.GitHubApi
import com.antoniosj.githubbrowser.githubapi.model.RepoApiModel
import com.antoniosj.githubbrowser.githubapi.model.UserApiModel
import com.antoniosj.githubbrowser.testing.app.githubapi.FakeGitHubApi
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test


private val fakeRepoApiModel = RepoApiModel(id = 1L,
    name = "Mock repo",
    description = "mock description",
    owner = (UserApiModel(1L, "dagger")),
    stargazersCount = 1,
    forksCount = 1,
    contributorsUrl = "",
    createdDate = "1/1/2020",
    updatedDate = "1/1/2020"
)

class AppRepositoryTest {

    private lateinit var appRepository: AppRepository
    private val fakeGitHubApi = FakeGitHubApi().apply {
        repos = listOf(fakeRepoApiModel)
    }

    @Before
    fun setUp() {
        appRepository = AppRepository(fakeGitHubApi)
    }

    @Test
    fun successfulGetTopReposQuery() {
        val topRepos = runBlocking { appRepository.getTopRepos() }

        assertThat(topRepos.size).isEqualTo(1)
        assertThat(topRepos[0]).isEqualTo(fakeRepoApiModel)
    }
}

