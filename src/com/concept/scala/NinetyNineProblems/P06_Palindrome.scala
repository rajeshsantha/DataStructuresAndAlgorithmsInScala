package com.concept.scala.NinetyNineProblems
object P06_Palindrome {
  def isPalindrome_builtin[A](ls: List[A]): Boolean = ls == ls.reverse
  def isPalindromeFunctional[T](list: List[T]): Boolean = list ./:(List[T]()) { (a, b) => b :: a } == list
}
