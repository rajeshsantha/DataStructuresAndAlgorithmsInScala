package com.concept.scala.leetcode_30days_challenge_June2020

import com.concept.scala.leetcode_30days_challenge_April2020.TreeNode

/** **
  * Day 23
  *
  * @see https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/542/week-4-june-22nd-june-28th/3369/
  *      OR
  *      https://leetcode.com/problems/count-complete-tree-nodes
  *
  *      Given a complete binary tree, count the number of nodes.
  *
  *      Note:
  *
  *      Definition of a complete binary tree from Wikipedia:
  *      In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
  *
  *      Example:
  *
  *      Input:
  *         1
  *        /  \
  *       2    3
  *      / \   /
  *      4  5  6
  *
  *      Output: 6
  *
  *
  *
  *
  */
object CountCompleteTreeNodes {


  def main (args: Array[String]): Unit = {
    // val arr = Array(1, 2, 3, 4, 5, 6)
    val root = new TreeNode(1)
    root.left = new TreeNode(2)
    root.right = new TreeNode(3)
    root.left.left = new TreeNode(4)
    root.left.right = new TreeNode(5)
    //root.left.left.left = new TreeNode(1)
    root.right.left = new TreeNode(6)
    //root.right.left.right = new TreeNode(7)
    println(countNodes(root))
  }

  /**
    * Runtime: 868 ms, faster than 93.33% of Scala online submissions for Count Complete Tree Nodes.
    * Memory Usage: 56.2 MB, less than 69.23% of Scala online submissions for Count Complete Tree Nodes.
    *
    *
    * 18 / 18 test cases passed.
    * Status: Accepted
    * Runtime: 868 ms
    * Memory Usage: 56.2 MB
    *
    */
  def countNodes (root: TreeNode): Int = {
    var count = 0

    def helper (root: TreeNode): Int = {
      if (root == null) return count
      count += 1
      helper(root.left)
      helper(root.right)
    }

    helper(root)
    count
  }


}


/*
 class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
   var value: Int = _value
   var left: TreeNode = _left
   var right: TreeNode = _right
 }
*/
