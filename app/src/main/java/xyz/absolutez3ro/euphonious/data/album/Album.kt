package xyz.absolutez3ro.euphonious.data.album

data class Album(
    val id: Int,
    val title: String,
    val artistId: Int,
    val artist: String,
    val numberOfSongs: Int
)