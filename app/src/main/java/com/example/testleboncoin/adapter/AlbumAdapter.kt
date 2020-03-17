package com.example.testleboncoin.adapter

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testleboncoin.R
import com.example.testleboncoin.model.Album
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout_album_row.view.*

class AlbumAdapter(private val items: List<Album>?) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var mParent: ViewGroup

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        mParent = parent
       return AlbumViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.layout_album_row, parent, false)
        )
    }

    override fun getItemCount(): Int = items?.size ?: 0

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is AlbumViewHolder) {
            holder.bind(items?.get(position) as Album, mParent.context)
        }
    }

    class AlbumViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val v: View = view
        fun bind(album: Album, context: Context) {
            v.albumTitle.text = album.title
            Picasso.get().load(album.thumbnailUrl).into(v.thumbnail)
        }
    }
}