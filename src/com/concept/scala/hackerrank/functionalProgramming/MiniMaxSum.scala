package com.concept.scala.hackerrank.functionalProgramming

/**
  * @author Rajesh
  * @see https://www.hackerrank.com/challenges/mini-max-sum/problem
  * @todo Given five positive integers, find the minimum and maximum values that can be calculated by summing exactly four of the five integers. Then print the respective minimum and maximum values as a single line of two space-separated long integers.
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
