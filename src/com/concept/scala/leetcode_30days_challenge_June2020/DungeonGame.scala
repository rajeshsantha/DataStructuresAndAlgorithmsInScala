package com.concept.scala.leetcode_30days_challenge_June2020

import com.concept.scala.RunTimeCalculation

/**
  * Day 21
  *
  * @see https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/541/week-3-june-15th-june-21st/3367/
  *      OR
  *      https://leetcode.com/problems/dungeon-game/
  *
  *      The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.
  *
  *      The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.
  *
  *      Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).
  *
  *      In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.
  *
  *
  *
  *      Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.
  *
  *      For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.
  *
  *      -2(K)	 -3	      3
  *      -5	     -10	    1
  *      10	      30	    -5(P)
  *
  *
  *      Note:
  *
  *      The knight's health has no upper bound.
  *      Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.
  *      Accepted
  *      88,999
  *      Submissions
  *      295,629
  *
  *
  */
object DungeonGame {
  def main (args: Array[String]): Unit = {
    val dungeon = Array(Array(-2, -3, 3), Array(-5, -10, 1), Array(10, 30, -5))

    val oneDim_runtime = RunTimeCalculation.calculateRunTime(println(calculateMinimumHP_1D(dungeon)))
    val twoDim_runtime = RunTimeCalculation.calculateRunTime(println(calculateMinimumHP_2D(dungeon)))

    println(s" calculateMinimumHP_1D total run time = $oneDim_runtime seconds OR ${oneDim_runtime * 1000} milliseonds")
    println(s" calculateMinimumHP_2D total run time = $twoDim_runtime seconds OR ${twoDim_runtime * 1000} milliseonds")
    /*
    7
    7
     calculateMinimumHP_1D total run time = 1.665 seconds OR 1665.0 milliseonds
     calculateMinimumHP_2D total run time = 0.023 seconds OR 23.0 milliseonds
    */
  }

  /** **
    * Runtime: 496 ms, faster than 50.00% of Scala online submissions for Dungeon Game.
    * Memory Usage: 53.3 MB, less than 25.00% of Scala online submissions for Dungeon Game.
    *
    *
    * 45 / 45 test cases passed.
    * Status: Accepted
    * Runtime: 496 ms
    * Memory Usage: 53.3 MB
    *
    */
  def calculateMinimumHP_1D (dungeon: Array[Array[Int]]): Int = {
    if (dungeon == null || dungeon.length == 0 || dungeon.head == null || dungeon.head.length == 0) return 0

    val colLength = dungeon.head.length
    val dp = Array.fill[Int](colLength + 1)(Int.MaxValue)
    dp(colLength - 1) = 1


    for (row <- dungeon.length - 1 to 0 by -1; col <- colLength - 1 to 0 by -1)
      dp(col) = math.max(1, math.min(dp(col), dp(col + 1)) - dungeon(row)(col))

    dp.head
  }

  /** **
    * Runtime: 508 ms, faster than 50.00% of Scala online submissions for Dungeon Game.
    * Memory Usage: 52.2 MB, less than 50.00% of Scala online submissions for Dungeon Game.
    *
    * 45 / 45 test cases passed.
    * Status: Accepted
    * Runtime: 508 ms
    * Memory Usage: 52.2 MB
    *
    */
  def calculateMinimumHP_2D (dungeon: Array[Array[Int]]): Int = {
    if (dungeon == null || dungeon.length == 0 || dungeon.head == null || dungeon.head.length == 0) return 0

    val m = dungeon.length
    val n = dungeon.head.length
    val dp = Array.ofDim[Int](m, n)

    for (i <- m - 1 to 0 by -1; j <- n - 1 to 0 by -1) {
      if (i == m - 1 && j == n - 1)
        dp(m - 1)(n - 1) = math.max(1, 1 - dungeon(m - 1)(n - 1))
      else if (i == m - 1)
        dp(m - 1)(j) = math.max(1, dp(m - 1)(j + 1) - dungeon(m - 1)(j))
      else if (j == n - 1)
        dp(i)(n - 1) = math.max(1, dp(i + 1)(n - 1) - dungeon(i)(n - 1))
      else
        dp(i)(j) = math.min(math.max(1, dp(i + 1)(j) - dungeon(i)(j)), math.max(1, dp(i)(j + 1) - dungeon(i)(j)))
    }

    dp.head.head
  }

}
