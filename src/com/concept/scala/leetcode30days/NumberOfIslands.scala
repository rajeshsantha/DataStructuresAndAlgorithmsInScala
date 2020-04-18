package com.concept.scala.leetcode30days

import scala.collection.mutable

/** *
  * Day 17
  *
  * @see https://leetcode.com/problems/number-of-islands/
  *      OR
  *      https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3302/
  *
  *      Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
  *
  *      Example 1:
  *
  *      Input:
  *      11110
  *      11010
  *      11000
  *      00000
  *
  *      Output: 1
  *      Example 2:
  *
  *      Input:
  *      11000
  *      11000
  *      00100
  *      00011
  *
  *      Output: 3
  */
object NumberOfIslands {
  def main (args: Array[String]): Unit = {


    val grid = mutable.ListBuffer(11110, 11010, 11000).map(_.toString.toCharArray)
    grid.append(Array('0', '0', '0', '0', '0'))

    println(s" result = ${numIslands(grid.toArray)}")

  }


  def numIslands (grid: Array[Array[Char]]): Int = {
    val (height, width) = (grid.length, grid.headOption.map(_.length).getOrElse(0))
    if (height == 0 || width == 0) return 0

    var countOfIslands = 0
    for (i <- 0 until height; j <- 0 until width) {

      /*
          print(s"  ${grid(i)(j)}")
          if (j == len2D - 1) println("")
    */
      if (grid(i)(j) == '1') {
        numIslandsDFS(i, j, grid, width, height)
        countOfIslands += 1
      }


    }
    countOfIslands
  }

  //directionHorizontal: Int, directionVertical: Int

  def numIslandsDFS (i: Int, j: Int, grid: Array[Array[Char]], width: Int, height: Int): Unit = {
    if (i < 0 || i >= height || j < 0 || j >= width || (grid(i)(j) == '0')) return 0
    else if (grid(i)(j) == '0') {
      numIslandsDFS(i + 1, j, grid, width, height)
      numIslandsDFS(i - 1, j, grid, width, height)
      numIslandsDFS(i, j + 1, grid, width, height)
      numIslandsDFS(i, j - 1, grid, width, height)
    }
  }
}



