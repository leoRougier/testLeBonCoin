package com.example.testleboncoin.repository.local

import com.example.testleboncoin.database.AlbumDatabase
import com.example.testleboncoin.model.Album
import com.example.testleboncoin.util.subscribeOnIO

class AlbumLocalSource(private val db: AlbumDatabase) {

    private val dao = db.albumDao()

    fun observe() = dao.observe()
    fun set(albums: List<Album>) = dao.replaceAll(db, albums).subscribeOnIO()


}