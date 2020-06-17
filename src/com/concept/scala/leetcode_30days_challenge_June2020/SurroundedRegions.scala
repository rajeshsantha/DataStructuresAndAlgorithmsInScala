package com.concept.scala.leetcode_30days_challenge_June2020

/** *
  * Day 17
  *
  * @see https://leetcode.com/problems/surrounded-regions/
  *      OR
  *      https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/541/week-3-june-15th-june-21st/3363/
  *
  *
  *      Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
  *
  *      A region is captured by flipping all 'O's into 'X's in that surrounded region.
  *
  *      Example:
  *
  *      X X X X
  *      X O O X
  *      X X O X
  *      X O X X
  *      After running your function, the board should be:
  *
  *      X X X X
  *      X X X X
  *      X X X X
  *      X O X X
  *      Explanation:
  *
  *      Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
  *
  *
  *
  */
object SurroundedRegions {

  /** *
    * Runtime: 540 ms, faster than 94.74% of Scala online submissions for Surrounded Regions.
    * Memory Usage: 54.6 MB, less than 50.00% of Scala online submissions for Surrounded Regions
    *
    * 59 / 59 test cases passed.
    * Status: Accepted
    * Runtime: 540 ms
    * Memory Usage: 54.6 MB
    *
    */
  def solve (board: Array[Array[Char]]): Unit = {
    if ((board.length == 0) || (board.head.length == 0)) return
    val row_length = board.length
    val column_length = board.head.length

    for (i <- 0 until row_length) {
      if (i == 0 || i == row_length - 1) {
        for (j <- 0 until column_length) {
          if (board(i)(j) == 'O') dfs(board, i, j)
        }

      } else {
        if (board(i).head == 'O') {
          dfs(board, i, 0)
        }
        if (board(i)(column_length - 1) == 'O') {
          dfs(board, i, column_length - 1)
        }
      }
    }
    for (i <- 0 until row_length; j <- 0 until column_length) {
      if (board(i)(j) == 'Z') {
        board(i)(j) = 'O'
      }
      else if (board(i)(j) == 'O') {
        board(i)(j) = 'X'
      }
    }


  }



  def dfs (board: Array[Array[Char]], row: Int, col: Int): Unit = {
    val n: Int = board.length
    val m: Int = board.head.length
    board(row)(col) = 'Z'
    if (row > 0 && (board(row - 1)(col) == 'O')) dfs(board, row - 1, col) else if (row < n - 1 && (board(row + 1)(col) == 'O')) dfs(board, row + 1, col) else if (col > 0 && (board(row)(col - 1) == 'O')) dfs(board, row, col - 1) else if (col < m - 1 && (board(row)(col + 1) == 'O')) dfs(board, row, col + 1)
  }
}

/*
 if (board.length == 0 || board[0].length == 0) return;
        int n = board.length, m = board[0].length;
        for (int i = 0; i < n; ++i) {
            if (i == 0 || i == n - 1) {
                for (int j = 0; j < m; ++j) {
                    if (board[i][j] == 'O') {
                        dfs(board, i, j);
                    }
                }
            }
            else {
                if (board[i][0] == 'O') {
                    dfs(board, i, 0);
                }
                if (board[i][m - 1] == 'O') {
                    dfs(board, i, m - 1);
                }
            }
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (board[i][j] == 'Z') {
                    board[i][j] = 'O';
                }
                else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int r, int c) {
        int n = board.length, m = board[0].length;
        board[r][c] = 'Z';
        if (r > 0 && board[r - 1][c] == 'O')
            dfs(board, r - 1, c);
        if (r < n - 1 && board[r + 1][c] == 'O')
            dfs(board, r + 1, c);
        if (c > 0 && board[r][c - 1] == 'O')
            dfs(board, r, c - 1);
        if (c < m - 1 && board[r][c + 1] == 'O')
            dfs(board, r, c + 1);
    }
 */