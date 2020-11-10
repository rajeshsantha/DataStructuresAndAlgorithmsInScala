package com.concept.scala.leetcode_30days_challenge_November2020

/** **
  *
  * Day 10
  *
  * @todo Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.
  *       To flip an image horizontally means that each row of the image is reversed.  For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].
  *       To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].
  * @example Example 1:
  *
  *          Input: [[1,1,0],[1,0,1],[0,0,0]]
  *          Output: [[1,0,0],[0,1,0],[1,1,1]]
  *          Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
  *          Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
  *          Example 2:
  *
  *          Input: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
  *          Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
  *          Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
  *          Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
  * @note 1 <= A.length = A[0].length <= 20
  *       0 <= A[i][j] <= 1
  * @see https://leetcode.com/explore/challenge/card/november-leetcoding-challenge/565/week-2-november-8th-november-14th/3526/
  *      OR
  *      https://leetcode.com/problems/flipping-an-image/
  *
  */
object FlippingAnImage {

  val invert: Int => Int = {
    case 1 => 0
    case _ => 1
  }

  /** *
    * 82 / 82 test cases passed.
    * Status: Accepted
    * Runtime: 508 ms
    * Memory Usage: 52.9 MB
    *
    */
  def flipAndInvertImage(A: Array[Array[Int]]): Array[Array[Int]] = A.map(_.reverse.map(invert))

  // or  A.map(_.map(_ ^ 1).reverse)

}
