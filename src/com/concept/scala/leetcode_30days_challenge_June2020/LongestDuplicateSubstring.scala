package com.concept.scala.leetcode_30days_challenge_June2020
import scala.collection.mutable.{Map, Set}

/** **
  * Day 19
  *
  * @see https://leetcode.com/problems/longest-duplicate-substring/
  *      OR
  *      https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/541/week-3-june-15th-june-21st/3365/
  *
  *
  *      Given a string S, consider all duplicated substrings: (contiguous) substrings of S that occur 2 or more times.  (The occurrences may overlap.)
  *
  *      Return any duplicated substring that has the longest possible length.  (If S does not have a duplicated substring, the answer is "".)
  *
  *
  *
  *      Example 1:
  *
  *      Input: "banana"
  *      Output: "ana"
  *      Example 2:
  *
  *      Input: "abcd"
  *      Output: ""
  *
  *
  *      Note:
  *
  *      2 <= S.length <= 10 pw 5
  *      S consists of lowercase English letters.
  *
  *
  *
  */
object LongestDuplicateSubstring {
  def longestDupSubstring (S: String): String = {

    val len = S.length
    val hash = Array.ofDim[Long](len)
    val power = Array.ofDim[Long](len)
    val base = 29L
    val mod = 1000000007L
    hash(0) = S.head
    power(0) = base


    for (i <- 1 until len) {
      hash(i) = ((hash(i - 1) * base) + S.charAt(i)) % mod
      power(i) = (base * power(i - 1)) % mod
    }

    def hashing (start: Int, end: Int): Long = (hash(end) - (if (start - 1 >= 0) hash(start - 1) else 0) * power(end - start) % mod + mod) % mod


    def fun (width: Int): Int = {
      val map = Map[Long, Set[Int]]()
      var t = hashing(0, width - 1)
      map.put(t, Set[Int]())
      map(t).add(0)
      for (i <- 1 to len - width) {
        t = hashing(i, i + width - 1)
        if (!map.contains(t)) {
          map.put(t, Set[Int]())
        } else {
          for (s <- map(t)) {
            if (S.substring(i, i + width).equals(S.substring(s, s + width))) return i
          }
        }
        map(t).add(i)
      }
      -1
    }

    var lowLen = 1
    var highLen = len - 1
    while (lowLen <= highLen) {
      val midLen = (lowLen + highLen) >> 1
      val tmp = fun(midLen)
      if (tmp == -1) {
        highLen = midLen - 1
      } else {
        lowLen = midLen + 1
      }
    }

    if (highLen == 0) return ""
    val res = fun(highLen)
    if (res == -1) "" else S.substring(res, res + highLen)
  }

  def main (args: Array[String]): Unit = {
    println(longestDupSubstring("banana"))
  }
}
