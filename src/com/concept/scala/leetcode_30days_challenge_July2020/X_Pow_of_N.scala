package com.concept.scala.leetcode_30days_challenge_July2020

/** *
  *
  * day 16
  *
  * @todo Implement pow(x, n), which calculates x raised to the power n (x pow n).
  * @example Example 1:
  *
  *          Input: 2.00000, 10
  *          Output: 1024.00000
  *          Example 2:
  *
  *          Input: 2.10000, 3
  *          Output: 9.26100
  *          Example 3:
  *
  *          Input: 2.00000, -2
  *          Output: 0.25000
  *          Explanation: 2-2 = 1/22 = 1/4 = 0.25
  * @note -100.0 < x < 100.0
  *       n is a 32-bit signed integer, within the range [−2 pow 31, 2 pow 31 − 1]
  */
object X_Pow_of_N {
  def main(args: Array[String]): Unit = {
    println(myPow_recursive(2.00000, -2))
  }

  def myPow(x: Double, n: Int): Double = scala.math.pow(x, n)


  def myPow_recursive(x: Double, n: Int): Double = {

    def helper(x: Double, n: Int): Double = {
      (x, n) match {
        case (_, 0) => 1
        case (1, _) => 1
        case (base, power) if power % 2 == 0 => helper(base * base, power / 2)
        case (base, power) => base * helper(base * base, power / 2)
      }
    }

    if (n < 0) if (n == Int.MinValue) 1 / myPow_recursive(x, -(n + 1)) / x else 1 / myPow_recursive(x, -n) else helper(x, n)
  }
}
