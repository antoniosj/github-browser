package com.antoniosj.githubbrowser.details

import com.antoniosj.githubbrowser.appdeps.ApplicationDeps
import com.antoniosj.githubbrowser.appdeps.applicationDeps
import com.antoniosj.githubbrowser.di.component.getComponent
import com.antoniosj.githubbrowser.di.scope.ScreenScope
import dagger.BindsInstance
import dagger.Component
import javax.inject.Named

@ScreenScope
@Component(dependencies = [ApplicationDeps::class], modules = [RepoDetailsModule::class])
interface RepoDetailsComponent {

    fun inject(repoDetailsFragment: RepoDetailsFragment)

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance @Named("repo_owner") repoOwner: String,
            @BindsInstance @Named("repo_name") repoName: String,
            applicationDeps: ApplicationDeps
        ): RepoDetailsComponent
    }
}

fun RepoDetailsFragment.inject() {
   getComponent {
       val repoOwner = arguments?.getString("repo_owner")
           ?: throw NullPointerException("repo_owner must be supplied in RepoDetailsFragment args")
       val repoName = arguments?.getString("repo_name")
           ?: throw NullPointerException("repo_name must be supplied in RepoDetailsFragment args")

       return@getComponent DaggerRepoDetailsComponent.factory().create(
           repoOwner,
           repoName,
           requireContext().applicationDeps()
       )
   }.inject(this)
}