package com.concept.scala.leetcode_30days_challenge_November2020

import scala.annotation.tailrec
import scala.collection.mutable


/** **
  *
  * Day 1 - November 
  *
  * @todo Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.
  *       Return the decimal value of the number in the linked list.
  * @example Example 1:
  *
  *
  *          Input: head = [1,0,1]
  *          Output: 5
  *          Explanation: (101) in base 2 = (5) in base 10
  *          Example 2:
  *
  *          Input: head = [0]
  *          Output: 0
  *          Example 3:
  *
  *          Input: head = [1]
  *          Output: 1
  *          Example 4:
  *
  *          Input: head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
  *          Output: 18880
  *          Example 5:
  *
  *          Input: head = [0,0]
  *          Output: 0
  * @note The Linked List is not empty.
  *       Number of nodes will not exceed 30.
  *       Each node's value is either 0 or 1.
  * @see https://leetcode.com/explore/challenge/card/november-leetcoding-challenge/564/week-1-november-1st-november-7th/3516/
  *      OR
  *      https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer
  *
  *
  */
object ConvertBinaryNumberInALinkedListToInteger {


  /** *
    * 102 / 102 test cases passed.
    * Status: Accepted
    * Runtime: 448 ms
    * Memory Usage: 51.2 MB
    *
    */
  def getDecimalValue_Iterative(head: ListNode): Int = {
    var headNode = head
    var number = 0

    while (headNode != null) {
      number = number * 2 + headNode.x
      headNode = headNode.next
    }
    number
  }

  /** **
    * 102 / 102 test cases passed.
    * Status: Accepted
    * Runtime: 452 ms
    * Memory Usage: 53.2 MB
    *
    */
  def getDecimalValue_stack(head: ListNode): Int = {

    var (headNode, number, factor) = (head, 0, 1)

    val stack = scala.collection.mutable.Stack[Int]()
    while (headNode != null) {
      stack.push(headNode.x)
      headNode = headNode.next
    }
    while (stack.nonEmpty) {
      number += stack.pop * factor
      factor = factor * 2
    }
    number
  }

  /** *
    *
    * 102 / 102 test cases passed.
    * Status: Accepted
    * Runtime: 428 ms
    * Memory Usage: 51.1 MB
    *
    */
  def getDecimalValue_tailrec(head: ListNode): Int = {
    @scala.annotation.tailrec
    def getDecimalTailRec(headnode: ListNode, num: Int): Int = headnode match {
      case null => num
      case _ => getDecimalTailRec(headnode.next, num * 2 + headnode.x)
    }

    getDecimalTailRec(head, 0)

  }

}

//Definition for singly-linked list
class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}
