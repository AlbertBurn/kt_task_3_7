package ru.netology.data

data class Comments(
    val id: Int = -1,
    val postId: Int? = null,
    val fromId: Int = 0,
    val text: String = "",
    val count: Int = 0,
    val canPost: Boolean = true,
    val groupsCanPost: Boolean = false,
    val canClose: Boolean = false,
    val canOpen: Boolean = false

)