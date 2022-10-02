package ru.netology

import ru.netology.data.Post
import ru.netology.service.WallService

fun main() {

    val post1 = Post(ownerId = 2, fromId = 3, postType = "post", text="Text 1")
    val post2 = Post(ownerId = 3, fromId = 5, postType = "reply", text="Text 2")

    WallService.add(post1)
    val post03 = WallService.add(post2).copy(text="Text 3")

    WallService.update(post03)

    println("Выполнено")
}