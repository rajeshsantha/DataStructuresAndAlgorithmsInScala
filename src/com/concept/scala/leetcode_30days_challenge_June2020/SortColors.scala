package com.concept.scala.leetcode_30days_challenge_June2020

/** **
  * Day 11
  *
  * @see https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3357/
  *      OR
  *      https://leetcode.com/problems/sort-colors/
  *
  *      Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
  *
  *      Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
  *
  *      Note: You are not suppose to use the library's sort function for this problem.
  *
  *      Example:
  *
  *      Input: [2,0,2,1,1,0]
  *      Output: [0,0,1,1,2,2]
  *      Follow up:
  *
  *      A rather straight forward solution is a two-pass algorithm using counting sort.
  *      First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
  *      Could you come up with a one-pass algorithm using only constant space?
  *
  *      Accepted
  *      458,732
  *      Submissions
  *      1,003,230
  *
  *
  */
object SortColors {
  val arr = Array(2, 0, 2, 1, 1, 0)

  def main(args: Array[String]): Unit = {
    println(arr.mkString("  "))
    sortColors(arr)
    println(arr.mkString("  "))
  }

  /** *
    *
    * 87 / 87 test cases passed.
    * Status: Accepted
    * Runtime: 504 ms
    * Memory Usage: 50.8 MB
    *
    *
    */
  def sortColors(nums: Array[Int]): Unit = {
    val len = nums.length
    for (i <- 1 until len; j <- 0 until (len - i) if nums(j) > nums(j + 1)) {

      (nums(j), nums(j + 1)) match {
        case (a, b) if a > b =>
          nums(j) = b
          nums(j + 1) = a
      }
    }

  }

}

