package com.primechannel.scala.tasks.syntax

/**
 *
 * @project scala-tasks
 * @autor Jack Malik - Primechannel Corporation Ltd.
 *        Date: 5/25/2024
 *        Time: 7:29 PM    
 *
 * */

class Convenience {
  class Animal

  class Reptile extends Animal

  class Mammal extends Animal

  class Zebra extends Mammal

  def selection[A >: Zebra <: Animal](a: A): A =
    a

  val unknownAnimal = new Animal
  val reptile = new Reptile
  val mammal = new Mammal
  val zebra = new Zebra

  def main(args: Array[String]): Unit = {
    println(selection(unknownAnimal))
    println(selection(reptile))
    println(selection(mammal))
    println(selection(zebra))
  }
}

object Conveniences {

  trait Animal

  case object Reptile extends Animal

  abstract class Mammal extends Animal

  case object Zebra extends Mammal

  class AnimalVet[+T](val animal: T)


  def triple(x: Int): Int = 3 * x

  def tripleEither(x: Either[String, Int]): Either[String, Int] =
    x.map(triple)

  def optionMap(x: Option[Int]): Option[Int] = {
    x.map(x => x + 1)
  }

  def optionFilter(x: Option[Int]): Option[Int] = {
    x.filter(x => x % 2 == 0)
  }

  def optionFlatMap(x: Option[Int]): Option[Int] = {
    x.flatMap(x => Some(x + 1))
  }

  def function(xs: Array[Int], ys: Array[Int]): Array[(Int, Int)] = {
    for {
      x <- xs if x % 2 == 0
      y <- ys
    } yield (x, y)
  }

  def functionDesugared(xs: Array[Int], ys: Array[Int]): Array[(Int, Int)] = {
    xs.filter { x =>
      x % 2 == 0
    }.flatMap { x =>
      ys.map { y =>
        (x, y)
      }
    }
  }

  case class Range(start: Int, end: Int, step: Int = 1)

  def average(x: Int, xs: Int*): Double =
    (x :: xs.toList).sum.toDouble / (xs.size + 1)


  type Result = Either[String, (Int, Int)]
  def divide(dividend: Int, divisor: Int): Result =
    if (divisor == 0) Left("Division by zero")
    else Right((dividend / divisor, dividend % divisor))

  def size[A](xs: List[A]): Int =
    xs match {
      case Nil => 0
      case y :: ys => 1 + size(ys)
    }

  def main(args: Array[String]): Unit = {
    val xs = Range(start = 1, end = 10)
    println("The step:")
    println(xs.step)

    println("average result:")
    println(average(1))
    println(average(1, 3))
    println(average(1, 3, 5, 7))

    println("divide result:")
    println(divide(4, 2))
    println(divide(5, 0))

    println(tripleEither(Right(1)))
    println(tripleEither(Left("not a number")))

    val reptileVet = new AnimalVet(Reptile)
    val zebraVet = new AnimalVet(Zebra)

    //Uncomment the line below to see if the reptileAnimal passes type-checking
    // val vet: AnimalVet[Mammal] = reptileVet
    val mammalVet: AnimalVet[Mammal] = zebraVet

    println(reptileVet.animal.getClass.getSimpleName)
    println(zebraVet.animal.getClass.getSimpleName)
    println(mammalVet.animal.getClass.getSimpleName)

    println(size(Nil))
    println(size(List(1, 2, 3)))
    println(size(1 :: 3 :: Nil))
  }
}