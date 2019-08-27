package com.concept.scala

import scala.collection.mutable.ListBuffer

/**
  * @author Rajesh Santha
  * @version 1.0 on 28th Aug,2019
  * @usecase Greedy algorithm pattern to solve below usecase
  *          farmer need to put a fence around his field having 'p' perimeter and 'lengths' are the variable lengths of wiresets available
  *          He want to complete the fence with less possible individual wiresets,
  *          to avoid 'the extra effort of joining the small lengths and cost of buying more number of smaller sets'
  * @example sides of the field are 4+4+4+4 =16 (p) then
  *          10 meter+5 meter+1 meter cost less than 5 meter+5 meter+5 meter+1 meter
  *          i.e include the longest length as much as possible
  *
  *
  */
object GreedyAlgorithmConcept {

  //lengths are the variable meters of lengths of wires
  val lengths = Array(10, 5, 2, 1)

  def main(args: Array[String]): Unit = {

    /* println(whichReels_iterativeStyle(16).mkString(","))
     println(whichReels_recursiveStyle(8).mkString(","))
    */ println(whichReels_functionalStyle(16).mkString(","))

  }

  /** *
    * Implementing the solution iteratively(imperatively)
    *
    * @param p is perimeter
    * @return List of largest possible lengths to cover perimeter
    */
  def whichReels_iterativeStyle(p: Int): List[Int] = {
    val reels = ListBuffer[Int]()
    var x = p
    while (x > 0) {
      var i = 0
      while (x < lengths(i)) i += 1
      reels += lengths(i)
      x -= lengths(i)
    }
    reels.toList
  }

  /** *
    * Implementing the solution recursively
    *
    * @param p is perimeter
    * @return List of largest possible lengths to cover perimeter
    */
  def whichReels_recursiveStyle(p: Int): List[Int] = {
    if (p == 0) Nil
    else {
      var i = 0
      while (lengths(i) > p) i += 1
      lengths(i) :: whichReels_recursiveStyle(p - lengths(i))
    }
  }

  /** *
    * Implementing the solution functionally
    *
    * @param p is perimeter
    * @return List of largest possible lengths to cover perimeter
    */
  def whichReels_functionalStyle(p: Int): List[Int] = {
    val finalChoice = lengths.foldLeft(Choice(p, List())) { (choice, len) =>
      val multiple = choice.p / len
      val reelsToBuy = List.fill(multiple)(len)
      Choice(choice.p - multiple * len, choice.reels ::: reelsToBuy)
    }

    finalChoice.reels
  }

  case class Choice(p: Int, reels: List[Int])

}
