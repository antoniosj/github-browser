package com.antoniosj.githubbrowser.home

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.antoniosj.githubbrowser.githubapi.model.RepoApiModel
import com.antoniosj.githubbrowser.githubapi.model.UserApiModel
import com.antoniosj.githubbrowser.testing.app.TestApplication
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeFragmentTest {

    @Before
    fun setUp() {
        val gitHubApi = TestApplication.component.gitHubApi()
        gitHubApi.repos = listOf(
            RepoApiModel(id = 1L,
                name = "Home Fragment",
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

    @Test
    fun reposDisplayed() {
        launchFragmentInContainer<HomeFragment>()
        onView(withId(R.id.tv_repo_name)).check(matches(withText("Home Fragment")))
    }
}