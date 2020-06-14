package com.concept.scala.leetcodeGeneralProblems

/** *
  *
  * @see https://leetcode.com/problems/shuffle-the-array/
  *
  *      Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
  *
  *      Return the array in the form [x1,y1,x2,y2,...,xn,yn].
  *
  *
  *
  *      Example 1:
  *
  *      Input: nums = [2,5,1,3,4,7], n = 3
  *      Output: [2,3,5,4,1,7]
  *      Explanation: Since x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 then the answer is [2,3,5,4,1,7].
  *      Example 2:
  *
  *      Input: nums = [1,2,3,4,4,3,2,1], n = 4
  *      Output: [1,4,2,3,3,2,4,1]
  *      Example 3:
  *
  *      Input: nums = [1,1,2,2], n = 2
  *      Output: [1,2,1,2]
  *
  */
object ShuffleTheArray {
  def main (args: Array[String]): Unit = {
    val nums = Array(1, 2, 3, 4, 4, 3, 2, 1)
    val n = 4

    println(shuffle(nums, n).mkString(" "))
  }

  /** **
    * Runtime: 772 ms, faster than 39.29% of Scala online submissions for Shuffle the Array.
    * Memory Usage: 69.4 MB, less than 100.00% of Scala online submissions for Shuffle the Array.
    *
    *
    * 53 / 53 test cases passed.
    * Status: Accepted
    * Runtime: 772 ms
    * Memory Usage: 69.4 MB
    *
    */
  def shuffle (nums: Array[Int], n: Int): Array[Int] = (0 until 2 * n).map(x => if (x % 2 == 0) nums(x / 2) else nums(n + x / 2)).toArray


}
