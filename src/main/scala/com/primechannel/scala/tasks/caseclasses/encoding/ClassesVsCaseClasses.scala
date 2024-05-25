package caseclasses.encoding

import scala.runtime.Nothing$

object ClassesVsCaseClasses {
  val c3 = Note("C", "Quarter", 3)
  val d = Note("D", "Quarter", 3)
  val c4 = c3.copy(octave = 4)
  val c5 = Note("A", "Month", 10)

  def main(args: Array[String]): Unit = {
    println(c3.toString)
    println(c3.equals(d))

    println(c4.toString)

    val bool: Boolean = c5.canEqual(d)
    println(bool)
    println(s"HashCd: ${c5.hashCode}")
    val c6:Note = c5.copy()
    println(c6.eq(c5))

  }
}