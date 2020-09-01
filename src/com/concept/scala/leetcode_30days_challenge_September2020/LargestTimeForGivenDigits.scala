package com.concept.scala.leetcode_30days_challenge_September2020

import scala.collection.mutable.ListBuffer

/** **
  *
  * Day 1
  *
  * @todo Given an array of 4 digits, return the largest 24 hour time that can be made.
  *       The smallest 24 hour time is 00:00, and the largest is 23:59.  Starting from 00:00, a time is larger if more time has elapsed since midnight.
  *       Return the answer as a string of length 5.  If no valid time can be made, return an empty string.
  * @example Example 1:
  *
  *          Input: [1,2,3,4]
  *          Output: "23:41"
  *          Example 2:
  *
  *          Input: [5,5,5,5]
  *          Output: ""
  * @note Note:
  *
  *       A.length == 4
  *       0 <= A[i] <= 9
  * @see https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/554/week-1-september-1st-september-7th/3445/
  *      OR
  *      https://leetcode.com/problems/largest-time-for-given-digits
  */
object LargestTimeForGivenDigits {
  def main(args: Array[String]): Unit = {
    val a1 = Array(1, 2, 3, 4)
    val a2 = Array(4, 2, 6, 1)
    println(largestTimeFromDigits(a1))
    println(largestTimeFromDigits(a2))
    println(largestTimeFromDigits(Array(2, 9, 9, 9)))
    println(largestTimeFromDigits(Array(2, 1, 9, 8)))

    println(largestTimeFromDigits_ByBuiltin(Array(2, 1, 9, 8)))

  }

  /** *
    * 172 / 172 test cases passed.
    * Status: Accepted
    * Runtime: 868 ms
    * Memory Usage: 75.4 MB
    *
    *
    */
  def largestTimeFromDigits(A: Array[Int]): String = {
    val permutations = permutationGen(A)
    var res = ""
    for (p <- permutations) {
      val HH = p.substring(0, 2)
      val MM = p.substring(2)
      if (HH.compareTo("24") < 0 && MM.compareTo("60") < 0 && res.compareTo(HH + ":" + MM) < 0) res = HH + ":" + MM
    }
    res
  }

  private def permutationGen(A: Array[Int]): ListBuffer[String] = {
    var s = ""
    for (a <- A) s += a
    val list = ListBuffer[String]()
    permutations(s, "", list)
    list
  }

  private def permutations(s: String, sofar: String, list: ListBuffer[String]): ListBuffer[String] = {
    if (s.isEmpty) list.append(sofar)
    for (i <- s.indices) permutations(s.substring(0, i) + s.substring(i + 1), sofar + s.charAt(i), list)
    list
  }

  /** **
    * 172 / 172 test cases passed.
    * Status: Accepted
    * Runtime: 924 ms
    * Memory Usage: 67.2 MB
    *
    */
  def largestTimeFromDigits_ByBuiltin(A: Array[Int]): String = {
    val permutations = A.permutations.map(_.mkString)
    var res = ""
    for (p <- permutations) {
      val HH = p.substring(0, 2)
      val MM = p.substring(2)
      if (HH.compareTo("24") < 0 && MM.compareTo("60") < 0 && res.compareTo(HH + ":" + MM) < 0) res = HH + ":" + MM
    }
    res
  }


}
