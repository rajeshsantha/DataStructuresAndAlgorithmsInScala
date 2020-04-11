package com.concept.scala.leetcode30days

/** *
  *
  * Day 11
  *
  * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
  *
  * Example:
  * Given a binary tree
  * 1
  * / \
  * 2   3
  * / \
  * 4   5
  * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
  *
  * Note: The length of path between two nodes is represented by the number of edges between them.
  *
  * 106 / 106 test cases passed.(diameterOfBinaryTree_Solution1)
  * Status: Accepted
  * Runtime: 0 ms
  * Memory Usage: 39.4 MB
  *
  *
  */
// Definition for a binary tree node.
class TreeNode (var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object DiameterofBinaryTree {

  var diameter_max = 0

  def diameterOfBinaryTree_Solution1 (root: TreeNode): Int = {
    height(root);
    diameter_max;
  }

  // java eq
  def height (node: TreeNode): Int = {
    if (node == null) return -1

    if (node == null) {
      return -1
    }
    val left = height(node.left)
    val right = height(node.right)
    diameter_max = Math.max(diameter_max, left + right + 2)
    Math.max(left, right) + 1

  }


  def diameterOfBinaryTree (root: TreeNode): Int = {
    if (root == null) 0
    else
      maxDepth(root.left) + maxDepth(root.right)
  }

  def maxDepth (root: TreeNode): Int = {
    if (root == null) 0
    else
      math.max(depthleftCounter(root, 0), rightDepthCounter(root, 0))

  }


  def depthleftCounter (node: TreeNode, depthLCount: Int): Int = {
    if (node == null) depthLCount
    else
      depthleftCounter(node.left, depthLCount + 1)

  }

  def rightDepthCounter (node: TreeNode, depthRCount: Int): Int = {
    if (node == null) depthRCount
    else
      rightDepthCounter(node.right, depthRCount + 1)

  }


}