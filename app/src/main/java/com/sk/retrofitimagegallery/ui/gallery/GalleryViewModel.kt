package com.sk.retrofitimagegallery.ui.gallery

import android.app.DownloadManager
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.sk.retrofitimagegallery.data.Repository

class GalleryViewModel @ViewModelInject constructor(private val repository:Repository): ViewModel() {
    private val currentquery= MutableLiveData(DEFAULT_QUERY)
    //val photos=repository.getSearchResults("cats")
    val photos=currentquery.switchMap {
        queryString-> repository.getSearchResults(queryString).cachedIn(viewModelScope)
    }
    fun searchPhotos(query:String){
        currentquery.value=query
    }
    companion object{
        private const val DEFAULT_QUERY="cats"
    }
}