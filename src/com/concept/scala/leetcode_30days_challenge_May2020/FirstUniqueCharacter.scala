package com.concept.scala.leetcode_30days_challenge_May2020

import com.concept.scala.RunTimeCalculation

import scala.collection.mutable

/** ***
  * Day 5
  *
  * @see https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3320/
  *      OR
  *      https://leetcode.com/problems/first-unique-character-in-a-string/
  *
  *      Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
  *
  *      Examples:
  *
  *      s = "leetcode"
  *      return 0.
  *
  *      s = "loveleetcode",
  *      return 2.
  *      Note: You may assume the string contain only lowercase letters.
  *
  *
  *
  *
  *
  *
  */
object FirstUniqueCharacter {

  /** **
    * 104 / 104 test cases passed.
    * Status: Accepted
    * Runtime: 560 ms
    * Memory Usage: 50.8 MB
    *
    * Runtime: 548 ms, faster than 80.95% of Scala online submissions for First Unique Character in a String.
    * Memory Usage: 50.5 MB, less than 100.00% of Scala online submissions for First Unique Character in a String.
    *
    * @param s
    * @return
    */
  def firstUniqChar(s: String): Int = {
    val hashmap = mutable.HashMap[Char, Int]().empty
    for (c <- s) {
      if (hashmap.keySet.contains(c)) {
        hashmap(c) = hashmap(c) + 1
      } else {
        hashmap.put(c, 1)

      }

    }
    for (c <- s if hashmap(c) == 1) return s.indexOf(c)

    return -1
  }

  def firstUniqChar_byCollection(s: String): Int = {
    val unique = s.zipWithIndex
      .map(x => (x._1, s.count(_ == x._1)))
      .distinct
      .toList
      .find(_._2 == 1)
      .map(_._1)
      .getOrElse("")
      .toString.toCharArray.head

    if (unique isWhitespace) return -1 else return s indexOf unique


  }

  def main(args: Array[String]): Unit = {

    println(s"firstUniqChar => total run time = ${RunTimeCalculation.calculateRunTime(println(firstUniqChar("leetcode")))} seconds")
    println(s"firstUniqChar => total run time = ${RunTimeCalculation.calculateRunTime(println(firstUniqChar("loveleetcode")))} seconds")

    println(s"firstUniqChar_byCollection => total run time = ${RunTimeCalculation.calculateRunTime(println(firstUniqChar_byCollection("leetcode")))} seconds")
    println(s"firstUniqChar_byCollection => total run time = ${RunTimeCalculation.calculateRunTime(println(firstUniqChar_byCollection("loveleetcode")))} seconds")


    /*
      0
      firstUniqChar => total run time = 0.035 seconds
      2
      firstUniqChar => total run time = 0.001 seconds
      0
      firstUniqChar_byCollection => total run time = 0.181 seconds
      2
      firstUniqChar_byCollection => total run time = 0.002 seconds

     */
  }

}
