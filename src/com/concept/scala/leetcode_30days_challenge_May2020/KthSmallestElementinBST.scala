package com.concept.scala.leetcode_30days_challenge_May2020

import scala.collection.mutable.ListBuffer

/** *
  * Day 20
  *
  * @see https://leetcode.com/problems/kth-smallest-element-in-a-bst/  (230. Kth Smallest Element in a BST)
  *      OR
  *      https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3335/
  *
  *
  *      Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
  *
  *      Note:
  *      You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
  *
  *      Example 1:
  *
  *      Input: root = [3,1,4,null,2], k = 1
  *      3
  *      / \
  *      1   4
  *      \
  *      2
  *      Output: 1
  *      Example 2:
  *
  *      Input: root = [5,3,6,2,4,null,null,1], k = 3
  *      5
  *      / \
  *      3   6
  *      / \
  *      2   4
  *      /
  *      1
  *      Output: 3
  *      Follow up:
  *      What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
  *
  *
  */
object KthSmallestElementinBST {
  def main (args: Array[String]): Unit = {

  }

  /** **
    *
    * 91 / 91 test cases passed.
    * Status: Accepted
    * Runtime: 656 ms
    * Memory Usage: 53.5 MB
    *
    */
  def inorder (root: BinaryTreeNode, arr: ListBuffer[Int]): ListBuffer[Int] = {
    if (root == null) return arr
    inorder(root.left, arr)
    arr.append(root.value)
    inorder(root.right, arr)
    arr
  }

  def kthSmallest (root: BinaryTreeNode, k: Int): Int = inorder(root, new ListBuffer[Int])(k - 1)

}

/**
  * Definition for a binary tree node.
  * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  * var value: Int = _value
  * var left: TreeNode = _left
  * var right: TreeNode = _right
  * }
  */