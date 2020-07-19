package com.concept.scala.leetcode_30days_challenge_July2020

/** **
  * Day 19
  *
  * @todo Given two binary strings, return their sum (also a binary string).
  *       The input strings are both non-empty and contains only characters 1 or 0.
  * @example
  *                1.Example
  *
  *                Input: a = "11", b = "1"
  *                Output: "100"
  *
  *                2.Example
  *
  *                Input: a = "1010", b = "1011"
  *                Output: "10101"
  * @note Constraints:
  *
  *       Each string consists only of '0' or '1' characters.
  *       1 <= a.length, b.length <= 10 pow 4
  *       Each string is either "0" or doesn't contain any leading zero.
  * @see https://leetcode.com/problems/add-binary/
  *      OR
  *      https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/546/week-3-july-15th-july-21st/3395/
  *
  */
object AddBinary {
  def main(args: Array[String]): Unit = {
    val a = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101"
    val b = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"

    println(addBinary(a, b))
  }

  /** *
    *
    * 294 / 294 test cases passed.
    * Status: Accepted
    * Runtime: 504 ms
    * Memory Usage: 50.4 MB
    *
    */
  def addBinary(a: String, b: String): String = (BigInt(a, 2) + BigInt(b, 2)).toString(2)


  //(Integer.parseInt(a, 2) + Integer.parseInt(b, 2)).toBinaryString // for small size ints

}
