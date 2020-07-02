package com.concept.scala.leetcode_30days_challenge_July2020

import com.concept.scala.leetcode_30days_challenge_June2020.SearchInBinarySearchTree.TreeNode

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/** **
  *
  * Day 2
  *
  * @todo Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
  * @example For example:
  *          Given binary tree [3,9,20,null,null,15,7],
  *          3
  *          / \
  *          9  20
  *          /  \
  *          15   7
  *          return its bottom-up level order traversal as:
  *          [
  *          [15,7],
  *          [9,20],
  *          [3]
  *          ]
  * @see https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/544/week-1-july-1st-july-7th/3378/
  *      OR
  *      https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
  *
  *
  *
  */
object BinaryTreeLevelOrderTraversalII {
  def main(args: Array[String]): Unit = {

    val arr = Array(3, 9, 20, null, null, 15, 7)
    val root = new TreeNode(3)
    root.left = new TreeNode(9)
    root.right = new TreeNode(20)
    root.right.left = new TreeNode(15)
    root.right.right = new TreeNode(7)

    println(levelOrderBottom(root))
  }

  /** **
    *
    * 34 / 34 test cases passed.
    * Status: Accepted
    * Runtime: 496 ms
    * Memory Usage: 51.2 MB
    *
    */
  def levelOrderBottom(root: TreeNode): List[List[Int]] = {
    import scala.collection.mutable.ListBuffer
    val result = ListBuffer[ListBuffer[Int]]()

    def dfsHelper(node: TreeNode, depth: Int, result: ListBuffer[ListBuffer[Int]]): Unit = {

      if (node == null) return
      println(s"result.size = ${result.size}    depth = $depth   ${if (result.size == depth) "same level" else "diff"} - Traversing the value ${node.value}")
      if (result.size <= depth) result append ListBuffer(node.value) else result(depth) append node.value

      dfsHelper(node.left, depth + 1, result)
      dfsHelper(node.right, depth + 1, result)
    }

    dfsHelper(root, 0, result)

    result.map(_.toList).toList.reverse
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
