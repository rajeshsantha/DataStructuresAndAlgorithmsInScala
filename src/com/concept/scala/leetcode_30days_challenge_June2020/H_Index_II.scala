package com.concept.scala.leetcode_30days_challenge_June2020

import scala.annotation.tailrec

/** **
  * Day 18
  *
  * @see https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/541/week-3-june-15th-june-21st/3364/
  *      OR
  *      https://leetcode.com/problems/h-index-ii/
  *
  *
  *      Given an array of citations sorted in ascending order (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.
  *
  *      According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."
  *
  *      Example:
  *
  *      Input: citations = [0,1,3,5,6]
  *      Output: 3
  *      Explanation: [0,1,3,5,6] means the researcher has 5 papers in total and each of them had
  *      received 0, 1, 3, 5, 6 citations respectively.
  *      Since the researcher has 3 papers with at least 3 citations each and the remaining
  *      two with no more than 3 citations each, her h-index is 3.
  *      Note:
  *
  *      If there are several possible values for h, the maximum one is taken as the h-index.
  *
  *      Follow up:
  *
  *      This is a follow up problem to H-Index, where citations is now guaranteed to be sorted in ascending order.
  *      Could you solve it in logarithmic time complexity?
  *
  *      Accepted        104,317
  *      Submissions      290,224
  *
  *
  *
  *
  *
  */
object H_Index_II {
  def main (args: Array[String]): Unit = {
    val arr = Array(0, 1, 3, 5, 6)
    println(hIndex(arr))

  }

  /** *
    * Runtime: 548 ms, faster than 100.00% of Scala online submissions for H-Index II.
    * Memory Usage: 60.1 MB, less than 100.00% of Scala online submissions for H-Index II.
    *
    * 84 / 84 test cases passed.
    * Status: Accepted
    * Runtime: 548 ms
    * Memory Usage: 60.1 MB
    *
    *
    */
  def hIndex (citations: Array[Int]): Int = {

    @tailrec
    def helper (start: Int, end: Int): Int = {
      val length = citations.length
      val mid = start + (end - start) / 2
      val h = length - mid

      if (start > end) return h

      citations(mid) match {
        case i if i == h => return h
        case i if h > i => helper(mid + 1, end)
        case _ => helper(start, mid - 1)
      }
    }

    helper(0, citations.length - 1)

  }

}
