package com.primechannel.scala.tasks.stdlib

/**
 *
 * @project scala-tasks
 * @autor Jack Malik - Primechannel Corporation Ltd.
 *        Date: 5/25/2024
 *        Time: 11:13 PM    
 *
 * */

class StdLib {
}

object StdLib {

  def triple(x: Int): Int = 3 * x

  def tripleEither(x: Either[String, Int]): Either[String, Int] =
    x.map(triple)

  def optionMap(x: Option[Int]): Option[Int] = {
    x.map(x => x + 1)
  }

  def optionFilter(x: Option[Int]): Option[Int] = {
    x.filter(x => x % 2 == 0)
  }

  def optionFlatMap(x: Option[Int]): Option[Int] = {
    x.flatMap(x => Some(x + 1))
  }
  def main(args: Array[String]): Unit = {

    println(StdLib.optionMap(Some(7)))
    println(StdLib.optionMap(None))
    println(StdLib.optionFilter(Some(5)))
    println(StdLib.optionFilter(Some(6)))
    println(StdLib.optionFlatMap(Some(4)))
    println(StdLib.optionFlatMap(None))

    println(StdLib.tripleEither(Right(1)))
    println(StdLib.tripleEither(Left("not a number")))
  }
}