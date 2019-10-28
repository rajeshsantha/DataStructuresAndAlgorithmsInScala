package com.concept.scala.hackerrank.ThirtyDaysOfCode

import scala.collection.mutable.{ListBuffer, Map}

/**
  * @author Rajesh Santha
  * @version 1.1 
  * @todo part of 30 days of code challenge. (Arrays)
  * @see https://www.hackerrank.com/challenges/30-dictionaries-and-maps/problem
  * @note Use functional programming, avoid imperative programming.
  *
  */
object DictionariesAndMaps extends {
  def main (args: Array[String]): Unit = {


    val totalList = ListBuffer[String]()
    val totalMap: Map[String, String] = Map()

    val stdin = scala.io.StdIn
    val inputLen = stdin.readLine.trim.toInt
    for (_ <- 0 until inputLen) {
      val rowMap = stdin.readLine.split(" ").grouped(2).map { case Array(k, v) => k -> v }.toMap
      totalMap ++= rowMap
    }
    for (_ <- 0 until inputLen) {
      val outputReq = stdin.readLine().trim
      //totalList = totalList += outputReq
      totalList += outputReq
    }
    totalList.foreach(getFormattedValue(_))

    def getFormattedValue (x: String) = if (totalMap.contains(x)) println(x + "=" + totalMap(x)) else println("Not found")

  }

  // Below code to satisfy the testcase 1 with 10k input.
  import scala.collection.mutable

  def otherSolution (args: Array[String]) {
    val sc = new java.util.Scanner(System.in)
    val n = sc.nextLine.toInt
    val book = mutable.HashMap[String, String]()
    for (i <- 0 until n) {
      val split = sc.nextLine.split(" ")
      book.put(split(0), split(1))
    }


    while (sc.hasNext) {
      val query = sc.nextLine
      val nr = book.get(query)
      if (nr.isDefined) {
        println(query + "=" + nr.get)
      } else {
        println("Not found")
      }
    }
  }


}
