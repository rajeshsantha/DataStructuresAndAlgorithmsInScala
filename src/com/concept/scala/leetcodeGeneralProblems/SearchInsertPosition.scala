package com.concept.scala.leetcodeGeneralProblems

/** *
  *
  * @todo Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
  *       You may assume no duplicates in the array.
  * @example Example 1:
  *
  *          Input: [1,3,5,6], 5
  *          Output: 2
  *          Example 2:
  *
  *          Input: [1,3,5,6], 2
  *          Output: 1
  *          Example 3:
  *
  *          Input: [1,3,5,6], 7
  *          Output: 4
  *          Example 4:
  *
  *          Input: [1,3,5,6], 0
  *          Output: 0
  */
object SearchInsertPosition {
  def searchInsert(nums: Array[Int], target: Int): Int = {
    def helper(start: Int, end: Int): Int = {

      if (start > end) return start
      val mid = start + (end - start) / 2

      nums(mid) match {
        case i if i == target => return mid
        case i if target > i => helper(mid + 1, end)
        case _ => helper(start, mid - 1)
      }
    }

    helper(0, nums.length - 1)
  }

}
