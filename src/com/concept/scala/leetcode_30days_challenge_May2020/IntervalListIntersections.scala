package com.concept.scala.leetcode_30days_challenge_May2020

import com.concept.scala.RunTimeCalculation


/** **
  * Day 23
  *
  * @see https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3338/
  *      OR
  *      https://leetcode.com/problems/interval-list-intersections/  (986)
  *
  *
  *      Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.
  *
  *      Return the intersection of these two interval lists.
  *
  *      (Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.  The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as a closed interval.  For example, the intersection of [1, 3] and [2, 4] is [2, 3].)
  *
  *
  *
  *      Example 1:
  *
  *
  *
  *      Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
  *      Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
  *      Reminder: The inputs and the desired output are lists of Interval objects, and not arrays or lists.
  *
  *
  *      Note:
  *
  *      0 <= A.length < 1000
  *      0 <= B.length < 1000
  *      0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10 pow 9
  *      NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
  *
  *
  *
  */
object IntervalListIntersections {

  def main(args: Array[String]): Unit = {
    val a = convertStringToNestedArray("[[0,2],[5,10],[13,23],[24,25]]")
    val b = convertStringToNestedArray("[[1,5],[8,12],[15,24],[25,26]]")
    val totalRuntime = RunTimeCalculation.calculateRunTime {
      intervalIntersection(a, b).foreach { x => print(x.mkString("[", ",", "]")); print("\t") }
    }
    println(s" \n total run time = seconds $totalRuntime seconds OR ${totalRuntime * 1000} milliseonds")
    /*
    [1,2]	[5,5]	[8,10]	[15,23]	[24,24]	[25,25]
     total run time = seconds 0.083 seconds OR 83.0 milliseonds

     */
  }

  /** **
    *
    * 86 / 86 test cases passed.
    * Status: Accepted
    * Runtime: 1084 ms
    * Memory Usage: 85.7 MB
    *
    *
    * Runtime: 1084 ms, faster than 6.67% of Scala online submissions for Interval List Intersections.
    * Memory Usage: 85.7 MB, less than 100.00% of Scala online submissions for Interval List Intersections.
    *
    */
  def intervalIntersection(A: Array[Array[Int]], B: Array[Array[Int]]): Array[Array[Int]] = {
    val result = scala.collection.mutable.ListBuffer[Array[Int]]()
    var (i, j) = (0, 0)


    while (i < A.length && j < B.length) {
      val (start, end) = (math.max(A(i)(0), B(j)(0)), math.min(A(i)(1), B(j)(1)))
      if (start <= end) result.append(Array[Int](start, end))
      if (A(i)(1) < B(j)(1)) i += 1 else j += 1

    }
    result toArray
  }

  def convertStringToNestedArray(str: String): Array[Array[Int]] = {
    str
      .replace('[', '(')
      .replace(']', ')')
      .split("\\)\\,\\(")
      .map(_.split(" "))
      .map(_.map(_.replace("(", "").replace(")", "")))
      .map(_.flatMap(_.replace("(", "").replace(")", "")
        .split(",").map(_.toInt)))
  }
}