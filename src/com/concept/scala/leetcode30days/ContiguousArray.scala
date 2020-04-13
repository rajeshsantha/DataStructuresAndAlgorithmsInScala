package com.concept.scala.leetcode30days

import scala.collection.mutable


/** *
  * Day 13
  *
  * @see https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3298/
  *
  *
  *      Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
  *
  *      Example 1:
  *      Input: [0,1]
  *      Output: 2
  *      Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
  *      Example 2:
  *      Input: [0,1,0]
  *      Output: 2
  *      Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
  *
  *
  *      555 / 555 test cases passed.
  *      Status: Accepted
  *      Runtime: 772 ms
  *      Memory Usage: 58.4 MB
  *
  *
  *      Runtime: 776 ms, faster than 66.67% of Scala online submissions for Contiguous Array.
  *      Memory Usage: 58.4 MB, less than 100.00% of Scala online submissions for Contiguous Array.
  *
  *
  *
  */

object ContiguousArray {
  def main(args: Array[String]): Unit = {

    val arr = Array(0, 0, 1, 0, 0, 0, 1, 1)
    println(findMaxLength(arr))
  }

  def findMaxLength(nums: Array[Int]): Int = {
    var maxlength = 0
    var count = 0
    val count_tracker: mutable.HashMap[Int, Int] = mutable.HashMap()

    // count_tracker stores (currentSum,index )

    count_tracker.put(0, -1) // intializing ( currentSum= 0,index=-1) index= -1 as loop will start from 0.

    for (i <- nums.indices) {
      count += (if (nums(i) == 0) -1 else 1)

      if (count_tracker.contains(count)) {
        maxlength = math.max(maxlength, i - count_tracker(count))
      } else {
        count_tracker.put(count, i)
      }

    }
    maxlength
  }

}
