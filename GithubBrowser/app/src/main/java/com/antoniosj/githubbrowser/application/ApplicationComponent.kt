package com.antoniosj.githubbrowser.application

import android.content.Context
import com.antoniosj.githubbrowser.appdeps.ApplicationDeps

import com.antoniosj.githubbrowser.githubapi.GitHubApiModule
import com.antoniosj.githubbrowser.repository.AppRepository
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [GitHubApiModule::class])
interface ApplicationComponent: ApplicationDeps {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationComponent
    }

}