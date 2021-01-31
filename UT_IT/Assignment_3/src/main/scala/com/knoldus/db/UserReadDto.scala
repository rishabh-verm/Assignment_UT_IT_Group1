package com.knoldus.db

import com.knoldus.models.User
import scala.collection.immutable.HashMap

 class UserReadDto {
  val user1: User = User("Rishabh","verma",24,"knoldus","Rishabh.verma@gmail.com")
  val user2: User = User("sachin","narang",26,"knoldus","sachin.narang@knoldus.com")


  val users: HashMap[String, User] = HashMap("Rishabh" -> user1, "sachin" -> user2)
  def getUserByName(name: String): Option[User] = users.get(name)
}
