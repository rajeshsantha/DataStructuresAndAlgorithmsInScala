package com.concept.scala.hackerrank.functionalProgramming

import scala.annotation.tailrec

/**
  * @author Rajesh Santha
  * @version 1.0
  * @note Use functional programming, avoid imperative programming.(follwed by Version 1.1 and 1.2)
  *       This one uses tail recursion in functional programming.(check StringCompressionAlgorithm_What_In_The_World_Version for one-liner solution)
  * @see https://www.hackerrank.com/challenges/string-compression/problem
  * @example If Input string is "abcaaabbb" => output should be abca3b3
  *
  */

object StringCompressionAlgorithm_FunctionalVersion {
  def compress(xs: String): List[(Char, Int)] = {

    @tailrec
    def go(acc: List[(Char, Int)], ys: String): List[(Char, Int)] = {
      if (ys.isEmpty) {
        acc
      } else {
        val y: Char = ys.head
        val spans: (String, String) = ys.span(_ == y)
        go((y, spans._1.length) :: acc, spans._2)
      }
    }

    go(Nil, xs).reverse
  }

  def format_count_tuple[T](tups: List[(T, Int)]): String = {
    tups.map(x => {
      if (x._2 == 1) {
        s"${x._1}"
      } else {
        s"${x._1}${x._2}"
      }
    }).mkString("")
  }

  def main(args: Array[String]) {
    val xs = readLine
    println(format_count_tuple(compress(xs)))
  }

}
