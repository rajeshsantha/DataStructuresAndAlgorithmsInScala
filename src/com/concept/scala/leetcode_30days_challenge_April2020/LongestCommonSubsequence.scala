package com.concept.scala.leetcode_30days_challenge_April2020

/** **
  *
  * Day 26
  *
  * @see https://leetcode.com/problems/longest-common-subsequence/
  *      or
  *      https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/531/week-4/3311/
  *
  *      Given two strings text1 and text2, return the length of their longest common subsequence.
  *
  *      A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.
  *
  *
  *
  *      If there is no common subsequence, return 0.
  *
  *
  *
  *      Example 1:
  *
  *      Input: text1 = "abcde", text2 = "ace"
  *      Output: 3
  *      Explanation: The longest common subsequence is "ace" and its length is 3.
  *      Example 2:
  *
  *      Input: text1 = "abc", text2 = "abc"
  *      Output: 3
  *      Explanation: The longest common subsequence is "abc" and its length is 3.
  *      Example 3:
  *
  *      Input: text1 = "abc", text2 = "def"
  *      Output: 0
  *      Explanation: There is no such common subsequence, so the result is 0.
  *
  *
  *      Constraints:
  *
  *      1 <= text1.length <= 1000
  *      1 <= text2.length <= 1000
  *      The input strings consist of lowercase English characters only.
  *
  *
  */
object LongestCommonSubsequence {
  def main(args: Array[String]): Unit = {
    val text1 = "abcde"
    val text2 = "ace"

    println(longestCommonSubsequence(text1, text2))
    printmatrix(longestCommonSubsequence_Debug(text1, text2))

  }

  /** **
    *
    * 37 / 37 test cases passed.
    * Status: Accepted
    * Runtime: 592 ms
    * Memory Usage: 66.2 MB
    *
    * @param text1 first string input
    * @param text2 second string input
    * @return count of longest Common Subsequence
    */

  def longestCommonSubsequence(text1: String, text2: String): Int = {

    val (len1, len2) = (text1.length, text2.length)
    val table = Array.ofDim[Int](len1 + 1, len2 + 1)
    for (i <- 0 to len1;
         j <- 0 to len2) {
      if (i == 0 || j == 0) table(i)(j) = 0
      else if (text1(i - 1) == text2(j - 1)) table(i)(j) = table(i - 1)(j - 1) + 1
      else table(i)(j) = math.max(table(i - 1)(j), table(i)(j - 1))
    }
    table(len1)(len2)

  }

  def longestCommonSubsequence_Debug(text1: String, text2: String): Array[Array[Int]] = {

    val (len1, len2) = (text1.length, text2.length)
    val table = Array.ofDim[Int](len1 + 1, len2 + 1)
    for (i <- 0 to len1; j <- 0 to len2) {
      if (i == 0 || j == 0) table(i)(j) = 0
      else if (text1(i - 1) == text2(j - 1)) table(i)(j) = table(i - 1)(j - 1) + 1
      else table(i)(j) = math.max(table(i - 1)(j), table(i)(j - 1))

    }
    table

  }

  def printmatrix(matrix: Array[Array[Int]]) = {
    matrix.foreach { x => x.foreach(print); println }

  }


}

/*
output :
3
0000
0111
0111
0122
0122
0123

 */