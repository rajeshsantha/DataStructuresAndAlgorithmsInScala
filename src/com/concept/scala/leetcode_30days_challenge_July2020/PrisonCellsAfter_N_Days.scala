package com.concept.scala.leetcode_30days_challenge_July2020


/** *
  *
  * Day 3
  *
  * @todo There are 8 prison cells in a row, and each cell is either occupied or vacant.
  *       Each day, whether the cell is occupied or vacant changes according to the following rules:
  *       If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell becomes occupied.
  *       Otherwise, it becomes vacant.
  *       (Note that because the prison is a row, the first and the last cells in the row can't have two adjacent neighbors.)
  *       We describe the current state of the prison in the following way: cells[i] == 1 if the i-th cell is occupied, else cells[i] == 0.
  *       Given the initial state of the prison, return the state of the prison after N days (and N such changes described above.)
  * @example Example 1:
  *
  *          Input: cells = [0,1,0,1,1,0,0,1], N = 7
  *          Output: [0,0,1,1,0,0,0,0]
  *          Explanation:
  *          The following table summarizes the state of the prison on each day:
  *          Day 0: [0, 1, 0, 1, 1, 0, 0, 1]
  *          Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
  *          Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
  *          Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
  *          Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
  *          Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
  *          Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
  *          Day 7: [0, 0, 1, 1, 0, 0, 0, 0]
  *
  *          Example 2:
  *
  *          Input: cells = [1,0,0,1,0,0,1,0], N = 1000000000
  *          Output: [0,0,1,1,1,1,1,0]
  * @note cells.length == 8
  *       cells[i] is in {0, 1}
  *       1 <= N <= 10 pw 9
  *
  **/
object PrisonCellsAfter_N_Days {
  /*  def prisonAfterNDays(cells: Array[Int], N: Int): Array[Int] = {
      val len = cells.length
      val oldCells = cells
      oldCells(0) = 0
      oldCells(len - 1) = 0
      val newCells = Array.fill(len)(0)
      for (x <- 1 to N) {
        Array.copy(oldCells, 0, newCells, 0, len)
        for (i <- 1 to len - 2) {
          if (oldCells(i - 1) == oldCells(i + 1)) newCells(i) = 1 else newCells(i) = 0
          println("oldCells => "+oldCells.mkString("[", "  ", "]"))
          println("newCells => "+newCells.mkString("[", "  ", "]"))
        }
      }
      newCells
    }*/
  def prisonAfterNDays(cells: Array[Int], N: Int): Array[Int] = {

    val seen = scala.collection.mutable.HashMap[Int, Array[Int]]()
    var (day, yesterday) = (1, cells)

    while (day <= N) {
      val today: Array[Int] = getCurrentDay(yesterday)
      if (seen.contains(1) && seen(1).sameElements(today)) {
        if (day - 1 == 1) {
          return today
        }
        else {
          val reqDay: Int = N % (day - 1)
          yesterday = seen.getOrElseUpdate(reqDay, null)
          if (yesterday != null) {
            return yesterday
          }
        }
      }
      yesterday = today
      seen.put(day, today)
      day += 1
    }

    def getCurrentDay(previousDay: Array[Int]): Array[Int] = {
      val today = new Array[Int](8)
      for (i <- 1 to 6) today(i) = if (previousDay(i - 1) == previousDay(i + 1)) 1 else 0
      today
    }

    yesterday

  }


  def main(args: Array[String]): Unit = {
    val cells = Array(0, 1, 0, 1, 1, 0, 0, 1)
    val N = 7
    println(prisonAfterNDays(cells, N).mkString("[", "  ", "]"))
  }

}
