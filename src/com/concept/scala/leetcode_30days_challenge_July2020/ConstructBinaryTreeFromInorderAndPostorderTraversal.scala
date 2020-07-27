package com.concept.scala.leetcode_30days_challenge_July2020

import com.concept.scala.leetcode_30days_challenge_June2020.SearchInBinarySearchTree.TreeNode


/** *
  *
  * Day 27
  *
  * @todo Given inorder and postorder traversal of a tree, construct the binary tree.
  * @note You may assume that duplicates do not exist in the tree.
  * @example example, given
  *
  *          inorder = [9,3,15,20,7]
  *          postorder = [9,15,7,20,3]
  *          Return the following binary tree:
  *
  *          3
  *          / \
  *          9  20
  *          /  \
  *          15   7
  * @see https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/547/week-4-july-22nd-july-28th/3403/
  *      OR
  *      https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
  *
  *
  */
object ConstructBinaryTreeFromInorderAndPostorderTraversal {

  /** *
    * 203 / 203 test cases passed.
    * Status: Accepted
    * Runtime: 604 ms
    * Memory Usage: 52.1 MB
    *
    */
  def buildTree(inorder: Array[Int], postorder: Array[Int]): TreeNode = {
    val N = inorder.length
    val inorderInvertedIndex = new java.util.HashMap[Int, Int](N)
    for (i <- 0 until N) inorderInvertedIndex.put(inorder(i), i)
    buildTreeRec(inorder, postorder, 0, N - 1, 0, N - 1, inorderInvertedIndex)
  }

  def buildTreeRec(inorder: Array[Int], postorder: Array[Int], inorderLeft: Int, inorderRight: Int, postorderL: Int, postorderR: Int, inorderInvertedIndex: java.util.HashMap[Int, Int]): TreeNode = {
    if (inorderLeft > inorderRight) return null
    val rootValue = postorder(postorderR)
    val root = new TreeNode(rootValue)
    val inorderRootIndex = inorderInvertedIndex.get(rootValue)
    val rightTreeLength = inorderRight - inorderRootIndex
    val rootLength = 1
    root.right = buildTreeRec(inorder, postorder, inorderRootIndex + rootLength, inorderRight, postorderR - rightTreeLength, postorderR - rootLength, inorderInvertedIndex)
    root.left = buildTreeRec(inorder, postorder, inorderLeft, inorderRootIndex - rootLength, postorderL, postorderR - rightTreeLength - rootLength, inorderInvertedIndex)
    root
  }
}
