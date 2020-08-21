package com.concept.scala.leetcode_30days_challenge_August2020

/** *
  *
  * Day 21
  *
  * @todo Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.
  *       You may return any answer array that satisfies this condition.
  * @see https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/551/week-3-august-15th-august-21st/3431/
  *      OR
  *      https://leetcode.com/problems/sort-array-by-parity/
  * @example Example 1:
  *
  *          Input: [3,1,2,4]
  *          Output: [2,4,3,1]
  *          The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
  * @note 1 <= A.length <= 5000
  *       0 <= A[i] <= 5000
  *
  */
object SortArrayByParity {
  def main(args: Array[String]): Unit = {
    println(sortArrayByParity(Array(3, 1, 2, 4)).mkString(","))
    println(sortArrayByParity_builtin(Array(3, 1, 2, 4)).mkString(","))
  }

  /** *
    *
    * Runtime: 1008 ms, faster than 16.67% of Scala online submissions for Sort Array By Parity.
    * Memory Usage: 77.1 MB, less than 5.55% of Scala online submissions for Sort Array By Parity.
    *
    * 285 / 285 test cases passed.
    * Status: Accepted
    * Runtime: 1008 ms
    * Memory Usage: 77.1 MB
    *
    */
  def sortArrayByParity(A: Array[Int]): Array[Int] = {
    // edge cases
    if (A.length == 1) return A
    if (A.length == 0) return Array()

    //util functions // replaced by implicit class
    //    val getElements: (Array[Int], Int => Boolean) => Array[Int] = (array: Array[Int], condition: Int => Boolean) => array.filter(condition)
    val isEven: Int => Boolean = _ % 2 == 0
    val isOdd: Int => Boolean = _ % 2 != 0

    ((A getElementsIfArray isEven toList) ::: (A getElementsIfArray isOdd toList)).toArray

  }

  implicit class UtilClass[A](array: Array[A]) {
    def getElementsIfArray: (A => Boolean) => Array[A] = (condition: A => Boolean) => array.filter(condition)
  }

  /** *
    * Runtime: 988 ms, faster than 16.67% of Scala online submissions for Sort Array By Parity.
    * Memory Usage: 78.1 MB, less than 5.55% of Scala online submissions for Sort Array By Parity.
    *
    * 285 / 285 test cases passed.
    * Status: Accepted
    * Runtime: 988 ms
    * Memory Usage: 78.1 MB
    *
    */
  def sortArrayByParity_builtin(A: Array[Int]): Array[Int] = {
    val (evenList, oddList) = A.partition(_ % 2 == 0)
    (evenList.toList ::: oddList.toList).toArray

  }
}