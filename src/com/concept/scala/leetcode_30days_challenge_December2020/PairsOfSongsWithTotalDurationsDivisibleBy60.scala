package com.concept.scala.leetcode_30days_challenge_December2020

/** **
  * Day 8
  *
  * @todo You are given a list of songs where the ith song has a duration of time[i] seconds.
  *       Return the number of pairs of songs for which their total duration in seconds is divisible by 60. Formally, we want the number of indices i, j such that i < j with (time[i] + time[j]) % 60 == 0.
  * @example Example 1:
  *
  *          Input: time = [30,20,150,100,40]
  *          Output: 3
  *          Explanation: Three pairs have a total duration divisible by 60:
  *          (time[0] = 30, time[2] = 150): total duration 180
  *          (time[1] = 20, time[3] = 100): total duration 120
  *          (time[1] = 20, time[4] = 40): total duration 60
  *          Example 2:
  *
  *          Input: time = [60,60,60]
  *          Output: 3
  *          Explanation: All three pairs have a total duration of 120, which is divisible by 60.
  * @note 1 <= time.length <= 6 * 104
  *       1 <= time[i] <= 500
  * @see https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/570/week-2-december-8th-december-14th/3559/
  *      OR
  *      https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60
  *
  *
  */
object PairsOfSongsWithTotalDurationsDivisibleBy60 {

  /** *
    * 34 / 34 test cases passed.
    * Status: Accepted
    * Runtime: 580 ms
    * Memory Usage: 58.5 MB
    *
    */
  def numPairsDivisibleBy60(time: Array[Int]): Int = {
    val DENOMINATOR = 60
    var result = 0
    val remainders = new Array[Int](DENOMINATOR)
    for (number <- time) {
      val rem = number % DENOMINATOR
      result += remainders((DENOMINATOR - rem) % DENOMINATOR)
      remainders(rem) += 1
    }
    result
    //time.combinations(2).count(_.sum % 60 == 0)
  }

  def main(args: Array[String]): Unit = {
    println(numPairsDivisibleBy60(Array(60, 60, 60)))
    println(numPairsDivisibleBy60(Array(30, 60, 30)))
  }
}
