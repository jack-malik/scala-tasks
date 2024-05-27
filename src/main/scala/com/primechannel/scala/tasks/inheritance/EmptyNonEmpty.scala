package com.primechannel.scala.tasks.inheritance

/**
 *
 * @project scala-tasks
 * @autor Jack Malik - Primechannel Corporation Ltd.
 *        Date: 5/25/2024
 *        Time: 10:42 PM    
 *
 * */

class EmptyNonEmpty {

}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {

  def contains(x: Int): Boolean =
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true

  def incl(x: Int): IntSet =
    if (x < elem) new NonEmpty(elem, left incl x, right)
    else if (x > elem) new NonEmpty(elem, left, right incl x)
    else this
}

abstract class IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
}

object Empty extends IntSet {
  def contains(x: Int): Boolean = false
  def incl(x: Int): IntSet = new NonEmpty(x, Empty, Empty)
}

object EmptyNonEmpty {
  var nonEmptyExample = new NonEmpty(7, Empty, Empty)

  def main(args: Array[String]): Unit = {
    println(Empty contains 2)
    println(nonEmptyExample contains 7)
  }
}