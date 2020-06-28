package com.concept.scala.leetcode_30days_challenge_June2020

import com.concept.scala.RunTimeCalculation

import scala.collection.mutable.ListBuffer

/** **
  * Day 6
  *
  * @see https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3352/
  *      OR
  *      https://leetcode.com/problems/queue-reconstruction-by-height
  *
  *
  *      Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.
  *
  *      Note:
  *      The number of people is less than 1,100.
  *
  *
  *      Example
  *
  *      Input:
  *      [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
  *
  *      Output:
  *      [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
  *
  *
  *
  *
  *
  */
object QueueReconstructionbyHeight {

  /** *
    * Runtime: 892 ms, faster than 25.00% of Scala online submissions for Queue Reconstruction by Height.
    * Memory Usage: 54 MB, less than 75.00% of Scala online submissions for Queue Reconstruction by Height.
    *
    * 37 / 37 test cases passed.
    * Status: Accepted
    * Runtime: 892 ms
    * Memory Usage: 54 MB
    *
    */
  def reconstructQueue(people: Array[Array[Int]]): Array[Array[Int]] = {
    val buffer: scala.collection.mutable.ListBuffer[Array[Int]] = ListBuffer[Array[Int]]()
    val sortedPeople = people.sortBy(-_.head)
    //val sortedPeople = people.sorted((p1: Array[Int], p2: Array[Int]) => if (p1(0) == p2(0)) p1(1) - p2(1) else p2(0) - p1(0))
    for (i <- sortedPeople.indices) buffer.insert(sortedPeople(i).last, sortedPeople(i))
    buffer.toArray
  }


  def main(args: Array[String]): Unit = {

    val people = Array(Array(7, 0), Array(4, 4), Array(7, 1), Array(5, 0), Array(6, 1), Array(5, 2))
    val totalRuntime = RunTimeCalculation.calculateRunTime(reconstructQueue(people).foreach { x: Array[Int] => print(x.mkString("[", ",", "]")); print("\t") })


    println(s" \n totalRuntime => = $totalRuntime seconds OR ${totalRuntime * 1000} milliseonds")
    println(s" Used Memory: ${(Runtime.getRuntime.totalMemory - Runtime.getRuntime.freeMemory) / 1048576} MB" +
      s"\n Total Memory: ${Runtime.getRuntime.totalMemory / 1048576} MB \n " +
      s"Free Memory: ${Runtime.getRuntime.freeMemory / 1048576} MB")

    /*
    [5,0]	[7,0]	[5,2]	[6,1]	[4,4]	[7,1]
   totalRuntime => = 0.553 seconds OR 553.0 milliseonds
   Used Memory: 19 MB
   Total Memory: 178 MB
   Free Memory: 158 MB
     */
  }

}
