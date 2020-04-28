package com.concept.scala.leetcode_30days_challenge_April2020

/** **
  *
  * Day 26
  *
  * @see https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/531/week-4/3312/
  *      OR
  *      https://leetcode.com/problems/maximal-square/
  *
  *      Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
  *
  *      Example:
  *
  *      Input:
  *
  *      1 0 1 0 0
  *      1 0 1 1 1
  *      1 1 1 1 1
  *      1 0 0 1 0
  *
  *      Output: 4
  *
  *      Runtime: 520 ms, faster than 100.00% of Scala online submissions for Maximal Square.
  *      Memory Usage: 53.6 MB, less than 100.00% of Scala online submissions for Maximal Square.
  *
  *
  *      69 / 69 test cases passed.
  *      Status: Accepted
  *      Runtime: 544 ms
  *      Memory Usage: 53.9 MB
  *
  *
  */
object MaximalSquare {

  def maximalSquare(matrix: Array[Array[Char]]): Int = {

    val rowSize = matrix.length
    if (rowSize == 0) return 0
    val colSize = matrix.head.length

    var largestSquare = 0

    val tempArray: Array[Array[Int]] = Array.ofDim[Int](rowSize + 1, colSize + 1)

    for (i <- 1 to rowSize; j <- 1 to colSize) {
      if (matrix(i - 1)(j - 1) == '1') {

        tempArray(i)(j) = 1 + math.min(math.min(tempArray(i)(j - 1), tempArray(i - 1)(j)), tempArray(i - 1)(j - 1))
        if (largestSquare < tempArray(i)(j))
          largestSquare = tempArray(i)(j)
      }
    }
    largestSquare * largestSquare
  }

  def main(args: Array[String]): Unit = {
    println(maximalSquare(string_To_2DArray("""[["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]""")))


  }

  def string_To_2DArray(str: String): Array[Array[Char]] = {
    val stringToCharArray: String => Array[Char] = _.replace("\"", "").replace(",", "").toCharArray

    val str1 = str.replace(']', ')').replace('[', '(').split("\\),\\(")

    val arr0 = str1.head.replace("(", "").replace("\"", "").replace(",", "").toCharArray
    val arr1 = stringToCharArray(str1(1))
    val arr2 = stringToCharArray(str1(2))
    val arr3 = str1.last.replace(")", "").replace("\"", "").replace(",", "").toCharArray

    Array(arr0, arr1, arr2, arr3)
  }

}
