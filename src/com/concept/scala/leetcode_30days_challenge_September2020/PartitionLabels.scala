package com.concept.scala.leetcode_30days_challenge_September2020

/** **
  *
  * Day 4
  *
  * @todo A string S of lowercase English letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.
  * @example Input: S = "ababcbacadefegdehijhklij"
  *          Output: [9,7,8]
  *          Explanation:
  *          The partition is "ababcbaca", "defegde", "hijhklij".
  *          This is a partition so that each letter appears in at most one part.
  *          A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
  * @see https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/554/week-1-september-1st-september-7th/3448/
  *      
  *      https://leetcode.com/problems/partition-labels/
  */
object PartitionLabels {

  def main(args: Array[String]): Unit = {
    println(partitionLabels("ababcbacadefegdehijhklij")) // List(9,7,8)
  }

  /** *
    * 116 / 116 test cases passed.
    * Status: Accepted
    * Runtime: 464 ms
    * Memory Usage: 50.3 MB
    *
    */
  def partitionLabels(s: String): List[Int] = {
    val a = new Array[Int](26)
    for (i <- s.indices) a(s(i) - 'a') = i
    var pointer = 0
    var last = -1
    val result = scala.collection.mutable.ListBuffer[Int]()
    for (i <- s.indices) {
      println(result)
      if (pointer < a(s(i) - 'a')) pointer = a(s(i) - 'a')
      if (pointer == i) {
        result += (i - last)
        last = pointer
      }
    }
    result.toList
  }

}
