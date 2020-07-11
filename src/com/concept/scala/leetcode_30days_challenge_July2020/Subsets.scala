package com.concept.scala.leetcode_30days_challenge_July2020

/** *
  * Day 11
  *
  * @todo Given a set of distinct integers, nums, return all possible subsets (the power set).
  * @note The solution set must not contain duplicate subsets.
  * @example Input: nums = [1,2,3]
  *          Output:
  *          [
  *          [3],
  *          [1],
  *          [2],
  *          [1,2,3],
  *          [1,3],
  *          [2,3],
  *          [1,2],
  *          []
  *          ]
  * @see https://leetcode.com/problems/subsets/
  *      OR
  *      https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/545/week-2-july-8th-july-14th/3387/
  *
  *
  */
object Subsets {

  /** *
    *
    * 10 / 10 test cases passed.
    * Status: Accepted
    * Runtime: 520 ms
    * Memory Usage: 51.7 MB
    *
    * Runtime: 512 ms, faster than 25.00% of Scala online submissions for Subsets.
    * Memory Usage: 51.4 MB, less than 47.06% of Scala online submissions for Subsets.
    *
    */
  def subsets(nums: Array[Int]): List[List[Int]] = {
    val len = nums.length
    var result = List[List[Int]]()
    for (i <- len to 0 by -1) {
      val temp = nums.combinations(i).map(_.toList).toList
      result :::= temp
    }
    result
  }

  def main(args: Array[String]): Unit = {
    val testcaseResult1: List[List[Int]] = subsets(Array(1, 2, 3))
    val testcaseResult2: List[List[Int]] = subsets(Array(1, 2, 3, 3))
    val testcaseResult3: List[List[Int]] = subsets(Array(1))

    //Unit test cases : Status : PASSED
    // Path           : DataStructuresAndAlgorithmsInScala/test/scala/leetcode_30days_challenge_July2020/TestSubsets.scala
    //link            : https://github.com/rajeshsantha/DataStructuresAndAlgorithmsInScala/blob/master/test/scala/leetcode_30days_challenge_July2020/TestSubsets.scala

  }


}
