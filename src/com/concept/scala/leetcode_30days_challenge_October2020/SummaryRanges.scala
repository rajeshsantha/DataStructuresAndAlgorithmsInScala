package com.concept.scala.leetcode_30days_challenge_October2020


/** **
  * D
  * @todo You are given a sorted unique integer array nums.
  *       Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.
  *       Each range [a,b] in the list should be output as:
  *       "a->b" if a != b
  *       "a" if a == b
  * @example Example 1:
  *
  *          Input: nums = [0,1,2,4,5,7]
  *          Output: ["0->2","4->5","7"]
  *          Explanation: The ranges are:
  *          [0,2] --> "0->2"
  *          [4,5] --> "4->5"
  *          [7,7] --> "7"
  *          Example 2:
  *
  *          Input: nums = [0,2,3,4,6,8,9]
  *          Output: ["0","2->4","6","8->9"]
  *          Explanation: The ranges are:
  *          [0,0] --> "0"
  *          [2,4] --> "2->4"
  *          [6,6] --> "6"
  *          [8,9] --> "8->9"
  *          Example 3:
  *
  *          Input: nums = []
  *          Output: []
  *          Example 4:
  *
  *          Input: nums = [-1]
  *          Output: ["-1"]
  *          Example 5:
  *
  *          Input: nums = [0]
  *          Output: ["0"]
  * @note 0 <= nums.length <= 20
  *       -231 <= nums[i] <= 231 - 1
  *       All the values of nums are unique.
  * @see https://leetcode.com/problems/summary-ranges/
  *      OR
  *      https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/562/week-4-october-22nd-october-28th/3510/
  *
  *
  *
  */
object SummaryRanges {
  def main(args: Array[String]): Unit = {
    println(summaryRanges(Array(0, 2, 3, 4, 6, 8, 9)).mkString(" , "))
  }

  /** *
    * 28 / 28 test cases passed.
    * Status: Accepted
    * Runtime: 436 ms
    * Memory Usage: 50.8 MB
    *
    * @param nums
    * @return
    */
  def summaryRanges(nums: Array[Int]): List[String] = {

    val result = scala.collection.mutable.ListBuffer[String]()
    val len = nums.length
    if (nums.length == 0) return result.toList
    var (start, end) = (nums.head, 0)

    for (i <- 1 until len) {
      if (nums(i) != nums(i - 1) + 1) {
        end = nums(i - 1)
        if (start == end) result.append(start + "") else result.append(start + "->" + end)
        start = nums(i)
      }
    }
    end = nums(len - 1)
    if (start == end) result.append(start + "") else result.append(start + "->" + end)

    result.toList
  }

}
