package com.concept.scala.leetcode30days

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

    var l = 0
    var h = 0

    for (c <- s.toCharArray) {
      if (c == '(') {
        l += 1
        h += 1
      }
      else if (c == ')') {
        h -= 1
        if (l > 0) {
          l -= 1
        }
      }
      else {
        h += 1
        if (l > 0) {
          l -= 1
        }
      }
      if (h < 0) return false
    }
    l == 0
  }
}
