package com.concept.scala.leetcode_30days_challenge_July2020

/** *
  *
  * Day 28
  *
  * @todo You are given a char array representing tasks CPU need to do. It contains capital letters A to Z where each letter represents a different task. Tasks could be done without the original order of the array. Each task is done in one unit of time. For each unit of time, the CPU could complete either one task or just be idle.
  *       However, there is a non-negative integer n that represents the cooldown period between two same tasks (the same letter in the array), that is that there must be at least n units of time between any two same tasks.
  *       You need to return the least number of units of times that the CPU will take to finish all the given tasks.
  * @example Example 1:
  *
  *          Input: tasks = ["A","A","A","B","B","B"], n = 2
  *          Output: 8
  *          Explanation:
  *          A -> B -> idle -> A -> B -> idle -> A -> B
  *          There is at least 2 units of time between any two same tasks.
  *          Example 2:
  *
  *          Input: tasks = ["A","A","A","B","B","B"], n = 0
  *          Output: 6
  *          Explanation: On this case any permutation of size 6 would work since n = 0.
  *          ["A","A","A","B","B","B"]
  *          ["A","B","A","B","A","B"]
  *          ["B","B","B","A","A","A"]
  *          ...
  *          And so on.
  *          Example 3:
  *
  *          Input: tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
  *          Output: 16
  *          Explanation:
  *          One possible solution is
  *          A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle -> idle -> A
  * @note The number of tasks is in the range [1, 10000].
  *       The integer n is in the range [0, 100].
  * @see https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/547/week-4-july-22nd-july-28th/3404/
  *      OR
  *      https://leetcode.com/problems/task-scheduler
  *
  *
  *
  */
object TaskScheduler {
  def main(args: Array[String]): Unit = {
    val tasks = Array("A", "A", "A", "A", "A", "A", "B", "C", "D", "E", "F", "G").mkString.toCharArray
    val n = 2
    println(leastInterval(tasks, n))
  }

  /** *
    * 69 / 69 test cases passed.
    * Status: Accepted
    * Runtime: 2380 ms
    * Memory Usage: 120.7 MB
    *
    */
  def leastInterval(tasks: Array[Char], n: Int): Int = {
    import scala.collection.mutable
    val orderedTasks = tasks.groupBy(identity).mapValues(_.length).toSeq
    val priorityQueue = mutable.PriorityQueue[(Char, Int)](orderedTasks: _ *)(Ordering by (_._2))

    @scala.annotation.tailrec
    def helper(currentVal: Int, coolDownPeriod: Map[Int, (Char, Int)]): Int = {
      if (coolDownPeriod contains currentVal) {
        priorityQueue enqueue coolDownPeriod(currentVal)
        helper(currentVal, coolDownPeriod - currentVal)
      }
      else if (priorityQueue nonEmpty) {
        val task = priorityQueue dequeue

        if (task._2 > 1) helper(currentVal + 1, coolDownPeriod + (currentVal + n + 1 -> (task._1, task._2 - 1)))
        else helper(currentVal + 1, coolDownPeriod)
      }
      else if (priorityQueue.isEmpty && coolDownPeriod.isEmpty) currentVal else helper(currentVal + 1, coolDownPeriod)
    }

    helper(0, Map())
  }


}
