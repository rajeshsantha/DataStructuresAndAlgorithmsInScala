package com.concept.scala.leetcode_30days_challenge_November2020

/** **
  * Day 12
  *
  * @todo Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
  * @example Example 1:
  *
  *          Input: nums = [1,1,2]
  *          Output:
  *          [ [1,1,2],
  *          [1,2,1],
  *          [2,1,1] ]
  *          Example 2:
  *
  *          Input: nums = [1,2,3]
  *          Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
  * @note 1 <= nums.length <= 8
  *       -10 <= nums[i] <= 10
  *
  *
  */
object Permutations_II {

  /** *
    * 33 / 33 test cases passed.
    * Status: Accepted
    * Runtime: 528 ms
    * Memory Usage: 53.9 MB
    *
    * @param nums
    * @return
    */
  def permuteUnique(nums: Array[Int]): List[List[Int]] = nums.permutations.map(_.toList).toList


  def main(args: Array[String]): Unit = {
    permuteUnique(Array(1, 2, 3)).foreach(_.mkString("[", ",", "]"))
  }
}
