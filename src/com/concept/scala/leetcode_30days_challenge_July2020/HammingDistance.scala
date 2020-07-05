package com.concept.scala.leetcode_30days_challenge_July2020

import com.concept.scala.RunTimeCalculation

/** *
  *
  * Day 5
  *
  * @todo The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
  *       Given two integers x and y, calculate the Hamming distance.
  * @example Input: x = 1, y = 4
  *          Output: 2
  *
  *          Explanation:
  *          1   (0 0 0 1)
  *          4   (0 1 0 0)
  *          ---->  ↑   ↑
  *
  *          The above arrows point to positions where the corresponding bits are different.
  * @note 0 ≤ x, y < 231.
  *
  */
object HammingDistance {


  /** *
    *
    * Runtime: 600 ms, faster than 5.88% of Scala online submissions for Hamming Distance.
    * Memory Usage: 59 MB, less than 7.69% of Scala online submissions for Hamming Distance.
    *
    * 149 / 149 test cases passed.
    * Status: Accepted
    * Runtime: 600 ms
    * Memory Usage: 59 MB
    *
    */
  def hammingDistance(x: Int, y: Int): Int = {
    if (x == y) return 0
    var xString = x.toBinaryString
    var yString = y.toBinaryString
    val (xlen, ylen) = (xString.length, yString.length)

    if (xlen < ylen) xString = padZeros(x, ylen) else if (xlen > ylen) yString = padZeros(y, xlen)

    var result = 0
    for (i <- xString.indices) if (xString(i) != yString(i)) result += 1
    result

  }

  // def padZeros(str: String, len: Int): String = s"%0${len}d".format(str.toInt) // works only within int range

  def padZeros(num: Int, len: Int): String = num.toBinaryString.reverse.padTo(len, '0').reverse

  /** *
    * Runtime: 708 ms, faster than 5.88% of Scala online submissions for Hamming Distance.
    * Memory Usage: 58.4 MB, less than 7.69% of Scala online submissions for Hamming Distance.
    *
    *
    * 149 / 149 test cases passed.
    * Status: Accepted
    * Runtime: 708 ms
    * Memory Usage: 58.4 MB
    *
    */
  def hammingDistanceByLibrary(x: Int, y: Int): Int = (x ^ y).toBinaryString.count(_ == '1')


  def main(args: Array[String]): Unit = {
    val x = 1
    val y = 4
    //    println(hammingDistance(x, y))
    // println(hammingDistance(4, 14))
    //    println(hammingDistance(4, 6))
    //    println(hammingDistance(297630147, 147274294))
    //01101100010111001110001100010
    //10001101111010111100111000011
    //147274294


    val stringManipulationRuntime = RunTimeCalculation.calculateRunTime {
      println(hammingDistance(4, 6))
      println(hammingDistance(297630147, 147274294))
    }
    val bitManipulationRuntime = RunTimeCalculation.calculateRunTime {
      println(hammingDistanceByLibrary(4, 6))
      println(hammingDistanceByLibrary(297630147, 147274294))
    }
    println(s"  stringManipulationRuntime   => = $stringManipulationRuntime seconds OR ${stringManipulationRuntime * 1000} milliseonds")
    println(s"  bitManipulationRuntime   => = $bitManipulationRuntime seconds OR ${bitManipulationRuntime * 1000} milliseonds")

    /*
    1
    17
    1
    17
  stringManipulationRuntime   => = 0.393 seconds OR 393.0 milliseonds
  bitManipulationRuntime   => = 0.001 seconds OR 1.0 milliseonds

     */

  }
}
