package com.concept.scala.leetcode_30days_challenge_August2020

/** **
  *
  * Day 1
  *
  * @todo Given a word, you need to judge whether the usage of capitals in it is right or not.
  *
  *       We define the usage of capitals in a word to be right when one of the following cases holds:
  *
  *       All letters in this word are capitals, like "USA".
  *       All letters in this word are not capitals, like "leetcode".
  *       Only the first letter in this word is capital, like "Google".
  *       Otherwise, we define that this word doesn't use capitals in a right way.
  * @example Example 1:
  *
  *          Input: "USA"
  *          Output: True
  *
  *          Example 2:
  *
  *          Input: "FlaG"
  *          Output: False
  * @note The input will be a non-empty word consisting of uppercase and lowercase latin letters.
  * @see https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/549/week-1-august-1st-august-7th/3409/
  *      OR
  *      https://leetcode.com/problems/detect-capital/
  *
  *
  *
  */
object DetectCapital {
  def main(args: Array[String]): Unit = {
    println(detectCapitalUse("USA"))
    println(detectCapitalUse("FlaG"))
    println(detectCapitalUse("usa"))


    println(detectCapitalUse_with_functions("USA"))
    println(detectCapitalUse_with_functions("FlaG"))
    println(detectCapitalUse_with_functions("usa"))

  }

  /** *
    * Runtime: 632 ms, faster than 100.00% of Scala online submissions for Detect Capital.
    * Memory Usage: 61.7 MB, less than 100.00% of Scala online submissions for Detect Capital.
    *
    * 550 / 550 test cases passed.
    * Status: Accepted
    * Runtime: 632 ms
    * Memory Usage: 61.7 MB
    *
    */
  def detectCapitalUse(word: String): Boolean = {
    /*
    True if,
    1. All uppercase
    2. first letter Uppercase , rest all lower case
    3. all lowercase
     */
    if (word.length <= 1) return true
    (word.head, word.tail) match {
      case (firstLetter, restOfString) if firstLetter.isUpper && restOfString.forall(_.isUpper) || restOfString.forall(!_.isUpper) => true
      case (firstLetter, restOfString) if !firstLetter.isUpper && restOfString.forall(!_.isUpper) => true
      case _ => false
    }

  }

  /** *
    * Runtime: 452 ms, faster than 100.00% of Scala online submissions for Detect Capital.
    * Memory Usage: 50.2 MB, less than 100.00% of Scala online submissions for Detect Capital.
    *
    * 550 / 550 test cases passed.
    * Status: Accepted
    * Runtime: 452 ms
    * Memory Usage: 50.2 MB
    */
  def detectCapitalUse_with_functions(word: String): Boolean = {
    val isLowerCase: Char => Boolean = 97 to 122 contains _
    val isUpperCase: Char => Boolean = 65 to 90 contains _

    if (isLowerCase(word.head)) return word.tail forall isLowerCase
    else if (isUpperCase(word.head)) return word.tail.forall(isLowerCase) || word.tail.forall(isUpperCase)

    false
  }

  /*
      val isLowerCase: Char => Boolean = (c: Char) => c >= 97 && c <= 122
      val isUpperCase: Char => Boolean = (c: Char) => c >= 65 && c <= 90

   */
}
