package xyz.absolutez3ro.euphonious.data.song

data class Song(
    val id: Int,
    val title: String,
    val trackNumber: Int,
    val year: Int,
    val duration: Long,
    val dateAdded: Long,
    val dateModified: Long,
    val albumId: Int,
    val albumName: String,
    val artistId: Int,
    val artistName: String
)