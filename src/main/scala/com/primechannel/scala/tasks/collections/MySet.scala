package com.primechannel.scala.tasks.collections
/*
LinearSeq
 */

import scala.collection.mutable
import scala.language.experimental.macros

class MySet {

}

object MySet {

  def main(args: Array[String]): Unit = {
    var mySet: mutable.HashSet[Int] = mutable.HashSet(1, 2, 3, 4)
    val mySet2: mutable.HashSet[Int] = mutable.HashSet(1, 2, 3, 4)

    var setIter = mySet.iterator

    println((mySet))

    val numbersList: List[Int] = 10 :: 2 :: 3 :: 4 :: Nil  // List of Integers
    val emptyList: List[Int] = Nil  // Empty List
    val x :: xs = numbersList

    val aList = List(10, 20, 30)

    aList match {
      case x :: xs => {
        val head = x
        val rest = xs
        println(s"Head: $x, Rest: $rest")
      }
      case Nil => println(s"Nil encountered in match")

    }
/*
    "AlaMaKota" match {
      case Nil => println(10)
    }

 */
//    assert(x == 1) // true
//    assert(xs == List(2, 3, 4)) // true

    val letters = List("b", "c")
    var letters2 = letters.::("a")
    val letters3 = letters2.::("a")
    letters .:: ("x")

    println(s"Letters: ${letters}")

    val numbers = List(1, 2, 3, 4, 5)
    val doubledNumbers = for (num <- numbers) yield num * 2
    println(doubledNumbers) // Output: List(2, 4, 6, 8, 10)
    var iter = numbers.iterator
    while (iter.hasNext) {
      println(iter.next())
    }

    numbers.foreach(elem => println(elem))





  }
}
