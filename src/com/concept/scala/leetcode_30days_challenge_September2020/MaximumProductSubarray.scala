package com.concept.scala.leetcode_30days_challenge_September2020

/** ***
  *
  * Day 9
  *
  * @todo Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
  * @example Example 1:
  *
  *          Input: [2,3,-2,4]
  *          Output: 6
  *          Explanation: [2,3] has the largest product 6.
  *          Example 2:
  *
  *          Input: [-2,0,-1]
  *          Output: 0
  *          Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
  * @see https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/555/week-2-september-8th-september-14th/3456/
  *      OR
  *      https://leetcode.com/problems/maximum-product-subarray
  *
  */
object MaximumProductSubarray {
  def main(args: Array[String]): Unit = {
    println(maxProduct(Array(2, 3, -2, 4)))
  }

  /** *
    * 187 / 187 test cases passed.
    * Status: Accepted
    * Runtime: 488 ms
    * Memory Usage: 51.3 MB
    *
    * @param nums
    * @return
    */
  def maxProduct(nums: Array[Int]): Int = {
    var globalMax = Integer.MIN_VALUE
    var max = 1
    var min = 1

    for (num <- nums) {
      val local_min = Math.min(min * num, max * num)
      val local_max = Math.max(min * num, max * num)
      min = Math.min(num, local_min)
      max = Math.max(num, local_max)
      globalMax = Math.max(globalMax, max)
    }
    globalMax
  }
}
