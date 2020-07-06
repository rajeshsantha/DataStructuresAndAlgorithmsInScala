package com.concept.scala.leetcode_30days_challenge_July2020

/** *
  * Day 6
  *
  * @todo Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
  *       The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
  *       You may assume the integer does not contain any leading zero, except the number 0 itself.
  * @example Example 1:
  *
  *          Input: [1,2,3]
  *          Output: [1,2,4]
  *          Explanation: The array represents the integer 123.
  *          Example 2:
  *
  *          Input: [4,3,2,1]
  *          Output: [4,3,2,2]
  *          Explanation: The array represents the integer 4321.
  *
  *
  */
object PlusOne {
  def main(args: Array[String]): Unit = {
    val digits = Array(7, 2, 8, 5, 0, 9, 1, 2, 9, 5, 3, 6, 6, 7, 3, 2, 8, 4, 3, 7, 9, 5, 7, 7, 4, 7, 4, 9, 4, 7, 0, 1, 1, 1, 7, 4, 0, 0, 6)
    println(plusOne(digits).mkString("[", ",", "]"))
    println(plusOneByRec(digits).mkString("[", ",", "]"))
  }

  def plusOne(digits: Array[Int]): Array[Int] = {
    (BigInt(digits.mkString) + 1).toString.toArray.map(_ - '0')
  }

  def plusOneByRec(digits: Array[Int]): Array[Int] = {
    def recHelper(digitsList: List[Int], carry: Int): List[Int] = {
      digitsList match {
        case digit :: tail => (digit + carry) % 10 :: recHelper(tail, (digit + carry) / 10)
        case Nil => if (carry == 1) List(1) else List()
      }
    }

    recHelper(digits.reverse.toList, 1).reverse.toArray
  }

}
