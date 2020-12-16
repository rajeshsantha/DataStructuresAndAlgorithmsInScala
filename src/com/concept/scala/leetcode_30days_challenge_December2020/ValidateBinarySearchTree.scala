package com.concept.scala.leetcode_30days_challenge_December2020

import com.concept.scala.leetcode_30days_challenge_April2020.TreeNode

/** **
  *
  * Day 16
  *
  * @todo Given the root of a binary tree, determine if it is a valid binary search tree (BST).
  *       A valid BST is defined as follows:
  *       The left subtree of a node contains only nodes with keys less than the node's key.
  *       The right subtree of a node contains only nodes with keys greater than the node's key.
  *       Both the left and right subtrees must also be binary search trees.
  * @example Example 1:
  *
  *
  *          Input: root = [2,1,3]
  *          Output: true
  *          Example 2:
  *
  *
  *          Input: root = [5,1,4,null,null,3,6]
  *          Output: false
  *          Explanation: The root node's value is 5 but its right child's value is 4.
  * @note The number of nodes in the tree is in the range [1, 104].
  *       -231 <= Node.val <= 231 - 1
  * @see https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/571/week-3-december-15th-december-21st/3568/
  *      OR
  *      https://leetcode.com/problems/validate-binary-search-tree/
  *
  *
  *
  */
object ValidateBinarySearchTree {
  def isValidBST(root: TreeNode): Boolean = root match {
    case null => return true
    case _ => check(root, Long.MinValue, Long.MaxValue)
  }

  /** *
    * 77 / 77 test cases passed.
    * Status: Accepted
    * Runtime: 520 ms
    * Memory Usage: 52.7 MB
    *
    *
    */
  def check(root: TreeNode, min: Long, max: Long): Boolean = {
    if (root == null) return true
    var ans = (root.value > min) & (root.value < max)
    if (root.left != null) ans &= check(root.left, min, root.value)
    if (root.right != null) ans &= check(root.right, root.value, max)
    ans
  }


  def checkrec(root: TreeNode, min: Long, max: Long): Boolean = {
    root match {
      case null => true
      case root if root.left != null => (root.value > min & root.value < max) & check(root.left, min, root.value)
      case root if root.right != null => (root.value > min & root.value < max) & check(root.right, root.value, max)
    }
  }
  }

/*if (root == null) return true
var ans = (root.value > min) & (root.value < max)
if (root.left != null) ans &= check(root.left, min, root.value)
if (root.right != null) ans &= check(root.right, root.value, max)
ans*/
