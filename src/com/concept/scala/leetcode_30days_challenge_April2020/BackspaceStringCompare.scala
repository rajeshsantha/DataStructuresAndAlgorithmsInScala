package com.concept.scala.leetcode_30days_challenge_April2020

/** *
  *
  * Day 9
  *
  * @see https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/529/week-2/3291/
  *
  *      Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
  *
  *      Example 1:
  *
  *      Input: S = "ab#c", T = "ad#c"
  *      Output: true
  *      Explanation: Both S and T become "ac".
  *      Example 2:
  *
  *      Input: S = "ab##", T = "c#d#"
  *      Output: true
  *      Explanation: Both S and T become "".
  *      Example 3:
  *
  *      Input: S = "a##c", T = "#a#c"
  *      Output: true
  *      Explanation: Both S and T become "c".
  *      Example 4:
  *
  *      Input: S = "a#c", T = "b"
  *      Output: false
  *      Explanation: S becomes "c" while T becomes "b".
  *      Note:
  *
  *      1 <= S.length <= 200
  *      1 <= T.length <= 200
  *      S and T only contain lowercase letters and '#' characters.
  *      Follow up:
  *
  *      Can you solve it in O(N) time and O(1) space?  {Done}
  *
  *      104 / 104 test cases passed.
  *      Status: Accepted
  *      Runtime: 476 ms
  *      Memory Usage: 52.2 MB
  *
  *
  */
object BackspaceStringCompare {
  def main (args: Array[String]): Unit = {

    val S = "rajeshhx## santhah#"
    val T = "rajeshty##  #sans#tha"

    println(s"input = $S  => output = ${generateString_Stack(S)}")
    println(s"input = $T  => output = ${generateString_Stack(T)}")
    println(s"final result is ${backspaceCompare(S, T)}")

  }

  def backspaceCompare (S: String, T: String): Boolean = {
    generateString_Stack(S) == generateString_Stack(T)
  }

  def generateString (s: String): String = {
    val sb: StringBuilder = new StringBuilder("")
    val len = s.length
    //    val s = "ab##"
    if (s.length > 0) {
      for (i <- 0 until len) {
        if (len - 1 != i) {

          if (s(i) != '#' && s(i + 1) != '#') {
            sb.append(s(i))

          }
        } else {
          if (s(i) != '#')
            sb.append(s(i))
        }

      }


    }
    else {
      sb.append(s)
    }

    sb.toString()
  }

  def generateString_Stack (s: String): String = {
    import scala.collection.mutable

    val stack: mutable.Stack[Char] = mutable.Stack()
    val len = s.length
    //    val s = "ab##"
    if (s.length > 0) {
      for (i <- 0 until len) {
        if (s(i) != '#') stack.push(s(i)) else if (stack.nonEmpty) stack.pop()

      }


    }

    stack.reverse.mkString("")

  }

}
