package xyz.absolutez3ro.euphonious.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import xyz.absolutez3ro.euphonious.R
import xyz.absolutez3ro.euphonious.data.playlist.Playlist

class PlaylistViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    private val playlistName: TextView = view.findViewById(R.id.textView_playlistTitle)

    fun bind(playlist: Playlist?) {
        if (playlist != null) playlistName.text = playlist.playlistName

        view.setOnClickListener {
            playlist?.playlistName.let {
                Toast.makeText(view.context, it, Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        fun create(parent: ViewGroup): PlaylistViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_playlist, parent, false)

            return PlaylistViewHolder(view)
        }
    }
}