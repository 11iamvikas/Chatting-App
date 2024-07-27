package com.example.chatapp.data

data class UserData(
    var userId: String?="",
    var name: String?="",
    var number: String?="",
    var imageUrl: String?="",
){
    fun toMap()= mapOf(
        "userId" to userId,
        "name" to name,
        "number" to number,
        "imageUrl" to imageUrl
    )
}

data class ChatData(
    val chatId: String?="",
    val user1: ChatUser= ChatUser(),
    val user2: ChatUser=ChatUser()
)
data class ChatUser(
    val userId: String?="",
    val name: String?="",
    val imageUrl: String?="",
    val number: String?=""
)

data class Message(
    var sendBy: String?="",
    val message: String?="",
    val timestamp: String?=""
)

data class Status(val user: ChatUser= ChatUser(),
    val imageUrl: String?="",
    val timestamp: Long?=null
    )