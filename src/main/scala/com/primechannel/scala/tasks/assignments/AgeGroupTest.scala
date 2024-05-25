package assignments
import javax.management.openmbean.InvalidKeyException
import scala.::
import scala.collection.mutable
import scala.util.Random
import scala.collection.immutable.Range.inclusive
import scala.collection.mutable.ListBuffer
/*
* - Given a file with first, last, age
 * - read content,
 * - then read age groups
 * - compute avg in each group
 * - write to file in the form: age_group, avg age
 */
import scala.io.Source
/*
case class Meter private (m: Int)
object Meter {
  def apply(m: Int): Meter = new Meter(m)
}
*/
trait Private


case class Meter private (m: Integer with Private)
object Meter {
  def apply(m: Int) = new Meter((m + 5).asInstanceOf[Integer with Private])
}

case class Person(first: String, last: String, age: Int)

class Helper() {

  def repeatedSpan[T](col: Iterable[T], pred: T => Boolean): List[Iterable[T]] = {
    if (col.isEmpty) Nil
    else {
      val (a, b) = col.span(pred)
      if (a.isEmpty) b.take(1) :: repeatedSpan(b.tail, pred)
      else a :: repeatedSpan(b, pred)
    }
  }

  def getRange(age: Int): Range = {
    if (10 until 20 contains age) {
      Range(10, 20)
    } else if (20 until 30 contains age) {
      Range(20, 30)
    } else if (30 until 40 contains age) {
      Range(30, 40)
    } else {
      Range(40, 50)
    }
  }

  val inPath: String = "c:/github/scala/input/first_last_age.csv"
  def process(path: String = ""): Unit = {
    val source = Source.fromFile(path)
    val lines = try {
      source.getLines // iterator
    } finally {

    }
    val nameToPersonMap: mutable.HashMap[Person, Range] = mutable.HashMap()
    var first: Boolean = true
    while (lines.hasNext) {
      lines.next().split(",") match {
        case Array(firstName, lastName, age) => {
          if (first) {
            first = false
          } else {
            nameToPersonMap += (Person(firstName, lastName, age.toInt) -> this.getRange(age.toInt))
          }
        }
        case _ => //throw IllegalArgumentException
      }
    }
    val rangeToListMap: mutable.Map[Range, mutable.ListBuffer[Int]] =
      new mutable.HashMap[Range, mutable.ListBuffer[Int]]()
/*
    for ((k, v) <- nameToPersonMap) {
      val aTmpList = rangeToListMap.getOrElse(v, mutable.Seq()) {
        rangeToListMap(v) = aTmpList :: v
      }
    }
 */
    //for (i <- 0 to 10; j <- 0 to 10) yield (i, j) -> Random.nextBoolean()).toMap

    source.close()
  }
}

object AgeGroupTest {

  val l2 = List(1,3,5,2,3,1,3,2,5,5,7)
  val ints = List(1, 2, 3)

  //@inline def my_identity(x: Int): Int = (x * 2)

  /*
  val my_identity = (x: Int): Int = 2 * x
  val doubledInts: List[Int] = ints.map { (i: Int) => i * 2
  }
*/
  def main(args: Array[String]): Unit = {

    val l = List("cab", "cab", "cab", "abc", "abc", "cbe")
    val lGrouped: Map[String, List[String]] = l.groupBy(identity)
    println(lGrouped)

    //def my_identity(x: String): String = (x * 2)
    val my_identity = (x: String) => x * 2

    val l_my_identity = List("cab", "cab", "cab", "abc", "abc", "cbe")
    val lGrouped_my_identity: Map[String, List[String]] = l_my_identity.groupBy(my_identity)
    println(lGrouped_my_identity)

    val lamb2 = (x: String) => x + x


    val lGrouped7 = l.groupBy[String](identity).map(x => x + "-mystr-") // + x)
    println(lGrouped7)


    sys.exit(0)

    val lGrouped8: Map[Int, List[Int]] = l2.groupBy[Int](identity) //.map(x => x)
    println(lGrouped8)

    val lGrouped2: Iterable[String] = l.groupBy[String](identity).keys
    println(lGrouped2)

    val lGrouped3: Iterable[String] = l.groupBy[String](identity).keys
    println(lGrouped3)

    val lGrouped4: Iterable[List[String]] = l.groupBy[String](identity).values
    println(lGrouped4)

    val lGrouped5: Iterable[List[String]] = l.groupBy[String](identity).values
    println(lGrouped5)


    val lGrouped6_0: scala.collection.immutable.Map[String, List[String]] = l.groupBy[String](identity) //.map {
      //x => x.canEqual("cab")
    //}

    /*
            val lGrouped: Map[String, List[String]] = l.groupBy[String](identity).map(x => x)
            println(lGrouped)

            val lGrouped2: Iterable[String] = l.groupBy[String](identity).map(x => x._1)
            println(lGrouped2)

            val lGrouped3: Iterable[String] = l.groupBy[String](identity).keys
            println(lGrouped3)

            val lGrouped4 = l.groupBy[String](identity).map(x => x.canEqual("cab"))
            println(lGrouped4)
         */
        sys.exit(0)
/*
        val h: Helper = new Helper()
        //    h.readInput()

        val intSequence: Seq[Int] = Range(1,50)
        //    val intSequence*: Range = Range(1, 10).span(_ <= intSequence.length/2).

        val firstHalf = intSequence.span(_ <= intSequence.length /2)
        val limits = (0 until 100 by 1) map {

          i => (i , i + 10)
        }

        //val range = 0 to 50
        //println(range.zip(range.tail.by(10)))
        val range = 0 to 1000  by 100
        val lamb = (x: Int, y: Int) => (x, y-1)

        val aSet: Set[(Int, Int)] = range.zip(range.tail).toSet
        println(s"ASet: $aSet")
        println( s"${range.zip(range.tail)}")
        //println(s"Done: $range")
        val aSeq = {for (i <- 0 until 50 by 1)
          yield (i%10, i + 10)}.toArray

        println(s"Done: $aSeq")
        println("Done")
    }
*/
  }

}
