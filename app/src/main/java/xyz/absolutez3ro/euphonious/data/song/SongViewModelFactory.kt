package xyz.absolutez3ro.euphonious.data.song

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SongViewModelFactory : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>) = SongViewModel() as T
}