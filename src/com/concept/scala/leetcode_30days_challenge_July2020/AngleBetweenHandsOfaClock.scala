package com.concept.scala.leetcode_30days_challenge_July2020

/** *
  * Day 14
  *
  * @todo Given two numbers, hour and minutes. Return the smaller angle (in degrees) formed between the hour and the minute hand.
  * @example Input: hour = 12, minutes = 30
  *          Output: 165
  *          Input: hour = 3, minutes = 30
  *          Output: 75
  *          Input: hour = 3, minutes = 15
  *          Output: 7.5
  *          Input: hour = 4, minutes = 50
  *          Output: 155
  *          Input: hour = 12, minutes = 0
  *          Output: 0
  * @note 1 <= hour <= 12
  *       0 <= minutes <= 59
  *       Answers within 10 pow -5 of the actual value will be accepted as correct.
  * @see https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/545/week-2-july-8th-july-14th/3390/
  *      OR
  *      https://leetcode.com/problems/angle-between-hands-of-a-clock/
  *
  *
  */
object AngleBetweenHandsOfaClock {

  def main(args: Array[String]): Unit = {
    println(angleClock(12, 30))
    println(angleClock(3, 30))
    println(angleClock(3, 15))
    println(angleClock(4, 50))
    println(angleClock(12, 0))

    /*
    165.0
    75.0
    7.5
    155.0
    0.0
     */
  }

  /** *
    * 105 / 105 test cases passed.
    * Status: Accepted
    * Runtime: 716 ms
    * Memory Usage: 59.1 MB
    *
    */
  def angleClock_math(hour: Int, minutes: Int): Double = math.min(math.abs(30 * hour - 5.5 * minutes), 360 - math.abs(30 * hour - 5.5 * minutes))

  /** *
    * 105 / 105 test cases passed.
    * Status: Accepted
    * Runtime: 800 ms
    * Memory Usage: 58.4 MB
    *
    */
  def angleClock(hour: Int, minutes: Int): Double = {
    var h = hour

    h = h % 12
    var hoursAngle: Double = (360 / 12) * h
    hoursAngle += (30 * minutes) / 60.0

    val minuteAngle = (360 / 60) * minutes

    if (minuteAngle > hoursAngle) Math.min(minuteAngle - hoursAngle, 360 - minuteAngle + hoursAngle)
    else Math.min(hoursAngle - minuteAngle, 360 - hoursAngle + minuteAngle)
  }
}
