package lambdastuff

import java.lang
import scala.collection.immutable.Map

class LambdaTest {

}

object LambdaTest {

  def SomeFunction(a: String): Unit = {
    throw new NotImplementedError
  }

  def main(args: Array[String]): Unit = {

    SomeFunction("alamakota")

    val emptyMap: Map[Int, String] = Map.empty[Int, String]

    val lambdaSum = (x: Int, y: Int) => x * y
    val aList = 1 :: 2 :: 5 :: 6 :: Nil
    val sum = aList.foldLeft(0)(lambdaSum)
    println(s"SUM: $sum")

    // simple lambda returning 2 strings with 'Donut' appended
    val donutLambda = (acc:String, curr:String) => {
      var tmp = s" $acc $curr Donut"
      println(tmp)
      tmp
    }
    //val donutLambda = (acc:String, curr:String) =>  s"$acc Donut"

    // simple lambda returning a new string with char prepended
    val strLambda = (acc: String, curr: Char) => {
      var tmp = s"$curr$acc"
      println(s"ACC: $acc CURR: $curr")
      tmp
    }

    val aList2 = "Strawberry" :: "Plain" :: "Glazed" :: Nil
    println(aList2.foldLeft("--")(donutLambda))

    val aStr = "California2"
    val aCharArr: Array[Char] = aStr.toCharArray
    val len: Int = aCharArr.length
    //println(aCharArr.foldLeft (aCharArr(len - 1).toString)  (strLambda))
    println(aCharArr.foldLeft ("")  (strLambda))

    val strLambda2 = (acc: String, curr: Char) => s"$curr$acc"

    val myString = "California2"
//    myString.map(_ => )
    val reversed = myString.foldLeft ("")  ((acc: String, curr: Char) => s"$curr$acc")
    val reversed2 = myString.foldRight ("")  ((curr: Char, acc: String) => s"$acc$curr")
    println(reversed2)

    def multi(num:Int, num1:Int): Int = {
      val tmp = num * 10
      println(tmp)
      tmp
    }
    val multi2 = ((num:Int, num1:Int) => num * num1)
    val lambdaSum2 = (x: Int, y: Int) => x * y
    println((1 until 3).foldLeft(0)(multi))

    val aTmp: IndexedSeq[Int] = (1 to 5) filter { _ % 2 == 0 }



    println((1 to 5) filter {
      _ % 2 == 0
    } map {
      _ * 2
    })

  }
}
