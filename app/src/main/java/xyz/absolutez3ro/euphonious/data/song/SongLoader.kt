package xyz.absolutez3ro.euphonious.data.song

import android.content.ContentResolver
import android.provider.BaseColumns
import android.provider.MediaStore

class SongLoader(private val contentResolver: ContentResolver) {
    fun loadSongs(limit: Int, offset: Int): List<Song> {
        val listOfSongs = mutableListOf<Song>()
        val baseUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
        val projection = arrayOf(
            BaseColumns._ID,
            MediaStore.Audio.AudioColumns.TITLE,
            MediaStore.Audio.AudioColumns.TRACK,
            MediaStore.Audio.AudioColumns.YEAR,
            MediaStore.Audio.AudioColumns.DURATION,
            MediaStore.Audio.AudioColumns.DATE_ADDED,
            MediaStore.Audio.AudioColumns.DATE_MODIFIED,
            MediaStore.Audio.AudioColumns.ALBUM_ID,
            MediaStore.Audio.AudioColumns.ALBUM,
            MediaStore.Audio.AudioColumns.ARTIST_ID,
            MediaStore.Audio.AudioColumns.ARTIST
        )

        val cursor = contentResolver.query(
            baseUri,
            projection,
            null,
            null,
            MediaStore.Audio.Media.DEFAULT_SORT_ORDER + " LIMIT $limit OFFSET $offset"
        )

        if (cursor != null && cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(0)
                val title = cursor.getString(1)
                val trackNumber = cursor.getInt(2)
                val year = cursor.getInt(3)
                val duration = cursor.getLong(4)
                val dateAdded = cursor.getLong(5)
                val dateModified = cursor.getLong(6)
                val albumId = cursor.getInt(7)
                val albumName = cursor.getString(8)
                val artistId = cursor.getInt(9)
                val artistName = cursor.getString(10)

                listOfSongs.add(
                    Song(
                        id,
                        title,
                        trackNumber,
                        year,
                        duration,
                        dateAdded,
                        dateModified,
                        albumId,
                        albumName,
                        artistId,
                        artistName
                    )
                )
            } while (cursor.moveToNext())
        }

        cursor?.close()
        return listOfSongs
    }
}

