package com.primechannel.scala.tasks.recursive
import scala.annotation.tailrec
import scala.util.{ Try, Success, Failure }

/**
 *
 * @project scala-tasks
 * @autor Jack Malik - Primechannel Corporation Ltd.
 *        Date: 5/25/2024
 *        Time: 12:48 PM    
 *
 * */

class GCD {

  @tailrec
  final def gcd(a: Int, b: Int): Int = {
    if (b == 0) a
    else gcd(b, a % b)
  }
}

object GCD {

  def main(args: Array[String]): Unit = {

    val result = Try {
      print("Enter first number: ")
      val n: Int = scala.io.StdIn.readLine.toInt
      print("Enter second number: ")
      val k: Int = scala.io.StdIn.readLine.toInt
      new GCD().gcd(n, k)
      //def value =
      //value
    }
    result match {
      case Success(value) => println(s"GCD:  $value")
      case Failure(ex) => println(s"Computation failed. Exception: ${ex.getMessage}")
    }
  }
}
