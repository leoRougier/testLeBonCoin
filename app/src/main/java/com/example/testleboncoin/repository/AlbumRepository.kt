package com.example.testleboncoin.repository

import com.example.testleboncoin.repository.api.AlbumRemoteApi
import com.example.testleboncoin.repository.local.AlbumLocalSource
import io.reactivex.Completable

class AlbumRepository(private val local:AlbumLocalSource,
                      private val remoteApi :AlbumRemoteApi) {

    fun fetchAlbums(): Completable {
        return remoteApi.getAlbums().flatMapCompletable {
            local.set(it)
        }
    }

    fun observeAlbums() = local.observe()

}