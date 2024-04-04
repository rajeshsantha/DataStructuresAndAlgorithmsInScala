package com.concept.scala.leetcodeGeneralProblems

/** *
  * Given two strings s and t, determine if they are isomorphic.
  *
  * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
  *
  * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
  *
  *
  *
  * Example 1:
  *
  * Input: s = "egg", t = "add"
  * Output: true
  * Example 2:
  *
  * Input: s = "foo", t = "bar"
  * Output: false
  * Example 3:
  *
  * Input: s = "paper", t = "title"
  * Output: true
  *
  */
object IsomorphicStrings extends App {
  def isIsomorphic1(s1: String, s2: String): Boolean = {
    val register = scala.collection.mutable.Map[Char, Char]()
    var isIsoMorphicString = false

    if (s1.length != s2.length)
      isIsoMorphicString = false
    else if (s1 == s2)
      isIsoMorphicString = true
    else {
      for (i <- 0 until s1.length) {
        if (!register.contains(s1(i))) {
          register.put(s1(i), s2(i))

        } else {
          isIsoMorphicString = register(s1(i)) == s2(i)
        }
      }
    }
    isIsoMorphicString
  }

}
