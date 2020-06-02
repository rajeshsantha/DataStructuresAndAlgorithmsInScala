package com.concept.scala.leetcode_30days_challenge_June2020

/** *
  * Day 2
  *
  * @see https://leetcode.com/explore/featured/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3348/
  *      OR
  *      https://leetcode.com/problems/delete-node-in-a-linked-list/
  *
  *
  *      Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
  *
  *      Given linked list -- head = [4,5,1,9], which looks like following:
  *
  *
  *
  *
  *
  *      Example 1:
  *
  *      Input: head = [4,5,1,9], node = 5
  *      Output: [4,1,9]
  *      Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.
  *      Example 2:
  *
  *      Input: head = [4,5,1,9], node = 1
  *      Output: [4,5,9]
  *      Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your function.
  *
  *
  *      Note:
  *
  *      The linked list will have at least two elements.
  *      All of the nodes' values will be unique.
  *      The given node will not be the tail and it will always be a valid node of the linked list.
  *      Do not return anything from your function.
  *
  *
  *
  */
object DeleteNodeInLinkedList {

  /** *
    * 41 / 41 test cases passed.
    * Status: Accepted
    * Runtime: 500 ms
    * Memory Usage: 50.9 MB
    *
    * Runtime: 500 ms, faster than 44.12% of Scala online submissions for Delete Node in a Linked List.
    * Memory Usage: 50.9 MB, less than 100.00% of Scala online submissions for Delete Node in a Linked List.
    *
    */
  def deleteNode (node: ListNode): Unit = {
    /*
        if (node == null) return null
        if (node.next == null) return node
        if (node.next.next == null) return node.next
    */

    node.x = node.next.x
    node.next = node.next.next

  }

  private class ListNode (var _x: Int = 0) {
    var next: ListNode = null
    var x: Int = _x
  }

}

