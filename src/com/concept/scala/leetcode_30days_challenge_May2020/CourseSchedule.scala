package com.concept.scala.leetcode_30days_challenge_May2020

import com.concept.scala.RunTimeCalculation

/** *
  * Day 29
  *
  * @see https://leetcode.com/problems/course-schedule/
  *      OR
  *      https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/538/week-5-may-29th-may-31st/3344/
  *
  *
  *
  *      There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
  *
  *      Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
  *
  *      Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
  *
  *
  *
  *      Example 1:
  *
  *      Input: numCourses = 2, prerequisites = [[1,0]]
  *      Output: true
  *      Explanation: There are a total of 2 courses to take.
  *      To take course 1 you should have finished course 0. So it is possible.
  *      Example 2:
  *
  *      Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
  *      Output: false
  *      Explanation: There are a total of 2 courses to take.
  *      To take course 1 you should have finished course 0, and to take course 0 you should
  *      also have finished course 1. So it is impossible.
  *
  *
  *      Constraints:
  *
  *      The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
  *      You may assume that there are no duplicate edges in the input prerequisites.
  *      1 <= numCourses <= 10 pow 5
  *
  */
object CourseSchedule {
  def main(args: Array[String]): Unit = {
    val prerequisites = Array(Array(0, 1), Array(0, 2), Array(1, 2), Array(2, 0), Array(2, 3), Array(3, 3))
    val prerequisites2 = Array(Array(0, 1), Array(0, 2), Array(1, 2), Array(2, 3))


    val totalRuntime = RunTimeCalculation.calculateRunTime {
      println(canFinish(3, prerequisites)) //false
      println(canFinish(3, prerequisites2)) // true
    }

    println(s" \n total run time =  $totalRuntime seconds OR ${totalRuntime * 1000} milliseonds")
    /*
    false
    true

    total run time =  0.682 seconds OR 682.0 milliseonds

     */


  }

  def canFinish(numCourses: Int, prerequisites: Array[Array[Int]]): Boolean = {

    if (prerequisites.isEmpty) return true
    //val prerequisites = Array(Array(0,1),Array(0,2),Array(1,2),Array(2,0),Array(2,3),Array(3,3))
    // prerequisites.head.head -> acc.getOrElse(prerequisites.head.last,Set())
    // +
    //prerequisites.head.last -> acc.getOrElse(prerequisites.head.head, Set())
    val inDegreeMap = prerequisites.foldLeft(Map[Int, Set[Int]]()) {
      case (accumulator, Array(start, end)) =>
        accumulator + (end -> (accumulator.getOrElse(end, Set()) + start)) + (start -> accumulator.getOrElse(start, Set()))
    }
    //inDegreeMap: scala.collection.immutable.Map[Int,Set[Int]] = Map(1 -> Set(0), 0 -> Set(2), 2 -> Set(0, 1), 3 -> Set(2))
    // 1 -> Set(0)    ==> (0,1)
    //0 -> Set(2)     ==> (2,0)
    //2 -> Set(0, 1)  ==> (0,2) and (1,2) // i.e you can end up 2 by starting at 0 and 1
    //3 -> Set(2)     ==> (2,3)


    def topologicalSort(inDegreePairs: Map[Int, Set[Int]]): Boolean = {
      val (inDegreeZeros, inDegreeNonZeros) = inDegreePairs.partition(_._2.isEmpty)
      //inDegreeZeros: scala.collection.immutable.Map[Int,Set[Int]] = Map()
      //inDegreeNonZeros: scala.collection.immutable.Map[Int,Set[Int]] = Map(1 -> Set(0), 0 -> Set(2), 2 -> Set(0, 1), 3 -> Set(2))
      (inDegreeZeros.isEmpty, inDegreeNonZeros.isEmpty) match {
        case (true, true) => true
        case (true, false) => false
        case _ => topologicalSort(inDegreeNonZeros.mapValues(_ -- inDegreeZeros.keys))
      }
    }

    topologicalSort(inDegreeMap)

  }


}

//Array(Array(0,1),Array(0,2),Array(1,2),Array(2,0),Array(2,3),Array(3,3))
/*
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

 */