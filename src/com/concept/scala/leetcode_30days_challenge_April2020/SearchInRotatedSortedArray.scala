package com.concept.scala.leetcode_30days_challenge_April2020

/***
  * Day 19
  *
  * @see https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/530/week-3/3304/
  *      OR
  *      https://leetcode.com/problems/search-in-rotated-sorted-array
  *
  *      Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
  *
  *      (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
  *
  *      You are given a target value to search. If found in the array return its index, otherwise return -1.
  *
  *      You may assume no duplicate exists in the array.
  *
  *      Your algorithm's runtime complexity must be in the order of O(log n).
  *
  *      Example 1:
  *
  *      Input: nums = [4,5,6,7,0,1,2], target = 0
  *      Output: 4
  *      Example 2:
  *
  *      Input: nums = [4,5,6,7,0,1,2], target = 3
  *      Output: -1
  *
  *      196 / 196 test cases passed.
  *      Status: Accepted
  *      Runtime: 484 ms
  *      Memory Usage: 50.7 MB
  *
  *
  *      Runtime: 500 ms, faster than 21.43% of Scala online submissions for Search in Rotated Sorted Array.
  *      Memory Usage: 50.4 MB, less than 50.00% of Scala online submissions for Search in Rotated Sorted Array.
  *
  *
  *
  *
  */
object SearchInRotatedSortedArrayinverted {

  def main(args: Array[String]): Unit = {
val arr =Array(4,5,6,7,0,1,2)
    println(search(arr,0))

  }

  def search(nums: Array[Int], target: Int): Int = {
    var start = 0
    var end = nums.length - 1
    while ( {
      start <= end
    }) {
      val mid = start + (end - start) / 2
      if (nums(mid) == target) return mid
      else if (nums(start) <= target && nums(mid) > target) end = mid - 1
      else if (nums(start) > nums(mid) && (nums(start) <= target || nums(mid) > target)) end = mid - 1
      else start = mid + 1
    }
    -1
  }
}
