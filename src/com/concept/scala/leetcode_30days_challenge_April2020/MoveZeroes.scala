package com.concept.scala.leetcode_30days_challenge_April2020

/** *
  *
  * @see https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3286/
  *      Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
  *
  *      Example:
  *
  *      Input: [0,1,0,3,12]
  *      Output: [1,3,12,0,0]
  *      Note:
  *
  *      You must do this in-place without making a copy of the array.
  *      Minimize the total number of operations.
  *
  *      21 / 21 test cases passed.
  *      Status: Accepted
  *      Runtime: 536 ms
  *      Memory Usage: 51.3 MB
  */
object MoveZeroes {
  def main (args: Array[String]): Unit = {
    val arr = Array(0, 1, 0, 0, 0, 0, 3, 12)
    moveZeroes(arr)
  }

  def moveZeroes (nums: Array[Int]): Unit = {
    val len = nums.length - 1
    var temp = 0

    val numberOfzeros = nums.count(_ == 0)
    var itr = 0
    while (itr < numberOfzeros) {
      for (i <- nums.indices) {
        if (nums(i) == 0 && i != len && nums(i + 1) != 0) {

          println(s"elements ${nums(i)} and ${nums(i + 1)} are swapping")
          temp = nums(i + 1)
          nums(i + 1) = nums(i)
          nums(i) = temp
        }


      }

      println(nums.mkString(" "))
      itr += 1
    }
    println("Final array result is " + nums.mkString(" "))

  }

  def moveZerosFunctional (nums: Array[Int]): Unit = {



  }
}
