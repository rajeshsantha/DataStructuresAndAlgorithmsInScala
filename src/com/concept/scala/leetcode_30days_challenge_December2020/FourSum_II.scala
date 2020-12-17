package com.concept.scala.leetcode_30days_challenge_December2020

/** **
  * Day 17
  *
  * @todo Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.
  *       To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.
  * @example Input:
  *          A = [ 1, 2]
  *          B = [-2,-1]
  *          C = [-1, 2]
  *          D = [ 0, 2]
  *
  *          Output:
  *          2
  *
  *          Explanation:
  *          The two tuples are:
  *     1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
  *     2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
  * @see https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/571/week-3-december-15th-december-21st/3569/
  *      OR
  *      https://leetcode.com/problems/4sum-ii/
  *
  *
  *
  *
  */
object FourSum_II {

  /**
    * 48 / 48 test cases passed.
    * Status: Accepted
    * Runtime: 1976 ms
    * Memory Usage: 151.2 MB
    *
    * @param a array1
    * @param b array2
    * @param c array3
    * @param d array4
    * @return number of zero sums
    */
  def fourSumCount(a: Array[Int], b: Array[Int], c: Array[Int], d: Array[Int]): Int = {
    val sumOfAB = for (i <- a; j <- b) yield i + j
    val sumOfCountAB = sumOfAB.groupBy(identity).map { case (sum: Int, array: Array[Int]) => (sum, array.length) }
    val result = {
      for (k <- c; l <- d) yield sumOfCountAB.getOrElse(-k - l, 0)
    }.sum
    result
  }

  def main(args: Array[String]): Unit = {
    val (a, b, c, d) =
      (Array(1, 2),
        Array(-2, -1),
        Array(-1, 2),
        Array(0, 2))
    println(fourSumCount(a, b, c, d))
  }
}
