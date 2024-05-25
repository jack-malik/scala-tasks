package com.primechannel.scala.tasks.monads
import cats._
import cats.implicits._
import scala.util.Random
import scala.collection.mutable

class MyMonads {

}

object MyMonads {

  class A[T] {
    var t: T = _
  }
  // same as:
  //class A[T] { var t: T = _ }
  //defined class A

  new A[String].t
  //res0: String = null

  new A[Object].t
  //res1: java.lang.Object = null

  new A[Int].t
  //res2: Int = 0

  new A[Byte].t
  //res3: Byte = 0

  new A[Boolean].t
  //res4: Boolean = false

  new A[Any].t
  //res5: Any = null

  private val opt1 = Monad[Option].pure(3)
  val opt2 = Monad[Option].flatMap(opt1)(a => Some(a + 2))

  def multiply(x:Int, y:Int) = {
    x * y;
  }
  //x=>y, y=> x*y }
  val aMultiplyFunction = multiply _

  val aList = List(1,2,3,4)

  //println(multiply(aList: _*))

  var c = (for (i <- 0 to 99; j <- 0 to 99)
    yield (i, j) -> Random.nextBoolean()).toMap

  // -------------------------- MAIN ----------------------------------------------
  def main(args: Array[String]): Unit = {
    var aMap: mutable.Map[(Int, Int), Int] = mutable.HashMap[(Int, Int), Int]()

    for (x: Int <- 0 to 5; y: Int <-0 to 5) {
      val elem = Tuple2 ((x, y), x * y)
      aMap.addOne((x, y), x * y)
      aMap.addOne(Tuple2((x, y), x * y))
    }
    println(aMap)


    var c2 = (for (i <- 0 to 99; j <- 0 to 99)
      yield (i,j) -> Random.nextInt()).toMap

    println(s"Map elem: 55,55 is: ${c2((55, 55))}]")

    val arr2d: Array[Array[Int]] = Array.ofDim[Int](3,3)
    arr2d(0)(0) = 10

    //val anyList: List[Int] = scala.collection.immutable.List(1, 2, 3, 4)
    val anyList: List[Int] = List(1, 2, 3, 4)
    val anyList2: List[Int] = anyList.map(x => x* 2)

    //    anyList :: List(1, 2)

    val tmpArr: Array[Int] = Array(10)

    val list2d: List[List[Int]] = List[List[Int]]( List(1, 2, 3), List(4,5,6))
    val second = list2d::List(4.0, 5, 6)
    println(second) // List( List( List(1, 2, 3)),   4, 5, 6)
    for (elem <- second) {
      println(s"Elem: $elem, Type: $elem.")
    }
  }
}
