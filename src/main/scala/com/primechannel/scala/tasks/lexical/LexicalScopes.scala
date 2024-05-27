package com.primechannel.scala.tasks.lexical
import scala.collection.mutable
/**
 *
 * @project scala-tasks
 * @autor Jack Malik - Primechannel Corporation Ltd.
 *        Date: 5/27/2024
 *        Time: 11:42 AM    
 *
 * */

class LexicalScopes {

}

object LexicalScopes {
  def objectScopes(): Int = {
    object Foo {
      val x = 1
    }

    object Bar {
      val x = 2
    }

    object Baz {

      import Bar.x

      val y = x + Foo.x
    }

    Baz.y
  }

  def main(args: Array[String]): Unit = {
    println(objectScopes())
  }
}


object LazyEvaluation {
  val builder = new mutable.StringBuilder
  val x      = { builder += 'x'; 1 }
  lazy val y = { builder += 'y'; 2 }
  def z      = { builder += 'z'; 3 }

  def main(args: Array[String]): Unit = {

    println(z + y + x + z + y + x)

    println(builder.result())
  }

}