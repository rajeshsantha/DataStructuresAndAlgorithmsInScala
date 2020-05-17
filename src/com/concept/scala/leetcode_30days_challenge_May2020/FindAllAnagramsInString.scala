package com.concept.scala.leetcode_30days_challenge_May2020

import scala.collection.immutable


/** ***
  * Day 17
  *
  * @see https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3332/
  *      OR
  *      https://leetcode.com/problems/find-all-anagrams-in-a-string/
  *
  *
  *      Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
  *
  *      Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
  *
  *      The order of output does not matter.
  *
  *      Example 1:
  *
  *      Input:
  *      s: "cbaebabacd" p: "abc"
  *
  *      Output:
  *      [0, 6]
  *
  *      Explanation:
  *      The substring with start index = 0 is "cba", which is an anagram of "abc".
  *      The substring with start index = 6 is "bac", which is an anagram of "abc".
  *      Example 2:
  *
  *      Input:
  *      s: "abab" p: "ab"
  *
  *      Output:
  *      [0, 1, 2]
  *
  *      Explanation:
  *      The substring with start index = 0 is "ab", which is an anagram of "ab".
  *      The substring with start index = 1 is "ba", which is an anagram of "ab".
  *      The substring with start index = 2 is "ab", which is an anagram of "ab".
  *
  *
  *
  *
  *
  *
  *
  *
  */
object FindAllAnagramsInString {
  def main (args: Array[String]): Unit = {
    val (s, p) = ("cbaebabacd", "abc")
    println(findAnagrams(s, p))
  }

  def findAnagrams (s: String, p: String): List[Int] = {
    val LS = s.length
    val LP = p.length
    var S = 0
    var P = 0
    val A = scala.collection.mutable.ListBuffer.empty[Int]

    if (LP > LS) return List.empty[Int]

    for (i <- 0 until LP) {
      S = S + s(i).hashCode()
      P = P + p(i).hashCode()
    }
    if (S == P) A.append(0)


    for (i <- LP until LS) {
      S += s(i).hashCode() - s(i - LP).hashCode()
      if (S == P) A.append(i - LP + 1)
    }
    if (A.toList.length == 1 && A.head == 0) return List.empty[Int] else A.toList


  }

  def generateAnagrams (s: String): immutable.Map[Char, Int] = {
    //s.toList.groupMapReduce(identity)(_ => 1)((_ + _))
    //groupMapReduce(identity)(_ => 1)(_ + _) works in scala 2.13
   Map[Char, Int]() //dummy return to avoid compilation error
  }

  /**
    *
    * 36 / 36 test cases passed.
    * Status: Accepted
    * Runtime: 1740 ms
    * Memory Usage: 95 MB
    *
    * @param s
    * @param p
    * @return
    */
  def findAnagrams2 (s: String, p: String): List[Int] = {

    val mappingForP = generateAnagrams(p)
    val (intial, rest) = s.splitAt(p.length())
    val init = generateAnagrams(intial)
    val counts = rest.zip(s.dropRight(p.length()))
      .scanLeft(init)(
        (map, tuple: (Char, Char)) => {

          val (charToAdd, charToDelete) = tuple
          val accumulatedValue = map.getOrElse(charToAdd, 0) + 1
          val appendedMap: Map[Char, Int] = map + (charToAdd -> accumulatedValue)
          val new_map = appendedMap.get(charToDelete) match {
            case Some(1) => appendedMap - charToDelete
            case Some(n) => appendedMap.updated(charToDelete, n - 1)
           // case _ => throw new IllegalArgumentException("Did not expect None")
          }
          new_map
        })
    counts.zipWithIndex
      .filter((tuple) => mappingForP.equals(tuple._1))
      .map(_._2).toList
  }
}

/*
    	LS, LP, S, P, A = len(s), len(p), 0, 0, []
    	if LP > LS: return []
    	for i in range(LP): S, P = S + hash(s[i]), P + hash(p[i])
    	if S == P: A.append(0)
    	for i in range(LP, LS):
    		S += hash(s[i]) - hash(s[i-LP])
    		if S == P: A.append(i-LP+1)
    	return A

 */