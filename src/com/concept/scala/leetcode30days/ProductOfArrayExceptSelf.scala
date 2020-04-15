package com.concept.scala.leetcode30days

/** *
  * Day 15
  *
  * @see https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/530/week-3/3300/
  *
  *      Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
  *
  *      Example:
  *
  *      Input:  [1,2,3,4]
  *      Output: [24,12,8,6]
  *      Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.
  *
  *      Note: Please solve it without division and in O(n).
  *
  *      Follow up:
  *      Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
  *
  *
  *      Runtime: 592 ms, faster than 36.67% of Scala online submissions for Product of Array Except Self.
  *      Memory Usage: 55.5 MB, less than 100.00% of Scala online submissions for Product of Array Except Self.
  *
  *      18 / 18 test cases passed.
  *      Status: Accepted
  *      Runtime: 592 ms
  *      Memory Usage: 55.5 MB
  *
  */
object ProductOfArrayExceptSelf {

  def main(args: Array[String]): Unit = {
    val nums = Array(4, 5, 1, 8, 2)
    println(s"Input = ${nums.mkString(",")}  ====> ${productExceptSelf(nums).mkString(",")}")
    println(s"Input = ${nums.mkString(",")}  ====> ${productExceptSelf_functional(nums).mkString(",")}")
  }

  def productExceptSelf_functional(nums: Array[Int]): Array[Int] = {


    nums.indices.map(x => (nums.zipWithIndex filter { case (_, index) => index != x }).unzip._1 product) toArray


  }

  def productExceptSelf(nums: Array[Int]): Array[Int] = {
    val length = nums.length
    if (length == 0 || length == 1) return nums
    if (length == 2) return nums.reverse

    val leftArr = Array.tabulate[Int](length)(_ => 1)
    val rightArr = Array.tabulate[Int](length)(_ => 1)
    val outputArr = Array.tabulate[Int](length)(_ => 1)

    leftArr(0) = 1
    rightArr(length - 1) = 1

    for (i <- nums.indices if i != 0) {
      leftArr(i) = nums(i - 1) * leftArr(i - 1)
    }

    for (i <- length - 2 to 0 by -1) {
      rightArr(i) = nums(i + 1) * rightArr(i + 1)
    }

    for (i <- 0 until length) {
      outputArr(i) = leftArr(i) * rightArr(i)
    }
    outputArr
  }


}
