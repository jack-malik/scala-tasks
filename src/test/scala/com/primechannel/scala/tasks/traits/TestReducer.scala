package com.primechannel.scala.tasks.traits

import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.funspec._
import org.scalatest.matchers.should.Matchers
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.refspec.RefSpec
import org.scalatest.matchers.should.Matchers
import org.scalatest.matchers.should.Matchers._
import org.scalatest.matchers.should.Matchers
import org.scalatest.matchers.should
import org.scalatest.flatspec._
import org.scalatest.matchers.should._
/**
 *
 * @project scala-tasks
 * @autor Jack Malik - Primechannel Corporation Ltd.
 *        Date: 5/25/2024
 *        Time: 11:00 PM    
 *
 * */

class TestReducer extends RefSpec with Matchers {

  def `test reducer`(): Unit = {

    val nums = List(1, 2, 3, 4)

    Traits.Product.reduce(nums) shouldBe 24
    Traits.Sum.reduce(nums) shouldBe 10
  }
}

