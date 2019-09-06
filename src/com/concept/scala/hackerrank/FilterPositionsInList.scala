package com.concept.scala.hackerrank

object FilterPositionsInList extends App {


  val listArgs = scala.io.Source.stdin.getLines.toList.map(_.trim.toInt)
  f(listArgs).foreach(println)

  def f(arr: List[Int]) = {
    (for (i <- arr.indices.filter(_ % 2 != 0)) yield {
      arr(i)
    }).toList
  }
}
