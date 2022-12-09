import java.util.Objects

interface Attachment {
    val id: Int
    val ownerId: Int
}

class Audio(
    override val id: Int,
    override val ownerId: Int,
    val userId: Int,
    val artist: String,
    val title: String,
    val duration: Int,
    val url: String,
    val lyricsId: Int,
    val albumId: Int,
    val genreId: Int,
    val noSearch: Boolean = false,
    val isHQ: Boolean = false,
) : Attachment

class Video(
    override val id: Int,
    override val ownerId: Int,
    val title: String,
    val description: String,
    val image: String,
    val views: Int
) : Attachment

class Photo(
    override val id: Int,
    override val ownerId: Int,
    val albumId: Int,
    val userId: Int,
    val text: String,
    val date: Int,
    val sizes: Array<PhotoSizes>
) : Attachment

class PhotoSizes(
    val type: String = "photo",
    val url: String = "www...",
    val width: Int = 800,
    val height: Int = 600
)

class File(
    override val id: Int,
    override val ownerId: Int,
    val title: String,
    val size: Int,
    val ext: String,
    val url: String,
    val date: Int,
    val type: Int
) : Attachment

class Graffity(
    override val id: Int,
    override val ownerId: Int,
    val url: String,
    val width: Int,
    val height: Int
) : Attachment