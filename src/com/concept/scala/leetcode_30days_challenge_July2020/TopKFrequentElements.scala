package com.concept.scala.leetcode_30days_challenge_July2020

import scala.collection.mutable.ListBuffer

/** *
  * Day 17
  *
  * @todo Given a non-empty array of integers, return the k most frequent elements.
  * @example Example 1:
  *
  *          Input: nums = [1,1,1,2,2,3], k = 2
  *          Output: [1,2]
  *          Example 2:
  *
  *          Input: nums = [1], k = 1
  *          Output: [1]
  * @note You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
  *       Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
  *       It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
  *       You can return the answer in any order.
  *
  */
object TopKFrequentElements {
  def main(args: Array[String]): Unit = {
    println(topKFrequent(Array(1, 1, 1, 2, 2, 3), 2).mkString(","))
    println(topKFrequent(Array(1), 1).mkString(","))

  }


  def topKFrequent(nums: Array[Int], k: Int): Array[Int] = {
    def priorityLogic(topKList: ListBuffer[(Int, Int)], tuple: (Int, Int)): ListBuffer[(Int, Int)] = {
      if (topKList.length < k)
        topKList += tuple
      else {
        //val topKMin: (Int, Int) = topKList.sortBy(_._2).head
        val topKMin: (Int, Int) = topKList.minBy(_._2)
        if (tuple._2 > topKMin._2) topKList -= topKMin += tuple
      }
      topKList
    }

    nums.groupBy(identity).mapValues(_.length).foldLeft(ListBuffer[(Int, Int)]())(priorityLogic).map(_._1).toArray
  }


}
