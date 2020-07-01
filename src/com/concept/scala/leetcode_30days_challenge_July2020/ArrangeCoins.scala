package com.concept.scala.leetcode_30days_challenge_July2020

import com.concept.scala.RunTimeCalculation

/** *
  * Day 1
  *
  * @todo You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.
  *       Given n, find the total number of full staircase rows that can be formed.
  *       n is a non-negative integer and fits within the range of a 32-bit signed integer.
  * @example Example 1:
  *
  *          n = 5
  *          The coins can form the following rows:
  *          ¤
  *          ¤ ¤
  *          ¤ ¤
  *
  *          Because the 3rd row is incomplete, we return 2.
  *
  *          Example 2:
  *
  *          n = 8
  *          The coins can form the following rows:
  *          ¤
  *          ¤ ¤
  *          ¤ ¤ ¤
  *          ¤ ¤
  *
  *          Because the 4th row is incomplete, we return 3.
  *
  *
  */
object ArrangeCoins {

  /** *
    * Runtime: 464 ms, faster than 16.67% of Scala online submissions for Arranging Coins.
    * Memory Usage: 48.9 MB, less than 50.00% of Scala online submissions for Arranging Coins.
    *
    * 1336 / 1336 test cases passed.
    * Status: Accepted
    * Runtime: 464 ms
    * Memory Usage: 48.9 MB
    *
    */
  def arrangeCoins_BruteForce(n: Int): Int = {
    var temp = 0
    var input = n
    while (input > 0) {
      temp += 1
      input -= temp
    }
    if (input == 0) temp else temp - 1
  }

  /** **
    * Runtime: 424 ms, faster than 33.33% of Scala online submissions for Arranging Coins.
    * Memory Usage: 49 MB, less than 16.67% of Scala online submissions for Arranging Coins.
    *
    *
    * 1336 / 1336 test cases passed.
    * Status: Accepted
    * Runtime: 424 ms
    * Memory Usage: 49 MB
    *
    */
  def arrangeCoins_BinarySearch(n: Int): Int = {
    if (n <= 1) return n
    var low: Long = 1
    var high: Long = n
    while (low <= high) {
      val mid = low + (high - low) / 2
      val sum = mid * (mid + 1) / 2
      if (sum <= n) low = mid + 1 else high = mid - 1
    }

    low.toInt - 1
  }

  /** *
    * Runtime: 440 ms, faster than 16.67% of Scala online submissions for Arranging Coins.
    * Memory Usage: 49 MB, less than 33.33% of Scala online submissions for Arranging Coins.
    *
    * 1336 / 1336 test cases passed.
    * Status: Accepted
    * Runtime: 440 ms
    * Memory Usage: 49 MB
    * */
  def arrangeCoins_By_Math(n: Int): Int = ((math.sqrt((8L * n + 1)) - 1) / 2).toInt


  def main(args: Array[String]): Unit = {
    val bruteForceRuntime = RunTimeCalculation.calculateRunTime(println(arrangeCoins_BruteForce(865464643)))
    val binarySearchRuntime = RunTimeCalculation.calculateRunTime(println(arrangeCoins_BinarySearch(865464643)))
    val mathRuntime = RunTimeCalculation.calculateRunTime(println(arrangeCoins_By_Math(865464643)))

    println(s"  bruteForceRuntime   => = $bruteForceRuntime seconds OR ${bruteForceRuntime * 1000} milliseonds")
    println(s"  binarySearchRuntime => = $binarySearchRuntime seconds OR ${binarySearchRuntime * 1000} milliseonds")
    println(s"  mathRuntime         => = $mathRuntime seconds OR ${mathRuntime * 1000} milliseonds")
    /*
    41603
    41603
    41603
      bruteForceRuntime   => = 0.269 seconds OR 269.0 milliseonds
      binarySearchRuntime => = 0.0 seconds OR 0.0 milliseonds
      mathRuntime         => = 0.002 seconds OR 2.0 milliseonds

     */
  }
}
