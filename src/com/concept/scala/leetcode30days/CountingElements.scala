package com.concept.scala.leetcode30days

/** *
  *
  * Day 7
  *
  * @see https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3289/
  *
  *      Given an integer array arr, count element x such that x + 1 is also in arr.
  *
  *      If there're duplicates in arr, count them seperately.
  *
  *
  *
  *      Example 1:
  *
  *      Input: arr = [1,2,3]
  *      Output: 2
  *      Explanation: 1 and 2 are counted cause 2 and 3 are in arr.
  *      Example 2:
  *
  *      Input: arr = [1,1,3,3,5,5,7,7]
  *      Output: 0
  *      Explanation: No numbers are counted, cause there's no 2, 4, 6, or 8 in arr.
  *      Example 3:
  *
  *      Input: arr = [1,3,2,3,5,0]
  *      Output: 3
  *      Explanation: 0, 1 and 2 are counted cause 1, 2 and 3 are in arr.
  *      Example 4:
  *
  *      Input: arr = [1,1,2,2]
  *      Output: 2
  *      Explanation: Two 1s are counted cause 2 is in arr.
  *
  *
  *      35 / 35 test cases passed.
  *      Status: Accepted
  *      Runtime: 468 ms
  *      Memory Usage: 50.7 MB
  *      Time complexity = O(n2)
  *      Space complexity = O(1) : constant
  *
  */
object CountingElements {
  /** *
    * *      35 / 35 test cases passed.
    * *      Status: Accepted
    * *      Runtime: 468 ms
    * *      Memory Usage: 50.7 MB
    *
    */
  def countElements (array: Array[Int]): Int = {
    var counter = 0
    val newArray = array map (_ + 1) // increment each element in array

    for (i <- newArray indices) {
      if (array contains newArray(i)) counter += 1
    }
    counter
  }


  def main (args: Array[String]): Unit = {
    val arr = Array(1, 2, 3) //2
    val arr1 = Array(1, 3, 2, 3, 5, 0) //3
    val arr2 = Array(1, 1, 2, 2) //2
    val arr3 = Array(1, 1, 3, 3, 5, 5, 7, 7) // 0

    println(countElements(arr))
    println(countElements(arr1))
    println(countElements(arr2))
    println(countElements(arr3))


  }
}
