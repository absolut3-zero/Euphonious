package xyz.absolutez3ro.euphonious.data.playlist

import android.content.ContentResolver
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList

class PlaylistViewModel : ViewModel() {
    private fun loadPlaylist(contentResolver: ContentResolver): LiveData<PagedList<Playlist>> {
        val config = PagedList.Config.Builder()
            .setPageSize(10)
            .setEnablePlaceholders(false)
            .build()
        return LivePagedListBuilder(PlaylistDataSourceFactory(contentResolver), config)
            .build()
    }

    fun getArtists(contentResolver: ContentResolver): LiveData<PagedList<Playlist>> {
        return loadPlaylist(contentResolver)
    }
}