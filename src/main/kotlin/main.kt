import java.util.Objects

fun main() {

    val attachments = arrayOf(
        VideoAttachment(video = Video(1,1,"title", "description", "url", 0)),
        AudioAttachment(audio = Audio(1,1,1,"artist","title", 999, "url", 1,1,1)),
        PhotoAttachment(photo = Photo(1,1,1,1,"text", 1, arrayOf(PhotoSizes()))),
        FileAttachment(file = File(1,1,"title", 1,"ext", "url", 1,1)),
        GraffityAttachment(graffity = Graffity(1,1,"url", 1,1))
    )

    val post1 = Post(1,
        1,
        1,
        1,
        1234567890,
        "text",
        1,
        1,
        true,
        Comments(),
        Copyright(),
        Likes(),
        Reposts(),
        0,
        "post",
        PostSource(),
        Geo(),
        1,
        emptyArray(),
        true,
        true,
        true,
        attachment = attachments
    )

    val post2 = Post(2,
        2,
        2,
        2,
        1234567890,
        "text",
        2,
        2,
        true,
        Comments(),
        Copyright(),
        Likes(),
        Reposts(),
        0,
        "post",
        PostSource(),
        Geo(),
        1,
        emptyArray(),
        true,
        true,
        true,
        attachment = attachments
    )

    WallService.add(post1)
    WallService.add(post2)
    WallService.createComment(1, Comment(1, 1, 111111, "comment", 1, 0, attachments))
    WallService.createComment(1, Comment(1, 3, 222222, "comment", 1, 0, attachments))
    WallService.showPostsAndComments()
}


