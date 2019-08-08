package xyz.absolutez3ro.euphonious.data.playlist

import android.content.ContentResolver
import androidx.paging.PositionalDataSource

class PlaylistDataSource(contentResolver: ContentResolver) :
    PositionalDataSource<Playlist>() {

    private val playlistLoader = PlaylistLoader(contentResolver)

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<Playlist>) {
        val listOfPlaylist =
            playlistLoader.loadPlaylists(params.requestedLoadSize, params.requestedStartPosition)
        callback.onResult(listOfPlaylist, 0)
    }

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<Playlist>) {
        val listOfPlaylist =
            playlistLoader.loadPlaylists(params.loadSize, params.startPosition)
        callback.onResult(listOfPlaylist)
    }
}