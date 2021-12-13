package com.sk.retrofitimagegallery

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ModelUnsplashPhoto(
    val id:String,
    val description:String?,
    val urls:Unsplashphotourls,
    val user:Unsplashuser
):Parcelable {

    @Parcelize
    data class Unsplashphotourls(
        val raw:String,
        val full:String,
        val regular:String,
        val small:String,
        val thum:String
):Parcelable
    @Parcelize
    data class Unsplashuser(
        val name:String,
        val username:String):Parcelable
    {
       val attributeUrl get() = "https://unsplash.com/$username?utm_source=RetroImageGallery&utm_medium=referral"
    }

}