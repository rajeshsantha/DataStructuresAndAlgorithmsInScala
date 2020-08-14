package com.concept.scala.leetcode_30days_challenge_August2020

import scala.collection.immutable.HashSet

/** **
  *
  * Day 14
  *
  * @todo Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
  *       This is case sensitive, for example "Aa" is not considered a palindrome here.
  * @note Assume the length of given string will not exceed 1,010.
  * @example Input:
  *          "abccccdd"
  *
  *          Output:
  *          7
  *
  *          Explanation:
  *          One longest palindrome that can be built is "dccaccd", whose length is 7.
  * @see https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/550/week-2-august-8th-august-14th/3423/
  *      OR
  *      https://leetcode.com/problems/longest-palindrome/
  *
  *
  */
object LongestPalindrome {
  def main(args: Array[String]): Unit = {
    println(longestPalindrome("abccccdd"))

  }

  /** *
    * 95 / 95 test cases passed.
    * Status: Accepted
    * Runtime: 464 ms
    * Memory Usage: 49.6 MB
    *
    */
  def longestPalindrome(s: String): Int = {
    val map = new Array[Int](128)
    var i = 0
    while (i < s.length) {
      map(s.charAt(i)) += 1
      i += 1
    }
    var totalLength = 0
    var single = 0
    for (i <- map.indices) {
      if (map(i) % 2 == 0) totalLength += map(i)
      else {
        totalLength += map(i) - 1
        single = 1
      }
    }
    totalLength + single
  }

  def longestPalindrome2(s: String): Int = {
    val (count: Int, charVisited: HashSet[Char]) = s.foldLeft((0, HashSet.empty[Char]))((tuple, current) => {
      val (count: Int, charactersSeen: HashSet[Char]) = tuple

      if (charactersSeen.contains(current)) (count + 2, charactersSeen - current) else (count, charactersSeen + current)
    })

    count + (if (charVisited.nonEmpty) 1 else 0)

  }
}
