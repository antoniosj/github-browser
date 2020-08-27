package com.antoniosj.githubbrowser.githubapi

import retrofit2.http.GET

interface GitHubApi {

    @GET(value = "search/repositories?q=language:kotlin&order=desc&sort=stars")
    suspend fun getTopRepositories(): TopReposSearchResult
}