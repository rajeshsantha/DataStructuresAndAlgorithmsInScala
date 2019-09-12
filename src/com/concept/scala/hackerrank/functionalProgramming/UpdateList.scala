package com.concept.scala.hackerrank.functionalProgramming

/**
  * @author Rajesh Santha
  * @version 1.0 (No further revison)
  * @todo
  * Update the values of a list with their absolute values. (do not use ABS)
  *
  * @note Use functional programming, avoid imperative programming.
  *
  */

object UpdateList {

  def main(args: Array[String]): Unit = {

    //val listArgs = scala.io.Source.stdin.getLines.toList.map(_.trim.toInt) // To run in hackerrank
    val list1 = List(3, 2, -4, 6, 4, -7, -8, 0, 1) // To run local

    f(list1).foreach(println)
  }
  def f(arr:List[Int]):List[Int] = arr.map(x=>if(x<0) -x else x)
}
