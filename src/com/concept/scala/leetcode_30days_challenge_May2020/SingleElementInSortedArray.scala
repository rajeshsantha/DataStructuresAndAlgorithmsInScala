package com.concept.scala.leetcode_30days_challenge_May2020

import com.concept.scala.RunTimeCalculation

/** **
  * Day 12
  *
  * @see https://leetcode.com/explore/featured/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3327/
  *      OR
  *      https://leetcode.com/problems/single-element-in-a-sorted-array/
  *
  *
  *      You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. Find this single element that appears only once.
  *
  *
  *
  *      Example 1:
  *
  *      Input: [1,1,2,3,3,4,4,8,8]
  *      Output: 2
  *      Example 2:
  *
  *      Input: [3,3,7,7,10,11,11]
  *      Output: 10
  *
  *
  *      Note: Your solution should run in O(log n) time and O(1) space.
  *
  *
  *
  *
  */
object SingleElementInSortedArray {


  def main(args: Array[String]): Unit = {
    val nums = Array(1, 1, 2, 3, 3, 4, 4, 8, 8)
    val nums2 = Array(13, 3, 7, 7, 10, 11, 11)


    val BinarySearchRuntime = RunTimeCalculation.calculateRunTime {
      print(singleNonDuplicate_binarySearch(nums) + " ")
      print(singleNonDuplicate_binarySearch(nums2) + " ")
      print(singleNonDuplicate_binarySearch(Array(1, 1, 3, 3, 4)) + " ")
      print(singleNonDuplicate_binarySearch(Array(1)) + " ")
    }
    println(s"\n singleNonDuplicate_binarySearch Intellij IDEA runtime => total run time = seconds $BinarySearchRuntime seconds OR ${BinarySearchRuntime * 1000} milliseonds \n")
    val functionalRuntime = RunTimeCalculation.calculateRunTime {
      print(singleNonDuplicaten_functional(nums) + " ")
      print(singleNonDuplicaten_functional(nums2) + " ")
      print(singleNonDuplicaten_functional(Array(1, 1, 3, 3, 4)) + " ")
      print(singleNonDuplicaten_functional(Array(1)) + " ")
    }

    println(s"\n singleNonDuplicaten_functional Intellij IDEA runtime => total run time = seconds $functionalRuntime seconds OR ${functionalRuntime * 1000} milliseonds \n")
    val functionalRuntime2 = RunTimeCalculation.calculateRunTime {
      print(singleNonDuplicaten_functional2(nums) + " ")
      print(singleNonDuplicaten_functional2(nums2) + " ")
      print(singleNonDuplicaten_functional2(Array(1, 1, 3, 3, 4)) + " ")
      print(singleNonDuplicaten_functional2(Array(1)) + " ")
    }
    println(s"\n singleNonDuplicaten_functional2 Intellij IDEA runtime => total run time = seconds $functionalRuntime2 seconds OR ${functionalRuntime2 * 1000} milliseonds \n ")

    /*
      2 13 4 1
       singleNonDuplicate_binarySearch Intellij IDEA runtime => total run time = seconds 0.603 seconds OR 603.0 milliseonds

      2 13 4 1
       singleNonDuplicaten_functional Intellij IDEA runtime => total run time = seconds 0.109 seconds OR 109.0 milliseonds

      2 13 4 1
       singleNonDuplicaten_functional2 Intellij IDEA runtime => total run time = seconds 0.05 seconds OR 50.0 milliseonds
     */
  }

  /** ***
    *
    * Runtime: 488 ms, faster than 80.00% of Scala online submissions for Single Element in a Sorted Array.
    * Memory Usage: 51.4 MB, less than 100.00% of Scala online submissions for Single Element in a Sorted Array.
    *
    *
    * 12 / 12 test cases passed.
    * Status: Accepted
    * Runtime: 488 ms
    * Memory Usage: 51.4 MB
    *
    */
  def singleNonDuplicate_binarySearch(nums: Array[Int]): Int = {
    // 0 1 2 3 4 5 6 7 8
    val len = nums.length
    var start = 0
    var end = len - 1
    if (len == 1) return nums.head
    while (start <= end) {

      if (nums(start) != nums(start + 1))
        return nums(start)
      if (nums(end) != nums(end - 1))
        return nums(end)


      start += 2
      end -= 2


    }
    0

  }

  /** *
    *
    * 12 / 12 test cases passed.
    * Status: Accepted
    * Runtime: 532 ms
    * Memory Usage: 52.9 MB
    *
    *
    * Runtime: 544 ms, faster than 40.00% of Scala online submissions for Single Element in a Sorted Array.
    * Memory Usage: 52.9 MB, less than 100.00% of Scala online submissions for Single Element in a Sorted Array.
    *
    */
  def singleNonDuplicaten_functional(nums: Array[Int]): Int = {

    if (nums.length == 1) return nums.head

    nums.grouped(2).toList.filter(x => (x.head != x.last) || (x.length == 1)).head.head
  }

  /** *
    *
    * Runtime: 2976 ms, faster than 20.00% of Scala online submissions for Single Element in a Sorted Array.
    * Memory Usage: 52.6 MB, less than 100.00% of Scala online submissions for Single Element in a Sorted Array.
    *
    * 12 / 12 test cases passed.
    * Status: Accepted
    * Runtime: 2976 ms
    * Memory Usage: 52.6 MB
    *
    *
    */
  def singleNonDuplicaten_functional2(nums: Array[Int]): Int = nums.map(i => (i, nums.count(_ == i))).filter(_._2 == 1).head._1


}
