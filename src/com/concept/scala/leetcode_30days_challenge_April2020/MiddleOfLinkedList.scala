package com.concept.scala.leetcode_30days_challenge_April2020

/** *
  * Day 8
  *
  * @see https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/529/week-2/3290/
  *
  *      Given a non-empty, singly linked list with head node head, return a middle node of linked list.
  *
  *      If there are two middle nodes, return the second middle node.
  *
  *
  *
  *      Example 1:
  *
  *      Input: [1,2,3,4,5]
  *      Output: Node 3 from this list (Serialization: [3,4,5])
  *      The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
  *      Note that we returned a ListNode object ans, such that:
  *      ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
  *      Example 2:
  *
  *      Input: [1,2,3,4,5,6]
  *      Output: Node 4 from this list (Serialization: [4,5,6])
  *      Since the list has two middle nodes with values 3 and 4, we return the second one.
  *
  *
  *      Note:
  *
  *      The number of nodes in the given list will be between 1 and 100.
  *      15 / 15 test cases passed.
  *      Status: Accepted
  *      Runtime: 432 ms
  *      Memory Usage: 50.2 MB
  *
  *
  */
object MiddleOfLinkedList extends ListNode {
  def main (args: Array[String]): Unit = {
    val node = new ListNode()
    middleNode(node)
  }

  def middleNode (head: ListNode): ListNode = {
    var slowPointer = head
    var fasterPointer = head
    import scala.annotation.tailrec

    @tailrec
    def traverse (node: ListNode): ListNode = {
      if (node == null) slowPointer
      else {
        (node, node.next) match {
          case (_, null) => slowPointer //final node
          case (_, _) => {
            // if it is not final node
            slowPointer = slowPointer.next
            fasterPointer = node.next.next
            traverse(fasterPointer)
          }
        }
      }
    }

    traverse(head)

  }

}

//   Definition for singly-linked list.
class ListNode (var _x: Int = 0) {
  var next: ListNode = _
  var x: Int = _x
}



