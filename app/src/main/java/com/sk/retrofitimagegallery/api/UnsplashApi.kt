package com.sk.retrofitimagegallery.api

import com.sk.retrofitimagegallery.BuildConfig
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface UnsplashApi {
    companion object
    {
        const val BASE_URL="https://api.unsplash.com/"
        const val CLIENT_ID=BuildConfig.UNSPLASH_ACCESS_KEY
    }
    @Headers("Accept-Version: v1","Authorization: Client-ID $CLIENT_ID")
     @GET("search/photos")///http get request
    suspend fun searchphoto(           //keep executing code on another thread
        @Query("query")query: String, //Query
        @Query("page")page:Int,       //current page
        @Query("per_page")perPage:Int //no of images per page
    ):Unsplasresponse //returned object
}