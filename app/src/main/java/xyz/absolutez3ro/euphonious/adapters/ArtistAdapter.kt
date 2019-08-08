package xyz.absolutez3ro.euphonious.adapters

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import xyz.absolutez3ro.euphonious.data.artist.Artist

class ArtistAdapter : PagedListAdapter<Artist, ArtistViewHolder>(ARTIST_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder {
        return ArtistViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {
        val artist = getItem(position)
        if (artist != null) holder.bind(artist)
    }

    companion object {
        val ARTIST_COMPARATOR = object : DiffUtil.ItemCallback<Artist>() {
            override fun areItemsTheSame(oldItem: Artist, newItem: Artist) =
                oldItem.artistName == newItem.artistName

            override fun areContentsTheSame(oldItem: Artist, newItem: Artist) =
                oldItem == newItem
        }
    }
}