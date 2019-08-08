package xyz.absolutez3ro.euphonious.data.artist

import android.content.ContentResolver
import androidx.paging.PositionalDataSource

class ArtistDataSource(contentResolver: ContentResolver) : PositionalDataSource<Artist>() {

    private val artistLoader = ArtistLoader(contentResolver)

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<Artist>) {
        val listOfArtist =
            artistLoader.loadArtist(params.requestedLoadSize, params.requestedStartPosition)
        callback.onResult(listOfArtist, 0)
    }

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<Artist>) {
        val listOfArtist =
            artistLoader.loadArtist(params.loadSize, params.startPosition)
        callback.onResult(listOfArtist)
    }
}