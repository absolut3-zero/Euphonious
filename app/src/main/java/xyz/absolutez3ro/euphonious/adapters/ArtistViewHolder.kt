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
import xyz.absolutez3ro.euphonious.data.artist.Artist

class ArtistViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    private val artistName: TextView = view.findViewById(R.id.textView_artistName)
    private val artistArt: ImageView = view.findViewById(R.id.imageView_artistArt)

    fun bind(artist: Artist?) {
        if (artist != null) artistName.text = artist.artistName
        Glide.with(view.context).load(R.drawable.ic_outline_person_24px).into(artistArt)
        view.setOnClickListener {
            artist?.artistName.let {
                Toast.makeText(view.context, it, Toast.LENGTH_SHORT).show()
            }
        }

    }

    companion object {
        fun create(parent: ViewGroup): ArtistViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_artist, parent, false)
            return ArtistViewHolder(view)
        }
    }
}