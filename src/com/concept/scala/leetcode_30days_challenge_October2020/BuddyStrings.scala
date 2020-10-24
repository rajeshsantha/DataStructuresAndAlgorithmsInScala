package com.concept.scala.leetcode_30days_challenge_October2020

/** *
 *
 * Day 14
 *
 * @todo Given two strings A and B of lowercase letters, return true if you can swap two letters in A so the result is equal to B, otherwise, return false.
 *       Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j and swapping the characters at A[i] and A[j]. For example, swapping at indices 0 and 2 in "abcd" results in "cbad".
 * @example Example 1:
 *
 *          Input: A = "ab", B = "ba"
 *          Output: true
 *          Explanation: You can swap A[0] = 'a' and A[1] = 'b' to get "ba", which is equal to B.
 *          Example 2:
 *
 *          Input: A = "ab", B = "ab"
 *          Output: false
 *          Explanation: The only letters you can swap are A[0] = 'a' and A[1] = 'b', which results in "ba" != B.
 *          Example 3:
 *
 *          Input: A = "aa", B = "aa"
 *          Output: true
 *          Explanation: You can swap A[0] = 'a' and A[1] = 'a' to get "aa", which is equal to B.
 *          Example 4:
 *
 *          Input: A = "aaaaaaabc", B = "aaaaaaacb"
 *          Output: true
 *          Example 5:
 *
 *          Input: A = "", B = "aa"
 *          Output: false
 * @note 0 <= A.length <= 20000
 *       0 <= B.length <= 20000
 *       A and B consist of lowercase letters.
 * @see https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/560/week-2-october-8th-october-14th/3492/
 *      OR
 *      https://leetcode.com/problems/buddy-strings
 *
 */
object BuddyStrings {
  def main(args: Array[String]): Unit = {
    println(buddyStrings("aaaaaaabc", "aaaaaaacb"))
    println(buddyStrings("ab", "babbb"))
  }

  def buddyStrings1(A: String, B: String): Boolean = if (A.length == B.length) {
    val diff = A.indices.filter(i => A(i) != B(i))
    (diff.isEmpty && A.length > A.toSet.size) || (diff.length == 2 && diff.map(A(_)) == diff.map(B(_)).reverse)
  }
  else false

  /** *
   * 29 / 29 test cases passed.
   * Status: Accepted
   * Runtime: 460 ms
   * Memory Usage: 51.3 MB
   */
  def buddyStrings(A: String, B: String): Boolean = {
    if (A.length != B.length) return false
    val result = A.zip(B).filter(c => c._1 != c._2).flatMap(x => x._1.toString + x._2).mkString
    (result.isEmpty && A != A.distinct) || (result.length == 4 && result == result.reverse)

  }

}
