package xyz.absolutez3ro.euphonious.data.artist

import android.content.ContentResolver
import androidx.paging.DataSource

class ArtistDataSourceFactory(private val contentResolver: ContentResolver) :
    DataSource.Factory<Int, Artist>() {

    override fun create(): DataSource<Int, Artist> {
        return ArtistDataSource(contentResolver)
    }
}