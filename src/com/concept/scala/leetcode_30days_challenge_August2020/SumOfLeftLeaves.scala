package com.concept.scala.leetcode_30days_challenge_August2020

import com.concept.scala.leetcode_30days_challenge_June2020.SearchInBinarySearchTree.TreeNode

/** *
  *
  * day 24
  *
  * @todo Find the sum of all left leaves in a given binary tree
  * @example 3
  *          / \
  *          9  20
  *          /  \
  *          15   7
  *          There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
  * @see https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/552/week-4-august-22nd-august-28th/3435/
  *      OR
  *      https://leetcode.com/problems/sum-of-left-leaves/
  *
  */

object SumOfLeftLeaves {
  /** *
    * 102 / 102 test cases passed.
    * Status: Accepted
    * Runtime: 496 ms
    * Memory Usage: 50.8 MB
    *
    */
  def sumOfLeftLeaves(root: TreeNode): Int = {
    sumLeftRefactored(root, isLeft = false)
  }

  def sumLeft(root: TreeNode, isLeft: Boolean): Int = {
    root match {
      case _ if root == null => 0
      case _ if root.left == null && root.right == null =>
        isLeft match {
          case true => root.value
          case false => 0
        }
      case _ => sumLeft(root.left, isLeft = true) + sumLeft(root.right, isLeft = false)
    }
  }

  def sumLeftRefactored(root: TreeNode, isLeft: Boolean): Int = {
    root match {
      case NullNode() => 0
      case NotNullNode() =>
        isLeft match {
          case true => root.value
          case false => 0
        }
      case _ => sumLeft(root.left, isLeft = true) + sumLeft(root.right, isLeft = false)
    }
  }

  def main(args: Array[String]): Unit = {
    val root: TreeNode = new TreeNode(3)
    root.left = new TreeNode(9)
    root.right = new TreeNode(20)
    root.right.right = new TreeNode(7)
    root.right.left = new TreeNode(15)

    println(sumOfLeftLeaves(root))
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
object NullNode {
  def unapply(node: TreeNode): Boolean = node == null
}

object NotNullNode {
  def unapply(node: TreeNode): Boolean = node.left == null && node.right == null
}

object NodeValueEvaluator {
  def unapply(isLeftFlag: Boolean, node: TreeNode): Int = if (isLeftFlag) node.value else 0
}
