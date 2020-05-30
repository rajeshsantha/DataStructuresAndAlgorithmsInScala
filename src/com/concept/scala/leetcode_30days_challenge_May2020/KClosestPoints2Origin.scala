package com.concept.scala.leetcode_30days_challenge_May2020

/** **
  * Day 30
  *
  * @see https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/538/week-5-may-29th-may-31st/3345/
  *      OR
  *      https://leetcode.com/problems/k-closest-points-to-origin/
  *
  *
  *      We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
  *
  *      (Here, the distance between two points on a plane is the Euclidean distance.)
  *
  *      You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
  *
  *
  *
  *      Example 1:
  *
  *      Input: points = [[1,3],[-2,2]], K = 1
  *      Output: [[-2,2]]
  *      Explanation:
  *      The distance between (1, 3) and the origin is sqrt(10).
  *      The distance between (-2, 2) and the origin is sqrt(8).
  *      Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
  *      We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
  *      Example 2:
  *
  *      Input: points = [[3,3],[5,-1],[-2,4]], K = 2
  *      Output: [[3,3],[-2,4]]
  *      (The answer [[-2,4],[3,3]] would also be accepted.)
  *
  *
  *      Note:
  *
  *      1 <= K <= points.length <= 10000
  *      -10000 < points[i][0] < 10000
  *      -10000 < points[i][1] < 10000
  *
  *
  *
  *
  */
object KClosestPoints2Origin {
  def main (args: Array[String]): Unit = {

    val points = Array(Array(2, -2), Array(1, 3))
    val K = 1
    kClosest(points, K).foreach(x => println(x.mkString(",")))
  }

  /** **
    * 83 / 83 test cases passed.
    * Status: Accepted
    * Runtime: 984 ms
    * Memory Usage: 63.8 MB
    *
    * Runtime: 984 ms, faster than 56.92% of Scala online submissions for K Closest Points to Origin.
    * Memory Usage: 63.8 MB, less than 100.00% of Scala online submissions for K Closest Points to Origin.
    *
    */
  def kClosest (points: Array[Array[Int]], K: Int): Array[Array[Int]] =
    points zip points.map(point => math sqrt (math.pow(point.head, 2) + math.pow(point.last, 2))) sortBy (_._2) take K map (_._1)


  def kClosest_PriorityQueue (points: Array[Array[Int]], K: Int): Array[Array[Int]] = {
    val pq = scala.collection.mutable.PriorityQueue.empty[PointerObject](Ordering.by(_.c))

    points.foreach { point =>
      val a = Math.pow(point.head, 2)
      val b = Math.pow(point.last, 2)
      val c = Math.sqrt(a + b)

      pq.enqueue(PointerObject(c, point))
      if (pq.length > K) pq.dequeue
    }

    pq.dequeueAll.map(_.point).toArray
  }

}


case class PointerObject (c: Double, point: Array[Int])


