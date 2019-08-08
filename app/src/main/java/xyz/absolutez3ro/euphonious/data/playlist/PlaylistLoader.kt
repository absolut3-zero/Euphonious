package xyz.absolutez3ro.euphonious.data.playlist

import android.content.ContentResolver
import android.provider.MediaStore

class PlaylistLoader(private val contentResolver: ContentResolver) {
    fun loadPlaylists(limit: Int, offset: Int): List<Playlist> {
        val listOfPlaylist = mutableListOf<Playlist>()
        val baseUri = MediaStore.Audio.Playlists.EXTERNAL_CONTENT_URI
        val projection = arrayOf(
            MediaStore.Audio.Playlists._ID,
            MediaStore.Audio.Playlists.NAME,
            MediaStore.Audio.Playlists.DATE_ADDED,
            MediaStore.Audio.Playlists.DATE_MODIFIED
        )

        val cursor = contentResolver.query(
            baseUri,
            projection,
            null,
            null,
            MediaStore.Audio.Playlists.DEFAULT_SORT_ORDER + " LIMIT $limit OFFSET $offset"
        )

        if (cursor != null && cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(0)
                val name = cursor.getString(1)
                val dateAdded = cursor.getLong(2)
                val dateModified = cursor.getLong(3)

                listOfPlaylist.add(
                    Playlist(
                        id, name, dateAdded, dateModified
                    )
                )
            } while (cursor.moveToNext())
            cursor.close()
        }

        return listOfPlaylist
    }
}