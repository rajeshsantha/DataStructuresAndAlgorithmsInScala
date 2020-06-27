package com.concept.scala.hackerrank.functionalProgramming

import scala.annotation.tailrec

/**
* @note Use functional programming, avoid imperative programming.(follwed by Version 1.1 and 1.2)
  *       This one uses tail recursion in functional programming.(check StringCompressionAlgorithm_OneLiner_Version  for one-liner solution)
  * @see https://www.hackerrank.com/challenges/string-compression/problem
  * @example If Input string is "abcaaabbb" => output should be abca3b3
  *
  */

object StringCompressionAlgorithm_FunctionalVersion {
  def compress(xs: String): List[(Char, Int)] = {

    @tailrec
    def helperRecursive(accumulator: List[(Char, Int)], str: String): List[(Char, Int)] = {
      if (str.isEmpty) {
        accumulator
      } else {
        val firstChar = str.head
        val spans: (String, String) = str.span(_ == firstChar)
        helperRecursive((firstChar, spans._1.length) :: accumulator, spans._2)
      }
    }

    helperRecursive(Nil, xs).reverse
  }

  def tupleToString[T](tuples: List[(T, Int)]): String = {
    tuples.map(x => {
      if (x._2 == 1) {
        s"${x._1}"
      } else {
        s"${x._1}${x._2}"
      }
    }).mkString("")
  }

  def main(args: Array[String]) {
    val inputString = readLine
    println(tupleToString(compress(inputString)))
  }

}
