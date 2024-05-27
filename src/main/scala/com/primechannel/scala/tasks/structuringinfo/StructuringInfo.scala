package com.primechannel.scala.tasks.structuringinfo

/**
 *
 * @project scala-tasks
 * @autor Jack Malik - Primechannel Corporation Ltd.
 *        Date: 5/25/2024
 *        Time: 7:07 PM    
 *
 * */

class StructuringInfo {

}

object StructuringInformation {
  sealed trait Duration
  case object Whole   extends Duration
  case object Half    extends Duration
  case object Quarter extends Duration

  def fractionOfWhole(duration: Duration): Double =
    duration match {
      case Whole   => 1.0
      case Half    => 0.5
      case Quarter => 0.25
    }

  def main(args: Array[String]): Unit = {
    println(fractionOfWhole(Quarter))
    println(fractionOfWhole(Half))
    println(fractionOfWhole(Whole))
  }
}


object StructuringInformation2 {

  sealed trait Symbol
  case class Note(name: String, duration: String, octave: Int) extends Symbol
  case class Rest(duration: String) extends Symbol

  def symbolDuration(symbol: Symbol): String =
    symbol match {
      case Note(name, duration, octave) => duration
      case Rest(duration) => duration
    }

  def caseClassEquals(note: Note, otherNote: Note): Boolean = {
    note == otherNote
  }

  def main(args: Array[String]): Unit = {
    val c3      = Note("C", "Quarter", 3)
    val otherC3 = Note("C", "Quarter", 3)
    val f3      = Note("F", "Quarter", 3)
    val wholeRest = Rest("Whole")

    println("c3 equals to otherC3: " + caseClassEquals(c3, otherC3))
    println("The duration of the c3 is: " + symbolDuration(c3))
    println("c3 equals to f3: " + caseClassEquals(c3, f3))
    println("The duration of the wholeRest is: " + symbolDuration(wholeRest))
  }
}

object StructuringInformation3 {
  case class Note(name: String, duration: String, octave: Int)

  def setUpC3Note(): Note = {
    Note("C", "Quarter", 3)
  }

  def main(args: Array[String]): Unit = {
    val note = setUpC3Note()
    println("Name: " + note.name)
    print("duration: " + note.duration)
    print("octave: " + note.octave)
  }
}