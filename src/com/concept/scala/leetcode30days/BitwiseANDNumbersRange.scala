package com.concept.scala.leetcode30days

/** **
  * Day 23
  * #######easiest of all########
  *
  * @see https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/531/week-4/3308/
  *      OR
  *      https://leetcode.com/problems/bitwise-and-of-numbers-range/
  *
  *      Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
  *
  *      Example 1:
  *
  *      Input: [5,7]
  *      Output: 4
  *      Example 2:
  *
  *      Input: [0,1]
  *      Output: 0
  *
  *      8266 / 8266 test cases passed.
  *      Status: Accepted
  *      Runtime: 5436 ms
  *      Memory Usage: 49.3 MB
  *
  *      Runtime: 5464 ms, faster than 100.00% of Scala online submissions for Bitwise AND of Numbers Range.
  *      Memory Usage: 49.1 MB, less than 100.00% of Scala online submissions for Bitwise AND of Numbers Range.
  *
  */
object BitwiseANDNumbersRange {

  def main (args: Array[String]): Unit = {
    println(rangeBitwiseAnd(2147483647, 2147483647))
  }

  def rangeBitwiseAnd (m: Int, n: Int): Int = {

    (m to n).foldLeft(if (m == n) m else m + 1)((a, b) => {
      val res = a & b
      if (res == 0) return 0
      res
    })
  }


}
