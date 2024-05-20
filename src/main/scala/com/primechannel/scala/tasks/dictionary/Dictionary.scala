package com.primechannel.scala.tasks.dictionary

import scala.collection.mutable.ListBuffer
import scala.io.Source
import scala.util.Try
import scala.util.matching.Regex

/**
  * Task:
  * (i) Implement @see Dictionary#allWords
  * This should read all the words from resource words.txt and return them in a list.
  *
  * (ii) Implement @see Dictionary#wordsMatchingAllPredicates It should return a subset of allWords which matches all the given predicates.
  * Allow for predicates:
  * a. length = n
  * b. letter at index n is l
  */

trait Word {
  //This should have a sensible representation
  def toString: String
}

trait Predicate {
  def matches(word: Word): Boolean
}

trait Dictionary {
  def allWords: List[Word]
  def wordsMatchingAllPredicates(predicates: Predicate*): List[Word]
}

case class MyWord(val raw: String) extends Word {
  override def toString: String = raw
  def charAt(pos: Int): Char = raw(pos)
  def length: Int = raw.length
}

case class MyPredicate(re: Regex, reParams: Any*) extends Predicate {

  private val raw: String = re.toString()
  private val rawParams: Array[Any] = reParams.toArray

  override def matches(word: Word): Boolean = {
    val matched = raw match {
      case MyPredicate.letterAtPredicate.raw => {
        raw.replace("<n>", rawParams(0).toString).replace("<l>", rawParams(1).toString)
        word.asInstanceOf[MyWord].length > reParams(0).asInstanceOf[Int] &&
            word.asInstanceOf[MyWord].charAt(reParams(0).asInstanceOf[Int]) == reParams(1).asInstanceOf[String](0)
      }
      case MyPredicate.lengthPredicate.raw => {
        raw.replace("<n>", rawParams(0).toString)
        word.asInstanceOf[MyWord].length > 0 && word.asInstanceOf[MyWord].length == rawParams(0).asInstanceOf[Int]

      }
      case _ => false
    }
    matched
  }
}

object MyPredicate {
  // example predicate objects
  val letterAtPredicate: MyPredicate = MyPredicate("letter at index <n> is <l>".r, 3, "a")
  val lengthPredicate: MyPredicate = MyPredicate("length = <n>".r, 3)
}

class MyDictionary() extends Dictionary {

  private lazy val wordList: List[MyWord] = Try {
    val source = Source.fromFile(MyDictionary.srcPath)
    source.getLines.toList.map(x => MyWord(x))
  }.get

  private def wordsMatching(predicate: Predicate): List[Word] = {
    var tmpListBuf: ListBuffer[Word] = ListBuffer()
    wordList.foreach {
      word => if (word.asInstanceOf[MyWord].length > 0 &&  predicate.matches(word.asInstanceOf[MyWord]))
        tmpListBuf.addOne(word)
    }
    tmpListBuf
  }.toList

  // --------------- API --------------------------
  override def allWords: List[Word] = wordList
  override def wordsMatchingAllPredicates(predicates: Predicate*): List[Word] = {
    val predList: List[Predicate] = predicates.toList
    var tmpListBuf: ListBuffer[Word] = ListBuffer()
    for (pred <- predList) {
      tmpListBuf.addAll(wordsMatching(pred))
    }
    tmpListBuf.toList
  }
}

object MyDictionary {

  private val srcPath = "C:\\github\\scala-interview-temp-master\\src\\main\\resources\\words.txt"

  def main(args: Array[String]): Unit = {
    val myDict: MyDictionary = new MyDictionary
    val wordsMatchingList1 = myDict.wordsMatchingAllPredicates(MyPredicate.letterAtPredicate)
    println(s"\nTotal words matching letterAtPredicate: ${wordsMatchingList1.length} \n- $wordsMatchingList1\n")
    val wordsMatchingList2 = myDict.wordsMatchingAllPredicates(MyPredicate.lengthPredicate)
    println(s"Total words matching letterAtPredicate: ${wordsMatchingList2.length} \n- $wordsMatchingList2\n")
    val wordsMatchingList3 = myDict.wordsMatchingAllPredicates(MyPredicate.letterAtPredicate, MyPredicate.lengthPredicate)
    println(s"Total words matching both (version 1): ${wordsMatchingList3.length} \n- $wordsMatchingList3\n")
    val wordsMatchingList4 = myDict.wordsMatchingAllPredicates(MyPredicate.lengthPredicate, MyPredicate.letterAtPredicate)
    println(s"Total words matching both (version 2): ${wordsMatchingList3.length} \n- $wordsMatchingList3\n")
  }
}
