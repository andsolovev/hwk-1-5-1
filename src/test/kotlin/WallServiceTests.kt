import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

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
            attachment = Video(1,1,"video", "about", "www",0)
        )
        val result = WallService.add(post)
        assertNotEquals(post.id, result.id)
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
            attachment = Video(1,1,"video", "about", "www",0)
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
            attachment = Video(1,1,"video", "about", "www",0)
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
            attachment = Video(1,1,"video", "about", "www",0)
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
            attachment = Video(1,1,"video", "about", "www",0)
        )
        val result = WallService.update(updatePost)
        assertEquals(false, result)
    }
}