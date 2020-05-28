package com.concept.scala.leetcode_30days_challenge_May2020

/** ***
  * Day 28
  *
  * @see https://leetcode.com/problems/counting-bits
  *      OR
  *      https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3343/
  *
  *      Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
  *
  *      Example 1:
  *
  *      Input: 2
  *      Output: [0,1,1]
  *      Example 2:
  *
  *      Input: 5
  *      Output: [0,1,1,2,1,2]
  *      Follow up:
  *
  *      It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
  *      Space complexity should be O(n).
  *      Can you do it like a boss? Do it without using any builtin function like builtin_popcount in c++ or in any other language.
  *
  *
  *
  */
object CountingBits {
  def main(args: Array[String]): Unit = {
    println(countBits(2).mkString(","))
  }

  /** ***
    * Runtime: 488 ms, faster than 31.58% of Scala online submissions for Counting Bits.
    * Memory Usage: 49.7 MB, less than 100.00% of Scala online submissions for Counting Bits.
    *
    * 15 / 15 test cases passed.
    * Status: Accepted
    * Runtime: 488 ms
    * Memory Usage: 49.7 MB
    *
    */
  def countBits(num: Int): Array[Int] = {
    val result = new Array[Int](num + 1)
    result(0) = 0

    if (num == 0) return result
    for (i <- 1 to num)
      if ((i & 1) == 0) result(i) = result(i >> 1) else result(i) = result(i - 1) + 1

    result
  }
}
