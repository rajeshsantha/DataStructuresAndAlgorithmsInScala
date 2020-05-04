package com.concept.scala.leetcode_30days_challenge_May2020

import com.concept.scala.RunTimeCalculation

/** **
  * Day 4
  *
  * @see https://leetcode.com/problems/number-complement/
  *      OR
  *      https://leetcode.com/explore/featured/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3319/
  *
  *      Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.
  *      Input: 5
  *      Output: 2
  *      Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
  *
  *
  *
  */
object NumberComplement {
  def main(args: Array[String]): Unit = {


    println(s"Runtime = ${RunTimeCalculation.calculateRunTime(println(findComplement(5)))}seconds")

  }

  def findComplement(num: Int): Int = {
    Integer.parseInt(num.toBinaryString.map(x => if (x == '1') '0' else '1'), 2)
  }

}
