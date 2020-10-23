package com.concept.scala.leetcode_30days_challenge_September2020

import com.concept.scala.leetcode_30days_challenge_April2020.TreeNode


/** *
  *
  * Day 5
  *
  * @todo Given two binary search trees root1 and root2.
  *       Return a list containing all the integers from both trees sorted in ascending order.
  * @example Example 1:
  *
  *
  *          Input: root1 = [2,1,4], root2 = [1,0,3]
  *          Output: [0,1,1,2,3,4]
  *          Example 2:
  *
  *          Input: root1 = [0,-10,10], root2 = [5,1,7,0,2]
  *          Output: [-10,0,0,1,2,5,7,10]
  *          Example 3:
  *
  *          Input: root1 = [], root2 = [5,1,7,0,2]
  *          Output: [0,1,2,5,7]
  *          Example 4:
  *
  *          Input: root1 = [0,-10,10], root2 = []
  *          Output: [-10,0,10]
  *          Example 5:
  *
  *
  *          Input: root1 = [1,null,8], root2 = [8,1]
  *          Output: [1,1,8,8]
  * @note Each tree has at most 5000 nodes.
  *       Each node's value is between [-10^5, 10^5].
  * @see https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/554/week-1-september-1st-september-7th/3449/
  *      OR https://leetcode.com/problems/all-elements-in-two-binary-search-trees
  *
  *
  *
  */
object AllElementsInTwoBinarySearchTrees {

  import scala.collection.mutable.ListBuffer

  def main(args: Array[String]): Unit = {
    //root1 = [2,1,4], root2 = [1,0,3] ==> Output: List(0, 1, 1, 2, 3, 4)

    val root1 = new TreeNode(2)
    root1.left = new TreeNode(1)
    root1.right = new TreeNode(4)

    val root2 = new TreeNode(1)
    root2.left = new TreeNode(0)
    root2.right = new TreeNode(3)

    println(getAllElements(root1, root2))
  }

  /** *
    * 48 / 48 test cases passed.
    * Status: Accepted
    * Runtime: 1044 ms
    * Memory Usage: 59.1 MB
    *
    * @param root1 of bst1
    * @param root2 of bst2
    * @return list containing all the integers from both trees sorted in ascending order
    */
  def getAllElements(root1: TreeNode, root2: TreeNode): List[Int] =
    inorderTraversal(root2, inorderTraversal(root1, new ListBuffer[Int])).toList.sorted


  def inorderTraversal(root: TreeNode, result: ListBuffer[Int]): ListBuffer[Int] = {
    if (root == null) result else {
      val newElements = inorderTraversal(root.left, result)
      newElements.append(root.value)
      inorderTraversal(root.right, newElements)
    }


  }


}
