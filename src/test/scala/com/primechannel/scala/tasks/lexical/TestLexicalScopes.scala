package com.primechannel.scala.tasks.lexical

/**
 *
 * @project scala-tasks
 * @autor Jack Malik - Primechannel Corporation Ltd.
 *        Date: 5/27/2024
 *        Time: 11:44 AM    
 *
 * */

import org.scalatest.matchers.should.Matchers
import org.scalatest.refspec.RefSpec

class TestLexicalScopes extends RefSpec with Matchers {

  def `check object scopes`(): Unit = {
    LexicalScopes.objectScopes() shouldBe 3
  }

}

class Test extends RefSpec with Matchers {

  def `lazy evaluation`(): Unit = {
    z + y + x + z + y + x
    builder.result() shouldBe "xzyz"
  }
}


