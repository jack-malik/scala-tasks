package com.primechannel.scala.tasks.hansik.futures

/**
 *
 * @project scala-tasks
 * @autor Jack Malik - Primechannel Corporation Ltd.
 *        Date: 5/27/2024
 *        Time: 11:35 AM    
 *
 * */

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.concurrent.{Await, Future}

class Futures {

}

object Futures extends App {

  def someNumbers = List(3000, 1200, 1800, 600, 250, 1000, 1100, 8000, 550)

  def taskFutures: List[Future[String]] = someNumbers map { ms =>
    Future {
      Thread sleep ms
      s"Task completed in $ms ms"
    }
  }

  val allValuesEventually: Future[List[String]] = ???  // complete this please

  val x = Await.result(allValuesEventually, 30.seconds)
  x.foreach(println)

}
