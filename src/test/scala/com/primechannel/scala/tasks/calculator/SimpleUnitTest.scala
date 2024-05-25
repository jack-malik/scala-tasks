package com.primechannel.scala.tasks.calculator

import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.funspec._
import org.scalatest.matchers.should.Matchers

class SimpleUnitTest extends AnyFreeSpec with Matchers {
  "double revere should be the same" in {
    val data = 1 to 10 to List
    data.reverse should not be data
    data.reverse.reverse shouldBe data
  }
}

class CalculatorSpec extends AnyFunSpec {
  it("adds two numbers") {
    assert(Calculator.addNumbers(3, 4) === 7)
  }

  describe("realName") {
    it("returns her birth name") {
      assert(CardiB.realName() === "Belcalis Almanzar")
    }
  }
  describe("iLike") {
    it("works with a single argument") {
      assert(CardiB.iLike("dollars") === "I like dollars")
    }
    it("works with multiple arguments") {
      assert(CardiB.iLike("dollars", "diamonds") === "I like dollars, diamonds")
    }
  }

}

object CardiB {
  def realName(): String = {
    "Belcalis Almanzar"
  }

  def iLike(args: String*): String = {
    "I like " + args.mkString(", ")
  }
}