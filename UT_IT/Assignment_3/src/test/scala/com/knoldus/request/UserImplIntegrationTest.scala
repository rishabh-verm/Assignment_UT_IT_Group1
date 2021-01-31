package com.knoldus.request
import com.knoldus.db.{CompanyReadDto, UserReadDto}
import com.knoldus.models.User
import com.knoldus.validator.{EmailValidator, UserValidator}
import org.scalatest.flatspec.AnyFlatSpec

class UserImplIntegrationTest extends AnyFlatSpec {
  val companyReadDto = new CompanyReadDto
  val emailValidator = new EmailValidator
  val userValidator = new UserValidator(companyReadDto, emailValidator)
  val userImpl = new UserImpl(userValidator)



  "User" should "be valid" in {
    val user: User = User("Rishabh","verma",24,"Knoldus","Rishabh.verma@knoldus.com")
    val result =  userImpl.createUser(user)
    assert(!result.isEmpty)
  }

  "User" should "be invalid as it company doesnot exists in DB" in {
    val user: User = User("Karan","Verma",22,"Daffodil","Rishabh@rknoldus.com")
    val result =  userImpl.createUser(user)
    assert(result.isEmpty)
  }

  "User" should "be invalid as email id is invalid" in {
    val user: User = User("Rishabh","verma",24,"Knoldus","Rishabh.vermaknoldus.com")
    val result = userImpl.createUser(user)
    assert(result.isEmpty)
  }

  "User" should "be invalid as email id is invalid and company does not exists in DB" in {
    val user: User = User("Rishabh","verma",24,"Daffodil","rishabh.vermaknoldus.com")
    val result =  userImpl.createUser(user)
    assert(result.isEmpty)
  }
}
