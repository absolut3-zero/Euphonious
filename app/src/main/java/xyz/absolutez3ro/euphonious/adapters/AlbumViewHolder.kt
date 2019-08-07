package xyz.absolutez3ro.euphonious.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import xyz.absolutez3ro.euphonious.R
import xyz.absolutez3ro.euphonious.data.album.Album

class AlbumViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    private val albumArt: ImageView = view.findViewById(R.id.imageView_albumArt)
    private val albumName: TextView = view.findViewById(R.id.textView_albumName)
    fun bind(album: Album?) {
        if (album != null) {
            albumName.text = album.title
        }

        Glide.with(view.context).load(R.drawable.ic_outline_album_24px).into(albumArt)

        view.setOnClickListener {
            album?.title.let {
                Toast.makeText(view.context, it, Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        fun create(parent: ViewGroup): AlbumViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_album, parent, false)
            return AlbumViewHolder(view)
        }
    }
}