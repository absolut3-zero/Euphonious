package xyz.absolutez3ro.euphonious.adapters

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import xyz.absolutez3ro.euphonious.data.song.Song

class SongAdapter : PagedListAdapter<Song, SongViewHolder>(SONG_COMPARATOR) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        return SongViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        val song = getItem(position)
        if (song != null) holder.bind(song)
    }

    companion object {
        private val SONG_COMPARATOR = object : DiffUtil.ItemCallback<Song>() {
            override fun areItemsTheSame(oldItem: Song, newItem: Song): Boolean =
                oldItem.title == newItem.title

            override fun areContentsTheSame(oldItem: Song, newItem: Song): Boolean =
                oldItem == newItem
        }
    }
}