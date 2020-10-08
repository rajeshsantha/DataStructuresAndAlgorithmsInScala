package com.concept.scala.leetcode_30days_challenge_October2020

import com.concept.scala.RunTimeCalculation

/** **
  *
  * Day 8
  *
  * @todo Given a sorted (in ascending order) integer array nums of n elements and a target value, write a function to search target in nums. If target exists, then return its index, otherwise return -1.
  * @example Example 1:
  *
  *          Input: nums = [-1,0,3,5,9,12], target = 9
  *          Output: 4
  *          Explanation: 9 exists in nums and its index is 4
  *
  *          Example 2:
  *
  *          Input: nums = [-1,0,3,5,9,12], target = 2
  *          Output: -1
  *          Explanation: 2 does not exist in nums so return -1.
  * @note You may assume that all elements in nums are unique.
  *       n will be in the range [1, 10000].
  *       The value of each element in nums will be in the range [-9999, 9999].
  * @see https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/560/week-2-october-8th-october-14th/3488/
  *      OR
  *      https://leetcode.com/problems/binary-search/
  *
  */
object BinarySearch {

  def main (args: Array[String]): Unit = {

    val arr = Array(1, 2, 4, 6, 8, 9)
    val target = 4

    val iterativeRuntime = RunTimeCalculation.calculateRunTime {
      println(binarySearch_iterative(arr, target) match {
        case None => s"$target doesn't exist in ${arr.mkString("[", ",", "]")}"
        case Some(index) => s"$target exists at index $index"
      })
    }
    println(s" Iterative binaryseach total run time =  $iterativeRuntime seconds OR ${iterativeRuntime * 1000} milliseonds")

    val tailRecursiveuntime = RunTimeCalculation.calculateRunTime {
      println(binarySearch_tailRec(arr, target) match {
        case None => s"$target doesn't exist in ${arr.mkString("[", ",", "]")}"
        case Some(index) => s"$target exists at index $index"
      })
    }
    println(s" tailRecursive binaryseach total run time =  $tailRecursiveuntime seconds OR ${tailRecursiveuntime * 1000} milliseonds")


    /*
    9 exists at index 5
     Iterative binaryseach total run time =  0.13 seconds OR 130.0 milliseonds
    9 exists at index 5
     tailRecursive binaryseach total run time =  0.001 seconds OR 1.0 milliseonds
     */
  }

  def binarySearch_iterative (arr: Array[Int], target: Int): Option[Int] = {
    var (start, end) = (0, arr.length - 1)
    var mid = start + (end - start) / 2

    while (start <= end) {
      mid = start + (end - start) / 2
      if (arr(mid) == target)
        return Some(mid)
      if (arr(mid) > target) end = mid - 1
      else
        start = mid + 1

    }
    None
  }

  def binarySearch_tailRec (arr: Array[Int], target: Int): Option[Int] = {

    def helper (start: Int, end: Int): Option[Int] = {

      if (start > end) return None
      val mid = start + (end - start) / 2

      arr(mid) match {
        case i if i == target => return Some(mid)
        case i if target > i => helper(mid + 1, end)
        case _ => helper(start, mid - 1)
      }
    }

    helper(0, arr.length - 1)
  }

}
