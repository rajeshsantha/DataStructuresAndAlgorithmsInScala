package com.concept.scala.leetcode_30days_challenge_October2020

/** *
  * day 3
  *
  * @todo Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array.
  *
  *       A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:
  *
  *       0 <= i, j < nums.length
  *       i != j
  *       a <= b
  *       b - a == k
  * @example Example 1:
  *
  *          Input: nums = [3,1,4,1,5], k = 2
  *          Output: 2
  *          Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
  *          Although we have two 1s in the input, we should only return the number of unique pairs.
  *          Example 2:
  *
  *          Input: nums = [1,2,3,4,5], k = 1
  *          Output: 4
  *          Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
  *          Example 3:
  *
  *          Input: nums = [1,3,1,5,4], k = 0
  *          Output: 1
  *          Explanation: There is one 0-diff pair in the array, (1, 1).
  *          Example 4:
  *
  *          Input: nums = [1,2,4,4,3,3,0,9,2,3], k = 3
  *          Output: 2
  *          Example 5:
  *
  *          Input: nums = [-1,-2,-3], k = 1
  *          Output: 2
  * @note 1 <= nums.length <= 104
  *       -107 <= nums[i] <= 107
  *       0 <= k <= 107
  * @see https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/559/week-1-october-1st-october-7th/3482/
  *      OR
  *      https://leetcode.com/problems/k-diff-pairs-in-an-array
  *
  *
  */
object K_DiffPairsInAnArray {

  /** *
    * 51 / 59 test cases passed.
    * Status: Time Limit Exceeded
    * Submitted: 0 minutes ago
    *
    */
  def findPairs(nums: Array[Int], k: Int): Int = nums.combinations(2).count(array => math.abs(array.head - array.last) == k)

  /** *
    * 59 / 59 test cases passed.
    * Status: Accepted
    * Runtime: 544 ms
    * Memory Usage: 52.6 MB
    *
    */
  def findPairs2(nums: Array[Int], k: Int): Int = {
    if (k < 0) 0
    else if (k == 0) nums.groupBy(identity).count(_._2.length > 1)
    else {
      val s = nums.toSet
      s.count(n => s.contains(n + k))
    }
  }

}
