package com.concept.scala.leetcodeGeneralProblems

/** **
  *
  * @see https://leetcode.com/problems/power-of-three/
  *
  *      Given an integer, write a function to determine if it is a power of three.
  *
  *      Example 1:
  *
  *      Input: 27
  *      Output: true
  *      Example 2:
  *
  *      Input: 0
  *      Output: false
  *      Example 3:
  *
  *      Input: 9
  *      Output: true
  *      Example 4:
  *
  *      Input: 45
  *      Output: false
  *      Follow up:
  *      Could you do it without using any loop / recursion?
  *
  */
object PowerOfThree {
  def main(args: Array[String]): Unit = {
    println(isPowerOfThree(9))
    println(isPowerOfThree(6))
    println(isPowerOfThree(27))
    println(isPowerOfThree(-3))

  }

  /** *
    *
    * Runtime: 664 ms, faster than 11.11% of Scala online submissions for Power of Three.
    * Memory Usage: 49.5 MB, less than 13.33% of Scala online submissions for Power of Three.
    *
    *
    * 21038 / 21038 test cases passed.
    * Status: Accepted
    * Runtime: 664 ms
    * Memory Usage: 49.5 MB
    *
    */
  def isPowerOfThree(n: Int): Boolean = if (n <= 0) false else 1162261467 % n == 0


  // 1162261467 is the max 3 ^ x value that is possibly assgin for an integer value
}
