import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class WallServiceTests {

    @Test
    fun testAdd() {
        val post = Post(0, 101, 101, "First comment",1669480127, likes = Likes())
        val result = WallService.add(post)
        assertNotEquals(post.id, result.id)
    }

    @Test
    fun testUpdateTrue() {
        val post = Post(1, 101, 101, "First comment",1669480127, likes = Likes())
        val addedId = WallService.add(post).id
        val updatePost = Post(addedId, 101, 101, "First comment",1669480127, likes = Likes())
        val result = WallService.update(updatePost)
        assertEquals(true, result)

    }

    @Test
    fun testUpdateFalse() {
        val post = Post(1, 101, 101, "First comment",1669480127, likes = Likes())
        val addedId = WallService.add(post).id
        val updatePost = Post(addedId + 1, 101, 101, "First comment",1669480127, likes = Likes())
        val result = WallService.update(updatePost)
        assertEquals(false, result)
    }
}