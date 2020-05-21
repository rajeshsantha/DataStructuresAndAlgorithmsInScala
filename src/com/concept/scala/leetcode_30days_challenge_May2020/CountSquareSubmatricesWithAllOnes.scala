package com.concept.scala.leetcode_30days_challenge_May2020

/** ***
  * Day 21
  *
  * @see https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3336/
  *      OR
  *      https://leetcode.com/problems/count-square-submatrices-with-all-ones/ (1277)
  *
  *
  *      Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.
  *
  *
  *
  *      Example 1:
  *
  *      Input: matrix =
  *      [
  *      [0,1,1,1],
  *      [1,1,1,1],
  *      [0,1,1,1]
  *      ]
  *      Output: 15
  *      Explanation:
  *      There are 10 squares of side 1.
  *      There are 4 squares of side 2.
  *      There is  1 square of side 3.
  *      Total number of squares = 10 + 4 + 1 = 15.
  *      Example 2:
  *
  *      Input: matrix =
  *      [
  *      [1,0,1],
  *      [1,1,0],
  *      [1,1,0]
  *      ]
  *      Output: 7
  *      Explanation:
  *      There are 6 squares of side 1.
  *      There is 1 square of side 2.
  *      Total number of squares = 6 + 1 = 7.
  *
  *
  *
  */
object CountSquareSubmatricesWithAllOnes {
  def main (args: Array[String]): Unit = {
    val arr = Array(Array(0, 1, 1, 1), Array(1, 1, 1, 1), Array(0, 1, 1, 1))
    println(countSquares(arr))
  }

  /** ***
    *
    * 32 / 32 test cases passed.
    * Status: Accepted
    * Runtime: 632 ms
    * Memory Usage: 58.3 MB
    *
    *
    * Runtime: 632 ms, faster than 100.00% of Scala online submissions for Count Square Submatrices with All Ones.
    * Memory Usage: 57.9 MB, less than 100.00% of Scala online submissions for Count Square Submatrices with All Ones.
    */
  def countSquares (matrix: Array[Array[Int]]): Int = {
    val rowLength = matrix.length
    val columnLength = matrix.head.length
    val dp = Array.ofDim[Int](rowLength + 1, columnLength + 1)
    var result = 0

    for (i <- 1 to rowLength) {
      for (j <- 1 to columnLength) {
        if (matrix(i - 1)(j - 1) == 1) {
          dp(i)(j) = 1 + math.min(math.min(dp(i - 1)(j - 1), dp(i - 1)(j)), dp(i)(j - 1))
          result += dp(i)(j)
        }
      }
    }
    result

  }


}
