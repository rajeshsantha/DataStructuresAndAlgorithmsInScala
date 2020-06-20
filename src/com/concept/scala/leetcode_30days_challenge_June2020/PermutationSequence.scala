package com.concept.scala.leetcode_30days_challenge_June2020

import scala.collection.mutable.ListBuffer

/** **
  * Day 20
  *
  * @see https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/541/week-3-june-15th-june-21st/3366/
  *      OR
  *      https://leetcode.com/problems/permutation-sequence/
  *
  *      The set [1,2,3,...,n] contains a total of n! unique permutations.
  *
  *      By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
  *
  *      "123"
  *      "132"
  *      "213"
  *      "231"
  *      "312"
  *      "321"
  *      Given n and k, return the kth permutation sequence.
  *
  *      Note:
  *
  *      Given n will be between 1 and 9 inclusive.
  *      Given k will be between 1 and n! inclusive.
  *      Example 1:
  *
  *      Input: n = 3, k = 3
  *      Output: "213"
  *      Example 2:
  *
  *      Input: n = 4, k = 9
  *      Output: "2314"
  *
  *
  *      Accepted
  *      181,778
  *      Submissions
  *      496,798
  *
  *
  */
object PermutationSequence {
  def main (args: Array[String]): Unit = {
    val (n, k) = (3, 3)
    //val (n,k )= (4,9)
    println(getPermutation(n, k))
    println(getPermutation(4, 9))
    println(getPermutationMath(n, k))
    println(getPermutationMath(4, 9))


  }

  /** *
    * Runtime: 1688 ms, faster than 14.29% of Scala online submissions for Permutation Sequence.
    * Memory Usage: 52.5 MB, less than 25.00% of Scala online submissions for Permutation Sequence.
    *
    * 200 / 200 test cases passed.
    * Status: Accepted
    * Runtime: 1688 ms
    * Memory Usage: 52.5 MB
    *
    *
    *
    */
  def getPermutation (n: Int, k: Int): String = {
    // (1 to n).permutations.drop(k-1).toList.head.mkString("")
    //OR

    //(1 to n).permutations.slice(k-1,k).flatten.mkString
    //OR

    (1 to n).permutations.slice(k - 1, k).toList.head.mkString

  }

  /** *
    * Runtime: 808 ms, faster than 14.29% of Scala online submissions for Permutation Sequence.
    * Memory Usage: 59.9 MB, less than 25.00% of Scala online submissions for Permutation Sequence.
    *
    * 200 / 200 test cases passed.
    * Status: Accepted
    * Runtime: 808 ms
    * Memory Usage: 59.9 MB
    *
    */
  def getPermutationMath (n: Int, k: Int): String = {

    val result = new StringBuilder()
    val buffer = ListBuffer[Int]()
    var fact = 1
    (1 to n).foreach { i => fact *= i; buffer.append(i) }


    var l = k - 1
    for (i <- 0 until n) {
      fact /= (n - i)
      val currentIndex = l / fact
      result.append(buffer.remove(currentIndex))
      l -= currentIndex * fact

    }
    result.toString()
  }

}
