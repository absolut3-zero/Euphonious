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
import xyz.absolutez3ro.euphonious.adapters.ArtistAdapter
import xyz.absolutez3ro.euphonious.data.artist.ArtistViewModel
import xyz.absolutez3ro.euphonious.data.artist.ArtistViewModelFactory

class ArtistsFragment : Fragment() {
    private lateinit var artistViewModel: ArtistViewModel
    private val artistAdapter = ArtistAdapter()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_artists, container, false)

        // ViewModel
        artistViewModel = ArtistViewModelFactory().create(ArtistViewModel::class.java)

        initAdapter(view)

        return view
    }

    private fun initAdapter(view: View) {
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView_artistsFragment)
        recyclerView.layoutManager = GridLayoutManager(view.context, 2)
        recyclerView.adapter = artistAdapter

        artistViewModel.getArtists(this.activity!!.applicationContext.contentResolver).observe(
            this,
            Observer {
                artistAdapter.submitList(it)
            }
        )
    }
}