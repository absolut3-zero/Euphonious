package xyz.absolutez3ro.euphonious.data.artist

import android.content.ContentResolver
import android.provider.MediaStore

class ArtistLoader(private val contentResolver: ContentResolver) {
    fun loadArtist(limit: Int, offset: Int): List<Artist> {
        val listOfArtist = mutableListOf<Artist>()
        val baseUri = MediaStore.Audio.Artists.EXTERNAL_CONTENT_URI
        val projection = arrayOf(
            MediaStore.Audio.Artists._ID,
            MediaStore.Audio.Artists.ARTIST,
            MediaStore.Audio.Artists.NUMBER_OF_ALBUMS,
            MediaStore.Audio.Artists.NUMBER_OF_TRACKS
        )

        val cursor = contentResolver.query(
            baseUri,
            projection,
            null,
            null,
            MediaStore.Audio.Artists.DEFAULT_SORT_ORDER + " LIMIT $limit OFFSET $offset"
        )

        if (cursor != null && cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(0)
                val artist = cursor.getString(1)
                val numberOfAlbums = cursor.getInt(2)
                val numberOfTracks = cursor.getInt(3)

                listOfArtist.add(Artist(id, artist, numberOfAlbums, numberOfTracks))
            } while (cursor.moveToNext())
        }
        cursor?.close()
        return listOfArtist
    }
}