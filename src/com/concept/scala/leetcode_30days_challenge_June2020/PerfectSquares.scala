package com.concept.scala.leetcode_30days_challenge_June2020


/** *
  * Day 27
  *
  * @todo Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
  * @example Example 1:
  *
  *          Input: n = 12
  *          Output: 3
  *          Explanation: 12 = 4 + 4 + 4.
  *          Example 2:
  *
  *          Input: n = 13
  *          Output: 2
  *          Explanation: 13 = 4 + 9.
  * @see https://leetcode.com/problems/perfect-squares/
  *      OR
  *      https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/542/week-4-june-22nd-june-28th/3373/
  *
  *
  */
object PerfectSquares {
  def numSquares(n: Int): Int = {
    /*
        val l = (2 to n).filter(x => math.sqrt(x).isWhole())
        if (l.isEmpty) return 0
        l.foreach(x => if (n % x == 0) return n / x)
    */
    val dp = Array.fill(n + 1)(Int.MaxValue)
    dp(0) = 0
    for (i <- 1 to n; j <- 1 to math.sqrt(i).toInt) dp(i) = dp(i) min dp(i - j * j) + 1
    dp(n)


    /*
        val dp = Array.fill(n + 1)(Int.MaxValue)
        dp(1) = 0
        dp(1) = 1
        for (i <- 1 to n) {
          for (j <- 1 to i if j * j <= i)
            dp(i) = Math.min(dp(i), dp(i - (j * j)) + 1)
        }
        dp(n)
    */
  }

  def main(args: Array[String]): Unit = {
    println(numSquares(12))
    println(numSquares(6922))

  }

}
