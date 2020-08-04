package com.concept.scala.leetcode_30days_challenge_August2020

/** **
  *
  * Day 4
  *
  * @todo Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
  * @example Example 1:
  *
  *          Input: 16
  *          Output: true
  *          Example 2:
  *
  *          Input: 5
  *          Output: false
  * @see https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/549/week-1-august-1st-august-7th/3412/
  *      OR
  *      https://leetcode.com/problems/power-of-four/
  *
  *
  *
  */
object PowerOfFour {
  /**
    * 1060 / 1060 test cases passed.
    * Status: Accepted
    * Runtime: 648 ms
    * Memory Usage: 59.3 MB
    *
    */
  def isPowerOfFourByMath(num: Int): Boolean = num > 0 && (math.log(num) / math.log(4) % 1) == 0

  def isPowerOfFourByLoop(num: Int): Boolean = {
    var n = num
    while (n > 1) {
      if (n % 4 != 0) return false
      n /= 4
    }
    n == 1
  }
}
