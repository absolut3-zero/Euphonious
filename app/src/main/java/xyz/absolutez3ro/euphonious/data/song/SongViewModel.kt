package xyz.absolutez3ro.euphonious.data.song

import android.content.ContentResolver
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList

class SongViewModel : ViewModel() {

    private fun loadSongs(contentResolver: ContentResolver): LiveData<PagedList<Song>> {
        val config = PagedList.Config.Builder()
            .setPageSize(10)
            .setEnablePlaceholders(false)
            .build()
        return LivePagedListBuilder(SongDataSourceFactory(contentResolver), config)
            .build()
    }

    fun getSongs(contentResolver: ContentResolver): LiveData<PagedList<Song>> {
        return loadSongs(contentResolver)
    }
}