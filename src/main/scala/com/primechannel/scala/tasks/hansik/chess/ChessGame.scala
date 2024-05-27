package com.primechannel.scala.tasks.hansik.chess

/**
 *
 * @project scala-tasks
 * @autor Jack Malik - Primechannel Corporation Ltd.
 *        Date: 5/27/2024
 *        Time: 11:18 AM    
 *
 * */


import ChessGame.Figure

trait ChessGame {
  /**
   * For a chess board of the given dimensions and the given number of pieces, return the number of
   * unique board layouts that may be constructed such that no piece is threatened by any other piece.
   *
   * For example for a 2x3 board with two Kings there are four valid combinations as follows:
   *
   *   K-K    K--    --K    ---
   *   ---    --K    K--    K-K
   */
  def combinations(width: Int, length: Int, pieces: Map[Figure, Int]): Long
}

object ChessGame {
  sealed trait Figure
  object Queen extends Figure
  object King extends Figure
  object Rook extends Figure
  object Knight extends Figure
  object Bishop extends Figure
}

