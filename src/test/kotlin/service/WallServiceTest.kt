import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import ru.netology.data.Likes
import ru.netology.data.Post
import ru.netology.data.Views
import ru.netology.service.WallService

class WallServiceTest {


    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun add(myPost: Post) {
        val myPost = Post(
            id = 2,
            ownerId = 1,
            fromId = 1,
            date = 2022,
            text = "Text for test",
            friendsOnly = false,
            likes = Likes(4),
            views = Views(5),
            postType = "reply",
            canPin = true,
            isPinned = false
        )

        val result = add(myPost)
        assertEquals(3, result)
    }

    @Test
    fun updatePostWithExistingID() {
        WallService.add(Post(ownerId = 3, fromId = 3, postType = "post", text="Text 1"))
        WallService.add(Post(ownerId = 3, fromId = 4, postType = "reply", text="Text 2"))
        val myPost = WallService.add(Post(ownerId = 44, fromId = 44, postType = "post", text="Text 3"))
        val result = WallService.update(myPost.copy(
            postType = "primer",
            text="Text 4",
            views = Views(5),
            likes = Likes(2,true)
        ))

        // проверяем результат (используйте assertTrue или assertFalse)
        assertTrue(result)
    }

    @Test
    fun updatePostWithoutExistingID() {
        WallService.add(Post(ownerId = 3, fromId = 3, postType = "post", text="Text 1"))
        WallService.add(Post(ownerId = 3, fromId = 4, postType = "reply", text="Text 2"))
        WallService.add(Post(ownerId = 4, fromId = 4, postType = "post", text="Text 3"))

        val result = WallService.update(Post(
            ownerId = 4,
            fromId = 4,
            postType = "primer",
            text="Text 4",
            views = Views(5),
            likes = Likes(2,true)
        ))

        // проверяем результат (используйте assertTrue или assertFalse)
        assertFalse(result)
    }

}