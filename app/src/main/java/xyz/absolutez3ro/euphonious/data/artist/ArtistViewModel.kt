package xyz.absolutez3ro.euphonious.data.artist

import android.content.ContentResolver
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList

class ArtistViewModel : ViewModel() {

    private fun loadArtists(contentResolver: ContentResolver): LiveData<PagedList<Artist>> {
        val config = PagedList.Config.Builder()
            .setPageSize(6)
            .setEnablePlaceholders(false)
            .build()
        return LivePagedListBuilder(ArtistDataSourceFactory(contentResolver), config)
            .build()
    }

    fun getArtists(contentResolver: ContentResolver): LiveData<PagedList<Artist>> {
        return loadArtists(contentResolver)
    }
}