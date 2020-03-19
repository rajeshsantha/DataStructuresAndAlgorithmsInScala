package com.concept.scala.hackerrank.problemSolving

/** *
  *
  * @see https://www.hackerrank.com/challenges/diagonal-difference/problem
  */

object DiagonalDifference {


  def main (args: Array[String]) {
    val stdin = scala.io.StdIn

    val n = stdin.readLine.trim.toInt
    val arr = Array.ofDim[Int](n, n)
    for (i <- 0 until n) {
      arr(i) = stdin.readLine.split(" ").map(_.trim.toInt)
    }
    println(diagonalDifference(arr))


  }

  def diagonalDifference (arr: Array[Array[Int]]): Int = {

    val lengthOfArray = arr(0).length - 1
    var diagonal_1 = 0
    var diagonal_2 = 0
    for (x <- 0 to lengthOfArray; y <- lengthOfArray to 0 by -1 if x + y == lengthOfArray) {
      if (x + y == lengthOfArray) {
        diagonal_1 += arr(x)(x)
        diagonal_2 += arr(x)(y)
      }
    }
    math.abs(diagonal_1 - diagonal_2)
  }
}
