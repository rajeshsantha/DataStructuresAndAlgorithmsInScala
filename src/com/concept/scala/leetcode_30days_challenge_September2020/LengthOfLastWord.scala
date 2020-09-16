package com.concept.scala.leetcode_30days_challenge_September2020

/** *
 *
 * Day 15
 *
 * @todo Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word (last word means the last appearing word if we loop from left to right) in the string.
 *       If the last word does not exist, return 0.
 * @note Note: A word is defined as a maximal substring consisting of non-space characters only.
 * @example Example:
 *          Input: "Hello World"
 *          Output: 5
 * @see https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/556/week-3-september-15th-september-21st/3461/
 *      OR
 *      https://leetcode.com/problems/length-of-last-word/
 *
 *
 */
object LengthOfLastWord {

  def main(args: Array[String]): Unit = {
    val str = "Hello World"
    println(lengthOfLastWord(str))
    println(lengthOfLastWord("abcs e"))
    println(lengthOfLastWord("a"))

  }

  /** *
   * 59 / 59 test cases passed.
   * Status: Accepted
   * Runtime: 548 ms
   * Memory Usage: 49.7 MB
   *
   * @param s
   * @return
   */
  def lengthOfLastWord(s: String): Int = if (s.trim.length == 0) 0 else s.split(' ').last.trim.length

}
