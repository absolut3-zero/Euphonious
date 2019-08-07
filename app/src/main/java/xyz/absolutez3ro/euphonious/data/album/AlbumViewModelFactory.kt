package xyz.absolutez3ro.euphonious.data.album

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class AlbumViewModelFactory : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>) = AlbumViewModel() as T
}