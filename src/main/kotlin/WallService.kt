object WallService {
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()
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

    fun createComment(postId: Int, comment: Comment): Comment {
        for (post in posts) {
            if (post.id == postId) {
                posts[postId-1].comments.count +=1
                comments += comment
                return comments.last()
            }
        }
        throw PostNotFoundException("no id")
    }

    fun showPostsAndComments() {
        for (element in posts) {
            println(element)
        }
        for (element in comments) {
            println(element)
        }
    }

    fun showComments(): Array<Comment> {
        return comments
    }
}