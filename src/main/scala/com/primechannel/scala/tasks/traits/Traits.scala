package com.primechannel.scala.tasks.traits
/**
 *
 * @project scala-tasks
 * @autor Jack Malik - Primechannel Corporation Ltd.
 *        Date: 5/25/2024
 *        Time: 10:58 PM    
 *
 * */

class Traits {

}

object Traits {
  abstract class Reducer(init: Int) {
    def combine(x: Int, y: Int): Int
    def reduce(xs: List[Int]): Int =
      xs match {
        case Nil     => init
        case y :: ys => combine(y, reduce(ys))
      }
  }

  object Product extends Reducer(1) {
    def combine(x: Int, y: Int): Int = x * y
  }

  object Sum extends Reducer(0) {
    def combine(x: Int, y: Int): Int = x + y
  }

  val nums = List(1, 2, 3, 4)

  def main(args: Array[String]): Unit = {
    println(Product.reduce(nums))
    println(Sum.reduce(nums))
  }
}




