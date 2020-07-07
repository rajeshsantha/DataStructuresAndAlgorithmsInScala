package com.concept.scala.leetcode_30days_challenge_July2020

/** *
  * Day 7
  *
  * @todo You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.
  *       Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).
  *       The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
  * @example Input:
  *          [0,1,0,0],
  *          [1,1,1,0],
  *          [0,1,0,0],
  *          [1,1,0,0]
  *          *          Output: 16
  *          *          Explanation: The perimeter is the 16 yellow stripes in the image below
  * @see https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/544/week-1-july-1st-july-7th/3383/
  *      OR
  *      https://leetcode.com/problems/island-perimeter
  *
  *
  *
  */
object IslandPerimeter {
  def main(args: Array[String]): Unit = {

  }

  def islandPerimeter(grid: Array[Array[Int]]): Int = {
    var perimeter = 0
    for (i <- grid.indices; j <- grid.head.indices) if (grid(i)(j) == 1) perimeter += count(grid, i, j)
    perimeter
  }

  def count(grid: Array[Array[Int]], i: Int, j: Int): Int = {
    var count = 0
    if (i - 1 < 0 || grid(i - 1)(j) == 0) count += 1
    if (i + 1 >= grid.length || grid(i + 1)(j) == 0) count += 1
    if (j - 1 < 0 || grid(i)(j - 1) == 0) count += 1
    if (j + 1 >= grid(i).length || grid(i)(j + 1) == 0) count += 1
    count
  }
}