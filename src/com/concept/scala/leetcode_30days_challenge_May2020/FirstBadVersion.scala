package com.concept.scala.leetcode_30days_challenge_May2020

/** **
  * Day 1
  *
  * @see https://leetcode.com/problems/first-bad-version/
  *      OR
  *      https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3316/
  *
  *
  *
  *      You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
  *      Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
  *
  *      You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
  *
  *      Given n = 5, and version = 4 is the first bad version.
  *
  *      call isBadVersion(3) -> false
  *      call isBadVersion(5) -> true
  *      call isBadVersion(4) -> true
  *
  *      Then 4 is the first bad version.
  *
  *
  *
  *
  */
class VersionControl {

  var badVersion = 0

  def isBadVersion(v: Int): Boolean = {
    v == badVersion
  }
}

/* The isBadVersion API is defined in the parent class VersionControl.
      def isBadVersion(version: Int): Boolean = {} */

class FirstBadVersion extends VersionControl {

  /** *
    * Runtime: 408 ms, faster than 57.89% of Scala online submissions for First Bad Version.
    * Memory Usage: 48.6 MB, less than 100.00% of Scala online submissions for First Bad Version.
    *
    *
    *
    * 22 / 22 test cases passed.
    * Status: Accepted
    * Runtime: 432 ms
    * Memory Usage: 48.7 MB
    *
    * @param n
    * @return
    */
  def firstBadVersion(n: Int): Int = {
    var left = 1
    var right = n //10

    if (n <= 0) return 0

    while (left < right) { //0<10
      val mid = left + (right - left) / 2 // 5

      if (isBadVersion(mid)) { //5
        right = mid
      } else {
        left = mid + 1 //
      }

    }
    return left
  }
}

object FirstBadVersion {
  def main(args: Array[String]): Unit = {
    val obj = new FirstBadVersion
    val vcs = new VersionControl
    vcs.badVersion = 8
    println(s"${obj.firstBadVersion(10)}")

  }
}