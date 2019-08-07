package xyz.absolutez3ro.euphonious.data.album

import android.content.ContentResolver
import android.provider.MediaStore

class AlbumLoader(private val contentResolver: ContentResolver) {
    fun loadAlbums(limit: Int, offset: Int): List<Album> {
        val listOfAlbums = mutableListOf<Album>()
        val baseUri = MediaStore.Audio.Albums.EXTERNAL_CONTENT_URI
        val projection = arrayOf(
            MediaStore.Audio.Albums._ID,
            MediaStore.Audio.Albums.ALBUM,
            MediaStore.Audio.Albums.ARTIST_ID,
            MediaStore.Audio.Albums.ARTIST,
            MediaStore.Audio.Albums.NUMBER_OF_SONGS
        )

        val cursor = contentResolver.query(
            baseUri,
            projection,
            null,
            null,
            MediaStore.Audio.Albums.DEFAULT_SORT_ORDER + " LIMIT $limit OFFSET $offset"
        )

        if (cursor != null && cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(0)
                val title = cursor.getString(1)
                val artistId = cursor.getInt(2)
                val artist = cursor.getString(3)
                val numberOfSongs = cursor.getInt(4)

                listOfAlbums.add(
                    Album(
                        id, title, artistId, artist, numberOfSongs
                    )
                )
            } while (cursor.moveToNext())
        }

        cursor?.close()
        return listOfAlbums

    }
}