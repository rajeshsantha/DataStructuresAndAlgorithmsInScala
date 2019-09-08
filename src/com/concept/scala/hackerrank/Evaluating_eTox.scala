package com.concept.scala.hackerrank

import scala.annotation.tailrec

/**
  * @author Rajesh Santha
  * @version 1.0 (No further revison)
  * @todo
  * Evaluate {e to the power of x} for given values of  x by using the summation of series for the first 10 terms.
  * @Input_Format
  *
  * The first line contains an integer N, the number of test cases.
  * N lines follow. Each line contains a value of x for which you need to output the value of {e to the power of x} using the above series expansion.
  * These input values have exactly 4 decimal places each.
  * @note Use functional programming, not imperative programming
  * @see https://www.hackerrank.com/challenges/eval-ex/problem
  *
  *
  */

object Evaluating_eTox {

  def main(args: Array[String]): Unit = {


    val n = scala.io.StdIn.readLine.trim.toInt

    for (nItr <- 1 to n) {
      val x = scala.io.StdIn.readLine.trim.toDouble
      println(eToXevaluator(x))
    }
  }

  def eToXevaluator(num: Double): String = {

    val streamEX: Stream[Double] = Stream.from(0).map(x => math.pow(num, x) / factorial(x))
    val sum = streamEX.take(10).toList.sum
    f"$sum%.4f"
  }

  def factorial(fn: Int): Int = {
    @tailrec
    def f(acc: Int, fn: Int): Int = if (fn <= 0) acc else f(acc * fn, fn - 1)

    f(1, fn)
  }


}
