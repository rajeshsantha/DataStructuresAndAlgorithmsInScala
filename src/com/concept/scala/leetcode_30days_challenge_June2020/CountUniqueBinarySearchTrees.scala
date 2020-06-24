package com.concept.scala.leetcode_30days_challenge_June2020

/** *
  *
  * Day 24
  *
  * @see https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/542/week-4-june-22nd-june-28th/3370/
  *      OR
  *      https://leetcode.com/problems/unique-binary-search-trees/
  *
  *
  *      iven n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
  *
  *      Example:
  *
  *      Input: 3
  *      Output: 5
  *      Explanation:
  *      Given n = 3, there are a total of 5 unique BST's:
  *
  *      1         3     3      2      1
  *      \       /     /      / \      \
  *      3     2     1      1   3      2
  *      /     /       \                 \
  *      2     1         2                 3
  *
  *
  */
object CountUniqueBinarySearchTrees {
  def main (args: Array[String]): Unit = {
    println(numTrees(3))
    println(numTrees(5))
  }

  /** *
    * Runtime: 392 ms, faster than 50.00% of Scala online submissions for Unique Binary Search Trees.
    * Memory Usage: 48.6 MB, less than 50.00% of Scala online submissions for Unique Binary Search Trees.
    *
    * 19 / 19 test cases passed.
    * Status: Accepted
    * Runtime: 392 ms
    * Memory Usage: 48.6 MB
    *
    */
  def numTrees (n: Int): Int = {
    val arr = Array.ofDim[Int](n + 1)
    arr(0) = 1
    arr(1) = 1
    for (i <- 2 to n; j <- 0 until i) arr(i) += arr(j) * arr(i - j - 1)

    arr.last
  }

}
