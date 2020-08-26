package com.antoniosj.githubbrowser.testing.app

import android.app.Application
import android.app.Instrumentation
import androidx.test.platform.app.InstrumentationRegistry
import com.antoniosj.githubbrowser.appdeps.ApplicationDeps
import com.antoniosj.githubbrowser.appdeps.HasApplicationDeps
import com.antoniosj.githubbrowser.repository.AppRepository

class TestApplication: Application(), HasApplicationDeps {

    companion object {
        val component: TestApplicationComponent
        get() = (InstrumentationRegistry.getInstrumentation().targetContext.applicationContext as TestApplication).component
    }
    private lateinit var component: TestApplicationComponent



    override fun onCreate() {
        super.onCreate()
        component = DaggerTestApplicationComponent.factory().create(this)
    }

    override fun getApplicationDeps(): ApplicationDeps {
        return component
    }


}