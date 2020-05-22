package com.concept.scala.leetcode_30days_challenge_May2020

import com.concept.scala.RunTimeCalculation

import scala.collection.mutable

/** **
  *
  * Day 22
  *
  * @see https://leetcode.com/problems/sort-characters-by-frequency/  (451)
  *      OR
  *      https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3337/
  *
  *      Given a string, sort it in decreasing order based on the frequency of characters.
  *
  *      Example 1:
  *
  *      Input:
  *      "tree"
  *
  *      Output:
  *      "eert"
  *
  *      Explanation:
  *      'e' appears twice while 'r' and 't' both appear once.
  *      So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
  *      Example 2:
  *
  *      Input:
  *      "cccaaa"
  *
  *      Output:
  *      "cccaaa"
  *
  *      Explanation:
  *      Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
  *      Note that "cacaca" is incorrect, as the same characters must be together.
  *      Example 3:
  *
  *      Input:
  *      "Aabb"
  *
  *      Output:
  *      "bbAa"
  *
  *      Explanation:
  *      "bbaA" is also a valid answer, but "Aabb" is incorrect.
  *      Note that 'A' and 'a' are treated as two different characters.
  *
  *
  *
  *
  *
  *
  *
  */
object SortCharactersByFrequency {
  def main(args: Array[String]): Unit = {
    val str = "djhkfhdfjkmgdggsdjsfjiowficnaoisfnsoapdoaskdasdnmagninvdovmsPopewdfgomnergnemgovnsdfmspdmppfsdpcsmdnsdvonsdvsnsovnisifsdfisdg"


    val totalRuntime = RunTimeCalculation.calculateRunTime {
      println(frequencySort(str))
      // ssssssssssssssssssdddddddddddddddddnnnnnnnnnnnnffffffffffoooooooooommmmmmmmggggggggiiiiiiivvvvvvppppppaaaaajjjjeeekkkwwhhccPr
    }
    println(s" total run time = seconds $totalRuntime seconds OR ${totalRuntime * 1000} milliseonds")
    // total run time = seconds 0.865 seconds OR 865.0 milliseonds

  }

  /** *
    *
    * Runtime: 6796 ms, faster than 94.44% of Scala online submissions for Sort Characters By Frequency.
    * Memory Usage: 58.3 MB, less than 100.00% of Scala online submissions for Sort Characters By Frequency.    *
    * *
    *
    * 35 / 35 test cases passed.
    * Status: Accepted
    * Runtime: 6796 ms
    * Memory Usage: 58.3 MB
    *
    * @param s
    * @return
    */
  def frequencySort(s: String): String = {
    val map = mutable.HashMap[Char, Int]()

    for (i <- s)
      if (map.contains(i))
        map.update(i, map(i) + 1)
      else
        map.put(i, 1)

    /*  OR
        s.foreach { i =>
          if (map.contains(i))
            map.update(i, map(i) + 1)
          else
            map.put(i, 1)
        }
    */

    map.toList.sortBy(-_._2).map(x => x._1.toString * x._2).mkString
  }
}