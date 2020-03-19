package com.example.testleboncoin.features.albums

import androidx.paging.PagedList
import com.example.testleboncoin.architecture.BasePresenter
import com.example.testleboncoin.model.Album
import com.example.testleboncoin.repository.AlbumRepository
import com.example.testleboncoin.util.observeOnMain
import com.example.testleboncoin.util.subscribeOnIO

class AlbumPresenter(private val repo: AlbumRepository) : BasePresenter<AlbumView>() {

    override fun onCreate() {
        super.onCreate()
        repo.observeAlbums(5)
            .observeOnMain()
            .subscribe {
                onUpdate(it)
            }.disposeOnDestroy()

        repo.fetchAlbums().subscribeOnIO().subscribe().disposeOnDestroy()
    }

    private fun onUpdate(albums: PagedList<Album>) {
        view?.set(albums)
    }
}