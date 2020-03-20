package com.concept.scala.hackerrank.problemSolving

/***
  * @see https://www.hackerrank.com/challenges/apple-and-orange/problem
  */

object AppleandOrange {
  def main(args: Array[String]): Unit = {

    val stdin = scala.io.StdIn
    val st = stdin.readLine.split(" ")
    val s = st(0).trim.toInt
    val t = st(1).trim.toInt
    val ab = stdin.readLine.split(" ")
    val a = ab(0).trim.toInt
    val b = ab(1).trim.toInt
    val mn = stdin.readLine.split(" ")
    val m = mn(0).trim.toInt
    val n = mn(1).trim.toInt
    val apples = stdin.readLine.split(" ").map(_.trim.toInt)
    val oranges = stdin.readLine.split(" ").map(_.trim.toInt)

    countApplesAndOranges(s, t, a, b, apples, oranges)

  }
// Note :   a<s<t<b
  def countApplesAndOranges(s: Int, t: Int, a: Int, b: Int, apples: Array[Int], oranges: Array[Int]) {

    val isItOnTheHouse : (Int=>Boolean) = distance=> distance >=s && distance <=t

    println(apples map(_ + a ) count isItOnTheHouse)
    println(oranges map(_ + b ) count isItOnTheHouse )

  }

}
