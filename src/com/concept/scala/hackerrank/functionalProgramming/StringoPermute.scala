package com.concept.scala.hackerrank.functionalProgramming

import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

/**
  * @author Rajesh
  * @version 1.1 
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
    //val listStr = scala.io.Source.stdin.getLines.toList

    val str = "a1b2c3d4"
    println(s"input string is $str")
    println("output string is  ")

    val num = scala.io.StdIn.readInt()
    val listInput: ListBuffer[String] = ListBuffer()

    for (i <- 1 to num)
      listInput.append(scala.io.StdIn.readLine().toString)

    /*
        println(permuteString(str.toList, 2).mkString)
        println(builtin_Permutation(str.toList, 2).mkString.substring(str.length))
    */
    for (str <- listInput)
      println(permuteString(str.toList, 2).mkString.substring(str.length))


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

  def permuteStringList(ls: List[Char], num: Int): List[Char] = {
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

