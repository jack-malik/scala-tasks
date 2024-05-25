package com.primechannel.scala.tasks.currying

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.refspec.RefSpec
import org.scalatest.matchers.should.Matchers
import org.scalatest.matchers.should.Matchers._
import org.scalatest.matchers.should.Matchers
import org.scalatest.matchers.should
import org.scalatest.flatspec._
import org.scalatest.matchers.should._

import caseclasses.equality.ClassesVsCaseClasses.{aliceAccount, bobAccount, c3, cThree}

class CurryExample {

}

object CurryExample {

  import caseclasses.equality.ClassesVsCaseClasses.{aliceAccount, bobAccount, c3, cThree}

  aliceAccount == bobAccount shouldBe false
  c3 == cThree shouldBe true
  (5) shouldBe (5)

  def mycurrying(): Unit = {
    val sum: (Int, Int) => Int = (x, y) => x + y

    val curriedSum: Int => Int => Int = x => y => x + y
    5 shouldBe 5
    (curriedSum(1)(2)) shouldBe (3)
  }

  def main(args: Array[String]): Unit = {
    val x = "scala is awesome"
    println(x.reverse)
    val double = (n: Int) => 2 * n // <------ lambda
    assert(double(10) == 20)
    mycurrying()
  }
}
