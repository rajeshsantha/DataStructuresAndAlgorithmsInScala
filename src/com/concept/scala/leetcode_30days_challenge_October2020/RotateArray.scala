package com.concept.scala.leetcode_30days_challenge_October2020


/** *
 *
 * Day 15
 *
 * @todo Given an array, rotate the array to the right by k steps, where k is non-negative.
 * @example Example 1:
 *
 *          Input: nums = [1,2,3,4,5,6,7], k = 3
 *          Output: [5,6,7,1,2,3,4]
 *          Explanation:
 *          rotate 1 steps to the right: [7,1,2,3,4,5,6]
 *          rotate 2 steps to the right: [6,7,1,2,3,4,5]
 *          rotate 3 steps to the right: [5,6,7,1,2,3,4]
 *          Example 2:
 *
 *          Input: nums = [-1,-100,3,99], k = 2
 *          Output: [3,99,-1,-100]
 *          Explanation:
 *          rotate 1 steps to the right: [99,-1,-100,3]
 *          rotate 2 steps to the right: [3,99,-1,-100]
 * @note Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 *       Could you do it in-place with O(1) extra space?
 *       1 <= nums.length <= 2 * 104
 *       -231 <= nums[i] <= 231 - 1
 *       0 <= k <= 105
 * @see https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/561/week-3-october-15th-october-21st/3496/
 *      OR
 *      https://leetcode.com/problems/rotate-array/
 *
 *
 *
 */
object RotateArray {
  def main(args: Array[String]): Unit = {
    val nums = Array(1, 2, 3, 4, 5, 6, 7)
    val k = 3
    println("Before rotation : " + nums.mkString(","))
    rotate(nums, k)
    println("After rotation :  " + nums.mkString(","))
  }

  /** *
   *
   * 35 / 35 test cases passed.
   * Status: Accepted
   * Runtime: 508 ms
   * Memory Usage: 51.9 MB
   */
  def rotate(nums: Array[Int], k: Int): Unit = {
    val kmod = k % nums.length
    (nums.takeRight(kmod) ++ nums.take(nums.length - kmod)).zipWithIndex.foreach(e => nums(e._2) = e._1)
  }

  def rotate2(nums: Array[Int], k: Int): Unit = {
    var n = k % nums.length

    while (n > 0) {
      var prev = nums(0)
      var i = 1
      while (i < nums.length) {
        val temp = nums(i)
        nums(i) = prev
        prev = temp
        i += 1
      }
      nums(0) = prev
      n -= 1
    }
  }
}
