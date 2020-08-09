package com.concept.scala.leetcode_30days_challenge_August2020

/** **
  *
  * Day 9
  *
  * @todo In a given grid, each cell can have one of three values:
  *       the value 0 representing an empty cell;
  *       the value 1 representing a fresh orange;
  *       the value 2 representing a rotten orange.
  *       Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
  *       Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.
  * @example Example 1:
  *          Input: [[2,1,1],[1,1,0],[0,1,1]]
  *          Output: 4
  *
  *          Example 2:
  *          Input: [[2,1,1],[0,1,1],[1,0,1]]
  *          Output: -1
  *          Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
  *
  *          Example 3:
  *          Input: [[0,2]]
  *          Output: 0
  *          Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
  * @note 1 <= grid.length <= 10
  *       1 <= grid[0].length <= 10
  *       grid[i][j] is only 0, 1, or 2.
  * @see https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/550/week-2-august-8th-august-14th/3418/
  *      OR
  *      https://leetcode.com/problems/rotting-oranges/
  *
  */
object RottingOranges {
  def main(args: Array[String]): Unit = {
    val a = Array(Array(2, 1, 1), Array(1, 1, 0), Array(0, 1, 1))
    val b = Array(Array(2, 1, 1), Array(0, 1, 1), Array(1, 0, 1))
    val c = Array(Array(0, 2))
    printArray(a)
    println(orangesRotting(a))
    println(orangesRotting(b))
    println(orangesRotting(c))
  }

  def printArray(arr: Array[Array[Int]]): Unit = arr.foreach { array => println(array mkString " ") }

  val dirs: Array[Array[Int]] = Array(Array(-1, 0), Array(1, 0), Array(0, 1), Array(0, -1))

  /** *
    * 303 / 303 test cases passed.
    * Status: Accepted
    * Runtime: 536 ms
    * Memory Usage: 53.4 MB
    *
    */
  def orangesRotting(grid: Array[Array[Int]]): Int = {

    if (grid == null || grid.length == 0 || grid(0).length == 0) return -1
    val (m, n) = (grid.length, grid(0).length)
    var fresh = 0
    val queue = scala.collection.mutable.Queue[Array[Int]]()

    for (i <- 0 until m; j <- 0 until n) if (grid(i)(j) == 1) fresh += 1 else if (grid(i)(j) == 2) queue.enqueue(Array[Int](i, j))

    var step = 0
    while (queue nonEmpty) {
      val size = queue.size
      for (i <- 0 until size) {
        val bad = queue.dequeue()
        for (dir <- dirs) {
          val x = bad(0) + dir(0)
          val y = bad(1) + dir(1)
          if (x >= 0 && y >= 0 && x < m && y < n && grid(x)(y) == 1) {
            grid(x)(y) = 2
            queue.enqueue(Array[Int](x, y))
            fresh -= 1
            if (fresh == 0) return step + 1
          }
        }
      }
      step += 1
    }
    if (fresh == 0) 0
    else -1
  }

}
