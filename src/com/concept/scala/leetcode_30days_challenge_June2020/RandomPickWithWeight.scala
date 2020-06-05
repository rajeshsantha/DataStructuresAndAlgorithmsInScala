package com.concept.scala.leetcode_30days_challenge_June2020

import scala.util.Random

/** **
  * Day 5
  *
  * @see https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3351/
  *      OR
  *      https://leetcode.com/problems/random-pick-with-weight
  *
  *      Given an array w of positive integers, where w[i] describes the weight of index i, write a function pickIndex which randomly picks an index in proportion to its weight.
  *
  *      Note:
  *
  *      1 <= w.length <= 10000
  *      1 <= w[i] <= 10 pw 5
  *      pickIndex will be called at most 10000 times.
  *      Example 1:
  *
  *      Input:
  *      ["Solution","pickIndex"]
  *      [[[1]],]
  *      Output: [null,0]
  *      Example 2:
  *
  *      Input:
  *      ["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
  *      [[[1,3]],[],[],[],[],]
  *      Output: [null,0,1,1,1,0]
  *      Explanation of Input Syntax:
  *
  *      The input is two lists: the subroutines called and their arguments. Solution's constructor has one argument, the array w. pickIndex has no arguments. Arguments are always wrapped with a list, even if there aren't any
  *
  */


/** *
  * Runtime: 1028 ms, faster than 11.11% of Scala online submissions for Random Pick with Weight.
  * Memory Usage: 59.6 MB, less than 33.33% of Scala online submissions for Random Pick with Weight.
  *
  * 57 / 57 test cases passed.
  * Status: Accepted
  * Runtime: 1028 ms
  * Memory Usage: 59.6 MB
  *
  *
  */
class RandomPickWithWeight(_w: Array[Int]) {
  val nums: Array[Int] = Array.fill(_w.length)(0)
  var total = 0
  val random = new Random()
  var runningTotal = 0

  for (i <- _w.indices) {
    runningTotal += _w(i)
    nums(i) = runningTotal
  }
  total = runningTotal

  def pickIndex(): Int = {
    if (total == 0)
      return -1

    val n = random.nextInt(total)
    for (i <- nums.indices)
      if (n < nums(i))
        return i


    return -1
  }

}

