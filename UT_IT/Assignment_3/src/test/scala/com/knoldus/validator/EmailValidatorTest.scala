package com.knoldus.validator
import org.scalatest.flatspec.AnyFlatSpec

class EmailValidatorTest extends AnyFlatSpec {
  val emailValidator = new EmailValidator
  "email" should "have alphanumeric recipient name in lowercase and/or uppercase " in {
    var result: Boolean = emailValidator.emailIdIsValid("rishabh@knoldus.com")
    assert(result == true)
  }

  "email" should "valid when with starting numbers" in {
    var result: Boolean = emailValidator.emailIdIsValid("191020307002rishabh@knoldus.com")
    assert(result == true)
  }
  "email" should "valid when recipient name has dot and underscore" in {
    var result: Boolean = emailValidator.emailIdIsValid("191020307002.rishabh-verma@knoldus.com")
    assert(result == true)
  }

  "email" should "invalid with missing @" in {
    var result: Boolean = emailValidator.emailIdIsValid("rishabhknoldus.com")
    assert(result == false)
  }

  "email" should "invalid with starting with special symbols except dot and underscore" in {
    var result: Boolean = emailValidator.emailIdIsValid("*/rishabh@knoldus.com")
    assert(result == false)
  }

  "email" should "invalid with space in between" in {
    var result: Boolean = emailValidator.emailIdIsValid("rishabh @knoldus.com")
    assert(result == false)
  }

  "email" should "invalid with missing top level domain" in {
    var result: Boolean = emailValidator.emailIdIsValid("rishabh@gmail")
    assert(result == false)
  }

  "email" should "invalid with missing main domain" in {
    var result: Boolean = emailValidator.emailIdIsValid("rishabh@.com")
    assert(result == false)
  }

  "email" should "invalid when wrong top level domain except .com/.org/.net" in {
    var result: Boolean = emailValidator.emailIdIsValid("rishabh@gdgu.live")
    assert(result == false)
  }

  "email" should "invalid with more than one top level domain" in {
    var result: Boolean = emailValidator.emailIdIsValid("rishabh@knoldus.com.net")
    assert(result == false)
  }

  "email" should "invalid with double dots after domain name" in {
    var result: Boolean = emailValidator.emailIdIsValid("rishabh@knoldus..com")
    assert(result == false)
  }
}
