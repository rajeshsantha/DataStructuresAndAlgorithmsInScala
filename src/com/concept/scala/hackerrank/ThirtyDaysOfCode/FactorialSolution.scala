package com.concept.scala.hackerrank.ThirtyDaysOfCode

import scala.annotation.tailrec

object FactorialSolution {

    // Complete the factorial function below.
    def factorial(n: Int): Int = {
    @tailrec
    def f(acc: Int, fn: Int): Int = if (fn <= 0) acc else f(acc * fn, fn - 1)

    f(1, n)


    }

    def main(args: Array[String]) {
        val stdin = scala.io.StdIn

        val n = stdin.readLine.trim.toInt

        val result = factorial(n)

        println(result)
    }
}
