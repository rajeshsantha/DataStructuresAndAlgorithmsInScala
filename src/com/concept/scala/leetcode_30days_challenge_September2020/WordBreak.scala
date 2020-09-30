package com.concept.scala.leetcode_30days_challenge_September2020

/** *
  *
  * @todo Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
  * @note The same word in the dictionary may be reused multiple times in the segmentation.
  *       You may assume the dictionary does not contain duplicate words.
  * @example Example 1:
  *
  *          Input: s = "leetcode", wordDict = ["leet", "code"]
  *          Output: true
  *          Explanation: Return true because "leetcode" can be segmented as "leet code".
  *          Example 2:
  *
  *          Input: s = "applepenapple", wordDict = ["apple", "pen"]
  *          Output: true
  *          Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
  *          Note that you are allowed to reuse a dictionary word.
  *          Example 3:
  *
  *          Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
  *          Output: false
  *
  *
  *
  */
object WordBreak {
  def main(args: Array[String]): Unit = {
    val s = "leetcode"
    val wordDict = List("leet", "code")
    println(wordBreak(s, wordDict))
  }

  /** *
    * Runtime: 484 ms, faster than 57.38% of Scala online submissions for Word Break.
    * Memory Usage: 50.5 MB, less than 67.21% of Scala online submissions for Word Break.
    *
    * 43 / 43 test cases passed.
    * Status: Accepted
    * Runtime: 484 ms
    * Memory Usage: 50.5 MB
    *
    */
  def wordBreak(s: String, wordDict: List[String]): Boolean = ((1 to s.length).foldLeft(List(0))((accumulator, index) => if (accumulator.exists(x => wordDict.contains(s.substring(x, index)))) index :: accumulator else accumulator)).head == s.length


}
