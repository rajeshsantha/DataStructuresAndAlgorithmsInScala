package com.concept.scala.leetcode_30days_challenge_May2020

/** **
  *
  * Day 31
  *
  * @see https://leetcode.com/explore/featured/card/may-leetcoding-challenge/538/week-5-may-29th-may-31st/3346/
  *      OR
  *      https://leetcode.com/problems/edit-distance/
  *
  *      Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
  *
  *      You have the following 3 operations permitted on a word:
  *
  *      Insert a character
  *      Delete a character
  *      Replace a character
  *      Example 1:
  *
  *      Input: word1 = "horse", word2 = "ros"
  *      Output: 3
  *      Explanation:
  *      horse -> rorse (replace 'h' with 'r')
  *      rorse -> rose (remove 'r')
  *      rose -> ros (remove 'e')
  *      Example 2:
  *
  *      Input: word1 = "intention", word2 = "execution"
  *      Output: 5
  *      Explanation:
  *      intention -> inention (remove 't')
  *      inention -> enention (replace 'i' with 'e')
  *      enention -> exention (replace 'n' with 'x')
  *      exention -> exection (replace 'n' with 'c')
  *      exection -> execution (insert 'u')
  *
  *
  *
  */
object EditDistance {
  def main (args: Array[String]): Unit = {
    val word1 = "intention"
    val word2 = "execution"
    println(minDistance(word1, word2))

  }

  /** ***
    * Explanation : https://leetcode.com/problems/edit-distance/discuss/662685/scala-dynamic-programming-explained-100-faster
    * Formula to build the dp table :
    *
    * if characters of string1 and string2 matches then fill dp with it's previous index value
    * i.e dpTable(i)(j) =dpTable(i - 1)(j - 1)(because there will no operations required to replace the same character)
    * if characters of string1 and string2 are different, take the minimun of INSERT,DELETE,REPLACE values and add 1 .
    * //		i.e add 1 to the minimum of
    *
    * dpTable(i)(j - 1) //insert
    * dpTable(i - 1)(j)) //delete
    * dpTable(i - 1)(j - 1)) //replace
    *
    *
    *
    *
    *
    * Runtime: 468 ms, faster than 100.00% of Scala online submissions for Edit Distance.
    * Memory Usage: 50.7 MB, less than 100.00% of Scala online submissions for Edit Distance.
    *
    * 1146 / 1146 test cases passed.
    * Status: Accepted
    * Runtime: 468 ms
    * Memory Usage: 50.7 MB
    *
    */
  def minDistance (word1: String, word2: String): Int = {
    val (len1, len2) = (word1.length, word2.length)
    val dpTable = Array.ofDim[Int](len1 + 1, len2 + 1)

    for (i <- 0 to len1) dpTable(i)(0) = i
    for (i <- 0 to len2) dpTable(0)(i) = i

    /*
        dpTable.foreach { row => row.foreach { x => print(" " + x) }; println }

      Initialization of DP table:

             i n t e n t i o n
             
           0 1 2 3 4 5 6 7 8 9
      e    1 0 0 0 0 0 0 0 0 0
      x    2 0 0 0 0 0 0 0 0 0
      e    3 0 0 0 0 0 0 0 0 0
      c    4 0 0 0 0 0 0 0 0 0
      u    5 0 0 0 0 0 0 0 0 0
      t    6 0 0 0 0 0 0 0 0 0
      i    7 0 0 0 0 0 0 0 0 0
      o    8 0 0 0 0 0 0 0 0 0
      n    9 0 0 0 0 0 0 0 0 0
     */


    for (i <- 1 to len1; j <- 1 to len2)
      dpTable(i)(j) =
        if (word1(i - 1) == word2(j - 1))
          dpTable(i - 1)(j - 1)
        else
          math.min(math.min(dpTable(i)(j - 1), dpTable(i - 1)(j)), dpTable(i - 1)(j - 1)) + 1


    /*
     Final result:

          i n t e n t i o n

        0 1 2 3 4 5 6 7 8 9
   e    1 1 2 3 4 5 6 6 7 1
   x    2 2 2 3 4 5 6 7 7 7
   e    3 3 3 3 4 5 5 6 7 8
   c    4 3 4 3 4 5 6 6 7 8
   u    5 4 4 4 4 5 6 7 7 7
   t    6 5 5 5 5 5 5 6 7 8
   i    7 6 6 6 6 6 6 5 6 7
   o    8 7 7 7 7 7 7 6 5 6
   n    9 1 2 3 4 5 6 7 6 5  <------------- result = 5

     */

    dpTable.last.last

  }

}
