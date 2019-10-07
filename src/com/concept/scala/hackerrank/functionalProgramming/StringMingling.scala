package com.concept.scala.hackerrank.functionalProgramming

/**
  * @author Rajesh
  * @version 1.2
  * @todo String mingling
  * @example if string1 is "abcd", string2 is "1234", output should be "a1b2c3d4"
  * @usecase Implement the solution in all 3 ways.
  *          i)  With Built-in libraries
  *          ii) With recursion
  *          iii)With Tail-recursion
  * @note Use functional programming, avoid imperative programming
  * @see
  */
object StringMingling {

  def main(args: Array[String]): Unit = {
    /*
    val first = "abcd"
    val second = "1234"
    */

    val List(first, second) = List(scala.io.StdIn.readLine(), scala.io.StdIn.readLine())

    println(tail_recursive_StringMingling(first.toList, second.toList).mkString)
    println(recursive_StringMingling(first.toList, second.toList).mkString)
    println(builtIn_StringMingling(first, second).mkString)


  }

  def tail_recursive_StringMingling(str1: List[Char], str2: List[Char]): List[Char] = {

    def tail_recursive_StringMinglingHelper(str1: List[Char], str2: List[Char], acc: List[Char]): List[Char] = {

      if (str1.isEmpty) acc
      else
        tail_recursive_StringMinglingHelper(str1.tail, str2.tail, acc ++ List(str1.head, str2.head))

    }

    tail_recursive_StringMinglingHelper(str1, str2, Nil)


  }

  def recursive_StringMingling(str1: List[Char], str2: List[Char]): List[Char] = {

    if (str1.isEmpty) Nil
    else
      str1.head :: str2.head :: recursive_StringMingling(str1.tail, str2.tail)

  }

  def builtIn_StringMingling(str1: String, str2: String): String = {

    str1.zip(str2).flatMap(t => t._1 + "" + t._2).mkString

  }

}
