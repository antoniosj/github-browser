package com.antoniosj.githubbrowser.githubapi

import com.antoniosj.githubbrowser.githubapi.model.RepoApiModel
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TopReposSearchResult(val items: List<RepoApiModel>)