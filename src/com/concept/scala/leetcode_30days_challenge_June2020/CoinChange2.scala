package com.concept.scala.leetcode_30days_challenge_June2020

/** ***
  * Day 7
  *
  * @see https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3353/
  *      OR
  *      https://leetcode.com/problems/coin-change-2/
  *
  *
  *      You are given coins of different denominations and a total amount of money.
  *      Write a function to compute the number of combinations that make up that amount.
  *      You may assume that you have infinite number of each kind of coin.
  *
  *
  *
  *      Example 1:
  *
  *      Input: amount = 5, coins = [1, 2, 5]
  *      Output: 4
  *      Explanation: there are four ways to make up the amount:
  *      5=5
  *      5=2+2+1
  *      5=2+1+1+1
  *      5=1+1+1+1+1
  *      Example 2:
  *
  *      Input: amount = 3, coins = [2]
  *      Output: 0
  *      Explanation: the amount of 3 cannot be made up just with coins of 2.
  *      Example 3:
  *
  *      Input: amount = 10, coins = [10]
  *      Output: 1
  *
  *
  *      Note:
  *
  *      You can assume that
  *
  *      0 <= amount <= 5000
  *      1 <= coin <= 5000
  *      the number of coins is less than 500
  *      the answer is guaranteed to fit into signed 32-bit integer
  *
  *
  *
  *
  */
object CoinChange2 {

  def main(args: Array[String]): Unit = {

    println("final output = " + change(5, Array(1, 2, 5)))
    println("final output = " + change(3, Array(2)))
    println("final output = " + change(5, Array(2, 5)))
  }

  /** *
    * Runtime: 452 ms, faster than 81.82% of Scala online submissions for Coin Change 2.
    * Memory Usage: 50 MB, less than 90.91% of Scala online submissions for Coin Change 2.
    *
    *
    * 27 / 27 test cases passed.
    * Status: Accepted
    * Runtime: 452 ms
    * Memory Usage: 50 MB
    *
    */
  def change(amount: Int, coins: Array[Int]): Int = {
    val arr = Array.fill(amount + 1)(0)
    arr(0) = 1
    for (coin <- coins) {
      for (i <- coin to amount) {
        print(s"coin = $coin and i = $i ==>   ${arr(i)} + ${arr(i - coin)}  => arr($i) += arr($i - $coin)}")
        arr(i) += arr(i - coin)
        print(s"\t after  => ${arr(i)} + ${arr(i - coin)} \t ")
        arr.foreach(x => print(x + " "))
        println
      }
      println
    }
    arr(amount)
  }

  /*
  output log:

            coin = 1 and i = 1 ==>   0 + 1  => arr(1) += arr(1 - 1)}	 after  => 1 + 1 	 1 1 0 0 0 0
            coin = 1 and i = 2 ==>   0 + 1  => arr(2) += arr(2 - 1)}	 after  => 1 + 1 	 1 1 1 0 0 0
            coin = 1 and i = 3 ==>   0 + 1  => arr(3) += arr(3 - 1)}	 after  => 1 + 1 	 1 1 1 1 0 0
            coin = 1 and i = 4 ==>   0 + 1  => arr(4) += arr(4 - 1)}	 after  => 1 + 1 	 1 1 1 1 1 0
            coin = 1 and i = 5 ==>   0 + 1  => arr(5) += arr(5 - 1)}	 after  => 1 + 1 	 1 1 1 1 1 1

            coin = 2 and i = 2 ==>   1 + 1  => arr(2) += arr(2 - 2)}	 after  => 2 + 1 	 1 1 2 1 1 1
            coin = 2 and i = 3 ==>   1 + 1  => arr(3) += arr(3 - 2)}	 after  => 2 + 1 	 1 1 2 2 1 1
            coin = 2 and i = 4 ==>   1 + 2  => arr(4) += arr(4 - 2)}	 after  => 3 + 2 	 1 1 2 2 3 1
            coin = 2 and i = 5 ==>   1 + 2  => arr(5) += arr(5 - 2)}	 after  => 3 + 2 	 1 1 2 2 3 3

            coin = 5 and i = 5 ==>   3 + 1  => arr(5) += arr(5 - 5)}	 after  => 4 + 1 	 1 1 2 2 3 4

            final output = 4




            coin = 2 and i = 2 ==>   0 + 1  => arr(2) += arr(2 - 2)}	 after  => 1 + 1 	 1 0 1 0
            coin = 2 and i = 3 ==>   0 + 0  => arr(3) += arr(3 - 2)}	 after  => 0 + 0 	 1 0 1 0

            final output = 0



            coin = 2 and i = 2 ==>   0 + 1  => arr(2) += arr(2 - 2)}	 after  => 1 + 1 	 1 0 1 0 0 0
            coin = 2 and i = 3 ==>   0 + 0  => arr(3) += arr(3 - 2)}	 after  => 0 + 0 	 1 0 1 0 0 0
            coin = 2 and i = 4 ==>   0 + 1  => arr(4) += arr(4 - 2)}	 after  => 1 + 1 	 1 0 1 0 1 0
            coin = 2 and i = 5 ==>   0 + 0  => arr(5) += arr(5 - 2)}	 after  => 0 + 0 	 1 0 1 0 1 0

            coin = 5 and i = 5 ==>   0 + 1  => arr(5) += arr(5 - 5)}	 after  => 1 + 1 	 1 0 1 0 1 1

            final output = 1

   */
}
