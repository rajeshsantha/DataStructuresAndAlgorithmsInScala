package com.concept.scala.hackerrank.functionalProgramming

/**
  * @author Rajesh
  * @todo Find the number of ways that a given integer, X, can be expressed as the sum of the Nth  power of unique, natural numbers.
  * @see https://www.hackerrank.com/challenges/functional-programming-the-sums-of-powers/problem
  **/
object TheSumsOfPowers {
  def main (args: Array[String]): Unit = {
    val x = scala.io.StdIn.readInt()
    val n = scala.io.StdIn.readInt()
    println(s"\n x = $x n = $n ")
    println(numberOfWays(x, n))

val ls = List(1,2,3,4)
    ls.last
  }

  def numberOfWays (X: Int, N: Int): Int = {


    return 1

  }
}
