package com.concept.scala.leetcode_30days_challenge_May2020

import com.concept.scala.RunTimeCalculation

/** *
  * Day 11
  *
  * @see https://leetcode.com/explore/featured/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3326/
  *      OR
  *      https://leetcode.com/problems/flood-fill/
  *
  *
  *
  *      An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).
  *
  *      Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.
  *
  *      To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.
  *
  *      At the end, return the modified image.
  *
  *      Example 1:
  *      Input:
  *      image = [[1,1,1],[1,1,0],[1,0,1]]
  *      sr = 1, sc = 1, newColor = 2
  *      Output: [[2,2,2],[2,2,0],[2,0,1]]
  *      Explanation:
  *      From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected
  *      by a path of the same color as the starting pixel are colored with the new color.
  *      Note the bottom corner is not colored 2, because it is not 4-directionally connected
  *      to the starting pixel.
  *      Note:
  *
  *      The length of image and image[0] will be in the range [1, 50].
  *      The given starting pixel will satisfy 0 <= sr < image.length and 0 <= sc < image[0].length.
  *      The value of each color in image[i][j] and newColor will be an integer in [0, 65535].
  *
  *
  *
  */
object FloodFill {

  def main (args: Array[String]): Unit = {
    val image = Array(Array(1, 1, 1), Array(1, 1, 0), Array(1, 0, 1))
    val (sr, sc, newColor) = (1, 1, 2)

    //    println(floodFill_ByDFS(image, sr, sc, newColor).map(_.mkString).mkString("\n"))
    //    println(floodFill_ByBFS(image, sr, sc, newColor).map(_.mkString).mkString("\n"))

    val floodFill_ByDFS_runtime = RunTimeCalculation.calculateRunTime(println(floodFill_ByBFS(image, sr, sc, newColor).map(_.mkString).mkString("\n")))
    println(s"floodFill_ByDFS_runtime  Intellij IDEA runtime => total run time = seconds $floodFill_ByDFS_runtime  seconds OR ${floodFill_ByDFS_runtime * 1000} milliseonds")

    val floodFill_ByBFS_runtime = RunTimeCalculation.calculateRunTime(println(floodFill_ByBFS(image, sr, sc, newColor).map(_.mkString).mkString("\n")))
    println(s"floodFill_ByBFS Intellij IDEA runtime => total run time = seconds $floodFill_ByBFS_runtime seconds OR ${floodFill_ByBFS_runtime * 1000} milliseonds")

    /*


    222
    220
    201
    floodFill_ByDFS_runtime  Intellij IDEA runtime => total run time = seconds 0.518  seconds OR 518.0 milliseonds
    222
    220
    201
    floodFill_ByBFS Intellij IDEA runtime => total run time = seconds 0.001 seconds OR 1.0 milliseonds


    here BFS >>>>>> DFS as distance between nodes are very short
     */
  }

  /** *
    *
    * Depth First Search approach
    *
    * 277 / 277 test cases passed.
    * Status: Accepted
    * Runtime: 508 ms
    * Memory Usage: 51 MB
    *
    * floodFill_ByDFS_runtime  Intellij IDEA runtime => total run time = seconds 0.593  seconds OR 593.0 milliseonds
    *
    * Runtime: 540 ms, faster than 66.67% of Scala online submissions for Flood Fill.
    * Memory Usage: 52.9 MB, less than 100.00% of Scala online submissions for Flood Fill.
    *
    */
  def floodFill_ByDFS (image: Array[Array[Int]], sr: Int, sc: Int, newColor: Int): Array[Array[Int]] = {

    if (image(sr)(sc) == newColor) return image

    def fill (image: Array[Array[Int]], sr: Int, sc: Int, color: Int, newColor: Int): Unit = {
      if (sc < 0 || sr < 0 || sr >= image.length || sc >= image.head.length || image(sr)(sc) != color) {}
      else {
        image(sr)(sc) = newColor
        fill(image, sr - 1, sc, color, newColor) // top
        fill(image, sr + 1, sc, color, newColor) // bottom
        fill(image, sr, sc - 1, color, newColor) // left
        fill(image, sr, sc + 1, color, newColor) // right
      }
    }

    fill(image, sr, sc, image(sr)(sc), newColor)

    image
  }


  /** **
    *
    * Breadth First Search approach
    *
    * Runtime: 508 ms, faster than 95.24% of Scala online submissions for Flood Fill.
    * Memory Usage: 53.2 MB, less than 100.00% of Scala online submissions for Flood Fill.
    *
    * floodFill_ByBFS Intellij IDEA runtime => total run time = seconds 0.0 seconds OR 1.0 milliseonds
    *
    * 277 / 277 test cases passed.
    * Status: Accepted
    * Runtime: 584 ms
    * Memory Usage: 54.3 MB
    *
    */
  def floodFill_ByBFS (image: Array[Array[Int]], sr: Int, sc: Int, newColor: Int): Array[Array[Int]] = {
    import scala.collection.mutable
    import util.control.Breaks._

    val previousColor = image(sr)(sc)
    if (previousColor == newColor) return image
    val queue = mutable.Queue.empty[(Int, Int)]
    queue.enqueue((sr, sc))

    while (queue.nonEmpty) {
      val (r, c): (Int, Int) = queue.dequeue
      breakable {
        if (r < 0 || r >= image.length || c < 0 || c >= image.head.length || image(r)(c) != previousColor) {
          break // break out of the 'breakable', continue the outside loop
        } else {
          image(r)(c) = newColor
          queue.enqueue((r - 1, c))
          queue.enqueue((r + 1, c))
          queue.enqueue((r, c - 1))
          queue.enqueue((r, c + 1))
        }
      }

    }
    image

  }
}
