package xyz.absolutez3ro.euphonious.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import xyz.absolutez3ro.euphonious.R
import xyz.absolutez3ro.euphonious.data.song.Song

class SongViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    private val title: TextView = view.findViewById(R.id.textView_songTitle)

    fun bind(song: Song?) {
        if (song != null) {
            title.text = song.title
        }
        view.setOnClickListener {
            song?.title.let {
                Toast.makeText(view.context, it, Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        fun create(parent: ViewGroup): SongViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_song, parent, false)
            return SongViewHolder(view)
        }
    }
}