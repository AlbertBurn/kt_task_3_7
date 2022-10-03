package ru.netology.service

import ru.netology.data.Comments
import ru.netology.data.Post
import ru.netology.data.PostNotFoundException

object WallService {
    private var posts = emptyArray<Post>()
    private var nextPostId = 0
    private var comments = emptyArray<Comments>()
    private var nextCommentId = 0

    fun add(post: Post): Post {
        val postTypeNew = when (post.postType) {
            "post", "copy", "reply", "postpone", "suggest" -> post.postType
            else -> "post"
        }
        posts += post.copy(id = nextPostId++, postType = postTypeNew)
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, storedPost) in posts.withIndex()) {
            if (storedPost.id == post.id) {
                posts[index] = post.copy(
                    ownerId = storedPost.ownerId,
                    date = storedPost.date
                )
                return true
            }
        }
        return false
    }

    fun createComment(postId: Int, comment: Comments): Comments {
        for ((index, storedPost) in posts.withIndex()){
            if (storedPost.id == postId) {
                comments += comment.copy(count = (nextCommentId + 1))
                return comments.last()
            }
        }
        //если не нашли по id, то бросаем исключение
        throw PostNotFoundException("Нет такого поста ${postId}!!!")
    }

    fun clear() {
        posts = emptyArray()
        nextPostId = 0
    }

}
