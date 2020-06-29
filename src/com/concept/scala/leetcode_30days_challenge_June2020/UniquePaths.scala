package com.concept.scala.leetcode_30days_challenge_June2020

/** **
  *
  * Day 29
  *
  * @todo A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
  *       The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
  *       How many possible unique paths are there?
  * @example Example 1:
  *
  *          Input: m = 3, n = 2
  *          Output: 3
  *          Explanation:
  *          From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
  *         1. Right -> Right -> Down
  *         2. Right -> Down -> Right
  *         3. Down -> Right -> Right
  *          Example 2:
  *
  *          Input: m = 7, n = 3
  *          Output: 28
  * @see https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/543/week-5-june-29th-june-30th/3375/
  *      OR
  *      https://leetcode.com/problems/unique-paths/
  *
  *
  */
object UniquePaths {
  def uniquePaths(m: Int, n: Int): Int = {
    val dp = Array.ofDim[Int](m, n)
    for (i <- 0 until m; j <- 0 until n) if (i == 0 || j == 0) dp(i)(j) = 1
    printDPTable(dp)
    println
    for (i <- 1 until m; j <- 1 until n) {
      println(s" for row i  = $i and col j =$j")
      dp(i)(j) = dp(i - 1)(j) + dp(i)(j - 1)
      printDPTable(dp)
      println
    }
    dp.last.last
  }

  def printDPTable(table: Array[Array[Int]]): Unit = table.foreach { x => println(x.mkString("  ")) }


  def main(args: Array[String]): Unit = {
    val m = 3
    val n = 2
    //   println(uniquePaths(m, n))
    println(uniquePaths(7, 3))
  }
}

/*
Initlial Array
1  1  1
1  0  0
1  0  0
1  0  0
1  0  0
1  0  0
1  0  0

 for row i  = 1 and col j =1
1  1  1
1  2  0
1  0  0
1  0  0
1  0  0
1  0  0
1  0  0

 for row i  = 1 and col j =2
1  1  1
1  2  3
1  0  0
1  0  0
1  0  0
1  0  0
1  0  0

 for row i  = 2 and col j =1
1  1  1
1  2  3
1  3  0
1  0  0
1  0  0
1  0  0
1  0  0

 for row i  = 2 and col j =2
1  1  1
1  2  3
1  3  6
1  0  0
1  0  0
1  0  0
1  0  0

 for row i  = 3 and col j =1
1  1  1
1  2  3
1  3  6
1  4  0
1  0  0
1  0  0
1  0  0

 for row i  = 3 and col j =2
1  1  1
1  2  3
1  3  6
1  4  10
1  0  0
1  0  0
1  0  0

 for row i  = 4 and col j =1
1  1  1
1  2  3
1  3  6
1  4  10
1  5  0
1  0  0
1  0  0

 for row i  = 4 and col j =2
1  1  1
1  2  3
1  3  6
1  4  10
1  5  15
1  0  0
1  0  0

 for row i  = 5 and col j =1
1  1  1
1  2  3
1  3  6
1  4  10
1  5  15
1  6  0
1  0  0

 for row i  = 5 and col j =2
1  1  1
1  2  3
1  3  6
1  4  10
1  5  15
1  6  21
1  0  0

 for row i  = 6 and col j =1
1  1  1
1  2  3
1  3  6
1  4  10
1  5  15
1  6  21
1  7  0

 for row i  = 6 and col j =2
1  1  1
1  2  3
1  3  6
1  4  10
1  5  15
1  6  21
1  7  28

28

 */