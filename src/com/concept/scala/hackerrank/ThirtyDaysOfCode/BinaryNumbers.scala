package com.concept.scala.hackerrank.ThirtyDaysOfCode

/**
  * @author Rajesh
  * @todo Given a base-10 integer, , convert it to binary (base-2).
  *       Then find and print the base-10 integer denoting the maximum number of consecutive 1's in n's binary representation.
  * @see https://www.hackerrank.com/challenges/30-binary-numbers/problem
  * @note Use functional programming, avoid imperative programming.
  *
  */

object BinaryNumbers {
  def main (args: Array[String]): Unit = {
    val stdin = scala.io.StdIn
    val n = stdin.readLine.trim.toInt


    val divideBy2 = Iterator.iterate(n)(_ / 2)
    val result = divideBy2
      .takeWhile(_ > 0)
      .map(_ % 2)
      .mkString
      .reverse
      .split("0")
      .max
      .length

    println(result)
  }

}
