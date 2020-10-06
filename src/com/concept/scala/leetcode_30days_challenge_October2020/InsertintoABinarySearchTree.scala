package com.concept.scala.leetcode_30days_challenge_October2020

import com.concept.scala.leetcode_30days_challenge_April2020.TreeNode

/** *
  *
  * Day 6
  *
  * @todo You are given the root node of a binary search tree (BST) and a value to insert into the tree. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.
  *       Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.
  * @example Example 1:
  *
  *
  *          Input: root = [4,2,7,1,3], val = 5
  *          Output: [4,2,7,1,3,5]
  *          Explanation: Another accepted tree is:
  *
  *          Example 2:
  *
  *          Input: root = [40,20,60,10,30,50,70], val = 25
  *          Output: [40,20,60,10,30,50,70,null,null,25]
  *          Example 3:
  *
  *          Input: root = [4,2,7,1,3,null,null,null,null,null,null], val = 5
  *          Output: [4,2,7,1,3,5]
  * @note The number of nodes in the tree will be in the range [0, 104].
  *       -108 <= Node.val <= 108
  *       All the values Node.val are unique.
  *       -108 <= val <= 108
  *       It's guaranteed that val does not exist in the original BST.
  * @see https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/559/week-1-october-1st-october-7th/3485/
  *      OR
  *      https://leetcode.com/problems/insert-into-a-binary-search-tree
  *
  */
object InsertintoABinarySearchTree {
  /**
    * 35 / 35 test cases passed.
    * Status: Accepted
    * Runtime: 1964 ms
    * Memory Usage: 59.5 MB
    *
    * @param root existing root
    * @param value new node's value
    * @return newly inserted root
    */
  def insertIntoBST_recursive(root: TreeNode, value: Int): TreeNode = {
    if (root == null) return new TreeNode(value)
    else if (root.value < value) root.right = insertIntoBST_recursive(root.right, value)
    else if (root.value > value) root.left = insertIntoBST_recursive(root.left, value)
    root
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