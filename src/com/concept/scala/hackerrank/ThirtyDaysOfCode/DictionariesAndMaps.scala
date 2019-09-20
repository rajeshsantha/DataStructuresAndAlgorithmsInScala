package com.concept.scala.hackerrank.ThirtyDaysOfCode

import scala.collection.mutable.Map
import scala.collection.mutable.ListBuffer
/**
  * @author Rajesh Santha
  * @version 1.0 (10k input test case version pending) 
  * @todo part of 30 days of code challenge. (Arrays)
  * @see https://www.hackerrank.com/challenges/30-dictionaries-and-maps/problem
  * @note Use functional programming, avoid imperative programming.
  *
  */
object DictionariesAndMaps extends {
  def main(args: Array[String]): Unit = {


    var totalList = ListBuffer[String]()
    val totalMap: Map[String, String] = Map()

    val stdin = scala.io.StdIn
    val inputLen = stdin.readLine.trim.toInt
    for (i <- 0 until inputLen) {
      val rowMap = stdin.readLine.split(" ").grouped(2).map { case Array(k, v) => k -> v }.toMap
      totalMap ++= rowMap
    }
    for (i <- 0 until inputLen) {
      val outputReq = stdin.readLine().trim
      totalList = totalList += outputReq
    }
    totalList.foreach(x => getFormattedValue(x))
    def getFormattedValue(x: String) = if (totalMap.contains(x)) println(x + "=" + totalMap(x)) else println("Not found")

  }


}
