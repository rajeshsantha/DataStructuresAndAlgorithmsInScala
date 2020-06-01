package com.concept.scala.leetcode_30days_challenge_June2020

object InvertBinaryTree {

  /***
    *
    * 68 / 68 test cases passed.
    * Status: Accepted
    * Runtime: 492 ms
    * Memory Usage: 50.7 MB
    *
    * @param root
    * @return
    */
  def invertTree(root: TreeNode): TreeNode = {
    if (root == null) return root

    val tempNode = root.left
    root.left = invertTree(root.right)
    root.right = invertTree(tempNode)
    root


}
}

class TreeNode (_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}