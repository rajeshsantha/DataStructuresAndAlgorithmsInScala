package com.concept.scala.leetcode_30days_challenge_July2020

/** *
  *
  * Day 25
  *
  * @todo Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
  *       (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
  *       Find the minimum element.
  *       The array may contain duplicates.
  * @example Example 1:
  *
  *          Input: [1,3,5]
  *          Output: 1
  *          Example 2:
  *
  *          Input: [2,2,2,0,1]
  *          Output: 0
  * @note This is a follow up problem to Find Minimum in Rotated Sorted Array.
  *       Would allow duplicates affect the run-time complexity? How and why?
  *
  *
  */
object FindMinimumInRotatedSortedArrayII {
  def main(args: Array[String]): Unit = {
    println(findMinBinarySearch(Array(2, 2, 2, 0, 1)))
  }

  /** *
    * 192 / 192 test cases passed.
    * Status: Accepted
    * Runtime: 1084 ms
    * Memory Usage: 67 MB
    *
    */
  def findMin(nums: Array[Int]): Int = nums.min

  /** *
    *
    * 192 / 192 test cases passed.
    * Status: Accepted
    * Runtime: 524 ms
    * Memory Usage: 51.1 MB
    *
    */
  def findMinBinarySearch(nums: Array[Int]): Int = {
    var low: Int = 0
    var high: Int = nums.length - 1
    while (low < high) {
      val mid = low + (high - low) / 2
      if (nums(mid) < nums(high)) high = mid else if (nums(mid) > nums(high)) low = mid + 1 else high -= 1
    }
    nums(low)
  }


}
