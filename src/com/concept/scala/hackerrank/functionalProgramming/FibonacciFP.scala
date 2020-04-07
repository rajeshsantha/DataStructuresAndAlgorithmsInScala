package com.concept.scala.hackerrank.functionalProgramming

import scala.collection.mutable.ListBuffer

/**
  * @author Rajesh
  * @todo
  * For each test case, print Fib(n) % 10^8+7
  *  @see https://www.hackerrank.com/challenges/fibonacci-fp/problem
  * @note Use functional programming.
  *
  */
object FibonacciFP {
  val streamFib: Stream[BigInt] = BigInt(0) #:: BigInt(1) #:: streamFib.zip(streamFib.tail).map(t => t._1 + t._2)

  def main (args: Array[String]) {
    val stdin = scala.io.StdIn
    val num = stdin.readLine.trim.toInt
    val mod = BigDecimal.valueOf(scala.math.pow(10, 8) + 7).toBigInt
    val listInput: ListBuffer[Int] = ListBuffer()

    /* // for local test
        //val constList: ListBuffer[Int] = ListBuffer(0, 1, 5, 10, 100)
        println(s"${fib(0, streamFib)}%$mod = ${fib(0, streamFib) % mod}")
        println(s"${fib(1, streamFib)}%$mod = ${fib(1, streamFib) % mod}")
        println(s"${fib(5, streamFib)}%$mod = ${fib(5, streamFib) % mod}")
        println(s"${fib(10, streamFib)}%$mod = ${fib(10, streamFib) %mod}")
        println(s"${fib(100, streamFib)}%$mod = ${fib(100, streamFib) %mod}")
    */

    for (_ <- 1 to num)
      listInput.append(stdin.readLine().toInt)

    listInput.map(x => fib(x, streamFib) % mod).foreach(println)

  }


  def fib (n: Int, streamFib: Stream[BigInt]): BigInt = {
    streamFib.take(n + 1).toList.last
  }
}
