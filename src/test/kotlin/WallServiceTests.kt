import org.junit.jupiter.api.assertThrows
import kotlin.test.*

class WallServiceTests {

    @Test
    fun testAdd() {
        val post = Post(
            1,
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
            attachment = emptyArray()
        )
        val result = WallService.add(post)
        assertNotEquals(post.id-1, result.id)
    }

    @Test
    fun testUpdateTrue() {
        val post = Post(
            1,
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
            attachment = emptyArray()
        )

        val addedId = WallService.add(post).id
        val updatePost = Post(
            addedId,
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
            attachment = emptyArray()
        )
        val result = WallService.update(updatePost)
        assertEquals(true, result)

    }

    @Test
    fun testUpdateFalse() {
        val post = Post(
            1,
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
            attachment = emptyArray()
        )
        val addedId = WallService.add(post).id
        val updatePost = Post(
            addedId +1,
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
            attachment = emptyArray()
        )
        val result = WallService.update(updatePost)
        assertEquals(false, result)
    }
    @Test
    fun createCommentPostExists() {
        val post = Post(
            1,
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
            attachment = emptyArray()
        )

        WallService.add(post)

        val comment = WallService.createComment(1, Comment(1, 1, 111111, "comment", 1, 0, emptyArray()))
        val comments = WallService.showComments()
        assertContains(comments, comment)
    }

    @Test
    fun shouldThrow() {
        assertThrows<PostNotFoundException> {
            val post = Post(
                1,
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
                attachment = emptyArray()
            )

            WallService.add(post)

            val comment = WallService.createComment(99, Comment(1, 1, 111111, "comment", 1, 0, emptyArray()))
        }
    }

}