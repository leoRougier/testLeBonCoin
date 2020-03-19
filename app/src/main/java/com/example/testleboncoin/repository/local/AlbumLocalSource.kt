package com.example.testleboncoin.repository.local

import androidx.paging.PagedList
import androidx.paging.RxPagedListBuilder
import com.example.testleboncoin.database.AlbumDatabase
import com.example.testleboncoin.model.Album
import com.example.testleboncoin.util.subscribeOnIO
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable

class AlbumLocalSource(private val db: AlbumDatabase) {

    private val dao = db.albumDao()

    //fun observe() = dao.observe()
    fun observe(pageSize: Int): Flowable<PagedList<Album>> {
        val config: PagedList.Config = PagedList.Config.Builder()
            .setInitialLoadSizeHint(25)
            .setPrefetchDistance(10)
            .setEnablePlaceholders(true)
            .setPageSize(25)
            .build()
        return RxPagedListBuilder(dao.observe(), config)
            .buildFlowable(BackpressureStrategy.LATEST)
    }

    fun set(albums: List<Album>) = dao.replaceAll(db, albums).subscribeOnIO()


}