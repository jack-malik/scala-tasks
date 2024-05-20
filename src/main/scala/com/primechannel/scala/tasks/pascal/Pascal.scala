package com.primechannel.scala.tasks.pascal
import scala.util.{ Try, Success, Failure }

trait Pascal {

  /**
   *  In mathematics, Pascal's triangle is a triangular array of the binomial coefficients.
   *  It looks like this:
   *       1                   0 over 0 = 1/1*1 elements
   *      1 1                  1 over 1 = 1/1*1 = 1 elements
   *     1 2 1                 2 over 2 = 3!/1 * 2 = 6/2 = 3 elements
   *    1 3 3 1                3 over 1 = 4!/3!*1! = 24/6 = 4 elements
   *   1 4 6 4 1               sum of all elements: 2 ^ 4 = 16
   *  1 5 10 10 5 1
   *
   *  Formula for Pascal triangle: (n over k) = (n-1 over k-1) + (n-1 over k)
   *  (so: Each element is the sum of the two elements above it.)
   *
   *  Let E(i,j) be the jth element of the ith row so E(1,1)=1, E(5,2)=4
   *  Implement a function calculateIJth which calculates the value E(i,j)
   */
  def calculateTriangleEntry(i: Int, j: Int): Int
}

class PascalCalculator extends Pascal {

  private def calculator__(i: Int, j: Int, buff: Array[Array[Int]]) = {
    var x: Int = 2
    while (x <= i) {
      var y: Int = 0
      while (y <= i) {
        buff(x)(y) = buff(x-1)(y)
        if (y > 0)
          buff(x)(y) += buff(x-1)(y-1)
        y += 1
      }
      x += 1
    }
    buff(i)(j)
  }

  override def calculateTriangleEntry(i: Int, j: Int): Int = {
    if (i < 0 || i < j)
      throw new IllegalArgumentException("Row number negative or smaller than column number.")

    if (i == 0 || i == 1) {
      1
    } else {
      val tmpArr = Array.fill(i, i)(0)
      tmpArr(0)(0) = 1
      tmpArr(1)(0) = 1
      tmpArr(1)(1) = 1
      calculator__(i-1, j-1, tmpArr)
    }
  }
}

object Pascal {
  def main(args: Array[String]): Unit = {
    val result = Try {
      print("Enter row number in Pascal triangle:: ")
      val n: Int = scala.io.StdIn.readLine.toInt
      print("Enter column number in Pascal triangle: ")
      val k: Int = scala.io.StdIn.readLine.toInt
      new PascalCalculator().calculateTriangleEntry(n, k)
    }
    result match {
      case Success(value) => println(s"Entry in Pascal triangle is:  $value")
      case Failure(ex) => println(s"Computation failed. Exception: ${ex.getMessage}")
    }
  }
}

object Main extends App {

  val a = Array.tabulate(2,3){_+_} // Array[Array[Int]] = Array(Array(0, 1, 2), Array(1, 2, 3))
  //println(a.map{_(n - 1)})
  //a.map{innerArray => innerArray(n - 1)}
  //a.map{innerArray => innerArray.apply(n - 1)}

  println(a.map{_(0)})
  val col = a.map{_(0)}
  for (x <- col) {
    println(x)
  }

  val x = Array.tabulate(5)(x=>x*3)
  //x.foreach(println)
  //println(x)
  val buf = Array.tabulate(2, 2)(_*_*3)

  for (i <- buf.indices) {}
  //println(y(0).mkString(" "))
  //println(y(1).mkString(" "))
  val loc = 0
  var i = 0
  var j = 0
  while ( loc < buf(i).length) {
    buf(i).foreach(print)
    i += 1
    print("\n")
  }
  var row = 0
/*
  buf(row).foreach {

  }
*/

  val matrixFill = Array.fill(3, 2)(0)
  val matrixTabulate = Array.tabulate(3, 5) { case (_, c) => c }
  println(matrixTabulate.mkString(" "))
  val buf2 = Array.fill(3, 3)(0)
}
