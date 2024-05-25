package flatmap

class FlatMapClass(var name: String) {
}

object GfG
{

  // Main method
  def main(args:Array[String]): Unit = {

    // Creating a list of numbers
    val list = List(2, 3, 4)
    val iter = list.iterator

    // Defining a function
    def f(x:Int) = List(x-1, x, x+1)

    // Applying flatMap
    val result = list.flatMap(y => f(y))

    // Displays output
    println(result)
    // -----------------------------------------
    // Creating a sequence of numbers
    val seq = Seq(4, 5, 6, 7)

    print(seq.map(println(_)))
    // Applying flatMap on another
    // function
    val result2 = seq flatMap { s =>
      Seq(s, s - 1)
    }

    // Displays output
    println(result2)

    while (!list.isEmpty) {
      val head = list.head
      val tail = list.tail
    }
    println(result2)

  }
}

object FlatMapClass {
  val name: Seq[String] = Seq("Nidhi", "Singh")

  def main(args: Array[String]): Unit = {
    val result1 = this.name.map(_.toLowerCase)
    val result2 = result1.flatten
    println(s"Flatted: $result1")
    println(s"Flatten: $result2")
    result1 match {
      case List("nidhi", "singh") => println("Flatted")
      case _ => println("Failed")
    }
    val str = 1 #:: 2 #:: 3 #:: Stream.empty
    println(str)

    val name:Option[String] = None
    val email:Option[String] = None
    val pass:Option[String] = Some("Foo")
    val i = List(name,email,pass).find(x => x match{
      case None => true
      case _ => false
    })
    i match{
      case Some(x) => println("Bad Request")
      case None => {
        //move forward
      }
    }
/*
    val j = List(name, email, pass).find(x => x match {
      case Option[x] => true
      case _ => false
    })

 */
  }
}