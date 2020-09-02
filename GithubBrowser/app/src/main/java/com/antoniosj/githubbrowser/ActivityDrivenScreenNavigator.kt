package com.antoniosj.githubbrowser

import com.antoniosj.githubbrowser.di.scope.ActivityScope
import com.antoniosj.githubbrowser.navigation.Screen
import com.antoniosj.githubbrowser.navigation.ScreenNavigator
import javax.inject.Inject

@ActivityScope
class ActivityDrivenScreenNavigator @Inject constructor(): ScreenNavigator {

    var handleGoToScreen: ((Screen) -> Unit)? = null


    override fun goToScreen(screen: Screen) {
        handleGoToScreen?.invoke(screen)
    }
}