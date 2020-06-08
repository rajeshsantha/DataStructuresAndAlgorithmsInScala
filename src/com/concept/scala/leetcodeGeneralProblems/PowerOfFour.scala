package com.concept.scala.leetcodeGeneralProblems

/** *
  *
  * @see https://leetcode.com/problems/power-of-four/
  *
  *
  *      Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
  *
  *      Example 1:
  *
  *      Input: 16
  *      Output: true
  *      Example 2:
  *
  *      Input: 5
  *      Output: false
  *      Follow up: Could you solve it without loops/recursion?
  *
  */
object PowerOfFour {

  def main(args: Array[String]): Unit = {
    println(isPowerOfFour(8))
    println(isPowerOfFour(256))
    println(isPowerOfFour(16))
    println(isPowerOfFour(-2147483648))


  }

  /** *
    * Runtime: 544 ms, faster than 33.33% of Scala online submissions for Power of Four.
    * Memory Usage: 58.8 MB, less than 33.33% of Scala online submissions for Power of Four.
    *
    *
    * 1060 / 1060 test cases passed.
    * Status: Accepted
    * Runtime: 544 ms
    * Memory Usage: 58.8 MB
    *
    */
  def isPowerOfFour(num: Int): Boolean = {
    val bString = num.toBinaryString
    bString.count(_ == '1') == 1 && bString.length % 2 == 1
  }
}
