package com.example.testleboncoin.config.module

import com.example.testleboncoin.repository.api.AlbumRemoteApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
class ServiceModule {
    @Provides
    @Singleton
    fun provideAlbumService(@Named(ApiModule.API_RETROFIT) retrofit: Retrofit): AlbumRemoteApi =
        retrofit.create<AlbumRemoteApi>(AlbumRemoteApi::class.java)
}