package com.concept.scala.leetcode_30days_challenge_May2020

import scala.collection.mutable

/** **
  * Day 13
  *
  * @see https://leetcode.com/problems/remove-k-digits/
  *      OR
  *      https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3328/
  *
  *      Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.
  *
  *      Note:
  *      The length of num is less than 10002 and will be ≥ k.
  *      The given num does not contain any leading zero.
  *      Example 1:
  *
  *      Input: num = "1432219", k = 3
  *      Output: "1219"
  *      Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
  *      Example 2:
  *
  *      Input: num = "10200", k = 1
  *      Output: "200"
  *      Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
  *      Example 3:
  *
  *      Input: num = "10", k = 2
  *      Output: "0"
  *      Explanation: Remove all the digits from the number and it is left with nothing which is 0.
  *
  *
  *
  */
object Remove_K_Digits {

  def main(args: Array[String]): Unit = {
    val num = "10200"
    val k = 1

    println(removeKdigits(num, k))
  }

  /** ***
    * 33 / 33 test cases passed.
    * Status: Accepted
    * Runtime: 664 ms
    * Memory Usage: 53.1 MB
    *
    * Runtime: 664 ms, faster than 100.00% of Scala online submissions for Remove K Digits.
    * Memory Usage: 53.1 MB, less than 100.00% of Scala online submissions for Remove K Digits.
    *
    *
    */
  def removeKdigits(num: String, k: Int): String = {
    var J = k

    val len = num.length
    if (J == 0) return num
    if (len == J) return "0"
    var counter = 0
    val stack: mutable.Stack[Char] = mutable.Stack[Char]()
    val sb: mutable.StringBuilder = new mutable.StringBuilder()

    while (counter < len) {
      while (J > 0 && stack.nonEmpty && stack.top > num.charAt(counter)) {
        stack.pop()
        J -= 1
      }
      stack.push(num.charAt(counter))
      counter += 1
    }
    while (J > 0) {
      stack.pop()
      J -= 1
    }

    while (stack.nonEmpty) sb.append(stack.pop())
    sb.reverseContents()
    while (sb.length > 1 && sb.head == '0') sb.deleteCharAt(0)

    sb.toInt.toString
  }
}

