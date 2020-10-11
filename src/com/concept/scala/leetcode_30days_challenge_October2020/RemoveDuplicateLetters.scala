package com.concept.scala.leetcode_30days_challenge_October2020

/** *
 *
 * day 11
 *
 * @todo Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.
 * @note This question is the same as 1081: https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
 * @example Example 1:
 *
 *          Input: s = "bcabc"
 *          Output: "abc"
 *          Example 2:
 *
 *          Input: s = "cbacdcbc"
 *          Output: "acdb"
 * @note 1 <= s.length <= 104
 *       s consists of lowercase English letters.
 * @see https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/560/week-2-october-8th-october-14th/3491/
 *      OR
 *      https://leetcode.com/problems/remove-duplicate-letters/
 *
 */
object RemoveDuplicateLetters {
  def main(args: Array[String]): Unit = {
    val s = "bcabc"
    val s1 = "cbacdcbc"
    println(removeDuplicateLetters(s))
    println(removeDuplicateLetters(s1))
  }

  /**
   * Runtime: 460 ms, faster than 100.00% of Scala online submissions for Remove Duplicate Letters.
   * Memory Usage: 53.2 MB, less than 100.00% of Scala online submissions for Remove Duplicate Letters.
   *
   *
   * 289 / 289 test cases passed.
   * Status: Accepted
   * Runtime: 460 ms
   * Memory Usage: 53.2 MB
   *
   */
  def removeDuplicateLetters(s: String): String = {
    val counts = new Array[Int](26)
    val added = new Array[Boolean](26)
    if (s == null) return ""

    s.foreach(character => counts(character - 'a') += 1)
    val stack = scala.collection.mutable.Stack[Char]()


    for (character <- s) {
      val index = character - 'a'
      if (stack.isEmpty) {
        stack.push(character)
        added(index) = true
      }
      else if (!added(index)) {
        while (stack.nonEmpty && stack.head > character && counts(stack.head - 'a') > 0) {
          val cur = stack.pop
          added(cur - 'a') = false
        }
        stack.push(character)
        added(index) = true
      }
      counts(index) -= 1

    }
    val str = new StringBuffer()
    while (stack.nonEmpty) str.insert(0, stack.pop)
    str.toString


  }

}
