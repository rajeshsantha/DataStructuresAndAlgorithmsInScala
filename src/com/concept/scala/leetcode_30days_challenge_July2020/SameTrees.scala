package com.concept.scala.leetcode_30days_challenge_July2020

import scala.collection.mutable._
import com.concept.scala.leetcode_30days_challenge_June2020.SearchInBinarySearchTree.TreeNode

import scala.annotation.tailrec


/** **
  * Day 13
  *
  * @todo Given two binary trees, write a function to check if they are the same or not.
  *       Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
  * @example Example 1:
  *
  *          Input:     1         1
  *          / \       / \
  *          2   3     2   3
  *
  *          [1,2,3],   [1,2,3]
  *
  *          Output: true
  *          Example 2:
  *
  *          Input:     1         1
  *          /           \
  *          2             2
  *
  *          [1,2],     [1,null,2]
  *
  *          Output: false
  *          Example 3:
  *
  *          Input:     1         1
  *          / \       / \
  *          2   1     1   2
  *
  *          [1,2,1],   [1,1,2]
  *
  *          Output: false
  * @see https://leetcode.com/problems/same-tree/
  *      OR
  *      https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/545/week-2-july-8th-july-14th/3389/
  *
  *
  */
object SameTrees {
  def main(args: Array[String]): Unit = {
    /*
        val arr = Array(3, 9, 20, null, null, 15, 7)
        val root = new TreeNode(3)
        root.left = new TreeNode(9)
        root.right = new TreeNode(20)
        root.right.left = new TreeNode(15)
        root.right.right = new TreeNode(7)
    */
    val root = new TreeNode(1)
    root.left = new TreeNode(2)
    // root.right = new TreeNode(1)
    // root.right.right = new TreeNode(8)


    val root2 = new TreeNode(1)
    // root2.left = new TreeNode(1)
    root2.right = new TreeNode(2)
    val result1 = isSameTree2(root, new ListBuffer[Option[Int]])
    val result2 = isSameTree2(root2, new ListBuffer[Option[Int]])

    println(result1.mkString(","))
    println(result2.mkString(","))
    println(extractNodes(result1).mkString(","))
    println(extractNodes(result2).mkString(","))
    println(result1 sameElements result2)

    /*
    Some(1),Some(2),None,None,None
    Some(1),None,Some(2),None,None
    1,2,null,null,null
    1,null,2,null,null
    false

     */
  }

  /** *
    * 57 / 57 test cases passed.
    * Status: Accepted
    * Runtime: 636 ms
    * Memory Usage: 62.6 MB
    *
    */
  def isSameTree(node: TreeNode, lb: ListBuffer[Option[Int]]): ListBuffer[Option[Int]] = {


    if (node == null) {
      lb.append(None)
      return lb
    } else lb.append(Some(node.value))

    if (node.left != null) isSameTree(node.left, lb) else lb.append(None)
    if (node.right != null) isSameTree(node.right, lb) else lb.append(None)
    lb
  }

  def extractNodes(lb: ListBuffer[Option[Int]]): ListBuffer[Integer] = {
    val res = ListBuffer[Integer]()
    lb.foreach { i =>
      val result = i match {
        case Some(x) => x.asInstanceOf[Integer]
        case None => null
      }
      res.append(result)
    }
    res
  }

  /**
    * 57 / 57 test cases passed.
    * Status: Accepted
    * Runtime: 436 ms
    * Memory Usage: 50.3 MB
    */
  def isSameTree2(node: TreeNode, lb: ListBuffer[Option[Int]]): ListBuffer[Option[Int]] = {

    def helper(node: TreeNode, lb: ListBuffer[Option[Int]]): ListBuffer[Option[Int]] = {
      node match {
        case null => lb.append(None); lb
        case x =>
          lb.append(Some(x.value));
          if (x.left != null) helper(x.left, lb) else lb.append(None)
          if (x.right != null) helper(x.right, lb) else lb.append(None)
          lb
      }
    }

    helper(node, lb)
  }

  /** *
    * Runtime: 636 ms, faster than 26.79% of Scala online submissions for Same Tree.
    * Memory Usage: 62.3 MB, less than 5.00% of Scala online submissions for Same Tree.
    *
    * 57 / 57 test cases passed.
    * Status: Accepted
    * Runtime: 636 ms
    * Memory Usage: 62.3 MB
    *
    */
  def isSameTree(p: TreeNode, q: TreeNode): Boolean = (p == null && q == null) || (p != null && q != null && p.value == q.value && isSameTree(p.left, q.left) && isSameTree(p.right, q.right))


}
