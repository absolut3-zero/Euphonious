package xyz.absolutez3ro.euphonious.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import xyz.absolutez3ro.euphonious.R
import xyz.absolutez3ro.euphonious.adapters.AlbumAdapter
import xyz.absolutez3ro.euphonious.data.album.AlbumViewModel
import xyz.absolutez3ro.euphonious.data.album.AlbumViewModelFactory

class AlbumsFragment : Fragment() {

    private lateinit var albumViewModel: AlbumViewModel
    private val albumAdapter = AlbumAdapter()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_albums, container, false)

        // ViewModel
        albumViewModel = AlbumViewModelFactory().create(AlbumViewModel::class.java)

        initAdapter(view)
        return view
    }

    private fun initAdapter(view: View) {
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView_albumsFragment)
        recyclerView.layoutManager = GridLayoutManager(view.context, 2)
        recyclerView.adapter = albumAdapter

        albumViewModel.getAlbums(this.activity!!.applicationContext.contentResolver).observe(
            this,
            Observer {
                albumAdapter.submitList(it)
            }
        )
    }
}