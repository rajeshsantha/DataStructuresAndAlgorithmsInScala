package com.concept.scala.leetcodeGeneralProblems

/** *
  *
  * @see https://leetcode.com/problems/two-sum/
  *
  *
  *
  *      Runtime: 480 ms, faster than 97.76% of Scala online submissions for Two Sum.
  *      Memory Usage: 50.9 MB, less than 25.00% of Scala online submissions for Two Sum.
  *
  *      29 / 29 test cases passed.
  *      Status: Accepted
  *      Runtime: 480 ms
  *      Memory Usage: 50.9 MB
  *
  *
  */
object TwoSum {

  def main(args: Array[String]): Unit = {
    val target = 6
    val nums = Array(3, 3)

    println(twoSum(nums, target).mkString(","))
  }


  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    val count_tracker = scala.collection.mutable.HashMap[Int, Int]()

    for (i <- nums.indices) {

      val differrence = target - nums(i)

      if (count_tracker.contains(differrence))
        return Array(count_tracker(differrence), i)
      else
        count_tracker.put(nums(i), i)

    }
    count_tracker.toArray.map { case (_, y) => y }

  }
}
