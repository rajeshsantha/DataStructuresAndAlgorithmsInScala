package com.concept.scala.leetcode_30days_challenge_August2020


/** *
  *
  * Day 17
  *
  * @todo We distribute some number of candies, to a row of n = num_people people in the following way:
  *       We then give 1 candy to the first person, 2 candies to the second person, and so on until we give n candies to the last person.
  *       Then, we go back to the start of the row, giving n + 1 candies to the first person, n + 2 candies to the second person, and so on until we give 2 * n candies to the last person.
  *       This process repeats (with us giving one more candy each time, and moving to the start of the row after we reach the end) until we run out of candies.  The last person will receive all of our remaining candies (not necessarily one more than the previous gift).
  *       Return an array (of length num_people and sum candies) that represents the final distribution of candies.
  * @example Example 1:
  *
  *          Input: candies = 7, num_people = 4
  *          Output: [1,2,3,1]
  *          Explanation:
  *          On the first turn, ans[0] += 1, and the array is [1,0,0,0].
  *          On the second turn, ans[1] += 2, and the array is [1,2,0,0].
  *          On the third turn, ans[2] += 3, and the array is [1,2,3,0].
  *          On the fourth turn, ans[3] += 1 (because there is only one candy left), and the final array is [1,2,3,1].
  *          Example 2:
  *
  *          Input: candies = 10, num_people = 3
  *          Output: [5,2,3]
  *          Explanation:
  *          On the first turn, ans[0] += 1, and the array is [1,0,0].
  *          On the second turn, ans[1] += 2, and the array is [1,2,0].
  *          On the third turn, ans[2] += 3, and the array is [1,2,3].
  *          On the fourth turn, ans[0] += 4, and the final array is [5,2,3].
  * @note 1 <= candies <= 10 pow 9
  *       1 <= num_people <= 1000
  * @see https://leetcode.com/problems/distribute-candies-to-people/
  *      OR
  *      https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/551/week-3-august-15th-august-21st/3427/
  *
  *
  */
object DistributeCandiesToPeople {
  def main(args: Array[String]): Unit = {
    println(distributeCandies(7, 4).mkString(","))
    println(distributeCandies(10, 3).mkString(","))
  }

  /** *
    * 27 / 27 test cases passed.
    * Status: Accepted
    * Runtime: 408 ms
    * Memory Usage: 48.6 MB
    *
    */
  def distributeCandies(candies: Int, num_people: Int): Array[Int] = {
    var candiesInput = candies // making a copy variable with var, since candies is a val
    val arr = new Array[Int](num_people)
    var candiesCount = 1

    while (candiesInput > 0) {
      for (i <- 0 until num_people) {
        if (candiesInput > candiesCount) {
          arr(i) += candiesCount
          candiesInput -= candiesCount
          candiesCount += 1
        } else {
          arr(i) += candiesInput
          candiesInput = 0
        }

      }
    }
    arr
  }

}
