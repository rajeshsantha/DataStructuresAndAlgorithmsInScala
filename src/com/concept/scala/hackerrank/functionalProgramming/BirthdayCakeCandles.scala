package com.concept.scala.hackerrank.functionalProgramming

/**
  * @see https://www.hackerrank.com/challenges/birthday-cake-candles/problem
  */
object BirthdayCakeCandles {
  def main (args: Array[String]): Unit = {
    val stdin = scala.io.StdIn
    val ar = stdin.readLine.split(" ").map(_.trim.toInt)
    println(birthdayCakeCandles(ar))

  }

  def birthdayCakeCandles (ar: Array[Int]): Int = {
    val arr = ar.sorted
    arr count(_ == arr.last)
  }


}
