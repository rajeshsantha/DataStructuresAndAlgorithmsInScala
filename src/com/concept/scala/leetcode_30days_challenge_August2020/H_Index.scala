package com.concept.scala.leetcode_30days_challenge_August2020

/** *
  *
  * Day 11
  *
  * @todo Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.
  *       According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."
  * @example Example:
  *          Input: citations = [3,0,6,1,5]
  *          Output: 3
  *          Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had
  *          received 3, 0, 6, 1, 5 citations respectively.
  *          Since the researcher has 3 papers with at least 3 citations each and the remaining
  *          two with no more than 3 citations each, her h-index is 3.
  * @note If there are several possible values for h, the maximum one is taken as the h-index.
  * @see https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/550/week-2-august-8th-august-14th/3420/
  *      OR
  *      https://leetcode.com/problems/h-index/
  *
  *
  */
object H_Index {
  def main(args: Array[String]): Unit = {
    println(hIndex(Array(3, 0, 6, 1, 5)))
  }

  /** *
    * 82 / 82 test cases passed.
    * Status: Accepted
    * Runtime: 468 ms
    * Memory Usage: 50.6 MB
    *
    */
  def hIndex(citations: Array[Int]): Int = {
    val sortedCitations = citations.sorted
    val length = sortedCitations.length
    var start = 0
    var end = length - 1

    while (start <= end) {
      val mid = (start + end) / 2
      if (sortedCitations(mid) >= length - mid) end = mid - 1 else start = mid + 1
    }
    length - end - 1
  }
}

