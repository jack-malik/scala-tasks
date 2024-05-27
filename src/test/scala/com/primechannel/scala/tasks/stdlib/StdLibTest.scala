package com.primechannel.scala.tasks.stdlib
import org.scalatest.matchers.should.Matchers
import org.scalatest.refspec.RefSpec
/**
 *
 * @project scala-tasks
 * @autor Jack Malik - Primechannel Corporation Ltd.
 *        Date: 5/25/2024
 *        Time: 11:18 PM    
 *
 * */

class StdLibTest extends RefSpec with Matchers {

  def `check insertion sort`(): Unit = {

    StdLib.tripleEither(Right(2)) shouldBe (Right[String, Int](6): Either[String, Int])
    StdLib.tripleEither(Left("not a number")) shouldBe (Left[String, Int]("not a number"): Either[String, Int])
  }
}

