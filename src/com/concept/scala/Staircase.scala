package com.concept.scala

/**
  * @see https://www.hackerrank.com/challenges/staircase/problem
  *
  */
object Staircase {
  def main (args: Array[String]): Unit = {

    staircase(scala.io.StdIn.readInt())
  }

  def staircase (n: Int): Unit = {

    for (i <- 1 to n by 1) {
      for (j <- n to 1 by -1)
        if (i < j) print(" ") else print("#")
      println("")
    }
  }

}

/**
  * 6 (input)
  *
  * #       (output)
  * ##
  * ###
  * ####
  * #####
  * ######
  */