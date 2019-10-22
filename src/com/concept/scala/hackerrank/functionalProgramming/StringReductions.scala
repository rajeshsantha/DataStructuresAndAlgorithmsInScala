package com.concept.scala.hackerrank.functionalProgramming

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
  * @author Rajesh
  * @version 1.0
  * @todo String Reductions based on the input
  * @usecase Implement the solution in all 3 ways.
  *          i)  With Built-in libraries
  *          ii) With recursion
  *          iii)With Tail-recursion
  * @note Use functional programming, avoid imperative programming
  * @see https://www.hackerrank.com/challenges/string-reductions/problem
  */

object StringReductions {
  def main (args: Array[String]): Unit = {
    val str = "abcddefghhdcc"
    println(stringReduce_builtIn(str))
  }

  def stringReduce_builtIn (str: String): String = str.toCharArray.distinct.mkString

}
