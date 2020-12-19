package com.concept.scala.leetcode_30days_challenge_December2020

/** *
  *
  * Day  16
  *
  * @todo Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
  * @example Example 1:
  *
  *          Input: nums = [-4,-1,0,3,10]
  *          Output: [0,1,9,16,100]
  *          Explanation: After squaring, the array becomes [16,1,0,9,100].
  *          After sorting, it becomes [0,1,9,16,100].
  *          Example 2:
  *
  *          Input: nums = [-7,-3,2,3,11]
  *          Output: [4,9,9,49,121]
  * @note 1 <= nums.length <= 104
  *       -104 <= nums[i] <= 104
  *       nums is sorted in non-decreasing order.
  * @see https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/571/week-3-december-15th-december-21st/3567/
  *      OR
  *      https://leetcode.com/problems/squares-of-a-sorted-array/
  *
  *
  */
object SquaresOfASortedArray {
  def main(args: Array[String]): Unit = {
    sortedSquares(Array(-4, -1, 0, 3, 10)).foreach(println)
  }

  /** **
    *
    * Runtime: 608 ms, faster than 46.99% of Scala online submissions for Squares of a Sorted Array.
    * Memory Usage: 53.1 MB, less than 40.96% of Scala online submissions for Squares of a Sorted Array.
    *
    * 137 / 137 test cases passed.
    * Status: Accepted
    * Runtime: 608 ms
    * Memory Usage: 53.1 MB
    *
    */
  def sortedSquares(nums: Array[Int]): Array[Int] = nums.map(math.pow(_, 2).toInt).sorted

}
