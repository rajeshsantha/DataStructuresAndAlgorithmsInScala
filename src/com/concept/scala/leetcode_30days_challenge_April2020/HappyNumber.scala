package com.concept.scala.leetcode_30days_challenge_April2020

import scala.annotation.tailrec

/** *
  *
  * @see https://leetcode.com/explore/other/card/30-day-leetcoding-challenge/528/week-1/3284/
  * @note Day-2
  *
  *       Write an algorithm to determine if a number is "happy".
  *
  *       A happy number is a number defined by the following process:
  *       Starting with any positive integer, replace the number by the sum of the squares of its digits,
  *       and repeat the process until the number equals 1 (where it will stay),
  *       or it loops endlessly in a cycle which does not include 1.
  *       Those numbers for which this process ends in 1 are happy numbers.
  *
  *
  *
  */

object HappyNumber {


  @tailrec
  def isHappy(n: Int): Boolean = {

    //n.toString.split("").map(_.toDouble).map(math.pow(_,2)).sum.toInt
    val res = n.toString.split("").map(_.toDouble).map(math.pow(_, 2)).sum.toInt

    if (res == 1 || res == 7) true
    else if (res <= 9) false
    else
      isHappy(res)

  }


  def main(args: Array[String]): Unit = {
    println(isHappy(19))
    println(isHappy(20))
    println(isHappy(1111111))

  }
}
