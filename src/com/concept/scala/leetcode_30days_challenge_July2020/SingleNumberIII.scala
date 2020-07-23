package com.concept.scala.leetcode_30days_challenge_July2020


/** *
  * Day 23
  *
  * @todo Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
  * @example Example:
  *
  *          Input:  [1,2,1,3,2,5]
  *          Output: [3,5]
  * @note
  *       1.The order of the result is not important. So in the above example, [5, 3] is also correct.
  *       2.Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
  *
  */
object SingleNumberIII {
  def main(args: Array[String]): Unit = {
    val nums = Array(1, 2, 1, 3, 2, 5)
    println(singleNumber(nums).mkString(","))
    println(singleNumberByBits(nums).mkString(","))
  }

  /** **
    * 30 / 30 test cases passed.
    * Status: Accepted
    * Runtime: 572 ms
    * Memory Usage: 52.1 MB
    *
    * @param nums
    * @return
    */
  def singleNumber(nums: Array[Int]): Array[Int] = {
    val result = scala.collection.mutable.HashMap[Int, Int]()
    nums.foreach { i => result(i) = result.getOrElse(i, 2) - 1 }
    result.keySet.filter(key => result(key) == 1).toArray

  }

  /** *
    * 30 / 30 test cases passed.
    * Status: Accepted
    * Runtime: 876 ms
    * Memory Usage: 69 MB
    *
    * @param nums
    * @return
    */
  def singleNumberByBits(nums: Array[Int]): Array[Int] = {
    val difference = Integer.highestOneBit(nums.reduce(_ ^ _))
    val result = Array(0, 0)
    nums foreach { num => result(if ((difference & num) == 0) 0 else 1) ^= num }
    result
  }
}
