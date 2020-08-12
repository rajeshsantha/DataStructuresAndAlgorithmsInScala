package com.concept.scala.leetcode_30days_challenge_August2020

/** **
  *
  * Day 12
  *
  * @todo Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
  *       Note that the row index starts from 0.
  *       In Pascal's triangle, each number is the sum of the two numbers directly above it.
  * @example Input: 3
  *          Output: [1,3,3,1]
  * @note Could you optimize your algorithm to use only O(k) extra space?
  * @see https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/550/week-2-august-8th-august-14th/3421/
  *      OR
  *      https://leetcode.com/problems/pascals-triangle-ii
  *
  *
  */
object PascalsTriangleII {
  /** *
    * 34 / 34 test cases passed.
    * Status: Accepted
    * Runtime: 416 ms
    * Memory Usage: 48.7 MB
    *
    */
  @annotation.tailrec
  def nextRow(ls: List[Int], lx: List[Int] = List(1)): List[Int] = ls match {
    case Nil => lx
    case _ :: Nil => nextRow(Nil, 1 :: lx)
    case e1 :: e2 :: t => nextRow(e2 :: t, e1 + e2 :: lx)
  }

  def getRow(rowIndex: Int): List[Int] = rowIndex match {
    case 0 => List(1)
    case 1 => List(1, 1)
    case x if x > 1 => nextRow(getRow(x - 1))
  }

  /**
    * 34 / 34 test cases passed.
    * Status: Accepted
    * Runtime: 420 ms
    * Memory Usage: 48.8 MB
    *
    */
  def getRow2(rowIndex: Int): List[Int] = {
    if (rowIndex == 0) return List(1)
    if (rowIndex == 1) return List(1, 1)

    val arr = Array.fill(rowIndex + 1)(0)
    arr(0) = 1
    arr(1) = 1
    for (i <- 2 until arr.length) {
      arr(i) = 1
      for (j <- i - 1 to 1 by -1) arr(j) = arr(j) + arr(j - 1)
    }
    arr.toList
  }

}
