package com.concept.scala.hackerrank.functionalProgramming

/**
  * @author Rajesh Santha
  * @todo Compute the Area of a Polygon (N sides)
  * @note Use functional programming, avoid imperative programming.
  * @see https://www.hackerrank.com/challenges/lambda-march-compute-the-area-of-a-polygon/problem
  *
  *
  */

object AreaOfPolygon {
  def main(args: Array[String]): Unit = {
    val stdin = scala.io.StdIn
    val n = stdin.readLine.trim.toInt
    val pairs = (1 to n).map(_ => stdin.readLine().split("\\s+")).map(x => (x(0).toDouble, x(1).toDouble)).toList
    val points = pairs.zip(pairs.tail ::: List(pairs.head))

    println(Math.abs((for {((x1, y1), (x2, y2)) <- points}
      yield {
        distanceOfCoordinates((x1, y1), (x2, y2))
      }
      ).sum) / 2)
  }

  def distanceOfCoordinates(p1: (Double, Double), p2: (Double, Double)): Double = {
    (p1._1 * p2._2) - (p1._2 * p2._1)
  }

}
