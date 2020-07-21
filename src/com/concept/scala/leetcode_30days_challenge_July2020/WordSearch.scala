package com.concept.scala.leetcode_30days_challenge_July2020

/** *
  * day 21
  *
  * @todo Given a 2D board and a word, find if the word exists in the grid.
  *       The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
  * @example Example:
  *
  *          board =
  *          [
  *          ['A','B','C','E'],
  *          ['S','F','C','S'],
  *          ['A','D','E','E']
  *          ]
  *
  *          Given word = "ABCCED", return true.
  *          Given word = "SEE", return true.
  *          Given word = "ABCB", return false.
  * @note Constraints:
  *
  *       board and word consists only of lowercase and uppercase English letters.
  *       1 <= board.length <= 200
  *       1 <= board[i].length <= 200
  *       1 <= word.length <= 10 pow 3
  * @see https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/546/week-3-july-15th-july-21st/3397/
  *
  *
  */
object WordSearch {


  def main(args: Array[String]): Unit = {

  }

  def exist(board: Array[Array[Char]], word: String): Boolean = {
    for (i <- board.indices; j <- board(0).indices) if (board(i)(j) == word.charAt(0) && isFound(board, i, j, word, 0)) return true
    false
  }

  def isFound(board: Array[Array[Char]], i: Int, j: Int, word: String, index: Int): Boolean = {
    if (index == word.length) return true
    if (i < 0 || j < 0 || i >= board.length || j >= board(0).length) return false //boundary condition
    if (word.charAt(index) != board(i)(j)) return false
    val temp = board(i)(j)
    board(i)(j) = '*'
    if (isFound(board, i + 1, j, word, index + 1) || isFound(board, i - 1, j, word, index + 1) || isFound(board, i, j + 1, word, index + 1) || isFound(board, i, j - 1, word, index + 1)) return true
    board(i)(j) = temp
    false
  }
}
