package com.antoniosj.githubbrowser

import com.antoniosj.githubbrowser.di.component.getComponent
import com.antoniosj.githubbrowser.di.scope.ActivityScope
import com.antoniosj.githubbrowser.navigation.NavigationDeps
import dagger.Component

@ActivityScope
@Component(modules = [MainActivityModule::class])
interface MainActivityComponent: NavigationDeps {

    fun inject(mainActivity: MainActivity)

    @Component.Factory
    interface Factory {
        fun create(): MainActivityComponent
    }
}

fun MainActivity.injectAndGetComponent(): MainActivityComponent {
    val component = getComponent { DaggerMainActivityComponent.create() }
    component.inject(this)
    return component
}