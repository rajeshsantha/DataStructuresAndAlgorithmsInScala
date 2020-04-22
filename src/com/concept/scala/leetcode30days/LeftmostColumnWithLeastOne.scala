package com.concept.scala.leetcode30days

/** *
  * Day 21
  *
  * @see https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/530/week-3/3306/
  *
  *      (This problem is an interactive problem.)
  *
  *      A binary matrix means that all elements are 0 or 1. For each individual row of the matrix, this row is sorted in non-decreasing order.
  *
  *      Given a row-sorted binary matrix binaryMatrix, return leftmost column index(0-indexed) with at least a 1 in it. If such index doesn't exist, return -1.
  *
  *      You can't access the Binary Matrix directly.  You may only access the matrix using a BinaryMatrix interface:
  *
  * BinaryMatrix.get(x, y) returns the element of the matrix at index (x, y) (0-indexed).
  * BinaryMatrix.dimensions() returns a list of 2 elements [n, m], which means the matrix is n * m.
  *      Submissions making more than 1000 calls to BinaryMatrix.get will be judged Wrong Answer.  Also, any solutions that attempt to circumvent the judge will result in disqualification.
  *
  *      For custom testing purposes you're given the binary matrix mat as input in the following four examples. You will not have access the binary matrix directly.
  *
  *
  *
  *      Example 1:
  *
  *
  *
  *      Input: mat = [[0,0],[1,1]]
  *      Output: 0
  *      Example 2:
  *
  *
  *
  *      Input: mat = [[0,0],[0,1]]
  *      Output: 1
  *      Example 3:
  *
  *
  *
  *      Input: mat = [[0,0],[0,0]]
  *      Output: -1
  *      Example 4:
  *
  *
  *
  *      Input: mat = [[0,0,0,1],[0,0,1,1],[0,1,1,1]]
  *      Output: 1
  *
  *
  *      Constraints:
  *
  *      1 <= mat.length, mat[i].length <= 100
  *      mat[i][j] is either 0 or 1.
  *      mat[i] is sorted in a non-decreasing way.
  *
  *
  *
  *
  *      37 / 37 test cases passed.
  *      Status: Accepted
  *      Runtime: 492 ms
  *      Memory Usage: 51.2 MB
  *
  *
  *
  */
object LeftmostColumnWithLeastOne extends BinaryMatrix {


  /**
    * 37 / 37 test cases passed.
    * Status: Accepted
    * Runtime: 492 ms
    * Memory Usage: 51.2 MB
    *
    * @param binaryMatrix binary sorted array
    * @return left Most Column that contains One
    *
    **/
  def leftMostColumnWithOne_Iterative (binaryMatrix: BinaryMatrix): Int = {
    val arr = binaryMatrix.dimensions()
    val (rows, col) = (arr(0), arr(1))

    if (rows == 0 || col == 0) return -1

    var result = -1
    var r = 0;
    var c = col - 1

    while (r < rows && c >= 0) {
      if (binaryMatrix.get(r, c) == 1) {
        result = c
        c -= 1

      } else {
        r += 1
      }
    }
    result

  }

  /** *
    *
    * 37 / 37 test cases passed.
    * Status: Accepted
    * Runtime: 512 ms
    * Memory Usage: 51 MB
    *
    * @param binaryMatrix binary sorted array
    * @return left Most Column that contains One
    */
  def leftMostColumnWithOneByRecursion (binaryMatrix: BinaryMatrix): Int = {

    val arr = binaryMatrix.dimensions()
    if (arr.isEmpty) return -1
    val (rows, cols) = (arr(0), arr(1))


    import scala.annotation.tailrec
    @tailrec
    def helperLeftMostColumnWithOne (binaryMatrix: BinaryMatrix, result: Int, currentRow: Int, currentColumn: Int): Int = {

      if (currentColumn < 0 || currentRow >= rows || result == 0) return result

      if (binaryMatrix.get(currentRow, currentColumn) == 1)
        helperLeftMostColumnWithOne(binaryMatrix, currentColumn, currentRow, currentColumn - 1)
      else
        helperLeftMostColumnWithOne(binaryMatrix, result, currentRow + 1, currentColumn)
    }

    helperLeftMostColumnWithOne(binaryMatrix, -1, 0, cols - 1)

  }


}


// This is the BinaryMatrix's API interface.
// You should not implement it, or speculate about its implementation

class BinaryMatrix {
  def get (x: Int, y: Int): Int = ???

  def dimensions (): Array[Int] = ???
}

