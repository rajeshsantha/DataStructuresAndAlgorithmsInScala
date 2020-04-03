package com.concept.scala.leetcode30days

object MaximumSubarray {

  /**
    * 202 / 202 test cases passed.
    * Status: Accepted
    * Runtime: 488 ms
    * Memory Usage: 51.6 MB
    *
    * @param nums
    * @return maxSurArraySum
    */
  def maxSubArray (nums: Array[Int]): Int = {
    var max: Long = nums(0)
    var current: Long = nums(0)

    for (i <- 1 until nums.length) {
      current = Math.max(current + nums(i), nums(i))
      max = Math.max(current, max)
    }
    max.toInt
  }

  /*def maxSubArray_Funtional (nums: Array[Int]): Int = {

  }*/
    def main (args: Array[String]): Unit = {
    val arr = Array(-2, 1, -3, 4, -1, 2, 1, -5, 4)
    println(maxSubArray(arr))
  }
}
