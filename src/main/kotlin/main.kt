import java.util.Objects

fun main() {

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
        attachment = Video(1,1,"video", "about", "www",0)
    )

    val post2 = Post(1,
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
        attachment = Audio(1, 1, 1, "Singer", "Song", 300, "www", 1, 1, 1)
    )

    val photo = Photo(1, 1, 1, 1, "text", 1234567890, emptyArray<PhotoSizes>())
    println(WallService.add(post1))
    println(WallService.add(post2))

}

data class Post(
    val id: Int,
    val ownerId: Int,
    val fromId: Int,
    val createdBy: Int,
    val date: Long,
    val text: String,
    val replyOwnerId: Int,
    val replyPostId: Int,
    val friendsOnly: Boolean,
    val comments: Comments,
    val copyright: Copyright,
    val likes: Likes,
    val reposts: Reposts,
    val views: Int,
    val postType: String,
    val postSource: PostSource,
    val geo: Geo?,
    val signerId: Int,
    val copyHistory: Array<Reposts>,
    val canPin: Boolean,
    val canDelete: Boolean,
    val canEdit: Boolean,
    val isPinned: Boolean = false,
    val markedAsAds: Boolean = false,
    val attachment: Attachment
)

class Likes(
    val count: Int = 0,
    val user_likes: Boolean = true,
    val can_like: Boolean = true,
    val can_publish: Boolean = true,
) {
    override fun toString(): String {
        return "$count likes"
    }
}

class Comments(
    val count: Int = 0,
    val canPost: Boolean = true,
    val groupsCanPost: Boolean = true,
    val canClose: Boolean = true,
    val canOpen: Boolean = true,
) {
    override fun toString(): String {
        return "$count comments"
    }
}

class Copyright(
    val id: Int = 0,
    val link: String = "_",
    val name: String = "_",
    val type: String = "_",
) {
    override fun toString(): String {
        return "copyright holder's ID: $id"
    }
}

class Reposts(
    val count: Int = 0,
    val userReposted: Boolean = true,
) {
    override fun toString(): String {
        return "$count reposts"
    }
}

class PostSource(
    val type: String = "_",
    val platform: String = "_",
    val data: String = "_",
    val url: String = "_",
)

class Geo(
    val type: String = "_",
    val coordinates: String = "_",
    val place: String = "_",
)

class Donat(
    val isDonut: Boolean = false,
    val paidDuration: Int = 0,
    val placeholder: String = "_",
    val canPublishFreeCopy: Boolean = true,
    val editMode: String = "_"
)


object WallService {
    private var posts = emptyArray<Post>()
    private var nextId = 0

    fun add(post: Post): Post {
        posts += post.copy(id = nextId ++)
        return posts.last()
    }

    fun update(newPost: Post): Boolean {
        for ((index, post) in posts.withIndex()) {
            if (post.id == newPost.id) {
                posts[index] = newPost.copy()
//                posts[index] = newPost.copy(id = nextId ++, fromId = post.fromId + 1, text = post.text + " (updated)")
                println(posts[index])
                return true
            }
        }
        return false
    }
}