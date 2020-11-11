package com.concept.scala.leetcode_30days_challenge_November2020

import scala.collection.mutable.ListBuffer

/** **
  * Day 11
  *
  * @todo Given the coordinates of four points in 2D space, return whether the four points could construct a square.
  *       The coordinate (x,y) of a point is represented by an integer array with two integers.
  * @example Example:
  *          Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
  *          Output: True
  * @note All the input integers are in the range [-10000, 10000].
  *       A valid square has four equal sides with positive length and four equal angles (90-degree angles).
  *       Input points have no order.
  * @see https://leetcode.com/explore/challenge/card/november-leetcoding-challenge/565/week-2-november-8th-november-14th/3527/
  *      OR
  *      https://leetcode.com/problems/valid-square/
  *
  *
  *
  */
object ValidSquare {


  /** *
    * 244 / 244 test cases passed.
    * Status: Accepted
    * Runtime: 480 ms
    * Memory Usage: 51.6 MB
    *
    * @param p1
    * @param p2
    * @param p3
    * @param p4
    * @return whether valid square
    */
  def validSquare(p1: Array[Int], p2: Array[Int], p3: Array[Int], p4: Array[Int]): Boolean = {
    val l = scala.collection.mutable.ListBuffer[Int]()

    l.append(distanceBetweenPoints(p1, p2))
    l.append(distanceBetweenPoints(p1, p3))
    l.append(distanceBetweenPoints(p1, p4))
    l.append(distanceBetweenPoints(p2, p3))
    l.append(distanceBetweenPoints(p2, p4))
    l.append(distanceBetweenPoints(p3, p4))
    val list = l.sorted

    list.head > 0 && (list.head == list(1)) && (list(1) == list(2)) && (list(2) == list(3)) && (list(4) == list(5))

  }

  val distanceBetweenPoints: (Array[Int], Array[Int]) => Int = (p1: Array[Int], p2: Array[Int]) =>
    (p1.head - p2.head) * (p1.head - p2.head) + (p1.last - p2.last) * (p1.last - p2.last)


}
