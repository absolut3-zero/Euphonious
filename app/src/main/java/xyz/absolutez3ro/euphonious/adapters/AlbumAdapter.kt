package xyz.absolutez3ro.euphonious.adapters

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import xyz.absolutez3ro.euphonious.data.album.Album

class AlbumAdapter : PagedListAdapter<Album, AlbumViewHolder>(ALBUM_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        return AlbumViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        val album = getItem(position)
        if (album != null) holder.bind(album)
    }

    companion object {
        val ALBUM_COMPARATOR = object : DiffUtil.ItemCallback<Album>() {
            override fun areItemsTheSame(oldItem: Album, newItem: Album) =
                oldItem.title == newItem.title

            override fun areContentsTheSame(oldItem: Album, newItem: Album) =
                oldItem == newItem
        }
    }
}