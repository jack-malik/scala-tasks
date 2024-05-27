package com.primechannel.scala.tasks.covariance
import org.scalatest.refspec.RefSpec
import org.scalatest.matchers.should.Matchers
import org.scalatest.Assertions._
import org.scalatest.Assertions
/**
 *
 * @project scala-tasks
 * @autor Jack Malik - Primechannel Corporation Ltd.
 *        Date: 5/27/2024
 *        Time: 12:23 PM    
 *
 * */

class TestCovariance extends RefSpec with Matchers {

  def `zebra vet can be assigned to mammal vet`(): Unit = {
    assertCompiles(
      """
         import Covariance._
         val mammalVet: AnimalVet[Mammal] = new AnimalVet(Zebra)
    """)
  }

  def `reptile vet can't be assigned to mammal vet`(): Unit = {
    assertDoesNotCompile(
      """
       import Covariance._
       val mammalVet: AnimalVet[Mammal] = new AnimalVet(Reptile)
    """)
  }
}
