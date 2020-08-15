package com.concept.scala.leetcode_30days_challenge_August2020

/** **
  *
  * Day 15
  *
  * @todo Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
  * @example Example 1:
  *
  *          Input: [[1,2],[2,3],[3,4],[1,3]]
  *          Output: 1
  *          Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
  *          Example 2:
  *
  *          Input: [[1,2],[1,2],[1,2]]
  *          Output: 2
  *          Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
  *          Example 3:
  *
  *          Input: [[1,2],[2,3]]
  *          Output: 0
  *          Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
  * @note You may assume the interval's end point is always bigger than its start point.
  *       Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.
  * @see https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/551/week-3-august-15th-august-21st/3425/
  *      OR
  *      https://leetcode.com/problems/non-overlapping-intervals/
  *
  *
  */
object NonOverlappingIntervals {

  def main(args: Array[String]): Unit = {

    println(eraseOverlapIntervals(Array(Array(1, 2), Array(2, 3), Array(3, 4), Array(1, 3))))
    println(eraseOverlapIntervals(Array(Array(1, 2), Array(1, 2), Array(1, 2))))
  }

  /** *
    *
    * 18 / 18 test cases passed.
    * Status: Accepted
    * Runtime: 676 ms
    * Memory Usage: 55.3 MB
    *
    */
  def eraseOverlapIntervals(intervals: Array[Array[Int]]): Int = {
    var count = 0
    if (intervals.length == 0) return count

    val sortedIntervals = intervals.sortBy(_.head)
    count = 0
    var end = sortedIntervals.head.last
    for (i <- 1 until sortedIntervals.length) {
      if (end > sortedIntervals(i).head) {
        end = math.min(end, sortedIntervals(i).last)
        count += 1
      }
      else end = sortedIntervals(i).last
    }
    count
  }
}
