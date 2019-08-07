package xyz.absolutez3ro.euphonious.data.album

import android.content.ContentResolver
import androidx.paging.DataSource


class AlbumDataSourceFactory(private val contentResolver: ContentResolver) :
    DataSource.Factory<Int, Album>() {
    override fun create(): DataSource<Int, Album> {
        return AlbumDataSource(contentResolver)
    }
}