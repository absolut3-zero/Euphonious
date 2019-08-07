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
import xyz.absolutez3ro.euphonious.adapters.SongAdapter
import xyz.absolutez3ro.euphonious.data.song.SongViewModel
import xyz.absolutez3ro.euphonious.data.song.SongViewModelFactory

class SongsFragment : Fragment() {
    private lateinit var songViewModel: SongViewModel
    private val adapter = SongAdapter()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_songs, container, false)

        // ViewModel
        songViewModel = SongViewModelFactory().create(SongViewModel::class.java)

        initAdapter(view)

        return view
    }

    private fun initAdapter(view: View) {
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView_songsFragment)
        recyclerView.layoutManager = LinearLayoutManager(view.context, RecyclerView.VERTICAL, false)
        val dividerItemDecoration = DividerItemDecoration(view.context, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(dividerItemDecoration)
        recyclerView.adapter = adapter

        songViewModel.getSongs(this.activity!!.applicationContext.contentResolver).observe(
            this,
            Observer {
                adapter.submitList(it)
            })
    }
}