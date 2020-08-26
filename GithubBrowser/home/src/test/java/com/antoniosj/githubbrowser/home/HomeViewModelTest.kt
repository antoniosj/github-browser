package com.antoniosj.githubbrowser.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.antoniosj.githubbrowser.githubapi.GitHubApi
import com.antoniosj.githubbrowser.githubapi.model.RepoApiModel
import com.antoniosj.githubbrowser.githubapi.model.UserApiModel
import com.antoniosj.githubbrowser.home.repolist.RepoItem
import com.antoniosj.githubbrowser.repository.AppRepository
import org.junit.Before
import com.google.common.truth.Truth.assertThat

import org.junit.Assert.*
import org.junit.Rule
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


class HomeViewModelTest {

    // Skip getMainLoop que não está mockado.
    @get:Rule
    val taskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: HomeViewModel
    private lateinit var viewStateValues: MutableList<HomeViewState>

    @Before
    fun setUp() {
        val appRepository = AppRepository(FakeGitHubApi())
        viewStateValues = mutableListOf()

        viewModel = HomeViewModel(appRepository)
        viewModel.viewStateUpdates.observeForever { viewStateValues.add(it) }
    }

    @Test
    fun `loaded state contains repo models`() {
        assertThat(viewStateValues.size).isEqualTo(1)
        val expectedState = HomeViewStateLoaded(
            repos = listOf(
                RepoItem(
                    name = fakeRepoApiModel.name,
                    description = fakeRepoApiModel.description,
                    starsCount = fakeRepoApiModel.stargazersCount,
                    forkCount = fakeRepoApiModel.forksCount
                )
            )
        )

        assertThat(viewStateValues[0]).isEqualTo(expectedState)
    }
}

// Pode usar mockito no lugar de criar um fake
private class FakeGitHubApi: GitHubApi {
    override fun getTopRepositories(): List<RepoApiModel> {
        return listOf(fakeRepoApiModel)
    }

}