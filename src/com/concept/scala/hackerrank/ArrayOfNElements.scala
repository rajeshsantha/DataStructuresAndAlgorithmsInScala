package com.concept.scala.hackerrank

import scala.io.StdIn

/**
  * @author Rajesh Santha
  * @version 1.0 (No further revison)
  * @todo
  * Create an array of  integers, where the value of  is passed as an argument to the pre-filled function in your editor.
  * This challenge uses a custom checker.
  * if input is num = 4 , return exactly the format [1,2,3,4] , inlcuding the '[',']'
  *
  * @note Use functional programming, avoid imperative programming.
  *
  */
object ArrayOfNElements extends App {

  val num = StdIn.readInt()

  println(f(num.toString.toInt).mkString("[", ",", "]"))

  def f(num: Int) = {
    List.range(0, num)

  }


}
