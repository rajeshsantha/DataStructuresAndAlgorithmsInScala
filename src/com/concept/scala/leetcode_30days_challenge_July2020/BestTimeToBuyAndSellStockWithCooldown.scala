package com.concept.scala.leetcode_30days_challenge_July2020

/** **
  * Day 29
  *
  * @todo Say you have an array for which the ith element is the price of a given stock on day i.
  *       Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
  *       You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
  *       After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
  * @example Example:
  *          Input: [1,2,3,0,2]
  *          Output: 3
  *          Explanation: transactions = [buy, sell, cooldown, buy, sell]
  * @see https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/548/week-5-july-29th-july-31st/3405/
  *      OR
  *      https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
  *
  */
object BestTimeToBuyAndSellStockWithCooldown {
  def main(args: Array[String]): Unit = {
    val prices = Array(1, 2, 3, 0, 2)
    println(maxProfit(prices))
  }

  /** *
    * 211 / 211 test cases passed.
    * Status: Accepted
    * Runtime: 596 ms
    * Memory Usage: 62.7 MB
    *
    */
  def maxProfit(prices: Array[Int]): Int = {

    var buy = Int.MaxValue
    var (free, last, now) = (0, 0, 0)

    prices foreach { x =>
      now = math.max(last, x - buy)
      buy = math.min(buy, x - free)
      free = last
      last = now
    }
    now
  }

}
