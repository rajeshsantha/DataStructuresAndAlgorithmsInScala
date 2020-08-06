package com.concept.scala.leetcode_30days_challenge_August2020

/** *
  * Day 6
  *
  * @todo Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
  *       Find all the elements that appear twice in this array.
  *       Could you do it without extra space and in O(n) runtime?
  * @example Example:
  *          Input:
  *          [4,3,2,7,8,2,3,1]
  *
  *          Output:
  *          [2,3]
  * @see https://leetcode.com/problems/find-all-duplicates-in-an-array/
  *      OR
  *      https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/549/week-1-august-1st-august-7th/3414/
  */
object FindAllDuplicatesInAnArray {
  def main(args: Array[String]): Unit = {
    println(findDuplicates(Array(4, 3, 2, 7, 8, 2, 3, 1)).mkString(","))
  }

  def findDuplicates(nums: Array[Int]): List[Int] = nums diff nums.distinct toList

  def findDuplicates2(nums: Array[Int]): List[Int] = nums.map(e => (e, nums.count(_ == e))).filter(_._2 == 2).map(_._1).distinct.toList

  def findDuplicates3(nums: Array[Int]): List[Int] = {
    nums.groupBy(identity).collect {
      case (num, count) if count.lengthCompare(1) > 0 => num
    }.toList
  }

  def findDuplicates4(nums: Array[Int]): List[Int] = {
    nums.foldLeft(Map[Int, Int]()) { (acc, n) =>
      val count = acc.get(n).fold(1)(_ + 1)
      acc + (n -> count)
    }.filter(_._2 == 2).keys.toList
  }

  def findDuplicates5(nums: Array[Int]): List[Int] = {
    nums.indices.foreach(index => {
      val indexToUpdate = nums(index) % (nums.length + 1) - 1
      nums(indexToUpdate) = nums(indexToUpdate) + (nums.length + 1)
    })
    nums.indices.filter(index => nums(index) > 2 * (nums.length + 1)).map(_ + 1).toList
  }

}

