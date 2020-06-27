package com.concept.scala.hackerrank.functionalProgramming

import scala.collection.mutable.HashSet
import scala.io.StdIn._

/**
  * @todo identifying a relation which represents a valid function. i.e "Is f(x)=x ?"
  * @note Use functional programming, avoid imperative programming (no Vars, no loops, no side effects)
  * @see https://www.hackerrank.com/challenges/functions-or-not/problem
  *
  */

object FunctionsOrNot {
  def main(args: Array[String]) {

    val T = readInt()
    (1 to T).map { t =>

      val pairs = (1 to readInt()).map { x =>
        readLine()
      }
      val value = pairs.map(_.split("\\s+")).map(_ (0))
      val uniq = new HashSet() ++ value
      if (value.length == uniq.size) "YES" else "NO"
    }.foreach(println)
  }

}
