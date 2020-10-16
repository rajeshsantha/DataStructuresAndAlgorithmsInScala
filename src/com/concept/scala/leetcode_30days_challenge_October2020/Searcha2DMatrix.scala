package com.concept.scala.leetcode_30days_challenge_October2020

import scala.annotation.tailrec

/** *
 * Day 16
 *
 * @todo Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *       Integers in each row are sorted from left to right.
 *       The first integer of each row is greater than the last integer of the previous row.
 * @example Example 1:
 *
 *
 *          Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 3
 *          Output: true
 *          Example 2:
 *
 *
 *          Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 13
 *          Output: false
 *          Example 3:
 *
 *          Input: matrix = [], target = 0
 *          Output: false
 * @note m == matrix.length
 *       n == matrix[i].length
 *       0 <= m, n <= 100
 *       -104 <= matrix[i][j], target <= 104
 * @see https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/561/week-3-october-15th-october-21st/3497/
 *      OR
 *      https://leetcode.com/problems/search-a-2d-matrix
 *
 */
object Searcha2DMatrix {
  def main(args: Array[String]): Unit = {
    println(searchMatrix(Array(Array(1, 3, 5, 7), Array(10, 11, 16, 20), Array(23, 30, 34, 50)), 20))
    println(searchMatrix(Array(Array(1, 3, 5, 7), Array(10, 11, 16, 20), Array(23, 30, 34, 50)), 55))
    println()
    println(searchMatrix2(Array(Array(1, 3, 5, 7), Array(10, 11, 16, 20), Array(23, 30, 34, 50)), 20))
    println(searchMatrix2(Array(Array(1, 3, 5, 7), Array(10, 11, 16, 20), Array(23, 30, 34, 50)), 55))
  }

  /** *
   * 135 / 135 test cases passed.
   * Status: Accepted
   * Runtime: 504 ms
   * Memory Usage: 51.2 MB
   *
   */
  def searchMatrix(matrix: Array[Array[Int]], target: Int): Boolean = matrix exists (_.contains(target))

  def searchMatrix2(matrix: Array[Array[Int]], target: Int): Boolean = {
    lazy val len = matrix.length * matrix.head.length //lazy because need to be fail-safe for empty array.

    matrix.length != 0 && len != 0 && binarySearch(target, 0, len)(matrix)
  }

  @tailrec
  def binarySearch(target: Int, left: Int, right: Int)(implicit M: Array[Array[Int]]): Boolean = {
    val mid = (left + right) / 2
    if (left + 1 == right) arr(left) == target
    else if (target < arr(mid)) binarySearch(target, left, mid)
    else binarySearch(target, mid, right)
  }

  def arr(index: Int)(implicit nums: Array[Array[Int]]): Int = {
    val len = nums.head.length
    nums(index / len)(index % len)
  }


}
