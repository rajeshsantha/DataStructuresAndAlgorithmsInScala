package com.concept.scala.leetcode_30days_challenge_July2020

/** *
  * Day 15
  *
  * @todo Given an input string, reverse the string word by word.
  * @example Example 1:
  *
  *          Input: "the sky is blue"
  *          Output: "blue is sky the"
  *          Example 2:
  *
  *          Input: "  hello world!  "
  *          Output: "world! hello"
  *          Explanation: Your reversed string should not contain leading or trailing spaces.
  *          Example 3:
  *
  *          Input: "a good   example"
  *          Output: "example good a"
  *          Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
  * @see https://leetcode.com/problems/reverse-words-in-a-string/
  *      OR
  *      https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/546/week-3-july-15th-july-21st/3391/
  * @note A word is defined as a sequence of non-space characters.
  *       Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
  *       You need to reduce multiple spaces between two words to a single space in the reversed string.
  *
  *
  */
object ReverseWordsInString {

  /** *
    *
    * 25 / 25 test cases passed.
    * Status: Accepted
    * Runtime: 4056 ms
    * Memory Usage: 727.7 MB
    *
    */
  def reverseWords1(s: String): String = s.split(" ").map(_.trim).filter(_.length > 0).reverse.mkString(" ")


  /** *
    *
    * 25 / 25 test cases passed.
    * Status: Accepted
    * Runtime: 3120 ms
    * Memory Usage: 51.1 MB
    *
    */
  def reverseWords2(s: String): String = s.trim.split(" +").reverse.mkString(" ")


}
