package com.concept.scala.hackerrank.functionalProgramming

import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

/**
* @note Use functional programming, avoid imperative programming.(follwed by Version 1.1 and 1.2)
  *       This one uses tail recursion in imperative programming.(check StringCompressionAlgorithm_FunctionalVersion for functional solution)
  * @see https://www.hackerrank.com/challenges/string-compression/problem
  * @example If Input string is "abcaaabbb" => output should be abca3b3
  *
  */
object StringCompressionAlgorithm_ImperativeVersion {
  def main(args: Array[String]): Unit = {
    val str = readLine() // "aaabbberfffllllluuq"
    val ls = str.toList
    //fx(ls).foreach(println)
    println(fx(ls)
      .map(x => x._1 + "" + x._2)
      .mkString.replace("1", ""))


  }

  def fx(ls: List[Char]): ListBuffer[(Char, Int)] = {
    var result = 1
    val lx = ListBuffer[(Char, Int)]()
    f(ls, lx)

    @tailrec
    def f(ls: List[Char], lx: ListBuffer[(Char, Int)]): Unit = {

      ls match {
        case x :: Nil => lx.append((x, result))
        case x :: tail => {
          if (x == tail.head) {
            result += 1
            //println(s"$x = ${tail.head} so result is $result")
            f(tail, lx)
          }
          else {
            result = if (result > 1) result else 1
            //   println(s"$x not eqal to  ${tail.head} so result is $result")
            lx.append((x, result))
            result = 1
            f(tail, lx)
          }
        }
      }

    }

    lx
  }

}
