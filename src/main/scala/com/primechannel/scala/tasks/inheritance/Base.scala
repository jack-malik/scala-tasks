package com.primechannel.scala.tasks.inheritance

class Base(var firstName: String, var lastName: String) {
  private var _age: Int = 0

  def this(age: Int) = {
    this("","")
    this._age = age
  }
  def this(first: String) = {
    this(first, "")
    this._age = 0
  }
  def age(age: Int): Unit = {
    this._age = age
  }
  def print(): Unit = {
    println(s"First: $firstName, Last: $lastName")
  }
}

object Base {
  def apply(first: String, last: String): Base = {
    new Base(first, last)
  }
}

trait Extended extends Base {

}

object Extended {
  private val first = "Jack"
  private val last = "Malik"
  def apply(arg1: Int) = new Base(arg1) with Extended
  def apply(arg2: String) = new Base(arg2) with Extended
}

object BaseObject {
  def main(args: Array[String]): Unit = {
    val aBaseObj: Base = Base("Jack", "Malik")
    println(aBaseObj)
  }
}