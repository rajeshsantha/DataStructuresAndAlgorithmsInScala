package com.concept.scala.leetcode_30days_challenge_May2020

import com.concept.scala.RunTimeCalculation

/** *
  * Day 3
  *
  * @see https://leetcode.com/explore/featured/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3318/
  *      OR
  *      https://leetcode.com/problems/ransom-note/
  *
  *
  *      Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
  *
  *      Each letter in the magazine string can only be used once in your ransom note.
  *
  *      Note:
  *      You may assume that both strings contain only lowercase letters.
  *
  *      canConstruct("a", "b") -> false
  *      canConstruct("aa", "ab") -> false
  *      canConstruct("aa", "aab") -> true
  *
  *
  *
  *
  *
  *
  *
  */
object RansomeNote {


  def main(args: Array[String]): Unit = {
    val exec1 = RunTimeCalculation.calculateRunTime(canConstruct("aa", "aab"))
    val exec2 = RunTimeCalculation.calculateRunTime(canConstruct2("aa", "aab"))

    println(s"" +
      s"exec1 = $exec1 seconds vs " +
      s"exec2= $exec2 seconds ")
    //exec1 = 0.863 seconds vs exec2= 0.099 seconds
    //exec1 = 1.015 seconds vs exec2= 0.104 seconds
    //exec1 = 0.949 seconds vs exec2= 0.174 seconds

  }

  def canConstruct(ransomNote: String, magazine: String): Boolean = {

    ransomNote.intersect(magazine) == ransomNote
  }

  def canConstruct2(ransomNote: String, magazine: String): Boolean = {

    val magazineCountOfChars = countOfEachChar(magazine)
    val ransomNoteCountOfChars = countOfEachChar(ransomNote)

    return ransomNoteCountOfChars.forall(x => (magazineCountOfChars.getOrElse(x._1, -100) - x._2) >= 0)


  }

  def countOfEachChar(str: String): Map[Char, Int] = str groupBy (x => x) mapValues (_.length)


}
