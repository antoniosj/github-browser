package com.antoniosj.githubbrowser.testing.app

import android.content.Context
import com.antoniosj.githubbrowser.appcomponent.ApplicationComponent
import com.antoniosj.githubbrowser.testing.app.githubapi.FakeGitHubApi
import com.antoniosj.githubbrowser.testing.app.githubapi.TestGitHubApiModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [TestGitHubApiModule::class])
interface TestApplicationComponent: ApplicationComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): TestApplicationComponent
    }

    fun gitHubApi(): FakeGitHubApi
}