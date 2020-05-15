package com.concept.scala.leetcode_30days_challenge_May2020

import com.concept.scala.RunTimeCalculation

/** ***
  *
  * Day 15
  *
  * @see https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3330/
  *      OR
  *      https://leetcode.com/problems/maximum-sum-circular-subarray/
  *
  *
  *
  *
  *      Given a circular array C of integers represented by A, find the maximum possible sum of a non-empty subarray of C.
  *
  *      Here, a circular array means the end of the array connects to the beginning of the array.  (Formally, C[i] = A[i] when 0 <= i < A.length, and C[i+A.length] = C[i] when i >= 0.)
  *
  *      Also, a subarray may only include each element of the fixed buffer A at most once.  (Formally, for a subarray C[i], C[i+1], ..., C[j], there does not exist i <= k1, k2 <= j with k1 % A.length = k2 % A.length.)
  *
  *
  *
  *      Example 1:
  *
  *      Input: [1,-2,3,-2]
  *      Output: 3
  *      Explanation: Subarray [3] has maximum sum 3
  *      Example 2:
  *
  *      Input: [5,-3,5]
  *      Output: 10
  *      Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10
  *      Example 3:
  *
  *      Input: [3,-1,2,-1]
  *      Output: 4
  *      Explanation: Subarray [2,-1,3] has maximum sum 2 + (-1) + 3 = 4
  *      Example 4:
  *
  *      Input: [3,-2,2,-3]
  *      Output: 3
  *      Explanation: Subarray [3] and [3,-2,2] both have maximum sum 3
  *      Example 5:
  *
  *      Input: [-2,-3,-1]
  *      Output: -1
  *      Explanation: Subarray [-1] has maximum sum -1
  *
  *
  *      Note:
  *
  *      -30000 <= A[i] <= 30000
  *      1 <= A.length <= 30000
  *
  *
  *
  *
  */
object MaximumSumCircularSubarray {
  def main (args: Array[String]): Unit = {


    val totalRuntime = RunTimeCalculation.calculateRunTime {
      println(maxSubarraySumCircular(Array(1, -2, 3, -2)))
      println(maxSubarraySumCircular(Array(5, -3, 5)))
      println(maxSubarraySumCircular(Array(3, -1, 2, -1)))
      println(maxSubarraySumCircular(Array(3, -2, 2, -3)))
      println(maxSubarraySumCircular(Array(-2, -3, -1)))

    }

    println(s" total run time = seconds $totalRuntime seconds OR ${totalRuntime * 1000} milliseonds")
    /*
    3
    10
    4
    3
    -1
     total run time = seconds 0.733 seconds OR 733.0 milliseonds

     */
  }

  /** **
    *
    * Runtime: 656 ms, faster than 100.00% of Scala online submissions for Maximum Sum Circular Subarray.
    * Memory Usage: 58.4 MB, less than 100.00% of Scala online submissions for Maximum Sum Circular Subarray.
    *
    *
    * 109 / 109 test cases passed.
    * Status: Accepted
    * Runtime: 656 ms
    * Memory Usage: 58.4 MB
    *
    * @param A
    * @return
    */
  def maxSubarraySumCircular (A: Array[Int]): Int = {
    if (A == null || A.length == 0) return 0

    val len = A.length
    var minSum = 0
    var maxSum = 0
    var sum = 0
    var min = Integer.MAX_VALUE
    var max = Integer.MIN_VALUE
    for (i <- 0 until len) {
      sum += A(i)
      minSum += A(i)
      maxSum += A(i)
      if (minSum < min) min = minSum
      if (maxSum > max) max = maxSum
      if (minSum > 0) minSum = 0
      if (maxSum < 0) maxSum = 0

    }

    if (max < 0) return max

    Math.max(max, sum - min)
  }

}
