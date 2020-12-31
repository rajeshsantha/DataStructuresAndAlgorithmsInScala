package com.concept.scala.leetcode_30days_challenge_December2020

import com.concept.scala.leetcode_30days_challenge_April2020.TreeNode

/**
  * Day 22
  *
  * @todo Given a binary tree, determine if it is height-balanced.
  *       For this problem, a height-balanced binary tree is defined as:
  *       a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
  * @example Example 1:
  *
  *
  *          Input: root = [3,9,20,null,null,15,7]
  *          Output: true
  *          Example 2:
  *
  *
  *          Input: root = [1,2,2,3,3,null,null,4,4]
  *          Output: false
  *          Example 3:
  *
  *          Input: root = []
  *          Output: true
  * @note The number of nodes in the tree is in the range [0, 5000].
  *       -10 4 <= Node.val <= 10 4
  * @see https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/572/week-4-december-22nd-december-28th/3577/
  *   OR
  *     https://leetcode.com/problems/balanced-binary-tree/
  *
  */
object BalancedBinaryTree {

  /**
    * 228 / 228 test cases passed.
    * Status: Accepted
    * Runtime: 540 ms
    * Memory Usage: 51.9 MB
    *
    * @param root root node
    * @return true if tree is balanced
    */
  def isBalanced(root: TreeNode): Boolean = root match {
    case null => true
    case _ => isBalanced(root.left) && isBalanced(root.right) && (math.abs(findDepth(root.left) - findDepth(root.right)) <= 1)
  }

  def findDepth(root: TreeNode): Int = root match {
    case null => 0
    case node if node.left == null && node.right == null => 1
    case _ => math.max(findDepth(root.left), findDepth(root.right)) + 1
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
