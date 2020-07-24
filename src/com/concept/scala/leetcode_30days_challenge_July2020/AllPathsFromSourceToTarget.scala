package com.concept.scala.leetcode_30days_challenge_July2020

/** **
  * Day 24
  *
  * @todo Given a directed, acyclic graph of N nodes.  Find all possible paths from node 0 to node N-1, and return them in any order.
  *       The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.  graph[i] is a list of all nodes j for which the edge (i, j) exists.
  * @example Example:
  *          Input: [[1,2], [3], [3], []]
  *          Output: [[0,1,3],[0,2,3]]
  *          Explanation: The graph looks like this:
  *          0--->1
  *          |    |
  *          v    v
  *          2--->3
  *          There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
  * @note          1.The number of nodes in the graph will be in the range [2, 15].
  *                2.You can print different paths in any order, but you should keep the order of nodes inside one path.
  *
  */
object AllPathsFromSourceToTarget {
  def main(args: Array[String]): Unit = {
    val graph: Array[Array[Int]] = Array(Array(1, 2), Array(3), Array(3), Array())
    println(allPathsSourceTarget(graph).mkString(","))
  }

  /**
    * 26 / 26 test cases passed.
    * Status: Accepted
    * Runtime: 828 ms
    * Memory Usage: 54.7 MB
    *
    */
  def allPathsSourceTarget(graph: Array[Array[Int]]): List[List[Int]] = {

    def paths(source: Int, target: Int): List[List[Int]] = if (source == target) List(List(target)) else (for (n <- graph(source); p <- paths(n, target)) yield source :: p).toList

    paths(0, graph.length - 1)

  }
}