package com.antoniosj.githubbrowser.application

import android.app.Application
import com.antoniosj.githubbrowser.appcomponent.DaggerApplicationComponent
import com.antoniosj.githubbrowser.appdeps.ApplicationDeps
import com.antoniosj.githubbrowser.appdeps.HasApplicationDeps

class GitHubBrowserApp: Application(), HasApplicationDeps {

    private val appComponent by lazy {
        DaggerApplicationComponent.factory().create(this)
    }

    override fun getApplicationDeps(): ApplicationDeps {
        return appComponent
    }
}