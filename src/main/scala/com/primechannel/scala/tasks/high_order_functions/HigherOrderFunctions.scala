package high_order_functions

import scala.reflect.ClassTag.{Nothing, Null}
import scala.runtime.Nothing$
abstract  class MyAbstractClass {
  val foo: Nothing
}
object HigherOrderFunctions {

  def sumBetween(f: Int => Int, a: Int, b: Int): Int = {
    def loop(x: Int, acc: Int): Int = {
      if (x > b) acc
      else loop(x + 1, acc + f(x))
    }

    loop(a, 0)
  }

  def factorial(n: Int): Int =
    if (n == 0) 1 else n * factorial(n - 1)

  def factorial2(n: Int): Int = {

    var f = 1
    for (i <- 1 to n) {
      f = f * i;
    }
    return f
  }

  def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)

  def main1(args: Array[String]): Unit = {
    println(sumBetween(x => x, 1, 10))

    print(gcd(0, 6))
  }

  def gimmeString(): String = throw new NoSuchElementException

  def main(args: Array[String]): Unit = {
    gimmeString()
//    val myNull: scala.Null = Null
    println(factorial(5))
    print(factorial2(5))
  }


}
