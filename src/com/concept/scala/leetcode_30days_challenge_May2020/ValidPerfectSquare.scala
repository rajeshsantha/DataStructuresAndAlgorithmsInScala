package com.concept.scala.leetcode_30days_challenge_May2020

import com.concept.scala.RunTimeCalculation

/** *
  * Day 9
  *
  * @see https://leetcode.com/explore/featured/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3324/
  *      OR
  *      https://leetcode.com/problems/valid-perfect-square/
  *
  *      Given a positive integer num, write a function which returns True if num is a perfect square else False.
  *
  *      Note: Do not use any built-in library function such as sqrt.
  *
  *      Example 1:
  *
  *      Input: 16
  *      Output: true
  *      Example 2:
  *
  *      Input: 14
  *      Output: false
  *
  *
  *
  *
  *
  *
  *
  */
object ValidPerfectSquare {
  def main(args: Array[String]): Unit = {
    /*
        val runtime1 = RunTimeCalculation.calculateRunTime(println(isPerfectSquare(2147483647)))
        println(s"runtime of isPerfectSquare is $runtime1 seconds OR ${(runtime1 * 1000).toInt} milliseconds")
    */

    val number = 808201
    println(s"sqrt of $number is ${math.sqrt(number)}") // library check

    val runtime2 = RunTimeCalculation.calculateRunTime(println(isPerfectSquare_binarySearch(number)))
    println(s"runtime of isPerfectSquare is $runtime2 seconds OR ${(runtime2 * 1000).toInt} milliseconds")


  }

  /** **
    *
    * Valid but not-optimized solution
    * Status - TLE
    *
    * */
  def isPerfectSquare(num: Int): Boolean = {
    var i = 0
    var flag = false
    while (i * i <= num) {

      if (i * i == num) {
        flag = true
        return true
      }
      i += 1
    }
    flag
  }

  /**
    *
    * 68 / 68 test cases passed.
    * Status: Accepted
    * Runtime: 372 ms
    * Memory Usage: 48.4 MB
    *
    * Runtime: 384 ms, faster than 91.67% of Scala online submissions for Valid Perfect Square.
    * Memory Usage: 48.7 MB, less than 100.00% of Scala online submissions for Valid Perfect Square.
    *
    */

  def isPerfectSquare_binarySearch(num: Int): Boolean = {

    val lastDigit = num % 10
    if (num == 1) return true
    if (lastDigit == 2 || lastDigit == 3 || lastDigit == 7 || lastDigit == 8) return false

    var start: Long = 1
    var end: Long = num

    var mid = start + (end - start) / 2

    while (start <= end) {
      mid = start + (end - start) / 2

      val sqr: Long = mid * mid

      if (sqr == num) return true
      if (sqr > num) {
        end = mid - 1
      } else {
        start = mid + 1
      }
    }
    false
  }

}
