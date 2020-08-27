package com.antoniosj.githubbrowser.githubapi

import com.squareup.moshi.Moshi
import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.Call
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
// provides retrofit + moshi + githubapi
object GitHubApiModule {

    @Provides
    @JvmStatic
    @Singleton
    fun provideOkHttp(): Call.Factory {
        return OkHttpClient.Builder()
            .build()
    }

    @Provides
    @JvmStatic
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .build()
    }

    @Provides
    @JvmStatic
    @Singleton
    fun provideRetrofit(
        moshi: Moshi,
        callFactory: Call.Factory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .callFactory(callFactory)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    @Provides
    @JvmStatic
    @Singleton
    // agora githubapi retorna retrofit como impl
    fun provideGitHubApi(retrofit: Retrofit): GitHubApi {
        return retrofit.create()
    }
}

//interface OkHttpConfigurator {
//    fun configure(clientBuilder: OkHttpClient.Builder)
//}