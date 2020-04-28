package com.concept.scala.leetcode_30days_challenge_April2020

/** *
  * Day 6
  *
  * @see https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3288/
  *
  *      Given an array of strings, group anagrams together.
  *
  *      Example:
  *
  *      Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
  *      Output:
  *      [
  *      ["ate","eat","tea"],
  *      ["nat","tan"],
  *      ["bat"]
  *      ]
  *      Note:
  *
  *      All inputs will be in lowercase.
  *      The order of your output does not matter.
  *
  *
  *      101 / 101 test cases passed.
  *      Status: Accepted
  *      Runtime: 684 ms
  *      Memory Usage: 57.6 MB
  *
  *
  */
object GroupAnagrams {

  def main (args: Array[String]): Unit = {
    val arr = Array("eat", "tea", "tan", "ate", "nat", "bat")
    println(groupAnagrams(arr))

  }


  def groupAnagrams (strs: Array[String]): List[List[String]] = {
    strs.groupBy(_.sorted).mapValues(_.toList).values.toList


  }


  /*
    def generateAnagrams (str: String): List[String] = {
      val listCombinations = scala.collection.mutable.ListBuffer.empty[String]

      listCombinations.append(str)
      for (char <- str) {
        listCombinations.append(listCombinations.last.substring(1) + char)

      }
      listCombinations.toList

    }
  */
}
