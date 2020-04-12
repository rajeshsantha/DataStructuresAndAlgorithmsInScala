package com.concept.scala.leetcode30days

import scala.collection.mutable.ListBuffer


/** *
  * Day 12
  *
  * @see https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/529/week-2/3297/
  *
  *      We have a collection of stones, each stone has a positive integer weight.
  *
  *      Each turn, we choose the two heaviest stones and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:
  *
  *      If x == y, both stones are totally destroyed;
  *      If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
  *      At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)
  *
  *
  *
  *      Example 1:
  *
  *      Input: [2,7,4,1,8,1]
  *      Output: 1
  *      Explanation:
  *      We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
  *      we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
  *      we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
  *      we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.
  *
  *
  *      Note:
  *
  *      1 <= stones.length <= 30
  *      1 <= stones[i] <= 1000
  *
  *
  */
object LastStoneWeight {

  def main (args: Array[String]): Unit = {
    //  val arr = Array(2, 7, 4, 1, 8, 1)
    val arr = Array(2, 2)

    println(s"result  = ${lastStoneWeight_withoutProrityQueue(arr)}")
  }

  /** *
    *
    *
    *
    * 70 / 70 test cases passed.
    * Status: Accepted
    * Runtime: 472 ms
    * Memory Usage: 50.3 MB
    *
    * @param stones with weights assigned
    * @return The weight of last standing stone.
    */
  def lastStoneWeight_withoutProrityQueue (stones: Array[Int]): Int = {
    val listBuffer: scala.collection.mutable.ListBuffer[Int] = ListBuffer()

    for (element <- stones) listBuffer.append(element)

    while (listBuffer.length > 1) {
      //   println(s" length = ${listBuffer.length}")
      val (x, y) = pickMaxTwoInt(listBuffer)
      if (x <= y) {
        if (x == y) {
          // remove x,y elements .  {Done already}
        } else if (x != y) {
          // remove x,y elements .  {Done already}
          listBuffer.append(y - x)

        }
      }
    }
    if (listBuffer.nonEmpty) listBuffer.head else 0
  }

  def pickMaxTwoInt (listBuffer: ListBuffer[Int]): (Int, Int) = {
    val max1 = listBuffer.max
    listBuffer.remove(listBuffer.indexWhere(_ == max1))
    val max2 = listBuffer.max
    listBuffer.remove(listBuffer.indexWhere(_ == max2))

    //(listBuffer.filter(_ != max1).max, max1)

    (max2, max1)

  }

  def lastStoneWeight_with_ProrityQueue (stones: Array[Int]): Int = {

  }


}
