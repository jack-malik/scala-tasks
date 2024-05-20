package com.primechannel.scala.tasks.calculator

import scala.util.matching.Regex

trait Calculator {

  /**
   * Implement a calculator that is able to evaluate a string containing digits, addition symbols
   * and minus symbols.
   * For example [[evaluate("3+4-5")]] should return Right(2). Any string
   * that does not conform to the expectation should return an error message.
   */
  def evaluate(expression: String): Either[String, Int]
}

class MyCalculator {
  private lazy val numRe: Regex = """([+-]?(\d)+)""".r
  private lazy val wholeExpression: Regex = """^[+-]?(\d)+([+-]?(\d))+$""".r

  def evaluate(expression: String): Either[String, Int] = {

    val stripped = expression.replace(" ", "").stripLeading().stripTrailing()
    val aSeq1: Seq[scala.util.matching.Regex.Match] = wholeExpression.findAllMatchIn(stripped).toSeq //.map(_.toString
    // .toInt)
    var total = 0

    aSeq1.size match {
      case 0 => {
        Left("Invalid expression format")
      }
      case _ => {
        numRe.findAllMatchIn(stripped).foreach {
          case numRe(x, y) => {
            total += s"$x".toInt
          }
          case _ => throw new MatchError("Something _really_ unexpected happened :-(")
        }
        Right(total)
      }
    }
  }
}

object MyCalculator {
  def main(args: Array[String]): Unit = {
    val myCalc: MyCalculator = new MyCalculator
    val resultRight: Either[String, Int] = myCalc.evaluate("    + 50+3 -3+ 33  ")
    println(s"Result: ${resultRight.toString}")

    val errorLeft: Either[String, Int] = myCalc.evaluate("    +- 50+3 -3+ 33  ")
    println(s"Result: ${errorLeft.toString}")
  }
}
