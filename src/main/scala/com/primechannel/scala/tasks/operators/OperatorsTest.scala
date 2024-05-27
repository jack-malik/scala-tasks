package com.primechannel.scala.tasks.operators

import scala.reflect.ClassTag

class OperatorsTest {
  def typetest[T: ClassTag]: Unit = {
    Console.println(this.isInstanceOf[T])
    Console.println(this.getClass)
  }
}

case class Thing[T](value: T)

object Thing {
  def processThing(thing: Thing[_]) = {
    thing match {
      case Thing(value: String) => println("Thing of string")
      case Thing(value: Int) => println("Thing of int")
      case Thing(value: Seq[Int]) => println("Thing of Seq[Int]")
      case _ => "Thing of something else"
    }
  }

  def isOddAndNotMulOf3or5(n: Int): Boolean = {
    n % 2 == 1 && n % 3 != 0 && n % 5 != 0
  }

  def main(args: Array[String]): Unit = {
    val collection: Seq[Int] = Array(1,3,5,7, 8)
    val lamb = isOddAndNotMulOf3or5 _
    val aCollectFiltered3 = collection.filter(isOddAndNotMulOf3or5)

    val aThing: Thing[Int] = Thing(10)
    processThing(aThing)

    val aString: String = "Ala ma kota"

    val aLamb = (acct: String, aChar: Char) => s"$acct$aChar"
    val reversed = aString.foldLeft("")(aLamb)

    // Creating a list and filtering returns new collection
    val m1 = List(5, 12, 3, 13)
    val result = m1.filter(_ < 10)

    // filter using case
    val aCollect: Seq[AnyVal] = Seq[AnyVal](1, 10.0, 20.2)
    val aCollect2: Seq[AnyVal] = Seq[AnyVal](1, 10.0, 20.2)
//    println(aCollect.filter(_.asInstanceOf[Int] % 3 == 0))  //.sum)
    val aCollectFiltered2 = aCollect2.filter(_.asInstanceOf[Int] % 2 == 1)
    val aCollectFiltered = aCollect.filter {
//      case i % 3 == 0 => true
      case i: Double if i == 10.0 => true
      case i: Float if i == 20.2.asInstanceOf[Float] => true
      case i: Int if i == 1 => true
      case _ => false
    } //.sum

    // % 3 != 0 && n % 5
    // != 0)
    // Displays output
    println(result)
  }
  // filtering collection

}

trait T
class B()
case class A() //extends B with T

/*
class Foo[A, B](a: A, b: B) {
  def g[T, A1 >: A <: T, B1 >: B <: T] = List[T](a: A1, b: B1)
}
 */
object OperatorsTest {

  def f[A, B](a: A, b: B): Unit = a match {
    case _: B => println("A is a B")
    case _ => println("A is not a B")
  }


  /*
    def f2[A, B](a: A, b: B) = a match {
      case a.isInstanceOf[B] => println("A is instance of B")
      case _ => println("A is not a B")
    }
  */

  Console.println("main")
  val hel = new OperatorsTest
  hel.typetest[Int]

  val anInt: List[Int] = Nil
  if (anInt.isInstanceOf[List[Int]]) println("Instance of Int") else println("Not an " +
      "instance" +
      " of Int")
  def main(args: Array[String]): Unit = {
//    val a: A with T = new A with T
//    val b: A with T = new A with T
//    f(a, b)

    val oT1 = new OperatorsTest
    val oT2 = oT1
    f(oT1, oT2)
    val oT3 = new OperatorsTest
    f(oT1, oT3)
  }
}
