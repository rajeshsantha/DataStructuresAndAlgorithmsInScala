package com.concept.scala.hackerrank.functionalProgramming

import scala.annotation.tailrec
import scala.collection.mutable

/**
  * @author Rajesh
  * @version 1.0
  * @todo String Reductions based on the input
  * @usecase Implement the solution in all 3 ways.
  *          i)  With Built-in libraries
  *          ii) With recursion
  *          iii)With Tail-recursion
  *          iv) pure functional with no additional data strucutres
  * @note Use functional programming, avoid imperative programming
  * @see https://www.hackerrank.com/challenges/string-reductions/problem
  */

object StringReductions {
  val result = mutable.LinkedHashSet[Char]()

  def main (args: Array[String]): Unit = {
    //val str = scala.io.StdIn.readLine()       // Dynamic input for hackerrank
    val str = "abcddefghhdcc"                   // Hardcoding input for local
    println(stringReduce_builtIn(str))          // output : abcdefgh
    println(stringReduce_recursive(str))        // output : abcdefgh
    println(stringReduce_recursive_tail(str))   // output : abcdefgh
    println(stringReduce_functional(str))       // output : abcdefgh

  }

  /**
    *
    * @param str
    * @return reduced string
    * @usecase builtIn implementation
    */

  def stringReduce_builtIn (str: String): String = str.toCharArray.distinct.mkString

  /**
    *
    * @param str
    * @return reduced string
    * @usecase recursive implementation
    */
  def stringReduce_recursive (str: String): String = {
    val ls = str.toList
    ls match {
      case Nil => Nil
      case _ :: Nil => result
      case x :: tail => result += x; stringReduce_recursive(tail.mkString)
    }
    result.mkString
  }

  /**
    *
    * @param str
    * @return reduced string
    * @usecase tail recursive implementation
    */
  def stringReduce_recursive_tail (str: String): String = {
    val ls = str.toList

    @tailrec
    def f (ls: List[Char], acc: mutable.LinkedHashSet[Char]): mutable.LinkedHashSet[Char] = {
      ls match {
        case _ :: Nil => acc
        case x :: tail => f(tail, acc += x)
      }
    }

    f(ls, result).mkString
  }

  /**
    *
    * @param str
    * @return reduced string
    * @usecase functional implementation without additonal data structures
    */
  def stringReduce_functional (str: String): String = {
    str.toList.foldLeft("") {
      (acc, char) => if (acc.contains(char)) acc else acc.concat(char.toString)
    }
  }
}
