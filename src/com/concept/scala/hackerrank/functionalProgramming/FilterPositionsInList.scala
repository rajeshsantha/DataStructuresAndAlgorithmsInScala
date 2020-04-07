package com.concept.scala.hackerrank.functionalProgramming

/**
  * @author Rajesh
  * @todo
  * For a given list with N integers, return a new list removing the elements at odd positions
  * @Input_Format
  *
  * N integers contained in the list, each on a separate line.
  * @Output_Format
  *
  * Output the list with the integers at odd positions removed
  * i.e. the first element, the third element and so on.
  * The relative positions of the remaining even-position elements should be the same as they were in the original array.
  * Each integer will be on a separate line.
  * @note Use functional programming, avoid imperative programming.
  *
  */

object FilterPositionsInList extends App {


  val listArgs = scala.io.Source.stdin.getLines.toList.map(_.trim.toInt)
  f(listArgs).foreach(println)

  def f (arr: List[Int]) = {
    (for (i <- arr.indices.filter(_ % 2 != 0)) yield {
      arr(i)
    }).toList
  }
}
