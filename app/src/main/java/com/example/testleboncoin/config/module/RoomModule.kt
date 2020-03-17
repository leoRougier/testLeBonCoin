package com.example.testleboncoin.config.module

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.testleboncoin.database.AlbumDatabase
import com.example.testleboncoin.repository.local.AlbumLocalSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {
    @Singleton
    @Provides
    fun provideDataBase(application: Application) =
        Room.databaseBuilder(
            application,
            AlbumDatabase::class.java, "database-name"
        ).fallbackToDestructiveMigration()
            .build()

    @Provides
    fun provideAlbumLocal(db: AlbumDatabase): AlbumLocalSource = AlbumLocalSource(db)

}