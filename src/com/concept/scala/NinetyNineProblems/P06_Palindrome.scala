package com.concept.scala.NinetyNineProblems
/***
*// P06 (*) Find out whether a list is a palindrome.
*//     Example:
*//     scala> isPalindrome(List(1, 2, 3, 2, 1))
*//     res0: Boolean = true
*
*
*
*
***/
object P06_Palindrome {
  def isPalindrome_builtin[A](ls: List[A]): Boolean = ls == ls.reverse
  def isPalindromeFunctional[T](list: List[T]): Boolean = list ./:(List[T]()) { (a, b) => b :: a } == list
}
