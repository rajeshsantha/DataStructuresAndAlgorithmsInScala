package com.concept.scala.leetcode_30days_challenge_April2020

/***
  *  Tree node  for binary tree problems  - re-use
  *
  * @param _value
  * @param _left
  * @param _right
  */
class TreeNode (_value: Int, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

