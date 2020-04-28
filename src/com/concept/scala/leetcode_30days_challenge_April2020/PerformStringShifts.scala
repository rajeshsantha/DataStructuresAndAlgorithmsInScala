package com.concept.scala.leetcode_30days_challenge_April2020

/** *
  *
  * Day 14
  *
  * @see https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/529/week-2/3299/
  *
  *      You are given a string s containing lowercase English letters, and a matrix shift, where shift[i] = [direction, amount]:
  *
  *      direction can be 0 (for left shift) or 1 (for right shift).
  *      amount is the amount by which string s is to be shifted.
  *      A left shift by 1 means remove the first character of s and append it to the end.
  *      Similarly, a right shift by 1 means remove the last character of s and add it to the beginning.
  *      Return the final string after all operations.
  *
  *
  *
  *      Example 1:
  *
  *      Input: s = "abc", shift = [[0,1],[1,2]]
  *      Output: "cab"
  *      Explanation:
  *      [0,1] means shift to left by 1. "abc" -> "bca"
  *      [1,2] means shift to right by 2. "bca" -> "cab"
  *      Example 2:
  *
  *      Input: s = "abcdefg", shift = [[1,1],[1,1],[0,2],[1,3]]
  *      Output: "efgabcd"
  *      Explanation:
  *      [1,1] means shift to right by 1. "abcdefg" -> "gabcdef"
  *      [1,1] means shift to right by 1. "gabcdef" -> "fgabcde"
  *      [0,2] means shift to left by 2.  "fgabcde" -> "abcdefg"
  *      [1,3] means shift to right by 3. "abcdefg" -> "efgabcd"
  *
  *
  *      31 / 31 test cases passed.
  *      Status: Accepted
  *      Runtime: 460 ms
  *      Memory Usage: 50.2 MB
  *
  *
  *
  */
object PerformStringShifts {

  def main(args: Array[String]): Unit = {

    val rotationList2 = Array(Array(0, 1), Array(1, 2))
    println(s"final result is ${stringShift("abc", rotationList2)}")

  }

  def stringShift(str: String, shift: Array[Array[Int]]): String = {
    var result = str
    val len = str.length

    for (arr <- shift) {

      val (j, i) = (arr(0), arr(1))
      result = if (j != 0) {
        result.slice(len - i, len) concat result.slice(0, len - i)

      }
      else {
        result.slice(i, len) concat result.slice(0, i)
      }
      println(s"$str  +  ${(j, i)}===> $result")
    }
    result
  }


}
