package com.concept.scala.hackerrank.functionalProgramming

/**
  * @author Rajesh
  * @see https://www.hackerrank.com/challenges/mini-max-sum/problem
  *
  */
object MiniMaxSum {
  def main (args: Array[String]): Unit = {

    miniMaxSum(scala.io.StdIn.readLine.split(" ").map(_.trim.toLong))

  }

  def miniMaxSum (inputArray: Array[Long]) {
    val arraySorted = inputArray sorted
    val (max, min): (BigInt, BigInt) = (arraySorted.tail.sum, arraySorted .reverse.tail.sum)
    println(s"$min $max")

  }

}
