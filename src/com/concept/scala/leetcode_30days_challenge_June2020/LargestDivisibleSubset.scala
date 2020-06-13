package com.concept.scala.leetcode_30days_challenge_June2020

import com.concept.scala.RunTimeCalculation.continueTil


/** **
  * Day 13
  *
  * @see https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3359/
  *      OR
  *      https://leetcode.com/problems/largest-divisible-subset/
  *
  *
  *      Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies:
  *
  *      Si % Sj = 0 or Sj % Si = 0.
  *
  *      If there are multiple solutions, return any subset is fine.
  *
  *      Example 1:
  *
  *      Input: [1,2,3]
  *      Output: [1,2] (of course, [1,3] will also be ok)
  *      Example 2:
  *
  *      Input: [1,2,4,8]
  *      Output: [1,2,4,8]
  *
  *      Accepted  71,160 out of Submissions 194,705
  *
  */
object LargestDivisibleSubset {
  def main(args: Array[String]): Unit = {
    val arr = Array(1, 2, 3)
    val arr2 = Array(1, 2, 4, 8)
    println(largestDivisibleSubset(arr).mkString("[", ",", "]"))
    println(largestDivisibleSubset(arr2).mkString("[", ",", "]"))


  }

  /** **
    * Runtime: 528 ms, faster than 100.00% of Scala online submissions for Largest Divisible Subset.
    * Memory Usage: 50.6 MB, less than 100.00% of Scala online submissions for Largest Divisible Subset.
    *
    *
    * 41 / 41 test cases passed.
    * Status: Accepted
    * Runtime: 528 ms
    * Memory Usage: 50.6 MB
    *
    */
  def largestDivisibleSubset(nums: Array[Int]): List[Int] = {

    import scala.collection.mutable.ListBuffer
    if (nums.isEmpty) return List[Int]()

    val len = nums.length
    val result = ListBuffer[Int]()
    val sortedNums = nums.sorted
    val (index, count) = (Array.fill(len)(0), Array.fill(len)(1))
    var (max, min) = (1, 0)


    for (i <- 0 until len; j <- i - 1 to 0 by -1) {
      if (sortedNums(i) % sortedNums(j) == 0 && count(i) < count(j) + 1) {
        count(i) = count(j) + 1
        index(i) = j
        if (count(i) > max) {
          max = count(i)
          min = i
        }

      }
    }

    continueTil(max > 0) {
      result.insert(0, nums(min))
      min = index(min)
      max -= 1
    }

    result.toList
  }
}

