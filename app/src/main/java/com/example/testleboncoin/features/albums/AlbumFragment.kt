package com.example.testleboncoin.features.albums

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testleboncoin.R
import com.example.testleboncoin.adapter.AlbumAdapter
import com.example.testleboncoin.architecture.BaseFragment
import com.example.testleboncoin.model.Album
import kotlinx.android.synthetic.main.fragment_album.*

class AlbumFragment : BaseFragment<AlbumPresenter>(), AlbumView {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.fragment_album, container, false)

    override fun set(albums: PagedList<Album>) {
        val adapter = AlbumAdapter()
        albumsRcv.layoutManager = LinearLayoutManager(context)
        albumsRcv.adapter = adapter
        adapter.submitList(albums)

    }
}