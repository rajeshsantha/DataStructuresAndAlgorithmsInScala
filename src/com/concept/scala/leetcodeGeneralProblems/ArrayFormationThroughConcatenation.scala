package com.concept.scala.leetcodeGeneralProblems

import scala.collection.mutable

/** *
  *
  * @todo You are given an array of distinct integers arr and an array of integer arrays pieces, where the integers in pieces are distinct. Your goal is to form arr by concatenating the arrays in pieces in any order. However, you are not allowed to reorder the integers in each array pieces[i].
  *       Return true if it is possible to form the array arr from pieces. Otherwise, return false.
  * @see https://leetcode.com/problems/check-array-formation-through-concatenation/
  *      OR
  *      https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/579/week-1-january-1st-january-7th/3589/
  *    @example 
  *          Example 1:
  *
  *          Input: arr = [85], pieces = [[85]]
  *          Output: true
  *          Example 2:
  *
  *          Input: arr = [15,88], pieces = [[88],[15]]
  *          Output: true
  *          Explanation: Concatenate [15] then [88]
  *          Example 3:
  *
  *          Input: arr = [49,18,16], pieces = [[16,18,49]]
  *          Output: false
  *          Explanation: Even though the numbers match, we cannot reorder pieces[0].
  *          Example 4:
  *
  *          Input: arr = [91,4,64,78], pieces = [[78],[4,64],[91]]
  *          Output: true
  *          Explanation: Concatenate [91] then [4,64] then [78]
  *          Example 5:
  *
  *          Input: arr = [1,3,5,7], pieces = [[2,4,6,8]]
  *          Output: false
  * @note 1 <= pieces.length <= arr.length <= 100
  *       sum(pieces[i].length) == arr.length
  *       1 <= pieces[i].length <= arr.length
  *       1 <= arr[i], pieces[i][j] <= 100
  *       The integers in arr are distinct.
  *       The integers in pieces are distinct (i.e., If we flatten pieces in a 1D array, all the integers in this array are distinct).
  *
  *
  *
  */
object ArrayFormationThroughConcatenation {

  def main(args: Array[String]): Unit = {
    val pieces = Array(Array(78), Array(4, 64), Array(91))
    val arr = Array(91, 4, 64, 78)
  }

  /** *
    *
    *
    * 82 / 82 test cases passed.
    * Status: Accepted
    * Runtime: 484 ms
    * Memory Usage: 52.4 MB
    *
    * @param arr standard 1D array
    * @param pieces 2D Array containing sub arrays(pieces) to for `arr`
    * @return if `pieces` can form `arr`
    */
  def canFormArray(arr: Array[Int], pieces: Array[Array[Int]]): Boolean = {
    val map = mutable.HashMap[Int, Array[Int]]()

    //form key value pair as below example
    pieces foreach (array => map put(array.head, array))
    // [[a],[b,c,d],[e]] ==> a->[a], b->[b,c,d],e->[e]

    var i = 0
    while (i < arr.length) {
      val currentElement = arr(i)
      if (!(map contains currentElement)) return false
      val arrayPiece = map(currentElement)
      var j = 0
      while (j < arrayPiece.length) {
        if (i >= arr.length || arr(i) != arrayPiece(j)) return false
        i += 1
        j += 1
      }
    }
    true
  }
}
