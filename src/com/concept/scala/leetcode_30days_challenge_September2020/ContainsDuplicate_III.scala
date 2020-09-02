package com.concept.scala.leetcode_30days_challenge_September2020


/** *
  *
  * Day 2
  *
  * @todo Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.
  * @example Example 1:
  *
  *          Input: nums = [1,2,3,1], k = 3, t = 0
  *          Output: true
  *          Example 2:
  *
  *          Input: nums = [1,0,1,1], k = 1, t = 2
  *          Output: true
  *          Example 3:
  *
  *          Input: nums = [1,5,9,1,5,9], k = 2, t = 3
  *          Output: false
  * @see https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/554/week-1-september-1st-september-7th/3446/
  *      OR
  *      https://leetcode.com/problems/contains-duplicate-iii
  * @note Time complexity O(n logk) - This will give an indication that sorting is involved for k elements.
  *       Use already existing state to evaluate next state - Like, a set of k sorted numbers are only needed to be tracked. When we are processing the next number in array, then we can utilize the existing sorted state and it is not necessary to sort next overlapping set of k numbers again.
  */
object ContainsDuplicate_III {
  // unit test in test/scala/leetcode_30days_challenge_September2020/ContainsDuplicate_III_Test
  /** **
    *
    * 41 / 41 test cases passed.
    * Status: Accepted
    * Runtime: 572 ms
    * Memory Usage: 51.5 MB
    *
    */
  def containsNearbyAlmostDuplicate(nums: Array[Int], k: Int, t: Int): Boolean = {
    if (nums == null || (nums.length == 0)) return false
    val set = new java.util.TreeSet[Long]()
    set.add(nums(0).asInstanceOf[Long])
    for (i <- 1 until nums.length) {
      if (i > k) set.remove(nums(i - k - 1).asInstanceOf[Long])
      val left = nums(i).toLong - t
      val right = nums(i).toLong + t
      if (left <= right && !set.subSet(left, right + 1).isEmpty) return true
      set.add(nums(i).asInstanceOf[Long])
    }
    false
  }


}
