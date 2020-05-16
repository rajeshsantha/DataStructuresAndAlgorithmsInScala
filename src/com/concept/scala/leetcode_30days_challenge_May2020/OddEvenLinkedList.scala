package com.concept.scala.leetcode_30days_challenge_May2020

/** ***
  *
  * Day 16
  *
  * @see https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3331/
  *      OR
  *      https://leetcode.com/problems/odd-even-linked-list/
  *
  *
  *
  *      Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
  *
  *      You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
  *
  *      Example 1:
  *
  *      Input: 1->2->3->4->5->NULL
  *      Output: 1->3->5->2->4->NULL
  *      Example 2:
  *
  *      Input: 2->1->3->5->6->4->7->NULL
  *      Output: 2->3->6->7->1->5->4->NULL
  *      Note:
  *
  *      The relative order inside both the even and odd groups should remain as it was in the input.
  *      The first node is considered odd, the second node even and so on ...
  *
  *      71 / 71 test cases passed.
  *      Status: Accepted
  *      Runtime: 520 ms
  *      Memory Usage: 51.1 MB
  *
  */
object OddEvenLinkedList {

  def oddEvenList (head: ListNode): ListNode = {
    if (head != null) {

      var (odd, even) = (head, head.next)
      val evenHead = even

      while (even != null && even.next != null) {
        odd.next = odd.next.next
        even.next = even.next.next
        odd = odd.next
        even = even.next
      }
      odd.next = evenHead
    }
    return head
  }
}


class ListNode (_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}

