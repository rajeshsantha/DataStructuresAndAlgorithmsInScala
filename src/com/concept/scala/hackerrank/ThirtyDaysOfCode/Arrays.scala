package com.concept.scala.hackerrank.ThirtyDaysOfCode


/**
  * @author Rajesh Santha
  * @version 1.0 (No further revison)
  * @todo part of 30 days of code challenge. (Arrays)
  * @see https://www.hackerrank.com/challenges/30-arrays/problem
  * @note Use functional programming, avoid imperative programming.
  *
  */

object Arrays {

  def main(args: Array[String]): Unit = {
    val stdin = scala.io.StdIn
    val n = stdin.readLine.trim.toInt
    val arr = stdin.readLine.split(" ").map(_.trim.toInt)
    val arr1 = arr.dropRight(arr.length - n)
    val len = arr1.length
    (for (i <- len - 1 to 0 by -1) yield {
      arr1(i)
    }).mkString(" ").foreach(print)

  }
}
