package com.concept.scala.hackerrank.warmups

/**
  * @see https://www.hackerrank.com/challenges/chocolate-feast/problem
  * 43203 / 60 = 720 chocolates ( 3 dollars left and you cannot buy any more chocolate for 3 dollar )
  *
  * 720 / 5 = 144 chocolates ( we can buy 144 chocolates from 720 wrappers )
  *
  * 144 / 5 = 28 chocolates ( we can buy 28 chocolates from 144 wrappers, 4 wrappers left )
  *
  * (28 + 4 ) / 5 = 6 ( 28 wrappers + 4 wrappers left from 144, we can buy 6 chocolates )
  *
  * (6 + 2) / 5 = 1 ( 6 wrappers + 2 wrappers left from 32 wrappers, we can buy 1 chocolate )
  *
  *
  * This sums to 720 + 144 + 28 + 6 + 1 = 899.
  */
object ChocolateFeast {
  def main (args: Array[String]): Unit = {
    var (intialAmount, costOfchoc, wrapperCost) = (43203, 60, 5)

    var totalChocolates = intialAmount / costOfchoc //720
    var totalWrappers = totalChocolates //720
    var freeChocolatesWithWrappers = 0 //0
    var wrappersToReturn = 0
    while (wrapperCost <= totalWrappers) {
      println(s"$wrapperCost <= $totalWrappers ")

      print(s"$totalWrappers - ($totalWrappers % $wrapperCost) =>")
      wrappersToReturn = totalWrappers - (totalWrappers % wrapperCost) //720+ 0
      print(wrappersToReturn)

      println()
      print(s"$freeChocolatesWithWrappers + ($wrappersToReturn / $wrapperCost) =>")
      freeChocolatesWithWrappers += (wrappersToReturn / wrapperCost) //0+720/5 =144
      print(freeChocolatesWithWrappers)

      println()
      print(s"$totalWrappers - ($wrappersToReturn + $freeChocolatesWithWrappers) =>")
      totalWrappers -= wrappersToReturn + freeChocolatesWithWrappers //720 - 720 + 144 = 144
      print(totalWrappers)

      println()
      print(s"$totalChocolates - $freeChocolatesWithWrappers  =>")
      totalChocolates += freeChocolatesWithWrappers // 720+144
      print(totalChocolates)

    }
    println("Total Result is = " + totalChocolates);

  }
}
