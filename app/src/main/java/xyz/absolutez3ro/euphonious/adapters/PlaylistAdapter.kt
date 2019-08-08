package xyz.absolutez3ro.euphonious.adapters

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import xyz.absolutez3ro.euphonious.data.playlist.Playlist

class PlaylistAdapter : PagedListAdapter<Playlist, PlaylistViewHolder>(PLAYLIST_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistViewHolder {
        return PlaylistViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: PlaylistViewHolder, position: Int) {
        val playlist = getItem(position)
        if (playlist != null) holder.bind(playlist)
    }

    companion object {
        val PLAYLIST_COMPARATOR = object : DiffUtil.ItemCallback<Playlist>() {
            override fun areItemsTheSame(oldItem: Playlist, newItem: Playlist) =
                oldItem.playlistName == newItem.playlistName

            override fun areContentsTheSame(oldItem: Playlist, newItem: Playlist) =
                oldItem == newItem
        }
    }
}