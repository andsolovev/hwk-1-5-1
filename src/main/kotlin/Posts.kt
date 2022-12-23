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
    val attachment: Array<Attachment>
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
    var count: Int = 0,
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

class Comment(
    val id: Int,
    val fromId: Int,
//    val postId: Int,
    val date: Int,
    val text: String,
    val replyToUser: Int,
    val replyToComment:Int,
    val attachment: Array<Attachment>
) {
    override fun toString(): String {
        return "Comment from User $fromId ($date): $text"
    }
}