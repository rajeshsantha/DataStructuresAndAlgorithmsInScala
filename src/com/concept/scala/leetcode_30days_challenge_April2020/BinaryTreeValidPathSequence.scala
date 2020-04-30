package com.concept.scala.leetcode_30days_challenge_April2020

/** **
  * Day 30 Scala version
  *
  * @see https://leetcode.com/explore/other/card/30-day-leetcoding-challenge/532/week-5/3315/
  *
  *      Given a binary tree where each path going from the root to any leaf form a valid sequence, check if a given string is a valid sequence in such binary tree.
  *
  *      We get the given string from the concatenation of an array of integers arr and the concatenation of all values of the nodes along a path results in a sequence in the given binary tree.
  *
  *
  *
  *      Example 1:
  *
  *
  *
  *      Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,0,1]
  *      Output: true
  *      Explanation:
  *      The path 0 -> 1 -> 0 -> 1 is a valid sequence (green color in the figure).
  *      Other valid sequences are:
  *      0 -> 1 -> 1 -> 0
  *      0 -> 0 -> 0
  *      Example 2:
  *
  *
  *
  *      Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,0,1]
  *      Output: false
  *      Explanation: The path 0 -> 0 -> 1 does not exist, therefore it is not even a sequence.
  *      Example 3:
  *
  *
  *
  *      Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,1]
  *      Output: false
  *      Explanation: The path 0 -> 1 -> 1 is a sequence, but it is not a valid sequence.
  *
  *
  *      Constraints:
  *
  *      1 <= arr.length <= 5000
  *      0 <= arr[i] <= 9
  *      Each node's value is between [0 - 9].
  *
  *      63 / 63 test cases passed.
  *      Status: Accepted
  *      Runtime: 716 ms
  *      Memory Usage: 55 MB
  *
  *
  *
  *
  */
object BinaryTreeValidPathSequence {

  def isValidSequence(root: TreeNode, arr: Array[Int]): Boolean = {

    checkifValidPath(root, arr, arr.length, 0)

  }

  def checkifValidPath(root: TreeNode, arr: Array[Int], len: Int, index: Int): Boolean = {
    if (root == null || index >= len) return false
    if (root.left == null && root.right == null) return index == len - 1 && root.value == arr(index)
    if (root.value == arr(index)) return checkifValidPath(root.left, arr, len, index + 1) || checkifValidPath(root.right, arr, len, index + 1)

    return false
  }

  def main(args: Array[String]): Unit = {


    // arr[] is sequence of root to leaf path
    val arr = Array(5, 8, 6, 7)
    val root = new TreeNode(5)
    root.left = new TreeNode(3)
    root.right = new TreeNode(8)
    root.left.left = new TreeNode(2)
    root.left.right = new TreeNode(4)
    root.left.left.left = new TreeNode(1)
    root.right.left = new TreeNode(6)
    root.right.left.right = new TreeNode(7)


    println(s"result is ${isValidSequence(root, arr)}")

  }

}

//using class com.concept.scala.leetcode_30days_challenge_April2020.TreeNode

//
//class TreeNode (_value: Int, _left: TreeNode = null, _right: TreeNode = null) {
//  var value: Int = _value
//  var left: TreeNode = _left
//  var right: TreeNode = _right
//}

/*
Python3 version :


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isValidSequence(self, root: TreeNode, arr: List[int]) -> bool:
        length=len(arr)
        index = 0
        return self.checkIfValidPath(root,arr, length,index)

    def checkIfValidPath(self,root,arr,length,index):
        if root is None:
            return length==0

        if(index == length-1) and (root.left ==None and root.right ==None and root.val ==arr[index]):
            return True

        if(index<length) and (root.val ==arr[index]):
            return self.checkIfValidPath(root.left,arr,length,index+1) or self.checkIfValidPath(root.right,arr,length,index+1)


 */