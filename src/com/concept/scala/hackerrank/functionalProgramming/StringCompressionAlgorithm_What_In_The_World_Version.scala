package com.concept.scala.hackerrank.functionalProgramming

/**
  * @author Rajesh Santha
  * @version 1.0
  * @note Use functional programming, avoid imperative programming.(follwed by Version 1.1 and 1.2)
  *       This one is a one-linere in functional programming with the help of regex.
  * @see https://www.hackerrank.com/challenges/string-compression/problem
  * @example If Input string is "abcaaabbb" => output should be abca3b3
  *
  */
object StringCompressionAlgorithm_What_In_The_World_Version extends App {
//abbbbcdeeerxxxxxxxxxghsd
  println("(\\w)\\1+".r.replaceAllIn(readLine(), x => "$1" + x.toString.length))
}
