package com.concept.scala.leetcode30days


/***
  * Day 1
  *
  * @see https://leetcode.com/explore/other/card/30-day-leetcoding-challenge/528/week-1/3283/
  *
  * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
  *
  * Note:
  *
  * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
  *
  * Example 1:
  *
  * Input: [2,2,1]
  * Output: 1
  * Example 2:
  *
  * Input: [4,1,2,1,2]
  * Output: 4
  */
object SingleNumber {

  def singleNumber(nums: Array[Int]): Int = {

    nums.groupBy(identity).mapValues(_.length).filter(t => t._2 <=1).keys.head
  }

  def main(args: Array[String]): Unit = {
    println(singleNumber(Array(4,1,2,1,2)))
    println(singleNumberByReduce(Array(4,1,2,1,2)))
    println(singleNumberByHashSet(Array(4,1,2,1,2)))
  }

  def singleNumberByReduce(nums:Array[Int]):Int ={

    nums.reduce(_ ^ _)

  }

  def singleNumberByHashSet(nums:Array[Int]):Int ={
    import scala.collection.immutable.HashSet


    nums.foldLeft(HashSet.empty[Int])((hashSet :HashSet[Int],currentValue:Int)=>{
      if(hashSet.contains(currentValue))
        hashSet - currentValue
      else
        hashSet + currentValue
    }).head



  }

}
