package com.example.testleboncoin.repository.api

import com.example.testleboncoin.model.Album
import io.reactivex.Single
import retrofit2.http.GET

interface AlbumRemoteApi {
    @GET("technical-test.json")
    fun getAlbums(): Single<List<Album>>
}