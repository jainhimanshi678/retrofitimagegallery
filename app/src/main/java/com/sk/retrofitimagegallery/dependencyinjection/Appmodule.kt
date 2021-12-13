package com.sk.retrofitimagegallery.dependencyinjection

import com.sk.retrofitimagegallery.api.UnsplashApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object Appmodule {
    @Provides
    @Singleton
    fun provideretrofit():Retrofit=Retrofit.Builder()
        .baseUrl(UnsplashApi.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    @Provides
    @Singleton
    fun provideunsplashapi(retrofit: Retrofit):UnsplashApi=retrofit.create(UnsplashApi::class.java)
}