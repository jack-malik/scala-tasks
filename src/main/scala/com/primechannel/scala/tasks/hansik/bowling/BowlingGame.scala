package com.primechannel.scala.tasks.hansik.bowling

/**
 *
 * @project scala-tasks
 * @autor Jack Malik - Primechannel Corporation Ltd.
 *        Date: 5/27/2024
 *        Time: 11:15 AM    
 *
 * */


/**
 * This interface should allow building of the score like this:<br/>
 * <pre>
 * game
 *   .roll(4).roll(4)
 *   .roll(4).roll(6)
 *   .roll(5).roll(0)
 *   .roll(10)
 *   .roll(5).roll(4)
 *   .score
 * </pre>
 * above score should be 56
 */
trait BowlingGame {
  def roll(noOfPins: Int): BowlingGame
  def score: Int
}
