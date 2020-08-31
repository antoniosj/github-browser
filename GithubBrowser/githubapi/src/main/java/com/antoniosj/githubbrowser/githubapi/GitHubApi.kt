package com.antoniosj.githubbrowser.githubapi

import com.antoniosj.githubbrowser.githubapi.model.ContributorApiModel
import com.antoniosj.githubbrowser.githubapi.model.RepoApiModel
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubApi {

    @GET(value = "search/repositories?q=language:kotlin&order=desc&sort=stars")
    suspend fun getTopRepositories(): TopReposSearchResult

    @GET("repos/{owner}/{name}/contributors")
    suspend fun getContributors(
        @Path("owner") repoOwner: String,
        @Path("name") repoName: String
    ): List<ContributorApiModel>

    @GET("repos/{owner}/{name}")
    suspend fun getRepo(
        @Path("owner") repoOwner: String,
        @Path("name") repoName: String
    ): RepoApiModel
}