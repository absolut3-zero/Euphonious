package xyz.absolutez3ro.euphonious.data.song

import android.content.ContentResolver
import androidx.paging.PositionalDataSource

class SongDataSource(contentResolver: ContentResolver) : PositionalDataSource<Song>() {

    private val songLoader = SongLoader(contentResolver)

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<Song>) {
        val listOfSongs =
            songLoader.loadSongs(params.requestedLoadSize, params.requestedStartPosition)
        callback.onResult(listOfSongs, 0, listOfSongs.size)
    }

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<Song>) {
        val listOfSongs = songLoader.loadSongs(params.loadSize, params.startPosition)
        callback.onResult(listOfSongs)
    }
}