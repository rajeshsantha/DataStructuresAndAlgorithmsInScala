package com.concept.scala.leetcode_30days_challenge_May2020

import com.concept.scala.RunTimeCalculation

/** **
  * Day 10
  *
  * @see https://leetcode.com/explore/featured/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3325/
  *      OR
  *      https://leetcode.com/problems/find-the-town-judge/
  *
  *
  *      In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.
  *
  *      If the town judge exists, then:
  *
  *      The town judge trusts nobody.
  *      Everybody (except for the town judge) trusts the town judge.
  *      There is exactly one person that satisfies properties 1 and 2.
  *      You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.
  *
  *      If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.
  *
  *
  *
  *      Example 1:
  *
  *      Input: N = 2, trust = [[1,2]]
  *      Output: 2
  *      Example 2:
  *
  *      Input: N = 3, trust = [[1,3],[2,3]]
  *      Output: 3
  *      Example 3:
  *
  *      Input: N = 3, trust = [[1,3],[2,3],[3,1]]
  *      Output: -1
  *      Example 4:
  *
  *      Input: N = 3, trust = [[1,2],[2,3]]
  *      Output: -1
  *      Example 5:
  *
  *      Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
  *      Output: 3
  *
  *
  *      Note:
  *
  *      1 <= N <= 1000
  *      trust.length <= 10000
  *      trust[i] are all different
  *      trust[i][0] != trust[i][1]
  *      1 <= trust[i][0], trust[i][1] <= N
  *
  */

object FindTheTownJudge {
  def main (args: Array[String]): Unit = {
    val N = 4
    val trust: Array[Array[Int]] = Array(Array(1, 3), Array(1, 4), Array(2, 3), Array(2, 4), Array(4, 3))
    //val trust: Array[Array[Int]] = Array(Array(1, 3), Array(2, 3))
    /*
     1, 3
     1, 4
     1, 3
     2, 3
     2, 4
     4, 3

     1 -> 3,4,3   -> 2
     2-> 3,4      -> 2
     4 -> 3       -> 1

     */
    val findJudge_ByHashMapRuntime = RunTimeCalculation.calculateRunTime(println(findJudge_ByHashMap(N, trust)))

    println(s"findJudge_ByHashMap Intellij IDEA runtime => total run time = seconds $findJudge_ByHashMapRuntime seconds" +
      s" OR ${findJudge_ByHashMapRuntime * 1000} milliseonds")


    val findJudge_byCountRuntime = RunTimeCalculation.calculateRunTime(println(findJudge_byDirectedGraph(N, trust)))
    println(s"findJudge_byCount Intellij IDEA runtime => total run time = seconds $findJudge_byCountRuntime seconds" +
      s" OR ${findJudge_byCountRuntime * 1000} milliseonds")


    val findJudge_functionalRuntime = RunTimeCalculation.calculateRunTime(println(findJudge_functional(N, trust)))
    println(s"findJudge_functional Intellij IDEA runtime => total run time = seconds $findJudge_functionalRuntime seconds" +
      s" OR ${findJudge_functionalRuntime * 1000} milliseonds")

    /*

    3
    findJudge_ByHashMap Intellij IDEA runtime => total run time = seconds 0.748 seconds OR 748.0 milliseonds
    3
    findJudge_byCount Intellij IDEA runtime => total run time = seconds 0.003 seconds OR 3.0 milliseonds
    3
    findJudge_functional Intellij IDEA runtime => total run time = seconds 0.098 seconds OR 98.0 milliseonds

     */

  }

  /** *
    * Runtime: 1160 ms, faster than 50.00% of Scala online submissions for Find the Town Judge.
    * Memory Usage: 61.4 MB, less than 100.00% of Scala online submissions for Find the Town Judge.
    *
    * 89 / 89 test cases passed.
    * Status: Accepted
    * Runtime: 1160 ms
    * Memory Usage: 61.4 MB
    *
    * @param N
    * @param trust
    * @return
    */
  def findJudge_ByHashMap (N: Int, trust: Array[Array[Int]]): Int = {
    val hashmap = scala.collection.mutable.HashMap[Int, List[Int]]().empty

    for (t <- trust)
      if (hashmap.contains(t(0)))
        hashmap.update(t(0), hashmap(t(0)) :+ t(1))
      else
        hashmap.put(t(0), List(t(1)))


    val newmap = hashmap.mapValues(_.distinct)
    val listOfPeopleWhoTrustNoOne = (1 to N).filterNot(newmap.keySet).toList
    if (listOfPeopleWhoTrustNoOne.isEmpty)
      return -1
    else {
      var judgeLabelNumber = 0
      val values = newmap.values.toList
      listOfPeopleWhoTrustNoOne.foreach(e => {

        if (values.forall(_ contains e))
          judgeLabelNumber = e
        else judgeLabelNumber = -1
      })

      judgeLabelNumber
    }

  }

  /** **
    *
    * Runtime: 896 ms, faster than 83.33% of Scala online submissions for Find the Town Judge.
    * Memory Usage: 62 MB, less than 100.00% of Scala online submissions for Find the Town Judge.
    *
    * 89 / 89 test cases passed.
    * Status: Accepted
    * Runtime: 896 ms
    * Memory Usage: 62 MB
    *
    * @param N
    * @param trust
    * @return
    */
  def findJudge_byDirectedGraph (N: Int, trust: Array[Array[Int]]): Int = {
    val counter = new Array[Int](N + 1)
    for (t <- trust) {
      counter(t(0)) -= 1
      counter(t(1)) += 1
    }
    for (i <- 1 to N)
      if (counter(i) == N - 1) return i

    -1
  }

  /** **
    *
    * Runtime: 1116 ms, faster than 66.67% of Scala online submissions for Find the Town Judge.
    * Memory Usage: 62.6 MB, less than 100.00% of Scala online submissions for Find the Town Judge.
    *
    * 89 / 89 test cases passed.
    * Status: Accepted
    * Runtime: 1116 ms
    * Memory Usage: 62.6 MB
    *
    * @param N
    * @param trust
    * @return
    */
  def findJudge_functional (N: Int, trust: Array[Array[Int]]): Int = {
    val candidates = (1 to N) diff trust.map(_.head)

    if (trust.isEmpty) N

    else
      trust
        .map(_.last)
        .filter(candidates contains _)
        .groupBy(identity)
        .mapValues(_.length)
        .filter(_._2 == N - 1).headOption // find(_._2 == N - 1)
        .getOrElse((-1, -1))._1
  }

}

class Graph (val vertex: IndexedSeq[String], edges: Seq[(Int, Int)]) {
  def size: Int = vertex.length

  val index: Map[String, Int] = vertex.zipWithIndex.toMap
  val adjacent = edges groupBy (_._1) mapValues (_ map (_._2))

  def adjacencyMatrix: Map[Int, IndexedSeq[Boolean]] = adjacent mapValues (_.toSet) mapValues (0 to size map _)

  def printEdges = {
    for (idx <- 0 until size)
      yield f"vertex $idx: ${adjacent(idx) mkString " "}"
  } mkString "\n"

  def printAdjacencyList: String = adjacent mapValues (_ mkString ", ") mkString "\n"

  def printAdjacencyMatrix: String = adjacencyMatrix mapValues (_ mkString ", ") mkString "\n"
}
