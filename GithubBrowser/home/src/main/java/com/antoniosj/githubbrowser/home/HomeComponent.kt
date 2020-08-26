package com.antoniosj.githubbrowser.home

import com.antoniosj.githubbrowser.appdeps.ApplicationDeps
import com.antoniosj.githubbrowser.appdeps.applicationDeps
import com.antoniosj.githubbrowser.di.component.getComponent
import com.antoniosj.githubbrowser.di.scope.ScreenScope
import dagger.Component

@ScreenScope
@Component(dependencies = [ApplicationDeps::class], modules = [HomeModule::class])
interface HomeComponent {

    fun inject(homeFragment: HomeFragment)

    @Component.Factory
    interface Factory {
        fun create(applicationDeps: ApplicationDeps): HomeComponent
    }
}

fun HomeFragment.inject() {
    //getComponent funciona aqui porque tem um fragment e o fragment armazena vm.
    getComponent {
        DaggerHomeComponent.factory().create(requireContext().applicationDeps())
    }.inject(this)
}