package com.concept.scala.leetcode_30days_challenge_July2020

/** *
  * Day 12
  *
  * @todo Reverse bits of a given 32 bits unsigned integer.
  * @example Example 1:
  *
  *          Input: 00000010100101000001111010011100
  *          Output: 00111001011110000010100101000000
  *          Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596, so return 964176192 which its binary representation is 00111001011110000010100101000000.
  *
  *          Example 2:
  *
  *          Input: 11111111111111111111111111111101
  *          Output: 10111111111111111111111111111111
  *          Explanation: The input binary string 11111111111111111111111111111101 represents the unsigned integer 4294967293, so return 3221225471 which its binary representation is 10111111111111111111111111111111
  * @note Note that in some languages such as Java, there is no unsigned integer type. In this case, both input and output will be given as signed integer type and should not affect your implementation, as the internal binary representation of the integer is the same whether it is signed or unsigned.
  *       In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 2 above the input represents the signed integer -3 and the output represents the signed integer -1073741825.
  * @see https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/545/week-2-july-8th-july-14th/3388/
  *      OR
  *      https://leetcode.com/problems/reverse-bits/
  *
  */
object ReverseBits {
  def main(args: Array[String]): Unit = {
    reverseBits(43261596)
  }

/*
  def reverseBits1(x: Int): Int = {
    val binString = x.toBinaryString
    Integer.parseInt(binString.reverse + ("0" * (32 - binString.length)), 2)
  }
*/

  // you need treat n as an unsigned value
  def reverseBits(x: Int): Int = {
    var n = x
    var result = 0
    (0 until 31) foreach { _ =>
      println(result + "\t" + n)
      result += (n & 1)
      result = result << 1
      n = n >> 1
    }
    result += (n & 1)
    result
  }

}
