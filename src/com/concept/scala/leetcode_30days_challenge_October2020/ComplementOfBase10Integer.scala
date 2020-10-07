package com.concept.scala.leetcode_30days_challenge_October2020

/** **
  *
  * Day 5
  *
  * @todo Every non-negative integer N has a binary representation.  For example, 5 can be represented as "101" in binary, 11 as "1011" in binary, and so on.  Note that except for N = 0, there are no leading zeroes in any binary representation.
  *       The complement of a binary representation is the number in binary you get when changing every 1 to a 0 and 0 to a 1.  For example, the complement of "101" in binary is "010" in binary.
  *       For a given number N in base-10, return the complement of it's binary representation as a base-10 integer.
  * @example Example 1:
  *
  *          Input: 5
  *          Output: 2
  *          Explanation: 5 is "101" in binary, with complement "010" in binary, which is 2 in base-10.
  *          Example 2:
  *
  *          Input: 7
  *          Output: 0
  *          Explanation: 7 is "111" in binary, with complement "000" in binary, which is 0 in base-10.
  *          Example 3:
  *
  *          Input: 10
  *          Output: 5
  *          Explanation: 10 is "1010" in binary, with complement "0101" in binary, which is 5 in base-10.
  * @note 0 <= N < 10 pow 9
  *       This question is the same as 476: https://leetcode.com/problems/number-complement/
  * @see https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/559/week-1-october-1st-october-7th/3484/
  *      OR
  *      https://leetcode.com/problems/complement-of-base-10-integer
  *
  */
object ComplementOfBase10Integer {
  def main(args: Array[String]): Unit = {
    println(bitwiseComplment(5)) //2
    println(bitwiseComplment(7)) //0
    println(bitwiseComplment(10)) //5
    println(bitwiseComplment(1)) //0
    println(bitwiseComplment(0)) //1
    println("***************")
    println(bitwiseComplment1(5)) //2
    println(bitwiseComplment1(7)) //0
    println(bitwiseComplment1(10)) //5
    println(bitwiseComplment1(1)) //0
    println(bitwiseComplment1(0)) //1
    println("***************")
    println(bitwiseComplment3(5)) //2
    println(bitwiseComplment3(7)) //0
    println(bitwiseComplment3(10)) //5
    println(bitwiseComplment3(1)) //0
    println(bitwiseComplment3(0)) //1

    println("***************")
    println(binaryToDecimal2("010"))
    println(binaryToDecimal2("10"))
    println(binaryToDecimal2("110"))

  }

  val binaryToDecimal: String => Double = (binaryString: String) => {
    val arr = binaryString.toCharArray.map(_.toString.toDouble)

    arr.indices.foldLeft(0.0) { (acc, i) => acc + (math.pow(2, i) * arr(i)) }
  }

  def binaryToDecimal2(binaryString: String): Double = {
    val arr: Array[Double] = binaryString.toCharArray.map(_.toString.toDouble).reverse
    var x = 0.0
    for (i <- arr.reverse.indices) x += math.pow(2, i) * arr(i)
    x
  }

  /** *
    * 128 / 128 test cases passed.
    * Status: Accepted
    * Runtime: 400 ms
    * Memory Usage: 49.5 MB
    *
    */
  def bitwiseComplment1(N: Int): Int = Integer.parseInt((N.toBinaryString.map(char => if (char == '1') '0' else '1')), 2)

  def bitwiseComplment(N: Int): Int = binaryToDecimal(N.toBinaryString.map(char => if (char == '1') '0' else '1')) toInt


  /** *
    * 128 / 128 test cases passed.
    * Status: Accepted
    * Runtime: 400 ms
    * Memory Usage: 49.3 MB
    *
    */
  def bitwiseComplment3(N: Int): Int = binaryToDecimal2(N.toBinaryString.map(char => if (char == '1') '0' else '1')).toInt

}
