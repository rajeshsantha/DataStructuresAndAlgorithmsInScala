package com.concept.scala.leetcode_30days_challenge_June2020

import java.io.PrintStream

import com.concept.scala.leetcode_30days_challenge_June2020.SearchInBinarySearchTree.TreeNode
import scala.collection.mutable.ListBuffer

import scala.collection.mutable


/** **
  * Day 26
  *
  * @todo Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
  *       An example is the root-to-leaf path 1->2->3 which represents the number 123.
  *       Find the total sum of all root-to-leaf numbers.
  *       Note: A leaf is a node with no children.
  * @example Input: [1,2,3]
  *          1
  *          / \
  *          2   3
  *          Output: 25
  *          Explanation:
  *          The root-to-leaf path 1->2 represents the number 12.
  *          The root-to-leaf path 1->3 represents the number 13.
  *          Therefore, sum = 12 + 13 = 25.
  *          Example 2:
  *
  *          Input: [4,9,0,5,1]
  *          4
  *          / \
  *          9   0
  *          / \
  *          5   1
  *          Output: 1026
  *          Explanation:
  *          The root-to-leaf path 4->9->5 represents the number 495.
  *          The root-to-leaf path 4->9->1 represents the number 491.
  *          The root-to-leaf path 4->0 represents the number 40.
  *          Therefore, sum = 495 + 491 + 40 = 1026.
  * @see https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/542/week-4-june-22nd-june-28th/3372/
  *      OR
  *      https://leetcode.com/problems/sum-root-to-leaf-numbers/
  *
  *
  *
  *
  */
object SumRootToLeafNumbers {

  def main(args: Array[String]): Unit = {
    val root = new TreeNode(4)
    root.left = new TreeNode(9)
    root.right = new TreeNode(0)
    root.left.left = new TreeNode(5)
    root.left.right = new TreeNode(1)
    //    println(sumNumbers(root))
    println(sumNumbersByDFS2(root))
    val root2 = new TreeNode(1)
    root2.left = new TreeNode(0)
    println(sumNumbers_ByDFS1(root2))
    println(sumNumbersByDFS2(root2))

  }

  /** *
    * Runtime: 648 ms, faster than 11.11% of Scala online submissions for Sum Root to Leaf Numbers.
    * Memory Usage: 64.2 MB, less than 12.50% of Scala online submissions for Sum Root to Leaf Numbers.
    *
    * 110 / 110 test cases passed.
    * Status: Accepted
    * Runtime: 648 ms
    * Memory Usage: 64.2 MB
    *
    */
  def sumNumbers_ByDFS1(root: TreeNode): Int = {
    var result = 0

    def helper(root: TreeNode, sum: Int): Int = {
      root match {
        case null => return sum
        case x if (x.left == null && x.right == null) => sum * 10 + root.value
        case x if root.right == null => helper(root.left, sum * 10 + root.value)
        case x if root.left == null => helper(root.right, sum * 10 + root.value)
        case _ => helper(root.left, sum * 10 + root.value) + helper(root.right, sum * 10 + root.value)
      }
    }

    helper(root, 0)
  }

  /** *
    * Runtime: 496 ms, faster than 22.22% of Scala online submissions for Sum Root to Leaf Numbers.
    * Memory Usage: 50.7 MB, less than 37.50% of Scala online submissions for Sum Root to Leaf Numbers.
    *
    * 110 / 110 test cases passed.
    * Status: Accepted
    * Runtime: 496 ms
    * Memory Usage: 50.7 MB
    *
    */
  def sumNumbersByDFS2(root: TreeNode): Int = {

    def helperDepthFirstSearch(root: TreeNode, currentValue: Int, result: ListBuffer[Int]): ListBuffer[Int] = {
      if (root == null) return result
      val newValue = currentValue * 10 + root.value
      if (root.left == null && root.right == null) result += newValue

      helperDepthFirstSearch(root.left, newValue, result)
      helperDepthFirstSearch(root.right, newValue, result)
      result
    }

    helperDepthFirstSearch(root, 0, ListBuffer[Int]()).sum
  }


}