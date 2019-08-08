package xyz.absolutez3ro.euphonious.data.playlist

import android.content.ContentResolver
import androidx.paging.DataSource

class PlaylistDataSourceFactory(private val contentResolver: ContentResolver) :
    DataSource.Factory<Int, Playlist>() {

    override fun create(): DataSource<Int, Playlist> {
        return PlaylistDataSource(contentResolver)
    }
}