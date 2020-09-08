package com.concept.scala.leetcode_30days_challenge_September2020

import com.concept.scala.leetcode_30days_challenge_April2020.TreeNode

/** **
  *
  * Day 8
  *
  * @todo Given a binary tree, each node has value 0 or 1.  Each root-to-leaf path represents a binary number starting with the most significant bit.  For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.
  *       For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.
  *       Return the sum of these numbers.
  * @example Example 1:
  *
  *          Input: [1,0,1,0,1,0,1]
  *          Output: 22
  *          Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
  * @note Note:
  *
  *       1.The number of nodes in the tree is between 1 and 1000.
  *       2.node.val is 0 or 1.
  *       3.The answer will not exceed 2 pow 31 - 1.
  *
  *
  */
object SumOfRootToLeafBinaryNumbers {

  /**
    * 63 / 63 test cases passed.
    * Status: Accepted
    * Runtime: 468 ms
    * Memory Usage: 51.1 MB
    *
    */
  def sumRootToLeaf(root: TreeNode): Int = helper(0, root)


  def helper(current: Int, node: TreeNode): Int = {
    var cur = current
    if (node == null) return 0
    cur <<= 1
    if (node.value == 1) cur += 1
    if (node.left == null && node.right == null) return cur
    helper(cur, node.left) + helper(cur, node.right)
  }
}

/**
  * Definition for a binary tree node.
  * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  * var value: Int = _value
  * var left: TreeNode = _left
  * var right: TreeNode = _right
  * }
  */