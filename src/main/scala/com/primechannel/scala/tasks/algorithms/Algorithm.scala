package com.primechannel.scala.tasks.algorithms

/**
 *
 * @project scala-tasks
 * @autor Jack Malik - Primechannel Corporation Ltd.
 *        Date: 5/25/2024
 *        Time: 1:03 PM    
 *
 * */

class Algorithm {

  def insertionSort[A](xs: List[A])(implicit ord: Ordering[A]): List[A] = {
    def insert(y: A, ys: List[A]): List[A] =
      ys match {
        case List() => y :: List()
        case z :: zs =>
          if (ord.lt(y, z)) y :: z :: zs
          else z :: insert(y, zs)
      }

    xs match {
      case List() => List()
      case y :: ys => insert(y, insertionSort(ys))
    }
  }
}

object Algorithm {



}
