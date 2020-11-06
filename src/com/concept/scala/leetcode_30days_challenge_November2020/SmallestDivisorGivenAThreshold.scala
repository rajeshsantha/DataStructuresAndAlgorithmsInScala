package com.concept.scala.leetcode_30days_challenge_November2020

/** *
  *
  * day 6
  *
  * @todo Given an array of integers nums and an integer threshold, we will choose a positive integer divisor and divide all the array by it and sum the result of the division. Find the smallest divisor such that the result mentioned above is less than or equal to threshold.
  *       Each result of division is rounded to the nearest integer greater than or equal to that element. (For example: 7/3 = 3 and 10/2 = 5).
  *       It is guaranteed that there will be an answer.
  * @example Example 1:
  *
  *          Input: nums = [1,2,5,9], threshold = 6
  *          Output: 5
  *          Explanation: We can get a sum to 17 (1+2+5+9) if the divisor is 1.
  *          If the divisor is 4 we can get a sum to 7 (1+1+2+3) and if the divisor is 5 the sum will be 5 (1+1+1+2).
  *          Example 2:
  *
  *          Input: nums = [2,3,5,7,11], threshold = 11
  *          Output: 3
  *          Example 3:
  *
  *          Input: nums = [19], threshold = 5
  *          Output: 4
  * @note Constraints:
  *
  *       1 <= nums.length <= 5 * 10 pow 4
  *       1 <= nums[i] <= 10 pow 6
  *       nums.length <= threshold <= 10 pow 6
  * @see https://leetcode.com/explore/challenge/card/november-leetcoding-challenge/564/week-1-november-1st-november-7th/3521/
  *      OR
  *      https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/
  **/
object SmallestDivisorGivenAThreshold {


  /** *
    *
    * 61 / 61 test cases passed.
    * Status: Accepted
    * Runtime: 568 ms
    * Memory Usage: 57.7 MB
    *
    * @param nums
    * @param threshold
    * @return
    */
  def smallestDivisor(nums: Array[Int], threshold: Int): Int = {
    var (begin, end) = (1, 0)
    for (i <- nums.indices)
      end = Math.max(end, nums(i))

    while (begin < end) {
      val mid: Int = (begin + end) / 2
      val sum: Int = divide(nums, mid)
      if (sum > threshold) begin = mid + 1 else end = mid
    }
    end
  }

  def divide(nums: Array[Int], divisor: Int): Int = {
    var count = 0
    for (i <- nums.indices) {
      count = count + nums(i) / divisor
      if (nums(i) % divisor != 0) count = count + 1
    }
    count
  }

  def main(args: Array[String]): Unit = {
    println(smallestDivisor(Array(2, 3, 5, 7, 11), 11)) // output 3
  }

}
