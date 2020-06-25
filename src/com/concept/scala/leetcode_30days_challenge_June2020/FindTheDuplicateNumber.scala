package com.concept.scala.leetcode_30days_challenge_June2020


/** *
  * Day 25
  *
  * @see https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/542/week-4-june-22nd-june-28th/3371/
  *      OR
  *      https://leetcode.com/problems/find-the-duplicate-number/
  *
  *
  *      Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
  *
  *      Example 1:
  *
  *      Input: [1,3,4,2,2]
  *      Output: 2
  *      Example 2:
  *
  *      Input: [3,1,3,4,2]
  *      Output: 3
  *      Note:
  *
  *      You must not modify the array (assume the array is read only).
  *      You must use only constant, O(1) extra space.
  *      Your runtime complexity should be less than O(n2).
  *      There is only one duplicate number in the array, but it could be repeated more than once.
  *
  */
object FindTheDuplicateNumber {

  /**
    * Runtime: 756 ms, faster than 27.78% of Scala online submissions for Find the Duplicate Number.
    * Memory Usage: 71.2 MB, less than 11.11% of Scala online submissions for Find the Duplicate Number.
    *
    * 53 / 53 test cases passed.
    * Status: Accepted
    * Runtime: 756 ms
    * Memory Usage: 71.2 MB
    *
    */
  def findDuplicate_ByMap (nums: Array[Int]): Int = {
    val map = scala.collection.mutable.HashMap[Int, Int]()
    nums.foreach { x => if (map contains x) return x else map.put(x, 1) }
    -1
  }


  def main (args: Array[String]): Unit = {
    val arr = Array(1, 3, 4, 2, 2)
    val arr2 = Array(3, 1, 3, 4, 2)
    println(findDuplicate_ByMap(arr))
    println(findDuplicate_ByMap(arr2))
  }
}
