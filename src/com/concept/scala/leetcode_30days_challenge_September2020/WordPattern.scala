package com.concept.scala.leetcode_30days_challenge_September2020

import scala.collection.mutable

/** **
  *
  * Day 7
  *
  * @todo Given a pattern and a string str, find if str follows the same pattern.
  *       Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
  * @example Example 1:
  *
  *          Input: pattern = "abba", str = "dog cat cat dog"
  *          Output: true
  *          Example 2:
  *
  *          Input:pattern = "abba", str = "dog cat cat fish"
  *          Output: false
  *          Example 3:
  *
  *          Input: pattern = "aaaa", str = "dog cat cat dog"
  *          Output: false
  *          Example 4:
  *
  *          Input: pattern = "abba", str = "dog dog dog dog"
  *          Output: false
  * @note You may assume pattern contains only lowercase letters, and str contains lowercase letters that may be separated by a single space.
  *
  *
  */
object WordPattern {
  def wordPattern(pattern: String, str: String): Boolean = {
    val a = pattern.toCharArray
    val b = str.split(" ")
    val tracker = mutable.HashMap[Char, String]()
    if (a.length != b.length) return false

    for (i <- a.indices) {
      if (tracker.contains(a(i))) {
        if (tracker(a(i)) != b(i)) return false
      }
      else {
        if (tracker.values.toArray.contains(b(i))) return false
        tracker.put(a(i), b(i))
      }
    }

    true
  }

  def main(args: Array[String]): Unit = {
    println(wordPattern(pattern = "abba", str = "dog cat cat dog"))
    println(wordPattern(pattern = "abba", str = "dog cat cat fish"))
    println(wordPattern(pattern = "aaaa", str = "dog cat cat dog"))
    println(wordPattern(pattern = "abba", str = "dog dog dog dog"))
  }
}
