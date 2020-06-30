package com.concept.scala.leetcode_30days_challenge_June2020

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/** **
  * Day 30 - June Challenge is completed
  *
  * @todo Given a 2D board and a list of words from the dictionary, find all words in the board.
  *       Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring.
  *       The same letter cell may not be used more than once in a word.
  * @example Input:
  *          board = [
  *          ['o','a','a','n'],
  *          ['e','t','a','e'],
  *          ['i','h','k','r'],
  *          ['i','f','l','v']
  *          ]
  *          words = ["oath","pea","eat","rain"]
  *
  *          Output: ["eat","oath"]
  * @see https://leetcode.com/explore/featured/card/june-leetcoding-challenge/543/week-5-june-29th-june-30th/3376/
  *      OR
  *      https://leetcode.com/problems/word-search-ii/
  *
  *
  */
object WordSearchII {

  def main(args: Array[String]): Unit = {
    val board = Array(
      Array('o', 'a', 'a', 'n'),
      Array('e', 't', 'a', 'e'),
      Array('i', 'h', 'k', 'r'),
      Array('i', 'f', 'l', 'v')
    )
    val words = Array("oath", "pea", "eat", "rain")

    println(findWords(board, words))
    //output => List("eat", "oath")

  }

  /** *
    * 36 / 36 test cases passed.
    * Status: Accepted
    * Runtime: 956 ms
    * Memory Usage: 54.9 MB
    *
    */
  def findWords(board: Array[Array[Char]], words: Array[String]): List[String] = {
    val result = mutable.ListBuffer[String]()
    for (word <- words if exist(board, word)) result append word
    result toList
  }

  def exist(board: Array[Array[Char]], word: String): Boolean = {
    for (i <- board.indices; j <- board.head.indices if (board(i)(j) == word.charAt(0) && existWord(board, word, i, j, 1))) return true
    false
  }

  def existWord(board: Array[Array[Char]], word: String, row: Int, col: Int, index: Int): Boolean = {
    if (index == word.length) return true
    board(row)(col) = '.'
    //navigating downwards
    if (row > 0 && board(row - 1)(col) == word(index) && existWord(board, word, row - 1, col, index + 1)) {
      board(row)(col) = word(index - 1)
      return true
    }
    //navigating upwards
    if (row < board.length - 1 && board(row + 1)(col) == word(index) && existWord(board, word, row + 1, col, index + 1)) {
      board(row)(col) = word(index - 1)
      return true
    }
    //navigating left side
    if (col > 0 && board(row)(col - 1) == word(index) && existWord(board, word, row, col - 1, index + 1)) {
      board(row)(col) = word(index - 1)
      return true
    }
    //navigating right side
    if (col < board(0).length - 1 && board(row)(col + 1) == word(index) && existWord(board, word, row, col + 1, index + 1)) {
      board(row)(col) = word(index - 1)
      return true
    }
    board(row)(col) = word(index - 1)
    false
  }
}
