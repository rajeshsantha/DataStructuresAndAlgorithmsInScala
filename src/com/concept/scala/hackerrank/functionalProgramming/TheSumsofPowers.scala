package com.concept.scala.hackerrank.functionalProgramming

/** *
  *
  * @see https://www.hackerrank.com/challenges/functional-programming-the-sums-of-powers/problem
  *
  *
  */
object TheSumsOfPowers {
  def numberOfWays (X: Int, N: Int): Int = {
    def calculatePowers (x: Int, n: Int, num: Int): Int = {
      val numbersTillN = math.pow(num, n).toInt

      if (numbersTillN > x) {
        return 0
      } else if (numbersTillN == x) {
        return 1
      } else {
        return calculatePowers(x, n, num + 1) + calculatePowers(x - numbersTillN, n, num + 1)
      }
    }

    calculatePowers(X, N, 1)
  }

  def main (args: Array[String]) {

    println(numberOfWays(scala.io.StdIn.readInt(), scala.io.StdIn.readInt()))
  }

}
