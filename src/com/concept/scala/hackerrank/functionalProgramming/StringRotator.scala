package com.concept.scala.hackerrank.functionalProgramming

import scala.collection.mutable.ListBuffer
import scala.io.StdIn

/**
* @todo Rotate the string
  * @example Input string => abc ,then output string should be =>bca cab abc
  * @note Use functional programming.
  * @see https://www.hackerrank.com/challenges/rotate-string/problem
  *
  */
object StringRotator {
  def main (args: Array[String]): Unit = {
    val listInput: ListBuffer[String] = ListBuffer()
    for (_ <- 1 to scala.io.StdIn.readLine.trim.toInt) listInput append StdIn.readLine
    // imperative + recursion
    listInput map (rotateString(_) mkString " ") foreach println
    // functional
    listInput map (rotateString_functional(_) mkString " ") foreach println

  }

  def rotateString (inputString: String): ListBuffer[String] = {
    val inputCharList = inputString toList
    val resultBuffer = ListBuffer[String]()
    var lengthOfString = (inputString length)
    if (lengthOfString == 1) resultBuffer append inputString

    def f (ls: List[Char], result: ListBuffer[String]): ListBuffer[String] = {
      if (lengthOfString >= 1) {
        ls match {
          case firstChar :: tail => {
            lengthOfString -= 1
            val tempString = (tail mkString) concat (firstChar toString)
            result append tempString
            f(tempString toList, result)
          }
        }
      }
      result
    }

    if (lengthOfString > 1) f(inputCharList, resultBuffer)
    else resultBuffer
  }

  def rotateString_functional (inputString: String): IndexedSeq[String] =
    (1 to (inputString length))
      .map(index => (inputString takeRight ((inputString length) - index)) + (inputString take index))


}

