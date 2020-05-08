package com.concept.scala.leetcode_30days_challenge_May2020

import com.concept.scala.RunTimeCalculation

/** *
  *
  * Day 8
  *
  * @see https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3323/
  *      OR
  *      https://leetcode.com/problems/check-if-it-is-a-straight-line/
  *
  *      You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.
  *      Example 1:
  *      *
  *
  *
  *      Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
  *      Output: true
  *      Example 2:
  *      *
  *
  *
  *      Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
  *      Output: false
  *      *
  *
  *      Constraints:
  *      *
  *      2 <= coordinates.length <= 1000
  *      coordinates[i].length == 2
  *      -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
  *      coordinates contains no duplicate point.
  *
  *      66 / 66 test cases passed.
  *      Status: Accepted
  *      Runtime: 568 ms
  *      Memory Usage: 52.6 MB
  *
  *
  *
  */
object CheckIfItIsStraightLine {
  def main (args: Array[String]): Unit = {
    val coordinates = Array(Array(1, 2), Array(2, 3), Array(3, 8), Array(4, 10))
    val arr2: Array[Array[Int]] = Array(Array(-3, -2), Array(-1, -2), Array(2, -2), Array(-2, -2), Array(0, -2))

    val checkStraightLineTime = RunTimeCalculation.calculateRunTime(println(checkStraightLine(coordinates)))
    println(s"checkStraightLine Intellij IDEA runtime => total run time = seconds $checkStraightLineTime seconds OR ${checkStraightLineTime * 1000} milliseonds")
    val checkStraightLine2 = RunTimeCalculation.calculateRunTime(println(checkStraightLine(arr2)))
    println(s"checkStraightLine Intellij IDEA runtime => total run time = seconds $checkStraightLine2 seconds OR ${checkStraightLine2 * 1000} milliseonds")

    /*
    false
    checkStraightLine Intellij IDEA runtime => total run time = seconds 0.5 seconds OR 500.0 milliseonds
    true
    checkStraightLine Intellij IDEA runtime => total run time = seconds 0.0 seconds OR 0.0 milliseonds

     */
  }

  /** *
    * Runtime: 488 ms, faster than 100.00% of Scala online submissions for Check If It Is a Straight Line.
    * Memory Usage: 50.4 MB, less than 100.00% of Scala online submissions for Check If It Is a Straight Line.
    *
    * @param coordinates
    * @return
    */
  def checkStraightLine (coordinates: Array[Array[Int]]): Boolean = {
    val len = coordinates.length

    if (len < 2) return false
    if (len == 2) return true

    val orderedCoordinates = coordinates.sortWith((x, y) => x(0) < y(0))
    val slopOfLine = Array(orderedCoordinates(1)(0) - orderedCoordinates(0)(0), orderedCoordinates(1)(1) - orderedCoordinates(0)(1))


    orderedCoordinates.drop(2).foldLeft(true) { (first, second) =>
      if (!first) return false
      else (second(0) - orderedCoordinates(0)(0)) * slopOfLine(1) == (second(1) - orderedCoordinates(0)(1)) * slopOfLine(0)
    }

  }

}

