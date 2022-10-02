package ru.netology.service

import ru.netology.data.Post

object WallService {
    private var posts = emptyArray<Post>()
    private var nextPostId = 0

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

    fun clear() {
        posts = emptyArray()
        nextPostId = 0
    }

}
