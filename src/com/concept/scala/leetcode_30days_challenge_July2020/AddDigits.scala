package com.concept.scala.leetcode_30days_challenge_July2020

/** *
  *
  * Day 26
  *
  * @todo Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
  * @example Example:
  *
  *          Input: 38
  *          Output: 2
  *          Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2.
  *          Since 2 has only one digit, return it.
  * @note Could you do it without any loop/recursion in O(1) runtime?
  *
  *
  *
  */
object AddDigits {
  def main(args: Array[String]): Unit = {
    println("final result is " + addDigits(38))
    println("final result is " + addDigits(199))
    println(addDigitsByMath(199))
    println(addDigitsByMath(38))
  }

  private def add(s: String): Int = s.split("").map(_.toInt).sum

  /**
    * Runtime: 480 ms, faster than 66.67% of Scala online submissions for Add Digits.
    * Memory Usage: 50 MB, less than 100.00% of Scala online submissions for Add Digits.
    *
    * 1101 / 1101 test cases passed.
    * Status: Accepted
    * Runtime: 480 ms
    * Memory Usage: 50 MB
    *
    * O(number of digits in the number) ~ O(N)
    * N = number of digits in input number
    * Time O(N)
    */

  @scala.annotation.tailrec
  def addDigits(num: Int): Int = {
    val tempResult = add(num.toString).toString
    if (tempResult.length == 1) tempResult.toInt else addDigits(tempResult.toInt)
  }

  /** *
    * Runtime: 416 ms, faster than 83.33% of Scala online submissions for Add Digits.
    * Memory Usage: 48.8 MB, less than 100.00% of Scala online submissions for Add Digits.
    *
    * 1101 / 1101 test cases passed.
    * Status: Accepted
    * Runtime: 416 ms
    * Memory Usage: 48.8 MB
    *
    * Time O(1) Space O(1)
    *
    * @see https://en.wikipedia.org/wiki/Digital_root#Congruence_formula
    */

  def addDigitsByMath(num: Int): Int = if (num == 0) 0 else 1 + (num - 1) % 9

}
