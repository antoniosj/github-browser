package com.antoniosj.githubbrowser

import com.antoniosj.githubbrowser.navigation.ScreenNavigator
import dagger.Binds
import dagger.Module

@Module
interface MainActivityModule {

    @Binds
    fun bindScreenNavigator(activityDrivenScreenNavigator: ActivityDrivenScreenNavigator) : ScreenNavigator
}