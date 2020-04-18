package com.concept.scala.leetcode30days

/** **
  * Day 17
  *
  * @see https://leetcode.com/problems/minimum-path-sum/
  *      OR
  *      https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3303/
  *
  *
  *      Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
  *
  *      Note: You can only move either down or right at any point in time.
  *
  *      Example:
  *
  *      Input:
  *      [
  *      [1,3,1],
  *      [1,5,1],
  *      [4,2,1]
  *      ]
  *      Output: 7
  *      Explanation: Because the path 1→3→1→1→1 minimizes the sum.
  *
  *
  *
  *      61 / 61 test cases passed.
  *      Status: Accepted
  *      Runtime: 544 ms
  *      Memory Usage: 51.8 MB
  *
  *      Runtime: 528 ms, faster than 40.00% of Scala online submissions for Minimum Path Sum.
  *      Memory Usage: 52.5 MB, less than 100.00% of Scala online submissions for Minimum Path Sum.
  *
  */
object MinimumPathSum {

  def main (args: Array[String]): Unit = {
    val arr: Array[Array[Int]] = Array(Array(1, 3, 1), Array(1, 5, 1), Array(4, 2, 1))
    println(minPathSum(arr))
  }

  def minPathSum (grid: Array[Array[Int]]): Int = {
    if (grid.isEmpty) return 0

    for {i <- grid.indices; j <- grid(i).indices if !(i == 0 && j == 0)} {
      val left = if (j > 0) grid(i)(j - 1) else Int.MaxValue
      val up = if (i > 0) grid(i - 1)(j) else Int.MaxValue
      //println(s"left = $left  right = $up")
      grid(i)(j) += Math.min(left, up)
      //  println(s"final sum ${grid(i)(j)}")

    }
    grid.last.last
  }
}
