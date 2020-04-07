package com.concept.scala.leetcode30days

import scala.collection.mutable.ListBuffer

/** *
  * Day 5
  *
  * @see https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/submissions/
  *      201 / 201 test cases passed.
  *      Status: Accepted
  *      Runtime: 488 ms
  *      Memory Usage: 50.9 MB
  *
  *      Runtime: 488 ms, faster than 82.61% of Scala online submissions for Best Time to Buy and Sell Stock II.
  *      Memory Usage: 50.9 MB, less than 100.00% of Scala online submissions for Best Time to Buy and Sell Stock II.
  *
  */

object BestTimeStockProfit2 {
  def main (args: Array[String]): Unit = {
    val arr = Array(7, 1, 5, 3, 6, 4)
    val arr1 = Array(1, 2, 3, 4, 5)
    val arr2 = Array(7, 6, 4, 3, 1)
    val arr3 = Array(1, 2)
    println(maxProfit(arr1))
  }

  def maxProfit (prices: Array[Int]): Int = {

    val profitCollection: ListBuffer[Int] = ListBuffer.empty
    if (prices.length < 2) { //to make sure if we have enough days to get profit
      profitCollection.sum
    }
    else {
      for (currentDay <- prices.indices if currentDay != 0) { // ignoring the first day as we are evaluating the profit after it's completion
        if (prices(currentDay) > prices(currentDay - 1)) { // if price is less than yesterday's
          profitCollection += (prices(currentDay) - prices(currentDay - 1))
        }
      }
      profitCollection.sum
    }
  }
}
