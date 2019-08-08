package xyz.absolutez3ro.euphonious.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import xyz.absolutez3ro.euphonious.R
import xyz.absolutez3ro.euphonious.adapters.PlaylistAdapter
import xyz.absolutez3ro.euphonious.data.playlist.PlaylistViewModel
import xyz.absolutez3ro.euphonious.data.playlist.PlaylistViewModelFactory

class PlaylistFragment : Fragment() {
    private lateinit var playlistViewModel: PlaylistViewModel
    private val playlistAdapter = PlaylistAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_playlist, container, false)

        // ViewModel
        playlistViewModel = PlaylistViewModelFactory().create(PlaylistViewModel::class.java)

        initAdapter(view)

        return view
    }

    private fun initAdapter(view: View) {
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView_playlistFragment)
        recyclerView.layoutManager = LinearLayoutManager(view.context, RecyclerView.VERTICAL, false)
        val divider = DividerItemDecoration(view.context, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(divider)
        recyclerView.adapter = playlistAdapter

        playlistViewModel.getArtists(this.activity!!.applicationContext.contentResolver).observe(
            this,
            Observer {
                playlistAdapter.submitList(it)
            }
        )
    }

}