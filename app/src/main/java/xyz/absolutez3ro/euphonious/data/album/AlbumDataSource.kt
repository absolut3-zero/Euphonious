package xyz.absolutez3ro.euphonious.data.album

import android.content.ContentResolver
import androidx.paging.PositionalDataSource

class AlbumDataSource(contentResolver: ContentResolver) : PositionalDataSource<Album>() {
    private val albumLoader = AlbumLoader(contentResolver)

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<Album>) {
        val listOfAlbums =
            albumLoader.loadAlbums(params.requestedLoadSize, params.requestedStartPosition)
        callback.onResult(listOfAlbums, 0)
    }

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<Album>) {
        val listOfAlbums = albumLoader.loadAlbums(params.loadSize, params.startPosition)
        callback.onResult(listOfAlbums)
    }
}