package com.example.testleboncoin.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.testleboncoin.model.Album
import com.example.testleboncoin.repository.local.AlbumDao

@Database(
    entities = [
    Album::class
    ],
    version = 1
)
abstract class AlbumDatabase: RoomDatabase() {
    abstract fun albumDao(): AlbumDao

}