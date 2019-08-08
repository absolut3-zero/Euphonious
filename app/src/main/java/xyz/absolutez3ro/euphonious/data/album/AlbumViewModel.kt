package xyz.absolutez3ro.euphonious.data.album

import android.content.ContentResolver
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList

class AlbumViewModel : ViewModel() {

    private fun loadAlbums(contentResolver: ContentResolver): LiveData<PagedList<Album>> {
        val config = PagedList.Config.Builder()
            .setPageSize(6)
            .setEnablePlaceholders(false)
            .build()
        return LivePagedListBuilder(AlbumDataSourceFactory(contentResolver), config)
            .build()
    }

    fun getAlbums(contentResolver: ContentResolver): LiveData<PagedList<Album>> {
        return loadAlbums(contentResolver)
    }
}