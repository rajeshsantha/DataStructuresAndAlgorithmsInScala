package com.concept.scala.leetcode_30days_challenge_June2020

import com.concept.scala.RunTimeCalculation

import scala.annotation.tailrec

/** ***
  * Day 10
  *
  * @see https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3356/
  *      OR
  *      https://leetcode.com/problems/search-insert-position
  *
  *      Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
  *
  *      You may assume no duplicates in the array.
  *
  *      Example 1:
  *
  *      Input: [1,3,5,6], 5
  *      Output: 2
  *      Example 2:
  *
  *      Input: [1,3,5,6], 2
  *      Output: 1
  *      Example 3:
  *
  *      Input: [1,3,5,6], 7
  *      Output: 4
  *      Example 4:
  *
  *      Input: [1,3,5,6], 0
  *      Output: 0
  *
  *
  *
  *
  *
  */
object SearchInsertPosition {
  def main(args: Array[String]): Unit = {
    val arr = (1 to 10000).map(_ => scala.util.Random.nextInt(50000)).sorted.distinct.toArray


    val runtime1 = RunTimeCalculation.calculateRunTime {
      println(searchInsert(arr, 1030))
      println(searchInsert(arr, 33))
      println(searchInsert(arr, 39400))
    }
    println(s" searchInsert total run time = $runtime1 seconds OR ${runtime1 * 1000} milliseonds")

    val runtime2 = RunTimeCalculation.calculateRunTime {
      println(searchInsert_BinarySearch(arr, 1030))
      println(searchInsert_BinarySearch(arr, 33))
      println(searchInsert_BinarySearch(arr, 39400))
    }
    println(s" searchInsert_BinarySearch total run time = $runtime2 seconds OR ${runtime2 * 1000} milliseonds")
    val runtime3 = RunTimeCalculation.calculateRunTime {
      println(searchInsert_BinarySearch_tailrec(arr, 1030))
      println(searchInsert_BinarySearch_tailrec(arr, 33))
      println(searchInsert_BinarySearch_tailrec(arr, 39400))
    }
    println(s" searchInsert_BinarySearch_tailrec total run time = $runtime3 seconds OR ${runtime3 * 1000} milliseonds")


    /*

    176
    4
    7078
     searchInsert total run time = 0.129 seconds OR 129.0 milliseonds

    176
    4
    7078
     searchInsert_BinarySearch total run time = 0.013 seconds OR 13.0 milliseonds

    176
    4
    7078
     searchInsert_BinarySearch_rec total run time = 0.001 seconds OR 1.0 milliseonds

     */

  }

  /** **
    *
    * O(n)
    *
    * 62 / 62 test cases passed.
    * Status: Accepted
    * Runtime: 616 ms
    * Memory Usage: 51.2 MB
    *
    */
  def searchInsert(nums: Array[Int], target: Int): Int =
    if (nums contains target) nums indexOf target else nums.length - nums.dropWhile(target >= _).length


  /** ***
    *
    * O(log n)
    *
    * 62 / 62 test cases passed.
    * Status: Accepted
    * Runtime: 780 ms
    * Memory Usage: 67.3 MB
    *
    */
  def searchInsert_BinarySearch(nums: Array[Int], target: Int): Int = {

    var (low, high) = (0, nums.length - 1)
    while (low <= high) {
      val mid = (low + high) / 2
      if (target == nums(mid)) return mid
      else if (target > nums(mid)) low = mid + 1 else high = mid - 1
    }
    low
  }

  /** ***
    * Fastest possible solution for this problem but thanks to `tortoise leetcode scala compiler`, it got rubbish runtime as usual.
    *
    *
    */
  def searchInsert_BinarySearch_tailrec(nums: Array[Int], target: Int): Int = {

    @tailrec
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
