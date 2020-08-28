package com.antoniosj.githubbrowser.details

import androidx.lifecycle.ViewModel
import com.antoniosj.githubbrowser.di.scope.ScreenScope
import com.antoniosj.githubbrowser.repository.AppRepository
import javax.inject.Inject
import javax.inject.Named

@ScreenScope
class RepoDetailsViewModel @Inject constructor(
    @Named("repo_owner") val repoOwner: String,
    @Named("repo_name") val repoName: String,
    val  appRepository: AppRepository
): ViewModel() {

}