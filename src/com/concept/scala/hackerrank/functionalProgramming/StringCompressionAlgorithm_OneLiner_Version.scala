package com.concept.scala.hackerrank.functionalProgramming

/**
  * @author Rajesh
  * @note Use functional programming, avoid imperative programming.(follwed by Version 1.1 and 1.2)
  *       This one is a one-linere in functional programming with the help of regular expression in scala. 
  * @see https://www.hackerrank.com/challenges/string-compression/problem
  * @example If Input string is "abcaaabbb" => output should be abca3b3
  *
  */
object StringCompressionAlgorithm_OneLiner_Version extends App {
//abbbbcdeeerxxxxxxxxxghsd
  println("(\\w)\\1+".r.replaceAllIn(readLine(), x => "$1" + x.toString.length))
}
