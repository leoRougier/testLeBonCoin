package com.example.testleboncoin.adapter

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedList
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.testleboncoin.R
import com.example.testleboncoin.model.Album
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout_album_row.view.*

class AlbumAdapter() :
    PagedListAdapter<Album, AlbumAdapter.AlbumViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object :
            DiffUtil.ItemCallback<Album>() {
            override fun areItemsTheSame(
                oldAlbum: Album,
                newAlbum: Album
            ) = oldAlbum.id == newAlbum.id

            override fun areContentsTheSame(
                oldAlbum: Album,
                newAlbum: Album
            ) = oldAlbum == newAlbum
        }
    }

    class AlbumViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val v: View = view
        fun bind(album: Album?) {
            v.albumTitle.text = album?.title
            Picasso.get().load(album?.thumbnailUrl).into(v.thumbnail)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder =
        AlbumViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.layout_album_row, parent, false)
        )

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        val album: Album? = getItem(position)
        holder.bind(album)

    }
}