package com.example.testleboncoin.repository.local

import androidx.paging.DataSource
import androidx.paging.PagedList
import androidx.room.*
import com.example.testleboncoin.model.Album
import com.example.testleboncoin.util.transactionCompletable
import io.reactivex.Flowable

@Dao
interface AlbumDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(notifications: List<Album>)

    @Query("SELECT * FROM Album")
    fun observe(): DataSource.Factory<Int, Album>

    @Transaction
    @Query("DELETE FROM Album")
    fun deleteAll()

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSync(conversations: List<Album>)
}

fun AlbumDao.replaceAll(database: RoomDatabase, albums: List<Album>) = database.transactionCompletable(this::deleteAll, { insertSync(albums) })
