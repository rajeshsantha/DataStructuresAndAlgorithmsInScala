package com.concept.scala.leetcode_30days_challenge_August2020

/** *
  *
  * Day 3
  *
  * @todo Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
  * @note For the purpose of this problem, we define empty string as valid palindrome.
  * @example Example 1:
  *
  *          Input: "A man, a plan, a canal: Panama"
  *          Output: true
  *          Example 2:
  *
  *          Input: "race a car"
  *          Output: false
  * @see https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/549/week-1-august-1st-august-7th/3411/
  *      OR
  *      https://leetcode.com/problems/valid-palindrome/
  *
  *
  */
object ValidPalindrome {
  def main(args: Array[String]): Unit = {
    val input1 = "A man, a plan, a canal: Panama"
    val input2 = "race a car"
    println(isPalindrome(input1))
    println(isPalindrome(input2))

    println(isPalindrome2(input1))
    println(isPalindrome2(input2))

    println(isPalindrome3(input1))
    println(isPalindrome3(input2))

  }

  /** *
    * 481 / 481 test cases passed.
    * Status: Accepted
    * Runtime: 688 ms
    * Memory Usage: 59.7 MB
    *
    */
  def isPalindrome(s: String): Boolean = {
    val filteredString = s.split("").filter(_.matches("[A-Za-z0-9]+")).mkString
    filteredString.toLowerCase == filteredString.toLowerCase.reverse
  }

  def isPalindrome2(s: String): Boolean = {
    val filtered = s.filter(_.isLetterOrDigit)
    filtered.equalsIgnoreCase(filtered.reverse)
  }

  def isPalindrome3(s: String): Boolean = {
    val filtered = s.toLowerCase filter (c => ('a' to 'z' contains c) || ('0' to '9' contains c))
    filtered.zip(filtered.reverse).forall(p => p._1 == p._2)

  }

}
