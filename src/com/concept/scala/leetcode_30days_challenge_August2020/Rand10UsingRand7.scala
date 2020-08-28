package com.concept.scala.leetcode_30days_challenge_August2020

/** *
  *
  * Day 28
  *
  * @todo Given a function rand7 which generates a uniform random integer in the range 1 to 7, write a function rand10 which generates a uniform random integer in the range 1 to 10.
  *       Do NOT use system's Math.random().
  * @example Example 1:
  *
  *          Input: 1
  *          Output: [7]
  *          Example 2:
  *
  *          Input: 2
  *          Output: [8,4]
  *          Example 3:
  *
  *          Input: 3
  *          Output: [8,1,10]
  * @note Note:
  *
  *       rand7 is predefined.
  *       Each testcase has one argument: n, the number of times that rand10 is called
  * @see https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/552/week-4-august-22nd-august-28th/3439/
  *      OR
  *      https://leetcode.com/problems/implement-rand10-using-rand7/
  */
object Rand10UsingRand7 extends SolBase {
  /** *
    * 10 / 10 test cases passed.
    * Status: Accepted
    * Runtime: 468 ms
    * Memory Usage: 50.8 MB
    *
    * @return uniform random integer in the range 1 to 10
    */
  def rand10(): Int = {
    var x = 0
    for (_ <- 0 until 7) x += rand7
    x % 10 + 1
  }
}

class SolBase {
  def rand7: Int = scala.util.Random.nextInt(7 - 1) + 1
}