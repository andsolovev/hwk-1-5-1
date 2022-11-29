fun main() {
    println(WallService.add(Post(11, 101, 101, "First comment",1669480127, likes = Likes())))
    println(WallService.add(Post(22, 102, 102, "Second comment",1669640468, likes = Likes())))
    println(WallService.update(Post(1, 101, 101, "First comment",1669480127, likes = Likes())))
}

data class Post(
    val id: Int,
    val ownerId: Int,
    val fromId: Int,
    val text: String,
    val date: Long,
    val views: Int = 0,
    val likes: Likes,
    val isPinned: Boolean = false,
    val markedAsAds: Boolean = false
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


object WallService {

    private var posts = emptyArray<Post>()
    private var nextId = 1

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