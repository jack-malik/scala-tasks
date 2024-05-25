package com.primechannel.scala.tasks.recursive
import scala.annotation.tailrec

trait Fibonacci {
  /**
   * In mathematics, the Fibonacci numbers are the numbers in the following integer sequence, called the Fibonacci sequence
   * and characterized by the fact that every number after the first two is the sum of the two preceding ones.
   * 1, 1, 2, 3, 5, 8, 13, 21, 34...
   * Implement a function to calculate the nth element of this series, so calculateNth(6) should return 8
   */
  def calculateNth(n: Int): Int
}

class MyFibonacciCalculator extends Fibonacci {

  def fibonaciRecursive(n: Int): Int = {
    if (n == 0 || n == 1) n
    else fibonaciRecursive(n - 1) + fibonaciRecursive(n - 2)
  }

  def fibonaciTailRecursive(n: Int): Int = {
    @tailrec
    def fibonaciTailRecursive(n: Int, a: Int, b: Int): Int = {
      if (n == 0) a
      else if (n == 1) b
      else fibonaciTailRecursive(n - 1, b, a + b)
    }
    fibonaciTailRecursive(n, 0, 1)
  }

  def fibonaciIterative(n: Int): Int = {
    if (n == 0) return 0
    var a = 0
    var b = 1
    for (i <- 1 until n) {
      val tmpFib = b
      b = a + b
      a = tmpFib
    }
    b
  }

  override def calculateNth(n: Int): Int = {
    fibonaciRecursive(n)
  }
}

object MyFibonacci {
  def main(args: Array[String]): Unit = {
    val fibCalculator = new MyFibonacciCalculator

    println(s"Recursive 6th of Fibonaci series: ${fibCalculator.calculateNth(6)}")
    println(s"Tail Recursive 6th of Fibonaci series: ${fibCalculator.fibonaciTailRecursive(6)}")
    println(s"Iterative 6th of Fibonaci series: ${fibCalculator.fibonaciIterative(6)}")
  }
}
