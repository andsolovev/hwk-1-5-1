import java.util.Objects

interface Attachment {
    val type: String
}

class AudioAttachment(
    override val type: String = "audio",
    val audio: Audio
) : Attachment

class VideoAttachment(
    override val type: String = "video",
    val video: Video
) : Attachment

class PhotoAttachment(
    override val type: String = "photo",
    val photo: Photo
) : Attachment

class FileAttachment(
    override val type: String = "file",
    val file: File
) : Attachment

class GraffityAttachment(
    override val type: String = "graffity",
    val graffity: Graffity
) : Attachment

class Audio(
    val id: Int,
    val ownerId: Int,
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
)

class Video(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val description: String,
    val image: String,
    val views: Int
)

class Photo(
    val id: Int,
    val ownerId: Int,
    val albumId: Int,
    val userId: Int,
    val text: String,
    val date: Int,
    val sizes: Array<PhotoSizes>
)

class PhotoSizes(
    val type: String = "photo",
    val url: String = "www...",
    val width: Int = 800,
    val height: Int = 600
)

class File(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val size: Int,
    val ext: String,
    val url: String,
    val date: Int,
    val fileType: Int
)

class Graffity(
    val id: Int,
    val ownerId: Int,
    val url: String,
    val width: Int,
    val height: Int
)