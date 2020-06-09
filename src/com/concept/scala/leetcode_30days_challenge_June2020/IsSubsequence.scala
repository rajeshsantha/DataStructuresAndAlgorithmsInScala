package com.concept.scala.leetcode_30days_challenge_June2020


/** **
  * Day 9
  *
  * @see https://leetcode.com/problems/is-subsequence/
  *      OR
  *      https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3355/
  *
  *      Given a string s and a string t, check if s is subsequence of t.
  *
  *      A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).
  *
  *      Follow up:
  *      If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?
  *
  *      Credits:
  *      Special thanks to @pbrother for adding this problem and creating all test cases.
  *
  *
  *
  *      Example 1:
  *
  *      Input: s = "abc", t = "ahbgdc"
  *      Output: true
  *      Example 2:
  *
  *      Input: s = "axc", t = "ahbgdc"
  *      Output: false
  *
  *
  *      Constraints:
  *
  *      0 <= s.length <= 100
  *      0 <= t.length <= 10 pow 4
  *      Both strings consists only of lowercase characters
  *
  *
  */
object IsSubsequence {
  def main(args: Array[String]): Unit = {
    val s = "abcx"
    val t = "ahbgdcx"
    println(isSubsequence(s, t))
    println(isSubsequence("aaaaaa", "bbaaaa"))
  }

  // 11/14 cases passed
  def isSubsequence(s: String, t: String): Boolean = {
    import scala.collection.mutable.ListBuffer

    if (s.forall(t.contains(_))) {
      val l = ListBuffer[Int]()
      s.foreach { x => l.append(t.indexOf(x)) }
      return l == l.sorted

    } else false

  }

  /** **
    * 14 / 14 test cases passed.
    * Status: Accepted
    * Runtime: 660 ms
    * Memory Usage: 61.6 MB
    */
  def isSubsequence_twoPointer(s: String, t: String): Boolean = {
    var (i, j) = (0, 0)
    val (slength, tlength) = (s.length, t.length)
    while (i < slength && j < tlength) {
      if (s.charAt(i) == t.charAt(j)) i += 1
      j += 1
    }

    i == slength
  }

}
