package com.example.testleboncoin.features.albums

import com.example.testleboncoin.architecture.BaseView
import com.example.testleboncoin.model.Album

interface AlbumView : BaseView {
    fun set(albums:List<Album>)
}