package com.concept.scala.leetcode_30days_challenge_April2020

object MaximumSubarray {

  /**
    * Day 3
    * @see https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3285/
    *
    * 202 / 202 test cases passed.
    * Status: Accepted
    * Runtime: 488 ms
    * Memory Usage: 51.6 MB
    *
    * @param nums
    * @return maxSurArraySum
    */
  def maxSubArray (nums: Array[Int]): Int = {
    var max: Long = nums(0)
    var current: Long = nums(0)

    for (i <- 1 until nums.length) {
      current = Math.max(current + nums(i), nums(i))
      max = Math.max(current, max)
    }
    max.toInt
  }

  /*def maxSubArray_Funtional (nums: Array[Int]): Int = {

  }*/
    def main (args: Array[String]): Unit = {
    val arr = Array(-2, 1, -3, 4, -1, 2, 1, -5, 4)
    println(maxSubArray(arr))
  }
}
