package com.concept.scala.leetcode_30days_challenge_June2020

import scala.annotation.tailrec

/** **
  *
  * Day 15
  *
  * @see https://leetcode.com/problems/search-in-a-binary-search-tree/
  *      OR
  *      https://leetcode.com/explore/featured/card/june-leetcoding-challenge/541/week-3-june-15th-june-21st/3361/
  *
  *
  *      Given the root node of a binary search tree (BST) and a value. You need to find the node in the BST that the node's value equals the given value. Return the subtree rooted with that node. If such node doesn't exist, you should return NULL.
  *
  *      For example,
  *
  *      Given the tree:
  *      4
  *      / \
  *      2   7
  *      / \
  *      1   3
  *
  *      And the value to search: 2
  *      You should return this subtree:
  *
  *      2
  *      / \
  *      1   3
  *      In the example above, if we want to search the value 5, since there is no node with value 5, we should return NULL.
  *
  *      Note that an empty tree is represented by NULL, therefore you would see the expected output (serialized tree format) as [], not null
  *
  *
  *
  *
  *
  */
object SearchInBinarySearchTree {
  /** *
    * Runtime: 920 ms, faster than 11.11% of Scala online submissions for Search in a Binary Search Tree.
    * Memory Usage: 185.2 MB, less than 8.33% of Scala online submissions for Search in a Binary Search Tree.
    *
    * 36 / 36 test cases passed.
    * Status: Accepted
    * Runtime: 920 ms
    * Memory Usage: 185.2 MB
    *
    */
  @tailrec
  def searchBST (root: TreeNode, `val`: Int): TreeNode = {
    val target = `val`
    if (root == null) return root
    else if (root.value == target) return root
    else if (target > root.value) searchBST(root.right, target)
    else searchBST(root.left, target)

  }

  /** ***
    *
    * Runtime: 684 ms, faster than 66.67% of Scala online submissions for Search in a Binary Search Tree.
    * Memory Usage: 56.1 MB, less than 29.17% of Scala online submissions for Search in a Binary Search Tree.
    *
    * 36 / 36 test cases passed.
    * Status: Accepted
    * Runtime: 684 ms
    * Memory Usage: 56.1 MB
    *
    *
    */

  @tailrec
  def searchBST_tail (root: TreeNode, `val`: Int): TreeNode = {
    val target = `val`
    val currentValue = root.value
    target match {
      case x if x == currentValue => return root
      case x if x < currentValue => searchBST_tail(root.left, target)
      case x if x > currentValue => searchBST_tail(root.right, target)
      case _ => null
    }

  }

}

class TreeNode (_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}
