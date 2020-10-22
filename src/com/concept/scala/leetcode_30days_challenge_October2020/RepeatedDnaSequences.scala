package com.concept.scala.leetcode_30days_challenge_October2020

/** *
 * Day 17
 *
 * @todo All DNA is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T', for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 *       Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 * @example Example 1:
 *
 *          Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 *          Output: ["AAAAACCCCC","CCCCCAAAAA"]
 *          Example 2:
 *
 *          Input: s = "AAAAAAAAAAAAA"
 *          Output: ["AAAAAAAAAA"]
 * @note 0 <= s.length <= 105
 *       s[i] is 'A', 'C', 'G', or 'T'
 * @see https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/561/week-3-october-15th-october-21st/3498/
 *      OR
 *      https://leetcode.com/problems/repeated-dna-sequences/
 *
 *
 *
 */
object RepeatedDnaSequences extends App{
  /** *
   *
   * 32 / 32 test cases passed.
   * Status: Accepted
   * Runtime: 1144 ms
   * Memory Usage: 92.3 MB
   *
   */
  def findRepeatedDnaSequences(s: String): List[String] = s.sliding(10).toList.groupBy(identity).mapValues(_.size).filter(_._2 > 1).keys.toList

  /** *
   * 32 / 32 test cases passed.
   * Status: Accepted
   * Runtime: 600 ms
   * Memory Usage: 60.8 MB
   *
   */
  def findRepeatedDnaSequences2(s: String): List[String] = {
    if (s.length < 10) return List()
    val hashmap = scala.collection.mutable.HashMap[String, Int]()
    //sliding implementation manually
    for (i <- 10 until s.length + 1) hashmap(s.substring(i - 10, i)) = hashmap.getOrElse(s.substring(i - 10, i), 0) + 1
   
    hashmap.filter(_._2 > 1).keys.toList

  }

}
