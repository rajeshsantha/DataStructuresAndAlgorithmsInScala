package com.concept.scala.hackerrank.functionalProgramming

/**
  * @author Rajesh Santha
  * @version 1.0 (No further revison)
  * @todo
  *       Given a list, repeat each element in the list N amount of times.
  *
  * @Input_Format
  *
  * The first line contains the integer S where S is the number of times you need to repeat the elements.
  * The next X lines each contain an integer. These are the X elements in the array.
  *
  * @Output_Format
  *
  * Output each element of the original list S times, each on a separate line.
  * You have to return the list/vector/array of S * X integers.
  * The relative positions of the values should be the same as the original list provided in the input.
  *
  * @note Use functional programming, avoid imperative programming.
  *
  */


object ListReplication {

  def main(args: Array[String]) {
    //val arr = scala.io.Source.stdin.getLines.toList.map(_.trim).map(_.toInt)

    val arr = args.toList.map(_.toInt)
    displayResult(arr)

  }

  def f(num: Int, arr: List[Int]): List[Int] = arr.flatMap(e => List.fill(num)(e))

  def displayResult(arr: List[Int]) = println(f(arr.head, arr.tail).map(_.toString).mkString("\n"))

}
