package com.knoldus

object Email
{
  def isValidEmail(emailid:String):Boolean={
  var regex= """^([a-zA-Z\d\.-]+)@([a-zA-Z\d-]+)\.(com|net|org)$""";
  return emailid.matches(regex);
  }

  def main(args:Array[String])={
  val ch = isValidEmail("try@gmail.com")
  println(ch)
  }
  }
