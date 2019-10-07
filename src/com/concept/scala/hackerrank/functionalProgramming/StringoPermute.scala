package com.concept.scala.hackerrank.functionalProgramming

import scala.annotation.tailrec

/**
  * @author Rajesh
  * @version 1.1 (not completed yet tail-recursion,recusion implementation)
  * @todo String Permutations based on the input
  * @usecase Implement the solution in all 3 ways.
  *          i)  With Built-in libraries
  *          ii) With recursion
  *          iii)With Tail-recursion
  * @note Use functional programming, avoid imperative programming
  * @see https://www.hackerrank.com/challenges/string-o-permute/problem
  */

object StringoPermute {
  def main(args: Array[String]): Unit = {

    val str = "a1b2c3d4"
    println(s"input string is $str")
    print("output string is  ")
    print(permuteString(str.toList, 2).mkString)
    print(builtin_Permutation(str.toList, 2).mkString.substring(str.size))


  }

  def permuteString(ls: List[Char], num: Int): List[Char] = {
    val acc = List[Char]()

    @tailrec
    def f(ls: List[Char], acc: List[Char]): List[Char] = {
      ls match {
        //case _ :: Nil => acc
        case Nil => acc
        case x :: y :: tail => f(tail, acc ++ List(y, x))
      }
    }

    f(ls, acc)
  }

  def builtin_Permutation(list: List[Char], num: Int): List[Char] = {
    list.grouped(num).map(x => x.reverse).toList.flatten

  }
}
