package com.concept.scala.hackerrank.functionalProgramming
import scala.annotation.tailrec

/**
  * @author Rajesh Santha
  * @version 1.0
  * @todo print pascal triangle.
  * @note Use functional programming, avoid imperative programming (no Vars, no loops, no side effects)
  * @see https://www.hackerrank.com/challenges/pascals-triangle/problem
  *
  */


object PascalTriangle {
  def main(args: Array[String]): Unit = {


    val stdin = scala.io.StdIn
    val number = stdin.readLine.trim.toInt


    for (n <- 0 until number;
         row <- 0 to n) {
      val num = factorial(n) / (factorial(row) * factorial(n - row))
      print(num + " ")
      if (row == n) println()
    }


  }

  def factorial(fn: Int): Int = {
    @tailrec
    def f(acc: Int, fn: Int): Int = if (fn <= 0) acc else f(acc * fn, fn - 1)

    f(1, fn)
  }


}
