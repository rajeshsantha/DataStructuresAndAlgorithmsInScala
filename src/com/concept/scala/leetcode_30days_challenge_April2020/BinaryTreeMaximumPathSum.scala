package com.concept.scala.leetcode_30days_challenge_April2020

/** *
  * Day 28
  *
  * @see https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/532/week-5/3314/
  *
  *      Given a non-empty binary tree, find the maximum path sum.
  *
  *      For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
  *
  *      Example 1:
  *
  *      Input: [1,2,3]
  *
  *      1
  *      / \
  *      2   3
  *
  *      Output: 6
  *      Example 2:
  *
  *      Input: [-10,9,20,null,null,15,7]
  *
  *      -10
  *      / \
  *      9  20
  *      /  \
  *      15   7
  *
  *      Output: 42
  *
  *      93 / 93 test cases passed.
  *      Status: Accepted
  *      Runtime: 776 ms
  *      Memory Usage: 53.5 MB
  *
  *
  *      Runtime: 748 ms, faster than 81.48% of Scala online submissions for Binary Tree Maximum Path Sum.
  *      Memory Usage: 55.6 MB, less than 100.00% of Scala online submissions for Binary Tree Maximum Path Sum.
  *
  *
  */
object BinaryTreeMaximumPathSum {
  def main (args: Array[String]): Unit = {

  }

  var result = 0

  def maxPathSum (root: TreeNode): Int = {
    result = Integer.MIN_VALUE

    if (root == null) return 0
    maxSumValue(root)
    result
  }

  def maxSumValue (root: TreeNode): Int = {
    if (root == null) return 0
    val leftMax = Math.max(0, maxSumValue(root.left))
    val rightMax = Math.max(0, maxSumValue(root.right))
    result = Math.max(result, root.value + leftMax + rightMax)
    return root.value + math.max(leftMax, rightMax)
  }


}


class TreeNode (_value: Int, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

