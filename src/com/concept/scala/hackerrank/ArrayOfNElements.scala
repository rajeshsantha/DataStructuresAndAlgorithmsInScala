package com.concept.scala.hackerrank

import scala.io.StdIn

object ArrayOfNElements extends App {

  val num = StdIn.readInt()

  println(f(num.toString.toInt).mkString("[", ",", "]"))

  def f(num: Int) = {
    List.range(0, num)

  }


}
