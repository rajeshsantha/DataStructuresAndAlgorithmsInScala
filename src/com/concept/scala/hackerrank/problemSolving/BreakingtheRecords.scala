package com.concept.scala.hackerrank.problemSolving

object BreakingtheRecords {
  def breakingRecords (scores: Array[Int]): Array[Int] = {

    val firstScore = scores(0)
    var maxCount = 0
    var minCount = 0
    var maxScore = firstScore
    var minScore = firstScore

    for (i <- scores.indices) {

      if (scores(i) > maxScore) {
        maxScore = scores(i)
        maxCount += 1
      }
      if (scores(i) < minScore) {
        minScore = scores(i)
        minCount += 1
      }

    }
    Array(maxCount, minCount)

  }


  def main (args: Array[String]) {
    val stdin = scala.io.StdIn
    val n = stdin.readLine.trim.toInt
    val scores = stdin.readLine.split(" ").map(_.trim.toInt)
    // println(breakingRecords(scores).mkString(" "))

  }
}
