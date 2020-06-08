package com.concept.scala.leetcode_30days_challenge_June2020

/** ****
  * Day 8
  *
  * @see https://leetcode.com/problems/power-of-two/
  *      OR
  *      https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3354/
  *
  *
  *
  *      Given an integer, write a function to determine if it is a power of two.
  *
  *      Example 1:
  *
  *      Input: 1
  *      Output: true
  *      Explanation: 20 = 1
  *      Example 2:
  *
  *      Input: 16
  *      Output: true
  *      Explanation: 24 = 16
  *      Example 3:
  *
  *      Input: 218
  *      Output: false
  *
  *
  *
  *
  *
  *
  */
object PowerofTwo {

  def main(args: Array[String]): Unit = {
    println(isPowerOfTwo(124))
    println(isPowerOfTwo(128))
    println(isPowerOfTwo(134))
    println(isPowerOfTwo(-2147483648))

  }

  /**
    * 1108 / 1108 test cases passed.
    * Status: Accepted
    * Runtime: 572 ms
    * Memory Usage: 58.9 MB
    *
    * Runtime: 572 ms, faster than 9.09% of Scala online submissions for Power of Two.
    * Memory Usage: 58.9 MB, less than 10.00% of Scala online submissions for Power of Two.
    *
    */
  def isPowerOfTwo(n: Int): Boolean = if (n == -2147483648) return false else n.toBinaryString.count(_ == '1') == 1

  /**
    *
    * 1108 / 1108 test cases passed.
    * Status: Accepted
    * Runtime: 428 ms
    * Memory Usage: 48.8 MB
    *
    * Runtime: 428 ms, faster than 54.55% of Scala online submissions for Power of Two.
    * Memory Usage: 48.8 MB, less than 50.00% of Scala online submissions for Power of Two.
    *
    */
  def isPowerOfTwo_ByMath(n: Int): Boolean = {
    import scala.math._
    val exponent: Double = log10(n) / log10(2.0)
    exponent - round(exponent) == 0
  }
}


