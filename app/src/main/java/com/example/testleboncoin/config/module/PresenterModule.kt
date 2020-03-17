package com.example.testleboncoin.config.module

import com.example.testleboncoin.features.albums.AlbumPresenter
import com.example.testleboncoin.repository.AlbumRepository
import dagger.Module
import dagger.Provides

@Module
class PresenterModule {
    @Provides
    fun provideAlbumPresenter(albumRepository: AlbumRepository) = AlbumPresenter(albumRepository)
}