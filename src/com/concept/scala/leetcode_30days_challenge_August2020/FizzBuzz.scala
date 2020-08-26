package com.concept.scala.leetcode_30days_challenge_August2020

/** *
  *
  * Day 26
  *
  * @todo Write a program that outputs the string representation of numbers from 1 to n.
  *       But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.
  * @example Example:
  *
  *          n = 15,
  *
  *          Return:
  *          [
  *          "1",
  *          "2",
  *          "Fizz",
  *          "4",
  *          "Buzz",
  *          "Fizz",
  *          "7",
  *          "8",
  *          "Fizz",
  *          "Buzz",
  *          "11",
  *          "Fizz",
  *          "13",
  *          "14",
  *          "FizzBuzz"
  *          ]
  * @see https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/552/week-4-august-22nd-august-28th/3437/
  *      OR
  *      https://leetcode.com/problems/fizz-buzz/
  *
  */
object FizzBuzz {

  /** *
    * 8 / 8 test cases passed.
    * Status: Accepted
    * Runtime: 468 ms
    * Memory Usage: 50.3 MB
    *
    */
  def fizzBuzz(n: Int): List[String] = (1 to n).map(logic).map(_.toString).toList

  def main(args: Array[String]): Unit = println(fizzBuzz(28).mkString(","))
//output : 1,2,Fizz,4,Buzz,Fizz,7,8,Fizz,Buzz,11,Fizz,13,14,FizzBuzz,16,17,Fizz,19,Buzz,Fizz,22,23,Fizz,Buzz,26,Fizz,28

  def logic(num: Int): Any = num match {
    case x if isMultipleOf15(x) => "FizzBuzz"
    case x if isMultipleOf3(x) => "Fizz"
    case x if isMultipleOf5(x) => "Buzz"
    case _ => num
  }


  val isMultipleOf3: Int => Boolean = _ % 3 == 0
  val isMultipleOf5: Int => Boolean = _ % 5 == 0
  val isMultipleOf15: Int => Boolean = (i: Int) => i % 5 == 0 && i % 3 == 0

}
