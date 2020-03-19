package com.concept.scala.hackerrank.warmups

import scala.collection.mutable.HashSet

/** *
  *
  * @see https://www.hackerrank.com/challenges/sock-merchant/problem
  */

object SockMerchant {
  def main (args: Array[String]): Unit = {
    val newArr = "10 20 20 10 10 30 50 10 20".split(" ").map(_.trim.toInt)

    println(sockMerchant_functional(10, newArr))
    println(sockMerchant_ForLoop(newArr))
  }

  def sockMerchant_functional (n: Int, ar: Array[Int]): Int = {

    val pairedTuples = ar.sorted.groupBy(identity).mapValues(_.size).toList.filterNot(x => x._2 == 1)
    pairedTuples.map(_._2).map(_ / 2).sum

  }

  def sockMerchant_ForLoop (ar: Array[Int]): Int = {
    val colors: HashSet[Int] = HashSet[Int]()
    var pairs = 0
    for (i <- ar.indices) {
      //  println(s"at $i  = ${ar(i)}")
      if (colors.contains(ar(i))) {
        pairs += 1
        //   println("pair added .. pair count " + pairs)
        colors.remove(ar(i))
      } else {
        colors.add(ar(i))
        // println("color added .. " + colors)

      }
    }
    pairs
  }
}
