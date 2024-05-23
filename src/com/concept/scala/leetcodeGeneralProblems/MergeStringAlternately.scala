package com.concept.scala.leetcodeGeneralProblems

import scala.collection.mutable.ListBuffer

/**
  * 1768. Merge Strings Alternately
  *
  * @see https://leetcode.com/problems/merge-strings-alternately/description/?envType=study-plan-v2&envId=leetcode-75
  *      You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.
  *
  *      Return the merged string.
  *
  *
  *
  *      Example 1:
  *
  *      Input: word1 = "abc", word2 = "pqr"
  *      Output: "apbqcr"
  *      Explanation: The merged string will be merged as so:
  *      word1:  a   b   c
  *      word2:    p   q   r
  *      merged: a p b q c r
  *      Example 2:
  *
  *      Input: word1 = "ab", word2 = "pqrs"
  *      Output: "apbqrs"
  *      Explanation: Notice that as word2 is longer, "rs" is appended to the end.
  *      word1:  a   b
  *      word2:    p   q   r   s
  *      merged: a p b q   r   s
  *      Example 3:
  *
  *      Input: word1 = "abcd", word2 = "pq"
  *      Output: "apbqcd"
  *      Explanation: Notice that as word1 is longer, "cd" is appended to the end.
  *      word1:  a   b   c   d
  *      word2:    p   q
  *      merged: a p b q c   d
  *
  */
object MergeStringAlternately {
  def main(args: Array[String]): Unit = {
    val (word1, word2) = ("abcd", "pq")

    println(mergeAlternately(word1, word2))
  }

  def mergeAlternately(word1: String, word2: String): String = {
    val (l1, l2) = (word1.length, word2.length)
    val mergedString = word1.zip(word2).map(x => x._1.toString + x._2.toString).mkString
    if (l1 == l2) mergedString
    else {
      val leftoverString = (l1, l2) match {
        case (a, b) if a > b => word1.substring(b)
        case (a, b) if a < b => word2.substring(a)
        case _ => ""
      }
      mergedString + leftoverString
    }
  }


}
