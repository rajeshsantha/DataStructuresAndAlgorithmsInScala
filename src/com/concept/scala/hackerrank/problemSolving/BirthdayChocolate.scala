package com.concept.scala.hackerrank.problemSolving

import scala.io.StdIn

object BirthdayChocolate {

  def main (args: Array[String]): Unit = {
    val n = StdIn.readLine.trim.toInt
    val s = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)
    val dm = StdIn.readLine.replaceAll("\\s+$", "").split(" ")
    val d = dm(0).toInt
    val m = dm(1).toInt
  //  val result = birthday(s, d, m)

  }
/*
  def birthday(s: Array[Int], d: Int, m: Int): Int = {

    s.combinations(m).filter(_.sum==d)

  }
*/

}
