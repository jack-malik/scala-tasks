package com.primechannel.scala.tasks.compress

trait Compress {
  /**
   * Eliminate consecutive duplicates of list elements. If a list contains repeated elements they should
   * be replaced with a single copy of the element. The order of the elements should not be changed.
   *
   * For example if provided with the List (1, 2, 2, 1) the function will return List(1, 2, 1)
   */
  def compress[A](xs: List[A]): List[A]
}

class Compressor extends  Compress {

  def compress[A](xs: List[A]): List[A] = {
    println(xs)
    var aList = List(xs.head)
    var next = xs.tail
    while (next.nonEmpty) {
      if (next.head != aList.head) {
        aList = next.head :: aList
      }
      next = next.tail
    }
    println(aList.reverse)
    aList.reverse
  }

}
object Compressor {

  private lazy val intList: Seq[Int] = 1 to 20 map { _ => scala.util.Random.nextInt(4) }
  private lazy val stringList: Seq[Int] = 1 to 20 map { _ => scala.util.Random.nextInt(4) }
  private val compressor: Compressor = new Compressor

  def main(args: Array[String]): Unit = {
    // Compress list of integers
    println(s"List length before compression: ${intList.length}")
    val compressedIntList = compressor.compress(intList.toList)
    println(s"List length after compression: ${compressedIntList.length}")
  }
}
