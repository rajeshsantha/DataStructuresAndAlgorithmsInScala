package com.concept.scala.leetcode_30days_challenge_May2020

/** *
  * Day 18
  *
  * @see https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3333/
  *      OR
  *      https://leetcode.com/problems/permutation-in-string/
  *
  *
  *      Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.
  *
  *
  *
  *      Example 1:
  *
  *      Input: s1 = "ab" s2 = "eidbaooo"
  *      Output: True
  *      Explanation: s2 contains one permutation of s1 ("ba").
  *      Example 2:
  *
  *      Input:s1= "ab" s2 = "eidboaoo"
  *      Output: False
  *
  *
  *      Note:
  *
  *      The input strings only contain lower case letters.
  *      The length of both given strings is in range [1, 10,000].
  *
  *
  *
  *
  */
object PermutationInString {
  /**
    * Status: Time Limit Exceeded
    *
    * @param s1
    * @param s2
    * @return
    */
  def checkInclusion (s1: String, s2: String): Boolean = s1.permutations.exists(s2.contains(_))

  /** **
    *
    * 103 / 103 test cases passed.
    * Status: Accepted
    * Runtime: 8052 ms
    * Memory Usage: 56.8 MB
    *
    * @param s1
    * @param s2
    * @return
    */
  def checkInclusion2 (s1: String, s2: String): Boolean = s2.sliding(s1.length).exists(s1.sorted == _.sorted)

  def main (args: Array[String]): Unit = {
    val x = "adc"
    val y = "dcda"
    val s3 = "dinitrophenylhydrazine"
    val s4 = "acetylphenylhydrazine"

    val s1 = "adc"
    val s2 = "dcda"
    println(checkInclusion(s1, s2))
  }


}

/*
    def checkInclusion(self, s1, s2):
	# 102 / 102 test cases passed.
	# Status: Accepted
	# Runtime: 64 ms
        ls1 = len(s1)
        key = sum(map(hash, s1))
        now = sum(map(hash, s2[:ls1]))
        if key == now: return True
        for i in range(ls1, len(s2)):
            now = now - hash(s2[i - ls1]) + hash(s2[i])
            if now == key:
                return True
        return False

 */