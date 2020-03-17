package com.example.testleboncoin.config.module

import com.example.testleboncoin.repository.AlbumRepository
import com.example.testleboncoin.repository.api.AlbumRemoteApi
import com.example.testleboncoin.repository.local.AlbumLocalSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun provideAlbumRepository(local: AlbumLocalSource, remoteApi: AlbumRemoteApi): AlbumRepository = AlbumRepository(local, remoteApi)
}