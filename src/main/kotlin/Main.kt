package ru.netology

import Link
import LinkAttachment
import Photo
import PhotoAttachment
import Video
import VideoAttachment
import ru.netology.data.Comments
import ru.netology.data.Post
import ru.netology.service.WallService

fun main() {

    val post1 = Post(ownerId = 2, fromId = 3, postType = "post", text="Text 1", attachment = arrayOf(
        PhotoAttachment(Photo(1)),
        VideoAttachment(Video(1))))
    val post2 = Post(ownerId = 3, fromId = 5, postType = "reply", text="Text 2", attachment = arrayOf(
        PhotoAttachment(Photo(2)),
        VideoAttachment(Video(2)),
        LinkAttachment(Link("Link post 2"))))

    println(post1)
    println(post2)

    WallService.add(post1)
    val post03 = WallService.add(post2).copy(text="Text 3")

    WallService.update(post03)

    val commentToPost03 = Comments(fromId = 0, text = "I do not think about horses")

    println("Выполнено")
}