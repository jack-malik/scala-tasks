package folding

import scala.:+

class Folding {

}
case class Person(name: String, sex: String)

object Folding {

  // Main method
  def main(args: Array[String]): Unit = {
    val list = List(1, 2, 3, 4, 5)
    val sum = list.fold(0)((x, y) => x + y)
    assert(sum == 15)
    println(s"Sum: $sum")

    //-------------------------------
    val persons = List(Person("Thomas", "male"), Person("Sowell", "male"), Person("Liz", "female"))
    val iter = persons.iterator
    while (iter.hasNext) {
      println(iter.next())
    }
    val foldedList = persons.foldLeft(List[String]()) {
      (accumulator, person) =>
        val title = person.sex match {
          case "male" => "Mr."
          case "female" => "Ms."
        }
        accumulator :+ s"$title ${person.name}"
    }
    assert(foldedList == List("Mr. Thomas", "Mr. Sowell", "Ms. Liz"))
    // ---------------------- foldRight
    val foldedListRight = persons.foldRight(List[String]()) {
      (person, accumulator) =>
        val title = person.sex match {
          case "male" => "Mr."
          case "female" => "Ms."
        }
      accumulator :+ s"$title ${person.name}"
    }
    assert(foldedListRight == List("Ms. Liz", "Mr. Sowell", "Mr. Thomas"))
  }

}

