package com.concept.scala.leetcode_30days_challenge_November2020

/** **
  *
  * Day 3
  *
  * @todo Given a string s, the power of the string is the maximum length of a non-empty substring that contains only one unique character.
  *       Return the power of the string.
  * @example Example 1:
  *
  *          Input: s = "leetcode"
  *          Output: 2
  *          Explanation: The substring "ee" is of length 2 with the character 'e' only.
  *          Example 2:
  *
  *          Input: s = "abbcccddddeeeeedcba"
  *          Output: 5
  *          Explanation: The substring "eeeee" is of length 5 with the character 'e' only.
  *          Example 3:
  *
  *          Input: s = "triplepillooooow"
  *          Output: 5
  *          Example 4:
  *
  *          Input: s = "hooraaaaaaaaaaay"
  *          Output: 11
  *          Example 5:
  *
  *          Input: s = "tourist"
  *          Output: 1
  
  * @note 1 <= s.length <= 500
  *       s contains only lowercase English letters
  * @see https://leetcode.com/explore/challenge/card/november-leetcoding-challenge/564/week-1-november-1st-november-7th/3518/
  *      OR
  *      https://leetcode.com/problems/consecutive-characters/
  *
  *
  *
  */
object ConsecutiveCharacters {
  def main(args: Array[String]): Unit = {
    println(maxPower("hooraaaaaaaaaaay")) //Output: 11
    println(maxPower("triplepillooooow")) //Output: 5
    println(maxPower("leetcode"))         //Output: 2
  }

  /** *
    * 333 / 333 test cases passed.
    * Status: Accepted
    * Runtime: 488 ms
    * Memory Usage: 51.4 MB
    *
    * @param s
    * @return
    */
  def maxPower(s: String): Int = {
    val len = s.length
    var (result, count) = (0, 1)
    for (i <- 0 until len)
      if (i == len - 1 || (s(i) != s(i + 1))) {
        result = math.max(result, count)
        count = 1
      }
      else count += 1
    result
  }
}

