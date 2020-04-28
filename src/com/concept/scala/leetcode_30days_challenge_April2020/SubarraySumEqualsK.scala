package com.concept.scala.leetcode_30days_challenge_April2020

/** **
  * Day 22
  *
  * @see https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/531/week-4/3307/
  *      OR
  *      https://leetcode.com/problems/subarray-sum-equals-k/
  *      Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
  *
  *      Example 1:
  *      Input:nums = [1,1,1], k = 2
  *      Output: 2
  *      Note:
  *      The length of the array is in range [1, 20,000].
  *      The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
  *
  *
  *      80 / 80 test cases passed.
  *      Status: Accepted
  *      Runtime: 592 ms
  *      Memory Usage: 53.8 MB
  *
  *      Runtime: 568 ms, faster than 100.00% of Scala online submissions for Subarray Sum Equals K.
  *      Memory Usage: 53.8 MB, less than 100.00% of Scala online submissions for Subarray Sum Equals K.
  *
  */
object SubarraySumEqualsK {

  def main (args: Array[String]): Unit = {
    val arr = Array(1, 1, 1)
    val arr2 = Array(1, 2, 3)
    println(subarraySumScan(arr2, 3))
  }

  /** *
    *
    * 80 / 80 test cases passed.
    * Status: Accepted
    * Runtime: 592 ms
    * Memory Usage: 53.8 MB
    *
    * @param nums
    * @param k
    * @return
    */
  def subarraySumScan (nums: Array[Int], k: Int): Int = {
    val map = scala.collection.mutable.Map[Int, Int]().withDefaultValue(0)

    var countOfsums = 0
    nums.scanLeft(0)(_ + _).foreach { currentSum =>
      val difference = currentSum - k
      if (map.contains(difference)) countOfsums += map(difference)
      map(currentSum) += 1
    }
    countOfsums

  }


}

