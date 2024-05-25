package com.primechannel.scala.tasks.collections

import annotations.AnnotationTests.echo
//import org.scalactic.ColCompatHelper.WithFilter
import scala.collection.WithFilter

import scala.Console.println
import scala.collection.immutable.ListMap

class MyListMap {

  echo("hello in myListmap class")
  val tupleList: ListMap[String, String] = ListMap("Rice"->"100","Wheat"->"50",
    "Gram"->"500")

  def update(aListMap: ListMap[String, String]): ListMap[String, String] = {
    println(s"in function call: $aListMap")
    val newListMap: ListMap[String, String] = aListMap + ("Russia" -> "Moscow")
    println(s"new: $newListMap, old: $aListMap")
    assert(newListMap.ne(aListMap))
    newListMap
  }

  def main(args: Array[String]): Unit = {
    print(tupleList)
  }
}

object MyListMapObj {

  def main(args: Array[String]): Unit = {

    val list = List("age=21", "name=xyz", "profession=Tester", "city=cuba")

    val myMap1: List[Array[String]] = list.map(text => text.split("=")) // .map(a => (a(0) -> a(1))).toMap
    val myMap2 = list.map(text => text.split("=")).map(a => (a(0) -> a(1))) // .toMap
    val myMap3 = list.map(text => text.split("=")).map(a => (a(0) -> a(1))).toMap


    val myList: List[(String, String)] = List("Uk" -> "London", "Poland" -> "Warsaw")
    val myList2: List[Int] = List(1,3,5,6,7)
    for (elem <- myList2) {
      elem match {
        case 1 =>
        case _ =>
      }
    }
    val dummyFunction = (x: Int, y: Int) => (x, y)
    //println(myList2.toMap(a => (a(0) => a(1)))


    println(myList2.toVector.toList.toVector.map(_ % 3 == 0))
    println(myList2.toVector.exists(x => x > 1 && x < 10 || x % 3 != 0))
    val filtered: WithFilter[Int, Stream] = myList2.toVector.toStream.withFilter(x => x > 1 && x < 10 || x % 3 != 0)
    println(myList2.toVector.toStream.withFilter(x => x > 1 && x < 10 || x % 3 != 0))
    println(myList2.toVector.contains(1))



    println(s"before call: $myList")
//    myList. update(ListMap[String, String]("UK" -> "London"))
    val aVec1 = myList.toVector.toMap//.toArray //.toList
    println(aVec1)
    aVec1.foreachEntry {
      case (k, v)  => println(s"$k - $v")
    }
    println(aVec1)

    /*
    var anArr: Array[AnyRef] = Array[AnyRef](10)
    anArr(1) = 1.0.asInstanceOf[Int]
    anArr(0) = "Foobar"
    println(anArr)
 */
/*
    anArr match {
      case i: Array[(String, String)] => println("array")
      case i: Array[String] => println("array 2")
      case i: Array[AnyRef] => println("array 3")
      case _ => println("No idea")
      case i: Array[Int] => println("array")
    }
 */
  //  println(myList.toString)

    //val v = Vector(1 to 10: _*)
    val range = (1 to 5).toVector
    val aVec: Vector[Number] = Vector(5, 1.0, 10.asInstanceOf[Float],'5')
//    aVec.foreach(x => println(x))
    aVec.foreach {
      //case x => println(x)
      println(_)
    }
    Map(1 -> "a", 2 -> "b", 3 -> "c").foreach {
      case (k, v) => println(s"The value for " + s"key ${k} is: ${v}")
    }
  //  val v = Vector(1 to 10)
//    println(v)
  }
}


