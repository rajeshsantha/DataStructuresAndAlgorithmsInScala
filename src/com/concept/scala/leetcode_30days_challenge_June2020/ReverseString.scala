package com.concept.scala.leetcode_30days_challenge_June2020

import com.concept.scala.RunTimeCalculation

/** **
  * Day 4
  *
  * @see https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3350/
  *      OR
  *      https://leetcode.com/problems/reverse-string/
  *
  *
  *      Write a function that reverses a string. The input string is given as an array of characters char[].
  *
  *      Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
  *
  *      You may assume all the characters consist of printable ascii characters.
  *
  *
  *
  *      Example 1:
  *
  *      Input: ["h","e","l","l","o"]
  *      Output: ["o","l","l","e","h"]
  *      Example 2:
  *
  *      Input: ["H","a","n","n","a","h"]
  *      Output: ["h","a","n","n","a","H"]
  *      Hint #1
  *      The entire logic for reversing a string is based on using the opposite directional two-pointer approach!
  *
  *
  *
  */
object ReverseString {

  def main(args: Array[String]): Unit = {

    val inputString = "asdcvbnm,lpokijuhygtfdsdfghjkdshcsenvdkhbkjhgfduiuyhgtfrtmk,omhjngfbvdgbh,ukmyjnhbsd kjszfdnvkja weacnernhqerncaafu"
    val totalRuntime_functional = RunTimeCalculation.calculateRunTime(println(reverseString_functional(inputString.toCharArray).mkString(",")))
    val totalRuntime_tailRec = RunTimeCalculation.calculateRunTime(println(reverseString_tailRec(inputString.toCharArray).mkString(",")))
    val totalRuntime_Iterative = RunTimeCalculation.calculateRunTime(println(reverseString_Iterative(inputString.toCharArray)))
    val totalRuntime_BuiltIn = RunTimeCalculation.calculateRunTime(println(reverseString_builtIn(inputString.toCharArray).mkString(",")))

    println(s" totalRuntime_functional => = $totalRuntime_functional seconds OR ${totalRuntime_functional * 1000} milliseonds")
    println(s" totalRuntime_tailRec => = $totalRuntime_tailRec seconds OR ${totalRuntime_tailRec * 1000} milliseonds")
    println(s" totalRuntime_Iterative =>  = $totalRuntime_Iterative seconds OR ${totalRuntime_Iterative * 1000} milliseonds")
    println(s" totalRuntime_BuiltIn =>  = $totalRuntime_BuiltIn seconds OR ${totalRuntime_BuiltIn * 1000} milliseonds")
    /*
       totalRuntime_functional => = 0.607 seconds OR 607.0 milliseonds
       totalRuntime_tailRec => = 0.01 seconds OR 10.0 milliseonds
       totalRuntime_Iterative =>  = 0.041 seconds OR 41.0 milliseonds
       totalRuntime_BuiltIn =>  = 0.001 seconds OR 1.0 milliseonds
     */
    println(s" Used Memory: ${(Runtime.getRuntime.totalMemory - Runtime.getRuntime.freeMemory) / 1048576} MB" +
      s"\n Total Memory: ${Runtime.getRuntime.totalMemory / 1048576} MB \n " +
      s"Free Memory: ${Runtime.getRuntime.freeMemory / 1048576} MB")
    /*
       Used Memory: 19 MB
       Total Memory: 178 MB
       Free Memory: 159 MB
    */
  }

  def reverseString_functional(s: Array[Char]): Array[Char] = s.foldLeft(List[Char]()) { (x, y) => y :: x }.toArray


  def reverseString_tailRec(s: Array[Char]): Array[Char] = {
    type A = Char

    def reverseList_Helper(finalList: List[A], InputList: List[A]): List[A] =
      InputList match {
        case Nil => finalList
        case x :: tail => reverseList_Helper(x :: finalList, tail)
      }

    reverseList_Helper(Nil, s.toList).toArray
  }

  /** **
    * Runtime: 600 ms, faster than 74.42% of Scala online submissions for Reverse String.
    * Memory Usage: 55.3 MB, less than 100.00% of Scala online submissions for Reverse String.
    *
    * 478 / 478 test cases passed.
    * Status: Accepted
    * Runtime: 600 ms
    * Memory Usage: 55.3 MB
    *
    *
    */
  def reverseString_Iterative(s: Array[Char]): Unit = {

    val length = s.length

    for (i <- 0 until length / 2) {
      val temp = s(i)
      s(i) = s(length - 1 - i)
      s(length - 1 - i) = temp
    }
    // println(s.mkString(","))
  }

  def reverseString_builtIn(s: Array[Char]): Array[Char] = s.reverse


}
