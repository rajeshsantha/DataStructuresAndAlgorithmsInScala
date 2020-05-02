package com.concept.scala.leetcode_30days_challenge_May2020

/** **
  *
  * Day 2
  *
  * @see https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3317/
  *      (OR)
  *      https://leetcode.com/problems/jewels-and-stones/
  *
  *      You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
  *      The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".
  *
  *      Example 1:
  *
  *      Input: J = "aA", S = "aAAbbbb"
  *      Output: 3
  *      Example 2:
  *
  *      Input: J = "z", S = "ZZ"
  *      Output: 0
  *      Note:
  *
  *      S and J will consist of letters and have length at most 50.
  *      The characters in J are distinct.
  *
  *      254 / 254 test cases passed.
  *      Status: Accepted
  *      Runtime: 644 ms
  *      Memory Usage: 61.4 MB
  *
  */
object JewelsAndStones {
  def main(args: Array[String]): Unit = {
    val S = "aA"
    val J = "aAAbbbb"

    println(numJewelsInStones_imperative(S, J))
    println(numJewelsInStones_byFold_functional(S, J))
    println(numJewelsInStones_functional(S, J))

  }

  def numJewelsInStones_imperative(J: String, S: String): Int = {
    val jewels = J.toCharArray
    val stones = S.toCharArray
    var countOfJewerls = 0

    for (i <- stones) if (jewels.contains(i)) countOfJewerls += 1

    countOfJewerls

  }

  def numJewelsInStones_byFold_functional(J: String, S: String): Int = {
    val jewels = J.toCharArray
    val stones = S.toCharArray

    stones.foldLeft(0)((countOfJewels, stone) => if (jewels contains stone) countOfJewels + 1 else countOfJewels)

  }

  def numJewelsInStones_functional(J: String, S: String): Int = {

    val (jewels, stones) = (J.toCharArray, S.toCharArray)

    stones count jewels.contains
  }

}
