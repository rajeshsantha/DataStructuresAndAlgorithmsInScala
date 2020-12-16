package com.concept.scala.leetcode_30days_challenge_December2020

import com.concept.scala.leetcode_30days_challenge_April2020.TreeNode

import scala.collection.mutable

/** *
  *
  * Day 3
  *
  * @todo Given the root of a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only one right child.
  * @example Example 1:
  *
  *
  *          Input: root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
  *          Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
  *          Example 2:
  *
  *
  *          Input: root = [5,1,7]
  *          Output: [1,null,5,null,7]
  * @note The number of nodes in the given tree will be in the range [1, 100].
  *       0 <= Node.val <= 1000
  * @see https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/569/week-1-december-1st-december-7th/3553/
  *      OR
  *      https://leetcode.com/problems/increasing-order-search-tree/
  *
  */
object IncreasingOrderSearchTree {
  /** *
    *
    * 37 / 37 test cases passed.
    * Status: Accepted
    * Runtime: 612 ms
    * Memory Usage: 67.4 MB
    *
    *
    */
  def increasingBST(root: TreeNode): TreeNode = {
    var mutableRoot = root
    val stack = mutable.Stack[TreeNode]()
    stack.push(mutableRoot)
    val dummyRoot = new TreeNode(0)
    var current = dummyRoot
    mutableRoot = mutableRoot.left
    while (stack.nonEmpty || mutableRoot != null) {

      while (mutableRoot != null) {
        stack.push(mutableRoot)
        mutableRoot = mutableRoot.left
      }
      val temp = stack.pop()
      current.right = new TreeNode(temp.value)
      current = current.right

      if (temp.right != null) mutableRoot = temp.right;
    }

    dummyRoot.right

  }

  def increasingBST_recursive(root: TreeNode): TreeNode = {
    if (root == null) null
    else if (root.left == null && root.right == null) {
      new TreeNode(root.value, null, null)
    } else if (root.left == null) {
      val rightI = increasingBST(root.right)
      new TreeNode(root.value, null, rightI)
    } else if (root.right == null) {
      val leftI = increasingBST(root.left)
      val currI = new TreeNode(root.value, null, null)
      addToRight(leftI, currI)
    } else {
      val leftI = increasingBST(root.left)
      val rightI = increasingBST(root.right)
      val currI = new TreeNode(root.value, null, rightI)
      addToRight(leftI, currI)
    }

  }

  def addToRight(root: TreeNode, tree: TreeNode): TreeNode = {
    if (root == null) null
    else if (root.right == null) new TreeNode(root.value, root.left, tree)
    else new TreeNode(root.value, root.left, addToRight(root.right, tree))
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
