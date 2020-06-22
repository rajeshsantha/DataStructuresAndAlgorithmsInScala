package com.concept.scala.leetcode_30days_challenge_June2020

import com.concept.scala.RunTimeCalculation


/** *
  * Day 22
  *
  * @see https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/542/week-4-june-22nd-june-28th/3368/
  *      OR
  *      https://leetcode.com/problems/single-number-ii/
  *
  *
  *      Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
  *
  *      Note:
  *
  *      Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
  *
  *      Example 1:
  *
  *      Input: [2,2,3,2]
  *      Output: 3
  *      Example 2:
  *
  *      Input: [0,1,0,1,0,1,99]
  *      Output: 99
  *
  *
  *
  *
  */
object SingleNumber_II {
  def main (args: Array[String]): Unit = {
    val nums = Array(2, 2, 3, 2)
    val nums2 = Array(0, 1, 0, 1, 0, 1, 99)

    val runtime1 = RunTimeCalculation.calculateRunTime {
      println(singleNumberByLibrary(nums))
      println(singleNumberByLibrary(nums2))
    }
    val runtime2 = RunTimeCalculation.calculateRunTime {
      println(singleNumberByMap(nums))
      println(singleNumberByMap(nums2))
    }
    val runtime3 = RunTimeCalculation.calculateRunTime {
      println(singleNumberByBits(nums))
      println(singleNumberByBits(nums2))
    }

    println(s" singleNumberByLibrary total run time = $runtime1 seconds OR ${runtime1 * 1000} milliseonds")
    println(s" singleNumberByMap total run time = $runtime2 seconds OR ${runtime2 * 1000} milliseonds")
    println(s" singleNumberByBits total run time = $runtime3 seconds OR ${runtime3 * 1000} milliseonds")
    /*
    3
    99
    3
    99
    3
    99
     singleNumberByLibrary    total run time = 0.925 seconds OR 925.0 milliseonds
     singleNumberByMap        total run time = 0.076 seconds OR 76.0 milliseonds
     singleNumberByBits       total run time = 0.016 seconds OR 16.0 milliseonds

     */
  }

  /** *
    * Runtime: 824 ms, faster than 20.00% of Scala online submissions for Single Number II.
    * Memory Usage: 51.4 MB, less than 100.00% of Scala online submissions for Single Number II.
    *
    * 11 / 11 test cases passed.
    * Status: Accepted
    * Runtime: 824 ms
    * Memory Usage: 51.4 MB
    *
    */
  def singleNumberByLibrary (nums: Array[Int]): Int = nums.find(x => nums.count(_ == x) == 1).get

  /** *
    * Runtime: 504 ms, faster than 80.00% of Scala online submissions for Single Number II.
    * Memory Usage: 52.2 MB, less than 71.43% of Scala online submissions for Single Number II.
    *
    * 11 / 11 test cases passed.
    * Status: Accepted
    * Runtime: 504 ms
    * Memory Usage: 52.2 MB
    *
    *
    */
  def singleNumberByMap (nums: Array[Int]): Int = {
    val map = scala.collection.mutable.HashMap[Int, Int]()
    for (i <- nums) if (map contains i) map(i) += 1 else map.put(i, 1)
    map.filterKeys(map(_) == 1).keys.head
  }

  /**
    * Runtime: 480 ms, faster than 100.00% of Scala online submissions for Single Number II.
    * Memory Usage: 52.1 MB, less than 71.43% of Scala online submissions for Single Number II.
    *
    * 11 / 11 test cases passed.
    * Status: Accepted
    * Runtime: 480 ms
    * Memory Usage: 52.1 MB
    *
    */
  def singleNumberByBits (nums: Array[Int]): Int = {

    var oneCounter, twoCounter, threeCounter = 0

    for (i <- nums.indices) {
      twoCounter |= oneCounter & nums(i)
      oneCounter ^= nums(i)
      threeCounter = oneCounter & twoCounter

      //reseting numbers that repeated 3 times, from both one's counter and two's counter
      oneCounter &= ~threeCounter
      twoCounter &= ~threeCounter

    }
    oneCounter
  }
}

