package com.knoldus.db
import org.scalatest.flatspec.AnyFlatSpec

class UserReadDtoTest extends AnyFlatSpec {
  "User" should "exist" in {
    val userReadDto = new UserReadDto
    val result = userReadDto.getUserByName("Rishabh")
    assert(!result.isEmpty)
  }

  "User" should "not exist" in {
    val userReadDto = new UserReadDto
    val result = userReadDto.getUserByName("Rahul")
    assert(result.isEmpty)
  }

}
