package com.concept.scala.leetcode_30days_challenge_July2020

/** **
  *
  * Day 20
  *
  * @todo Remove all elements from a linked list of integers that have value val.
  * @example Example:
  *
  *          Input:  1->2->6->3->4->5->6, val = 6
  *          Output: 1->2->3->4->5
  * @see https://leetcode.com/problems/remove-linked-list-elements/
  *      OR
  *      https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/546/week-3-july-15th-july-21st/3396/
  *
  *
  */
object RemoveLinkedListElements {
  def main(args: Array[String]): Unit = {
    val head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))))
    println(printLinkedList(head))
    val res = removeElements(head, 3)
    println(printLinkedList(res))
  }


  def removeElements(head: ListNode, `val`: Int): ListNode = {
    if (head == null) return null
    if (head.x == `val`) return head.next

    var current = head
    var nextNode = head.next

    while (nextNode != null) {
      if (nextNode.x == `val`) {
        current.next = nextNode.next
        nextNode = nextNode.next
      } else {
        current = nextNode
        nextNode = nextNode.next
      }
    }
    head
  }

  /** *
    *
    * 65 / 65 test cases passed.
    * Status: Accepted
    * Runtime: 888 ms
    * Memory Usage: 52 MB
    *
    */
  def removeElementsByTempHead(head: ListNode, `val`: Int): ListNode = {
    val tempHead = new ListNode()
    tempHead.next = head
    var curr = tempHead
    while (curr.next != null) if (curr.next.x == `val`) curr.next = curr.next.next else curr = curr.next
    tempHead.next
  }

  def printLinkedList(head: ListNode): String = {
    var head1 = head
    var s = ""
    while (head1 != null) {
      s += head1.x
      head1 = head1.next
    }
    s
  }
}


class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}

