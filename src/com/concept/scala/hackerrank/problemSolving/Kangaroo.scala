package com.concept.scala.hackerrank.problemSolving

object Kangaroo {

  /***
    *
    * @see https://www.hackerrank.com/challenges/kangaroo/problem
    */

  def main(args: Array[String]) {

    val stdin = scala.io.StdIn
    val x1V1X2V2 = stdin.readLine.split(" ")
    val x1 = x1V1X2V2(0).trim.toInt
    val v1 = x1V1X2V2(1).trim.toInt
    val x2 = x1V1X2V2(2).trim.toInt
    val v2 = x1V1X2V2(3).trim.toInt

    
println(kangaroo(x1, v1, x2, v2))

  }
  def kangaroo(x1: Int, v1: Int, x2: Int, v2: Int): String = {

    if((v1>v2) && (x1-x2)%(v2-v1) ==0 ) "YES" else "NO"


  }
 //0 2 5 3
//0 3 4 2 = YES but  4 2 0 3 = NO  because x2 is always greater than x1 as given in problem statement.

}
