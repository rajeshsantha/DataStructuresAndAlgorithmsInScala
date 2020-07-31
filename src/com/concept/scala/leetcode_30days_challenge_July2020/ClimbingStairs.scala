package com.concept.scala.leetcode_30days_challenge_July2020

import com.concept.scala.RunTimeCalculation

/** *
  * Day 31
  *
  * @todo You are climbing a stair case. It takes n steps to reach to the top.
  *       Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
  * @example Example 1:
  *
  *          Input: 2
  *          Output: 2
  *          Explanation: There are two ways to climb to the top.
  * 1. 1 step + 1 step
  * 2. 2 steps
  *          Example 2:
  *
  *          Input: 3
  *          Output: 3
  *          Explanation: There are three ways to climb to the top.
  * 1. 1 step + 1 step + 1 step
  * 2. 1 step + 2 steps
  * 3. 2 steps + 1 step
  * @note 1 <= n <= 45
  * @see https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/548/week-5-july-29th-july-31st/3407/
  *      OR
  *      https://leetcode.com/problems/climbing-stairs/
  *
  *
  */
object ClimbingStairs {
  def main(args: Array[String]): Unit = {
    val runtime = RunTimeCalculation.calculateRunTime(println(climbStairs(45)))
    val runtime2 = RunTimeCalculation.calculateRunTime(println(climbStairsHashMap(45)))
    val runtime3 = RunTimeCalculation.calculateRunTime(println(climbingStairsDP(45)))
    val runtime4 = RunTimeCalculation.calculateRunTime(println(climbingStairsDP2(45)))
    println(s" climbStairs total run time = $runtime seconds OR ${runtime * 1000} milliseonds")
    println(s" climbStairsHashMap total run time = $runtime2 seconds OR ${runtime2 * 1000} milliseonds")
    println(s" climbingStairsDP total run time = $runtime3 seconds OR ${runtime3 * 1000} milliseonds")
    println(s" climbingStairsDP2 total run time = $runtime4 seconds OR ${runtime4 * 1000} milliseonds")
    /*
    1836311903
    1836311903
    1836311903
    1836311903
     climbStairs total run time = 8.529 seconds OR 8529.0 milliseonds
     climbStairsHashMap total run time = 7.363 seconds OR 7363.0 milliseonds
     climbingStairsDP total run time = 0.004 seconds OR 4.0 milliseonds
     climbingStairsDP2 total run time = 0.001 seconds OR 1.0 milliseonds
     */
  }

  def climbStairs(n: Int): Int = if (n <= 1) 1 else climbStairs(n - 1) + climbStairs(n - 2)

  def climbStairsHashMap(n: Int): Int = {
    val map = scala.collection.mutable.HashMap[Int, Int]()
    if (n < 2) return 1
    if (map contains n) return map(n)
    map.put(n, climbStairs(n - 1) + climbStairs(n - 2))
    map(n)

  }

  /** *
    * Runtime: 376 ms, faster than 97.44% of Scala online submissions for Climbing Stairs.
    * Memory Usage: 48.3 MB, less than 100.00% of Scala online submissions for Climbing Stairs.
    *
    * 45 / 45 test cases passed.
    * Status: Accepted
    * Runtime: 376 ms
    * Memory Usage: 48.3 MB
    *
    */
  def climbingStairsDP(n: Int): Int = {
    if (n < 2) return 1
    val dp = new Array[Int](n + 1)
    dp(0) = 1
    dp(1) = 1
    for (i <- 2 to n) dp(i) = dp(i - 1) + dp(i - 2)
    dp(n)
  }

  def climbingStairsDP2(n: Int): Int = {
    if (n < 2) return 1
    val dp = new Array[Int](n + 1)
    dp(0) = 1
    dp(1) = 1
    var i = 2
    while (i <= n) {
      dp(i) = dp(i - 1) + dp(i - 2)
      i += 1
    }
    dp(n)
  }
}