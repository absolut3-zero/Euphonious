package xyz.absolutez3ro.euphonious.data.song

import android.content.ContentResolver
import androidx.paging.DataSource

class SongDataSourceFactory(private val contentResolver: ContentResolver) : DataSource.Factory<Int, Song>() {
    override fun create(): DataSource<Int, Song> {
        return SongDataSource(contentResolver)
    }
}