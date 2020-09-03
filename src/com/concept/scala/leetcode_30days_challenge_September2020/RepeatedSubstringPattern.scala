package com.concept.scala.leetcode_30days_challenge_September2020

/** *
  *
  * Day 3
  *
  * @todo Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
  * @example Example 1:
  *
  *          Input: "abab"
  *          Output: True
  *          Explanation: It's the substring "ab" twice.
  *          Example 2:
  *
  *          Input: "aba"
  *          Output: False
  *          Example 3:
  *
  *          Input: "abcabcabcabc"
  *          Output: True
  *          Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
  * @see https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/554/week-1-september-1st-september-7th/3447/
  *      OR
  *      https://leetcode.com/problems/repeated-substring-pattern/
  *
  *
  */
object RepeatedSubstringPattern extends App {
  /** *
    * 120 / 120 test cases passed.
    * Status: Accepted
    * Runtime: 528 ms
    * Memory Usage: 50.3 MB
    *
    * */
  def repeatedSubstringPattern(s: String): Boolean = {
    if (s == null || s.length <= 1) return false
    (s + s).indexOf(s, 1) != s.length
  }
}