package com.concept.scala.leetcode_30days_challenge_May2020

import com.concept.scala.RunTimeCalculation

/** **
  *
  * Day 19
  *
  * @see https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3334/
  *      OR
  *      https://leetcode.com/problems/online-stock-span/
  *
  *
  *      Write a class StockSpanner which collects daily price quotes for some stock, and returns the span of that stock's price for the current day.
  *
  *      The span of the stock's price today is defined as the maximum number of consecutive days (starting from today and going backwards) for which the price of the stock was less than or equal to today's price.
  *
  *      For example, if the price of a stock over the next 7 days were [100, 80, 60, 70, 60, 75, 85], then the stock spans would be [1, 1, 1, 2, 1, 4, 6].
  *
  *      Example 1:
  *
  *      Input: ["StockSpanner","next","next","next","next","next","next","next"], [[],[100],[80],[60],[70],[60],[75],[85]]
  *      Output: [null,1,1,1,2,1,4,6]
  *      Explanation:
  *      First, S = StockSpanner() is initialized.  Then:
  *      S.next(100) is called and returns 1,
  *      S.next(80) is called and returns 1,
  *      S.next(60) is called and returns 1,
  *      S.next(70) is called and returns 2,
  *      S.next(60) is called and returns 1,
  *      S.next(75) is called and returns 4,
  *      S.next(85) is called and returns 6.
  *
  *      Note that (for example) S.next(75) returned 4, because the last 4 prices
  *      (including today's price of 75) were less than or equal to today's price.
  *
  *
  *      Note:
  *
  *      Calls to StockSpanner.next(int price) will have 1 <= price <= 10 pow 5.
  *      There will be at most 10000 calls to StockSpanner.next per test case.
  *      There will be at most 150000 calls to StockSpanner.next across all test cases.
  *      The total time limit for this problem has been reduced by 75% for C++, and 50% for all other languages.
  *
  *
  */
class StockSpanner {

  import scala.collection.mutable

  val stack = mutable.Stack[(Int, Int)]()

  /** *
    *
    *
    * 99 / 99 test cases passed.
    * Status: Accepted
    * Runtime: 2024 ms
    * Memory Usage: 720.6 MB
    *
    * @param price
    * @return
    */
  def next (price: Int): Int = {
    var daycount = 1
    while (stack.nonEmpty && stack.top._1 <= price) {
      daycount += stack.pop()._2
    }

    stack.push((price, daycount))
    daycount
  }


}

object StockSpanner {
  def main (args: Array[String]): Unit = {
    val totalRuntime = RunTimeCalculation.calculateRunTime {
      val S = new StockSpanner()
      println(S.next(100))
      println(S.next(100)) // is called and returns 1,
      println(S.next(80)) //is called and returns 1,
      println(S.next(60)) //is called and returns 1,
      println(S.next(70)) //is called and returns 2,
      println(S.next(60)) //is called and returns 1,
      println(S.next(75)) //is called and returns 4,
      println(S.next(85)) //is called and returns 6.
    }
    println(s" total run time = seconds $totalRuntime seconds OR ${totalRuntime * 1000} milliseonds")
    /*
    1
    2
    1
    1
    2
    1
    4
    6
     total run time = seconds 0.524 seconds OR 524.0 milliseonds

     */
  }

}

