package com.concept.scala.leetcode_30days_challenge_April2020

/** *
  * Day 25
  *
  * @see https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/531/week-4/3310/
  *      OR
  *      https://leetcode.com/problems/jump-game/
  *
  *      Given an array of non-negative integers, you are initially positioned at the first index of the array.
  *
  *      Each element in the array represents your maximum jump length at that position.
  *
  *      Determine if you are able to reach the last index.
  *
  *      Example 1:
  *
  *      Input: [2,3,1,1,4]
  *      Output: true
  *      Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
  *      Example 2:
  *
  *      Input: [3,2,1,0,4]
  *      Output: false
  *      Explanation: You will always arrive at index 3 no matter what. Its maximum
  *      jump length is 0, which makes it impossible to reach the last index.
  *
  */
object JumpGame {
  def main (args: Array[String]): Unit = {

    val arr = Array(2, 3, 1, 1, 4)
    val arr2 = Array(3, 2, 1, 0, 4)

    println(canJump(arr2))
  }

  /** *
    *
    *
    * 75 / 75 test cases passed.
    * Status: Accepted
    * Runtime: 516 ms
    * Memory Usage: 52.4 MB
    *
    * Runtime: 568 ms, faster than 57.50% of Scala online submissions for Jump Game.
    * Memory Usage: 52.4 MB, less than 100.00% of Scala online submissions for Jump Game.
    *
    */
  def canJump (nums: Array[Int]): Boolean = {

    var lastSafeIndex = nums.length - 1
    val numIndexArray = nums.zipWithIndex
    for (i <- numIndexArray.indices.reverse) {
      if (numIndexArray(i)._2 + numIndexArray(i)._1 >= lastSafeIndex) lastSafeIndex = numIndexArray(i)._2

    }

    lastSafeIndex == 0
  }


}
