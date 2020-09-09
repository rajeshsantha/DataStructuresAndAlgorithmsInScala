package com.concept.scala.leetcode_30days_challenge_September2020

/** *
  *
  * Day 9
  *
  * @todo Compare two version numbers version1 and version2.
  *       If version1 > version2 return 1; if version1 < version2 return -1;otherwise return 0.
  *       You may assume that the version strings are non-empty and contain only digits and the . character.
  *       The . character does not represent a decimal point and is used to separate number sequences.
  *       For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
  *
  *       You may assume the default revision number for each level of a version number to be 0. For example, version number 3.4 has a revision number of 3 and 4 for its first and second level revision number. Its third and fourth level revision number are both 0.
  * @example Example 1:
  *
  *          Input: version1 = "0.1", version2 = "1.1"
  *          Output: -1
  *          Example 2:
  *
  *          Input: version1 = "1.0.1", version2 = "1"
  *          Output: 1
  *          Example 3:
  *
  *          Input: version1 = "7.5.2.4", version2 = "7.5.3"
  *          Output: -1
  *          Example 4:
  *
  *          Input: version1 = "1.01", version2 = "1.001"
  *          Output: 0
  *          Explanation: Ignoring leading zeroes, both “01” and “001" represent the same number “1”
  *          Example 5:
  *
  *          Input: version1 = "1.0", version2 = "1.0.0"
  *          Output: 0
  *          Explanation: The first version number does not have a third level revision number, which means its third level revision number is default to "0"
  * @note Note:
  *
  *       Version strings are composed of numeric strings separated by dots . and this numeric strings may have leading zeroes.
  *       Version strings do not start or end with dots, and they will not be two consecutive dots.
  * @see https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/555/week-2-september-8th-september-14th/3454/
  *      OR
  *      https://leetcode.com/problems/compare-version-numbers/
  *
  */
object CompareVersionNumbers {
  def main(args: Array[String]): Unit = {
    println(compareVersion(version1 = "0.1", version2 = "1.1")) // -1
    println(compareVersion(version1 = "1.0.1", version2 = "1")) // 1
    println(compareVersion(version1 = "7.5.2.4", version2 = "7.5.3")) // -1
    println(compareVersion(version1 = "1.01", version2 = "1.001")) // 0
    println(compareVersion(version1 = "1.0", version2 = "1.0.0")) // 0

  }

  /** *
    *
    * 72 / 72 test cases passed.
    * Status: Accepted
    * Runtime: 436 ms
    * Memory Usage: 50.1 MB
    *
    *
    */
  def compareVersion(version1: String, version2: String): Int = {
    val makeAnArray: String => Array[Int] = _.split('.').map(_.toInt)
    val (v1, v2) = (makeAnArray(version1), makeAnArray(version2))
    val (n1, n2) = (v1.length, v2.length)
    val greaterLength = math.max(n1, n2)

    for (i <- 0 until greaterLength) {
      val first = if (i < n1) v1(i) else 0
      val second = if (i < n2) v2(i) else 0
      if (first < second) return -1 else if (first > second) return 1 else if (first == second) {
        //do notning, just continue
      }
    }
    0
  }

}
