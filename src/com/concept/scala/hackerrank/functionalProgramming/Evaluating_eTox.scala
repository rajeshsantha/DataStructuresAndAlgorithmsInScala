package com.concept.scala.hackerrank.functionalProgramming

import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer


/**
  * @author Rajesh Santha
  * @version 1.3
  * @todo
  * Evaluate {e to the power of x} for given values of  x by using the summation of series for the first 10 terms.
  * @Input_Format
  *
  * The first line contains an integer N, the number of test cases.
  * N lines follow. Each line contains a value of x for which you need to output the value of {e to the power of x} using the above series expansion.
  * These input values have exactly 4 decimal places each.
  *
  * @note Use functional programming, avoid imperative programming (no Vars, no loops, no side effects)
  *
  * @see https://www.hackerrank.com/challenges/eval-ex/problem
  *
  *
  */

object Evaluating_eTox {

  def main(args: Array[String]): Unit = {

    val stdin = scala.io.StdIn
    val n = stdin.readLine.trim.toInt
    val resultList = new ListBuffer[String]()

    for (nItr <- 1 to n) {
      val x = stdin.readLine.trim.toDouble
      resultList += eToXevaluator(x)
    }
    resultList.foreach(println)
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
