package com.concept.scala.leetcode_30days_challenge_July2020

import scala.collection.mutable.ListBuffer

/** *
  * Day 4
  *
  * @todo Write a program to find the n-th ugly number.
  *       Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
  * @example Example:
  *
  *          Input: n = 10
  *          Output: 12
  *          Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
  * @note Note:
  *
  *       1 is typically treated as an ugly number.
  *       n does not exceed 1690
  *
  */
object UglyNumberII {
  def main(args: Array[String]): Unit = {
    val n = 10
    // println(nthUglyNumber(n))
    println(nthUglyNumberByList(10))
    println(nthUglyNumberByList(11))

  }

  def nthUglyNumber(n: Int): Int = {
    var input = n

    var uglyCount = 1
    while (input > 0) {
      uglyCount += 1 //prefix increment will solve the problem
      if (isUgly(uglyCount.toString)) input -= 1

    }
    uglyCount
  }

  def isUgly(str: String): Boolean = {
    if (str.length > 1) {
      val lastdigit = str.last.toInt
      return lastdigit % 2 == 0 || lastdigit == 0 || lastdigit == 5 || str.split("").map(_.toInt).sum % 3 == 0
    } else {
      val number = str.toInt
      return number % 2 == 0 || number % 3 == 0 || number % 5 == 0
    }
  }

  def isUgly2(n: Int): Boolean = {
    var num = n
    var i: Int = 2
    while (i < 6 && num > 0) {
      while (num % i == 0) num /= i
      return i == 1
    }
    i == 1

  }

  def nthUglyNumberByList(n: Int): Int = {

    if (n <= 0) return 0
    val ugly = scala.collection.mutable.ListBuffer[Int]()
    ugly append 1
    var twoIndex, threeIndex, fiveIndex = 0


    while (ugly.length < n) {
      val (by2, by3, by5) = (ugly(twoIndex) * 2, ugly(threeIndex) * 3, ugly(fiveIndex) * 5)
      val min = Math.min(by2, Math.min(by3, by5))
      ugly append min
      if (min == by2) twoIndex += 1
      if (min == by3) threeIndex += 1
      if (min == by5) fiveIndex += 1
      println(s"$twoIndex   $threeIndex   $fiveIndex")
    }
    ugly.last
  }

}

/*

1   0   0
1   1   0
2   1   0
2   1   1
3   2   1
4   2   1
4   3   1
5   3   2
6   4   2
Final result = 12

1   0   0
1   1   0
2   1   0
2   1   1
3   2   1
4   2   1
4   3   1
5   3   2
6   4   2
6   5   3

Final result = 15

 */
