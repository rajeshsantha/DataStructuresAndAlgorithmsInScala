package com.concept.scala.leetcode_30days_challenge_May2020

import com.concept.scala.RunTimeCalculation

/** **
  *
  * Day 25
  *
  * @see https://leetcode.com/problems/uncrossed-lines
  *      OR
  *      https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3340/
  *
  *
  *      We write the integers of A and B (in the order they are given) on two separate horizontal lines.
  *
  *      Now, we may draw connecting lines: a straight line connecting two numbers A[i] and B[j] such that:
  *
  *      A[i] == B[j];
  *      The line we draw does not intersect any other connecting (non-horizontal) line.
  *      Note that a connecting lines cannot intersect even at the endpoints: each number can only belong to one connecting line.
  *
  *      Return the maximum number of connecting lines we can draw in this way.
  *
  *
  *
  *      Example 1:
  *
  *
  *      Input: A = [1,4,2], B = [1,2,4]
  *      Output: 2
  *      Explanation: We can draw 2 uncrossed lines as in the diagram.
  *      We cannot draw 3 uncrossed lines, because the line from A[1]=4 to B[2]=4 will intersect the line from A[2]=2 to B[1]=2.
  *      Example 2:
  *
  *      Input: A = [2,5,1,2,5], B = [10,5,2,1,5,2]
  *      Output: 3
  *      Example 3:
  *
  *      Input: A = [1,3,7,1,7,5], B = [1,9,2,5,1]
  *      Output: 2
  *
  *
  *      Note:
  *
  *      1 <= A.length <= 500
  *      1 <= B.length <= 500
  *      1 <= A[i], B[i] <= 2000
  *
  */
object UncrossedLines {

  /** **
    * 74 / 74 test cases passed.
    * Status: Accepted
    * Runtime: 500 ms
    * Memory Usage: 50.5 MB
    *
    * Runtime: 508 ms, faster than 100.00% of Scala online submissions for Uncrossed Lines.
    * Memory Usage: 50.6 MB, less than 100.00% of Scala online submissions for Uncrossed Lines.
    *
    *
    */
  def maxUncrossedLines(A: Array[Int], B: Array[Int]): Int = {
    val (aLength, bLength) = (A.length, B.length)
    val maxLinesCountArray = Array.ofDim[Int](aLength + 1, bLength + 1)

    for (i <- 1 to aLength; j <- 1 to bLength)
      maxLinesCountArray(i)(j) =
        if (A(i - 1) == B(j - 1))
          maxLinesCountArray(i - 1)(j - 1) + 1
        else
          Math.max(maxLinesCountArray(i - 1)(j), maxLinesCountArray(i)(j - 1))


    maxLinesCountArray.last.last
  }

  def main(args: Array[String]): Unit = {

    RunTimeCalculation.calculateRunTime {
    }

    val totalRuntime = RunTimeCalculation.calculateRunTime {
      println(maxUncrossedLines(Array(2, 5, 1, 2, 5), Array(10, 5, 2, 1, 5, 2)))

    }
    println(s" total run time = $totalRuntime seconds OR ${totalRuntime * 1000} milliseonds")

    /*
    3
     total run time = 0.694 seconds OR 694.0 milliseonds
    */
  }
}
