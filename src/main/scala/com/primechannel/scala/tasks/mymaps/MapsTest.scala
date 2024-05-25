package mymaps

object MapsTest {

  def main(args: Array[String]): Unit = {
    val emptyMap: Map[Int, String] = Map.empty[Int, String]
    val map1: Map[Int, String] = Map(1 -> "first", 2 -> "second")
    val myList = List("age=21", "name=xyz", "profession=Tester", "city=cuba")
    val myMap = myList.map(text => text.split("=")).map(a => (a(0) -> a(1))).toMap
    /*
    attrs.foreach( kv => ... )          // kv._1 is the key, kv._2 is the value
    attrs.foreach{ case (k,v) => ... }  // k is the key, v is the value
    for ((k,v) <- attrs) { ... }        // k is the key, v is the value
         */

    myMap.foreach {
      keyVal => println(keyVal._1 + "=" + keyVal._2)
        val key1 = keyVal._1
        val val1 = keyVal._2
    }

    println(myMap)

    val tuple2: (String, Int) = ("Joe", 34)
    val tuple3: (String, String, Int) = ("Joe", "Malik", 34)
    val tuple4 = Tuple4(10, 20,30, 40)

    def echo(args: String*): Unit =
      for (arg <- args) println(arg)

    val arr = Array("What's", "up", "doc?", "Ala", "ma", "Kota")
    echo(arr: _*)

  }
}
