package com.example.testleboncoin.features.albums

import androidx.paging.PagedList
import com.example.testleboncoin.architecture.BaseView
import com.example.testleboncoin.model.Album

interface AlbumView : BaseView {
    fun set(albums: PagedList<Album>)
}