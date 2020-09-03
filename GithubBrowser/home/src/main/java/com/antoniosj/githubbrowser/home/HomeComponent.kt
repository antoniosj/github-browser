package com.antoniosj.githubbrowser.home

import com.antoniosj.githubbrowser.appdeps.ApplicationDeps
import com.antoniosj.githubbrowser.appdeps.applicationDeps
import com.antoniosj.githubbrowser.di.component.getComponent
import com.antoniosj.githubbrowser.di.scope.ScreenScope
import com.antoniosj.githubbrowser.navigation.NavigationDeps
import com.antoniosj.githubbrowser.navigation.navigationDeps
import dagger.Component

@ScreenScope
@Component(dependencies = [ApplicationDeps::class, NavigationDeps::class], modules = [HomeModule::class])
interface HomeComponent {

    fun inject(homeFragment: HomeFragment)

    @Component.Factory
    interface Factory {
        fun create(applicationDeps: ApplicationDeps, navigationDeps: NavigationDeps): HomeComponent
    }
}

fun HomeFragment.inject() {
    //getComponent funciona aqui porque tem um fragment e o fragment armazena vm.
    getComponent {
        DaggerHomeComponent.factory().create(requireContext().applicationDeps(), requireActivity().navigationDeps())
    }.inject(this)
}