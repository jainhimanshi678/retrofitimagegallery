package com.sk.retrofitimagegallery.data

import androidx.paging.PagingSource
import com.sk.retrofitimagegallery.api.UnsplashApi
import retrofit2.HttpException
import java.io.IOException

private const val UNSPLASH_STARTING_PAGE_INDEX=1

class PagingPhoto (private val unsplashApi: UnsplashApi,
                     private val query:String
): PagingSource<Int, ModelUnsplashPhoto>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ModelUnsplashPhoto> {
        val position = params.key ?: UNSPLASH_STARTING_PAGE_INDEX
        return try {
            val response = unsplashApi.searchphoto(query, position, params.loadSize)
            val photos = response.results
            LoadResult.Page(
                data = photos,
                prevKey = if (position == UNSPLASH_STARTING_PAGE_INDEX) null else position - 1,
                nextKey = if (photos.isEmpty()) null else position + 1
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }
}
