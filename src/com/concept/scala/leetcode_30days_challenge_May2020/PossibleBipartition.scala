package com.concept.scala.leetcode_30days_challenge_May2020

/** **
  * Day 27
  *
  * @see https://leetcode.com/explore/featured/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3342/
  *      OR
  *      https://leetcode.com/problems/possible-bipartition/
  *
  *      Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.
  *
  *      Each person may dislike some other people, and they should not go into the same group.
  *
  *      Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.
  *
  *      Return true if and only if it is possible to split everyone into two groups in this way.
  *
  *
  *
  *      Example 1:
  *
  *      Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
  *      Output: true
  *      Explanation: group1 [1,4], group2 [2,3]
  *      Example 2:
  *
  *      Input: N = 3, dislikes = [[1,2],[1,3],[2,3]]
  *      Output: false
  *      Example 3:
  *
  *      Input: N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
  *      Output: false
  *
  *
  *      Note:
  *
  *      1 <= N <= 2000
  *      0 <= dislikes.length <= 10000
  *      1 <= dislikes[i][j] <= N
  *      dislikes[i][0] < dislikes[i][1]
  *      There does not exist i != j for which dislikes[i] == dislikes[j].
  *
  *
  *
  *
  */

object PossibleBipartition {

  /** **
    * Runtime: 1096 ms, faster than 100.00% of Scala online submissions for Possible Bipartition.
    * Memory Usage: 83.8 MB, less than 100.00% of Scala online submissions for Possible Bipartition.
    *
    * 66 / 66 test cases passed.
    * Status: Accepted
    * Runtime: 1096 ms
    * Memory Usage: 83.8 MB
    *
    */
  def possibleBipartition(N: Int, dislikes: Array[Array[Int]]): Boolean = {
    val graph = Array.ofDim[Int](N, N)
    for (d <- dislikes) {
      graph(d(0) - 1)(d(1) - 1) = 1
      graph(d(1) - 1)(d(0) - 1) = 1
    }
    val group = new Array[Int](N)

    for (i <- 0 until N) {
      if (group(i) == 0 && !dfs(graph, group, i, 1)) return false
    }

    true
  }

  private def dfs(graph: Array[Array[Int]], group: Array[Int], index: Int, g: Int): Boolean = {
    group(index) = g
    for (i <- graph.indices) {

      if (graph(index)(i) == 1) {

        if (group(i) == g) return false
        if (group(i) == 0 && !dfs(graph, group, i, -(g))) return false
      }
    }
    true
  }

  def main(args: Array[String]): Unit = {
    println("")

    val arr = Array(Array(1, 2), Array(2, 3), Array(2, 4))

    println(possibleBipartition(4, arr))


  }
}
