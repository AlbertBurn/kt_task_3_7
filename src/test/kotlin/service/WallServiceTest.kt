import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import ru.netology.data.*
import ru.netology.service.WallService

class WallServiceTest {

    @Before
    fun clear() {
        WallService.clear()
    }

    @Test
    fun add() {
        val myPost = Post(ownerId = 1, fromId = 1, original = null)
        val result = WallService.add(myPost)

        assertEquals(myPost.copy(id = 0), result)
    }


    @Test
    fun updateWithExistingID() {
        WallService.add(Post(ownerId = 3, fromId = 3, postType = "post", text="Text 1 updateWithExistingID", original = null))
        WallService.add(Post(ownerId = 3, fromId = 4, postType = "reply", text="Text 2 updateWithExistingID", original = null))
        val myPost = WallService.add(Post(ownerId = 4, fromId = 4, postType = "post", text="Text 3 updateWithExistingID", original = null))

        val result = WallService.update(myPost.copy(
            postType = "reply",
            text="Text 4 updateWithExistingID",
            views = Views(5),
            likes = Likes(2,true)
        ))

        // проверяем результат (используйте assertTrue или assertFalse)
        assertTrue(result)
    }

    @Test
    fun updateWithoutExistingID() {
        WallService.add(Post(ownerId = 3, fromId = 3, postType = "post", text="Text 1 updateWithoutExistingID", original = null))
        WallService.add(Post(ownerId = 3, fromId = 4, postType = "reply", text="Text 2 updateWithoutExistingID", original = null))
        WallService.add(Post(ownerId = 4, fromId = 4, postType = "post", text="Text 3 updateWithoutExistingID", original = null))

        val result = WallService.update(Post(
            ownerId = 4,
            fromId = 4,
            postType = "reply",
            text="Text 1 updateWithoutExistingID",
            views = Views(5),
            likes = Likes(2,true),
            original = null
        ))

        // проверяем результат
        assertFalse(result)
    }

    @Test(expected = PostNotFoundException::class)
    fun shouldThrow() {
        // здесь код с вызовом функции, которая должна выкинуть PostNotFoundException

        WallService.add(Post(ownerId = 3, fromId = 3, postType = "post", text="Text 1 updateWithoutExistingID", original = null))
        val сomment = Comments(fromId = 0, text = "Коммент для теста")
        WallService.createComment(-1, сomment)
    }

}