package com.concept.scala.hackerrank.functionalProgramming

import scala.collection.mutable.ListBuffer
import scala.io.StdIn

/**
  * @author Rajesh
  * @version 1.0 (functional implementation to be done)
  * @todo Rotate the string
  * @example Input string => abc ,then output string should be =>bca cab abc
  * @note Use functional programming.
  * @see https://www.hackerrank.com/challenges/rotate-string/problem
  *
  */
object StringRotator {
  def main (args: Array[String]): Unit = {
    val listInput: ListBuffer[String] = ListBuffer()
    for (_ <- 1 to scala.io.StdIn.readLine.trim.toInt) listInput.append(StdIn.readLine())

    listInput.map(rotateString(_).mkString(" ")).foreach(println)

  }

  def rotateString (str: String): ListBuffer[String] = {
    val inputStrList = str.toList
    val res = ListBuffer[String]()
    var len = str.length
    if (len == 1) res.append(str)

    def f (ls: List[Char], result: ListBuffer[String]): ListBuffer[String] = {
      if (len >= 1) {
        ls match {
          case x :: tail => {
            len -= 1
            val tempString = tail.mkString + x.toString
            result.append(tempString)
            f(tempString.toList, result)
          }
        }
      }
      result
    }

    if (len > 1) f(inputStrList, res)
    else res
  }
}


/*
abcd
a bcd => bcda
bcd

 */