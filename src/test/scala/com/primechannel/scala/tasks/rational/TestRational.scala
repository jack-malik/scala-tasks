package com.primechannel.scala.tasks.rational

/**
 *
 * @project scala-tasks
 * @autor Jack Malik - Primechannel Corporation Ltd.
 *        Date: 5/26/2024
 *        Time: 12:45 PM    
 *
 * */

import org.scalatest.matchers.should.Matchers
import org.scalatest.refspec.RefSpec
import org.scalatest.funspec._
import org.scalatest.flatspec._
import org.scalatest.freespec.AnyFreeSpec

import org.scalatest.matchers.should.Matchers._

class TestRational {
  def `dynamic binding`(): Unit = {

    val firstRational = new Rational(1, 2)
    val secondRational = new Rational(5, 7)

    (firstRational * secondRational).numer shouldBe (5)
    (firstRational * secondRational).denom shouldBe 14
    (firstRational / secondRational).numer shouldBe 7
    (firstRational / secondRational).denom shouldBe 10
  }
}



class Test extends RefSpec with Matchers {

  def `dynamic binding`(): Unit = {

    val firstRational = new Rational(1, 2)
    val secondRational = new Rational(5, 7)

    (firstRational * secondRational).numer shouldBe 5
    (firstRational * secondRational).denom shouldBe 14
    (firstRational / secondRational).numer shouldBe 7
    (firstRational / secondRational).denom shouldBe 10
  }
}

