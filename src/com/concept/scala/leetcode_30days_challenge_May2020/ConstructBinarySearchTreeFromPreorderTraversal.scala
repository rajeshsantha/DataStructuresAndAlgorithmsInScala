package com.concept.scala.leetcode_30days_challenge_May2020

import com.concept.scala.RunTimeCalculation

/** ****
  * Day 24
  *
  * @see https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3339/
  *      OR
  *      https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
  *
  *
  *
  *      Return the root node of a binary search tree that matches the given preorder traversal.
  *
  *      (Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)
  *
  *      It's guaranteed that for the given test cases there is always possible to find a binary search tree with the given requirements.
  *
  *      Example 1:
  *
  *      Input: [8,5,1,7,10,12]
  *      Output: [8,5,10,1,7,null,12]
  *
  *
  *
  *      Constraints:
  *
  *      1 <= preorder.length <= 100
  *      1 <= preorder[i] <= 10 ^^ 8
  *      The values of preorder are distinct
  *
  *
  *
  *
  *
  */
object ConstructBinarySearchTreeFromPreorderTraversal {


  def main(args: Array[String]): Unit = {

    val array = "[8,5,1,7,10,12]".replace("[", "").replace("]", "").split(",").map(_.toInt)
    val totalRuntime = RunTimeCalculation.calculateRunTime {
      bstFromPreorder(array)
    }
    println(s" \n total run time =  $totalRuntime seconds OR ${totalRuntime * 1000} milliseonds")
    // total run time =  0.028 seconds OR 28.0 milliseonds
  }

  /** **
    *
    * Runtime: 476 ms, faster than 57.80% of Scala online submissions for Construct Binary Search Tree from Preorder Traversal.
    * Memory Usage: 50.7 MB, less than 100.00% of Scala online submissions for Construct Binary Search Tree from Preorder Traversal.    *
    *
    *
    * 110 / 110 test cases passed.
    * Status: Accepted
    * Runtime: 492 ms
    * Memory Usage: 50.8 MB
    *
    */
  //def helper(preorder: Array[Int], n: Int, position: Int, currentNode: BinaryTreeNode, left: Int, right: Int): Int = ???

  def bstFromPreorder(preorder: Array[Int]): BinaryTreeNode = {
    helper(preorder, 0, preorder.length - 1)
  }

 def helper(preorder: Array[Int], start: Int, end: Int): BinaryTreeNode = {
    import util.control.Breaks._
    if (start > end) return null // if not sorted , don't do anything
    val node = new BinaryTreeNode(preorder(start))
    var i = start

    breakable {
      while (i <= end) {
        if (preorder(i) > node.value)
          break
        i += 1
      }
    }
    node.left = helper(preorder, start + 1, i - 1)
    node.right = helper(preorder, i, end)

    node
  }


}

/*
class BinaryTreeNode(_value: Int = 0, _left: BinaryTreeNode = null, _right: BinaryTreeNode = null) {
  var value: Int = _value
  var left: BinaryTreeNode = _left
  var right: BinaryTreeNode = _right
}*/
/*
OR

 class TreeNode(var _value: Int) {
   var value: Int = _value
   var left: TreeNode = null
   var right: TreeNode = null
    }
 */