package com.example.testleboncoin.config.module

import android.content.Context
import androidx.room.Room
import com.example.testleboncoin.database.AlbumDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {
    @Singleton
    @Provides
    fun provideDataBase(context: Context) =
        Room.databaseBuilder(
            context,
            AlbumDatabase::class.java, "database-name"
        ).fallbackToDestructiveMigration()
            .build()

}