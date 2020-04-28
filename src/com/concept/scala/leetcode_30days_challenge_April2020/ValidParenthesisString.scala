package com.concept.scala.leetcode_30days_challenge_April2020

/** *
  * Day 16
  *
  * @see https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3301/
  *      (OR)
  *      https://leetcode.com/problems/valid-parenthesis-string/
  *
  *      Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:
  *
  *      Any left parenthesis '(' must have a corresponding right parenthesis ')'.
  *      Any right parenthesis ')' must have a corresponding left parenthesis '('.
  *      Left parenthesis '(' must go before the corresponding right parenthesis ')'.
  *      '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
  *      An empty string is also valid.
  *
  *      Example 1:
  *      Input: "()"
  *      Output: True
  *      Example 2:
  *      Input: "(*)"
  *      Output: True
  *      Example 3:
  *      Input: "(*))"
  *      Output: True
  *
  *      Note:
  *      The string size will be in the range [1, 100].
  *
  *      Runtime: 420 ms, faster than 100.00% of Scala online submissions for Valid Parenthesis String.
  *      Memory Usage: 49.7 MB, less than 100.00% of Scala online submissions for Valid Parenthesis String.
  *
  *      58 / 58 test cases passed.
  *      Status: Accepted
  *      Runtime: 428 ms
  *      Memory Usage: 49.7 MB
  *
  *
  */
object ValidParenthesisString {
  def main (args: Array[String]): Unit = {

    val str = "(sdf))"
    println(s"$str ====> ${checkValidString(str)}")
  }

  def checkValidString (s: String): Boolean = {

    var left = 0
    var stars = 0

    for (char <- s.toCharArray) {
      if (char == '(') {
        left += 1
        stars += 1
      }
      else if (char == ')') {
        stars -= 1
        if (left > 0) {
          left -= 1
        }
      }
      else {
        stars += 1
        if (left > 0) {
          left -= 1
        }
      }
      if (stars < 0) return false
    }
    left == 0
  }
}
