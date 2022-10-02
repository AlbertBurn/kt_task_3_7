package ru.netology.data

data class Post (
    val id: Int = -1,
    val ownerId: Int,
    val fromId: Int,
    val createdBy: Int? = null,
    val date: Int = (System.currentTimeMillis() / 86400000).toInt(),
    val text: String = "",
    val replyOwnerId: Int? = null,
    val replyPostId: Int? = null,
    val friendsOnly: Boolean = true,
    val comments: Comments = Comments(),
    val likes: Likes = Likes(),
    val views: Views = Views(),
    val postType: String = "post",
    val canPin: Boolean = true,
    val canDelete: Boolean = false,
    val isPinned: Boolean = true
)