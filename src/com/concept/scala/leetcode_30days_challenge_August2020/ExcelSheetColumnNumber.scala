package com.concept.scala.leetcode_30days_challenge_August2020

/** *
  *
  * Day 10
  *
  * @todo Given a column title as appear in an Excel sheet, return its corresponding column number.
  *       For example:
  *       A -> 1
  *       B -> 2
  *       C -> 3
  *       ...
  *       Z -> 26
  *       AA -> 27
  *       AB -> 28
  * @example Example 1:
  *
  *          Input: "A"
  *          Output: 1
  *          Example 2:
  *
  *          Input: "AB"
  *          Output: 28
  *          Example 3:
  *
  *          Input: "ZY"
  *          Output: 701
  * @note 1 <= s.length <= 7
  *       s consists only of uppercase English letters.
  *       s is between "A" and "FXSHRXW".
  * @see https://leetcode.com/problems/excel-sheet-column-number/
  *      OR
  *      https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/550/week-2-august-8th-august-14th/3419/
  */
object ExcelSheetColumnNumber {
  def main(args: Array[String]): Unit = {
    println(titleToNumber2("ZY"))
    println(titleToNumber2("AAA"))
  }

/*
  def titleToNumber(s: String): Int = {
    val arr = s.toCharArray.map(_.toInt - 64)
    arr.init.map(_ * 26).sum + arr.last
  }
*/

  /** *
    * 1000 / 1000 test cases passed.
    * Status: Accepted
    * Runtime: 464 ms
    * Memory Usage: 49.9 MB
    *
    */
  def titleToNumber2(s: String): Int = s.foldLeft(0)((accumulator, current) => accumulator * 26 + (current - 'A' + 1))


}
