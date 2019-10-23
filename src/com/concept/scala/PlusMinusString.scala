package com.concept.scala

object PlusMinusString {
  def main (args: Array[String]): Unit = {
    // val ls = "-4 3 -9 0 4 1".split(" ").map(_.toInt).toList // for hackerrank
    val ls = "-4 3 -9 0 4 1".split(" ").map(_.toInt).toList // for local

    val res = f(ls)
    val len = ls.length

    println(f"${res._1 / len}%.6f")
    println("%.6f".format(res._2 / len))
    println(f"${res._3 / len}%.6f")


  }

  def f (list: List[Int]): (Double, Double, Double) =
    (list.count(_ > 0), list.count(_ == 0), list.count(_ < 0))


}
