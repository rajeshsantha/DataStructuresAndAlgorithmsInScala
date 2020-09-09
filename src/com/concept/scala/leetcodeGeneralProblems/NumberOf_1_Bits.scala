package com.concept.scala.leetcodeGeneralProblems

/** **
  *
  * @todo Write a function that takes an unsigned integer and return the number of '1' bits it has (also known as the Hamming weight).
  * @example Example 1:
  *          *
  *          Input: 00000000000000000000000000001011
  *          Output: 3
  *          Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.
  *          Example 2:
  *          *
  *          Input: 00000000000000000000000010000000
  *          Output: 1
  *          Explanation: The input binary string 00000000000000000000000010000000 has a total of one '1' bit.
  *          Example 3:
  *          *
  *          Input: 11111111111111111111111111111101
  *          Output: 31
  *          Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits.
  * @note Note:
  *
  *       Note that in some languages such as Java, there is no unsigned integer type. In this case, the input will be given as signed integer type and should not affect your implementation, as the internal binary representation of the integer is the same whether it is signed or unsigned.
  *       In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 3 above the input represents the signed integer -3.
  *
  *
  *
  */
object NumberOf_1_Bits {
  def main(args: Array[String]): Unit = {
    //  println(hammingWeight(00000000000000000000000000001011))
  }

  /**
    *
    * Runtime: 416 ms, faster than 80.00% of Scala online submissions for Number of 1 Bits.
    * Memory Usage: 48.8 MB, less than 80.00% of Scala online submissions for Number of 1 Bits.
    *
    * 601 / 601 test cases passed.
    * Status: Accepted
    * Runtime: 416 ms
    * Memory Usage: 48.8 MB
    *
    * @param n
    * @return
    */
  def hammingWeight(n: Int): Int = {
    var count = 0
    var num = n
    while (num != 0) {
      if ((num & 1) != 0) count += 1
      num = num >>> 1
    }
    count
  }
}

