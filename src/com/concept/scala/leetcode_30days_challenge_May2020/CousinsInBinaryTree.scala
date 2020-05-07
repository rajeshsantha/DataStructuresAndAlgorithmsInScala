package com.concept.scala.leetcode_30days_challenge_May2020

/** **
  *
  * Day 7
  *
  * @see https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3322/
  *      OR
  *      https://leetcode.com/problems/cousins-in-binary-tree/
  *
  *
  *      In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
  *
  *      Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
  *
  *      We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
  *
  *      Return true if and only if the nodes corresponding to the values x and y are cousins.
  *
  *
  *
  *      Example 1:
  *
  *
  *      Input: root = [1,2,3,4], x = 4, y = 3
  *      Output: false
  *      Example 2:
  *
  *
  *      Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
  *      Output: true
  *      Example 3:
  *
  *
  *
  *      Input: root = [1,2,3,null,4], x = 2, y = 3
  *      Output: false
  *
  *
  *      Note:
  *
  *      The number of nodes in the tree will be between 2 and 100.
  *      Each node has a unique integer value from 1 to 100.
  *
  *
  *
  *      103 / 103 test cases passed.
  *      Status: Accepted
  *      Runtime: 460 ms
  *      Memory Usage: 50.6 MB
  *
  *      Runtime: 444 ms, faster than 100.00% of Scala online submissions for Cousins in Binary Tree.
  *      Memory Usage: 50.5 MB, less than 100.00% of Scala online submissions for Cousins in Binary Tree
  *
  *
  */
class CousinsInBinaryTree {
  var parentNodex: BinaryTreeNode = null
  var parentNodey: BinaryTreeNode = null
  var heightX = -1
  var heightY = -1


  def isCousins(root: BinaryTreeNode, x: Int, y: Int): Boolean = {

    traverseHelper(root, x, y, null, 0)
    parentNodex != parentNodey && heightX == heightY
  }

  def traverseHelper(currentNode: BinaryTreeNode, x: Int, y: Int, parent: BinaryTreeNode, currentHieght: Int): Boolean = {
    if (currentNode == null) return false
    if (currentNode.value == x) {
      parentNodex = parent
      heightX = currentHieght
    }
    if (currentNode.value == y) {
      parentNodey = parent
      heightY = currentHieght
    }
    traverseHelper(currentNode.left, x, y, currentNode, currentHieght + 1)
    traverseHelper(currentNode.right, x, y, currentNode, currentHieght + 1)
  }
}

object CousinsInBinaryTree {
  def main(args: Array[String]): Unit = {
    //Input: root = [1,2,3,4], x = 4, y = 3
  }
}

