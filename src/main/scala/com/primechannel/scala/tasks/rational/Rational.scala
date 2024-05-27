package com.primechannel.scala.tasks.rational

/**
 *
 * @project scala-tasks
 * @autor Jack Malik - Primechannel Corporation Ltd.
 *        Date: 5/25/2024
 *        Time: 10:56 PM    
 *
 * */
class Rational(x: Int, y: Int) {
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  private val g = gcd(x, y)

  def numer = x / g

  def denom = y / g

  def +(r: Rational) =
    new Rational(
      numer * r.denom + r.numer * denom,
      denom * r.denom
    )

  def -(r: Rational) =
    new Rational(
      numer * r.denom - r.numer * denom,
      denom * r.denom
    )

  def *(r: Rational) =
    new Rational(
      numer * r.numer,
      denom * r.denom
    )

  def /(r: Rational) =
    new Rational(
      numer * r.denom,
      denom * r.numer
    )
}

object Rational {
  def main(args: Array[String]): Unit = {
    val firstRational = new Rational(3, 4)
    val secondRational = new Rational(11, 13)

    println((firstRational * secondRational).numer)
    println((firstRational * secondRational).denom)
    println((firstRational / secondRational).numer)
    println((firstRational / secondRational).denom)
  }
}
