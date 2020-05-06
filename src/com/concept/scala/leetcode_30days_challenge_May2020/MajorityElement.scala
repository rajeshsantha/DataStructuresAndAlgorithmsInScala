package com.concept.scala.leetcode_30days_challenge_May2020

import com.concept.scala.RunTimeCalculation


/** **
  *
  * Day 6
  *
  * @see https://leetcode.com/problems/majority-element/
  *      OR
  *      https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3321/
  *
  *
  *      Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
  *
  *      You may assume that the array is non-empty and the majority element always exist in the array.
  *
  *      Example 1:
  *
  *      Input: [3,2,3]
  *      Output: 3
  *      Example 2:
  *
  *      Input: [2,2,1,1,1,2,2]
  *      Output: 2
  *
  *
  *
  *
  *
  */
object MajorityElement {
  def main(args: Array[String]): Unit = {
    val array = Array(2, 2, 1, 1, 1, 2, 2)

    val majorityElementRuntime = RunTimeCalculation.calculateRunTime(println(majorityElement(array)))
    println(s"majorityElement Intellij IDEA runtime => total run time = seconds $majorityElementRuntime seconds OR ${majorityElementRuntime * 1000} milliseonds")
    val majorityElement2Runtime = RunTimeCalculation.calculateRunTime(println(majorityElement2(array)))
    println(s"majorityElement2 Intellij IDEA runtime => total run time = $majorityElement2Runtime seconds OR ${majorityElement2Runtime * 1000} milliseonds")
    val majorityElement_ByHashMapRuntime = RunTimeCalculation.calculateRunTime(println(majorityElement_ByHashMap(array)))
    println(s"majorityElement_ByHashMap Intellij IDEA runtime => total run time = $majorityElement_ByHashMapRuntime seconds OR ${majorityElement_ByHashMapRuntime * 1000} milliseonds")
    val majorityElement_iterativeRuntime = RunTimeCalculation.calculateRunTime(println(majorityElement_iterative(array)))
    println(s"majorityElement_iterative Intellij IDEA runtime => total run time = $majorityElement_iterativeRuntime seconds OR ${majorityElement_iterativeRuntime * 1000} milliseonds")


    /*
      to Print current method

      def currentMethodName() : String = Thread.currentThread.getStackTrace()(2).getMethodName

      2
      majorityElement => total run time = seconds 0.696 seconds OR 696.0 milliseonds
      2
      majorityElement2 => total run time = 0.002 seconds OR 2.0 milliseonds
      2
      majorityElement_ByHashMap => total run time = 0.01} seconds OR 10.0 milliseonds
      2
      majorityElement_iterative => total run time = 0.002 seconds OR 2.0 milliseonds

     */
  }

  /** **
    * 46 / 46 test cases passed.
    * Status: Accepted
    * Runtime: 596 ms
    * Memory Usage: 59.4 MB
    *
    * majorityElement Intellij IDEA runtime => total run time = seconds 0.69 seconds OR 690.0 milliseonds
    */
  def majorityElement(nums: Array[Int]): Int = {

    //nums.distinct.map(e => (e, nums.count(_ == e))).sortBy(_._2).max._1
    nums.distinct.map(e => (e, nums.count(_ == e))).maxBy(_._2)._1

  }

  /** **
    *
    * 46 / 46 test cases passed.
    * Status: Accepted
    * Runtime: 584 ms
    * Memory Usage: 59.1 MB
    *
    * majorityElement2 Intellij IDEA runtime => total run time = 0.002 seconds OR 2.0 milliseonds
    *
    */
  def majorityElement2(nums: Array[Int]): Int = {

    val sortedArray = nums.sorted
    sortedArray(nums.length / 2)

  }

  /** *
    *
    * 46 / 46 test cases passed.
    * Status: Accepted
    * Runtime: 592 ms
    * Memory Usage: 58.1 MB
    *
    * majorityElement_ByHashMap Intellij IDEA runtime => total run time = 0.011 seconds OR 10.0 milliseonds
    */
  def majorityElement_ByHashMap(nums: Array[Int]): Int = {
    import scala.collection.mutable

    val hashmap = mutable.HashMap[Int, Int]().empty

    for (i <- nums) {
      if (hashmap.contains(i))
        hashmap(i) += 1
      else
        hashmap.put(i, 1)
    }
    hashmap.maxBy(_._2)._1
  }

  /** *
    * Runtime: 548 ms, faster than 92.59% of Scala online submissions for Majority Element.
    * Memory Usage: 59.4 MB, less than 100.00% of Scala online submissions for Majority Element.
    *
    * 46 / 46 test cases passed.
    * Status: Accepted
    * Runtime: 548 ms
    * Memory Usage: 59.4 MB
    *
    * majorityElement_iterative Intellij IDEA runtime => total run time = 0.002 seconds OR 2.0 milliseonds
    */
  def majorityElement_iterative(nums: Array[Int]): Int = {
    var (result, counter) = (0, 0)

    nums
      .foreach { i =>
        if (counter == 0) result = i
        if (i == result) counter += 1 else counter -= 1
      }

    result

  }
}