package com.concept.scala.hackerrank.functionalProgramming

/**
  * @author Rajesh
  * @todo
  * You are given a list. Return the sum of odd elements from the given list.
  * @note Use functional programming, avoid imperative programming.
  *
  */

object SumOfOddListElements extends App {

  //val listArgs = scala.io.Source.stdin.getLines.toList.map(_.trim.toInt)
  val list1 = List(3, 2, 4, 6, 5, 7, 8, 0, 1)

  println(f(list1))

  def f (list: List[Int]): Int = (for (i <- list.indices.filter(_ % 2 != 0)) yield list(i)).sum


}
