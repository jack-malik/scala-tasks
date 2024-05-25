package inheritance

class Multilevel {

}

final case class Node[T](value: T, var next: Option[Node[T]])
class Stack[T] private(head: Option[Node[T]])
class Stack2[T] (head: Option[Node[T]])

class Queue[T] private(forwards: Stack[T], backwards: Stack[T]) {}

class A() {
  val a = "A"
}

class B() extends A() {
  protected val b = "B"
}

class C() extends B() {
  val c = "C"
}

object Multilevel  extends {


  def main(args: Array[String]): Unit = {
    val c = new C
    /*
    println(s"c.a = ${c.a}") // A property (non direct superclass)
    println(s"c.b = ${c.b}") // B property (direct superclass)
    println(s"c.c = ${c.c}") // C property
     */
  }
}
