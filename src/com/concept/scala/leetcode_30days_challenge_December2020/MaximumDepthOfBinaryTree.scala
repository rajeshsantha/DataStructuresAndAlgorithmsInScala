package com.concept.scala.leetcode_30days_challenge_December2020

import com.concept.scala.leetcode_30days_challenge_April2020.TreeNode

/** *
  *
  * Day 1
  *
  * @todo Given the root of a binary tree, return its maximum depth.
  *       A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
  * @example Example 1:
  *
  *
  *          Input: root = [3,9,20,null,null,15,7]
  *          Output: 3
  *          Example 2:
  *
  *          Input: root = [1,null,2]
  *          Output: 2
  *          Example 3:
  *
  *          Input: root = []
  *          Output: 0
  *          Example 4:
  *
  *          Input: root = [0]
  *          Output: 1
  * @note The number of nodes in the tree is in the range [0, 104].
  *       -100 <= Node.val <= 100
  * @see https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/569/week-1-december-1st-december-7th/3551/
  *      OR
  *      https://leetcode.com/problems/maximum-depth-of-binary-tree/
  *
  *
  */
object MaximumDepthOfBinaryTree {


  /** *
    *
    * 39 / 39 test cases passed.
    * Status: Accepted
    * Runtime: 492 ms
    * Memory Usage: 52.2 MB
    */
  def maxDepth(root: TreeNode): Int = {
    if (root == null) 0
    else 1 + Math.max(maxDepth(root.left), maxDepth(root.right))
  }
}
