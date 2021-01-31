package com.knoldus.request
import com.knoldus.models.{Company, User}
import org.scalatest.flatspec.AnyFlatSpec
import com.knoldus.validator.UserValidator
import org.mockito.MockitoSugar.{mock, when}

class UserImplUnitTest extends AnyFlatSpec {

  val mockedUserValidate = mock[UserValidator]
  val user1: User = User("suraj","Sharma",32,"knoldus","suraj@knoldus.com")
  val user2: User = User("Gaurav","srivastav",24,"knoldus","gaurav.srivastav@knoluds.com")
  val knoldusCompany: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")

  "User" should "be valid" in {
    val userImpl = new UserImpl(mockedUserValidate)
    when(mockedUserValidate.userIsValid(user2)) thenReturn (true)
    val result = userImpl.createUser(user2)
    assert(!result.isEmpty)
  }

  "User" should "be not valid" in {
    val userImpl = new UserImpl(mockedUserValidate)
    when(mockedUserValidate.userIsValid(user1)) thenReturn (false)
    val result = userImpl.createUser(user1)
    assert(result.isEmpty)
  }
}
