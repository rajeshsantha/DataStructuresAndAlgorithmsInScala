package com.concept.scala.NinetyNineProblems

import scala.annotation.tailrec

/**
  * 
  * @note Scala-99-problems are about,implementing solutions without using builtin method(not applicable to language desgin features)
  *       to understand the language concepts clearly
  * @example //     scala> reverse(List(1, 9, 2, 3, 5, 8))
  *          //     res0: List[Int] = List(8, 5, 3, 2, 9, 1)
  * @groupname Problem - 5
  *
  */

object ReverseList extends App {

  def reverseListBuiltIn[A] (ls: List[A]): List[A] = ls.reverse


  def reverseList_Recursive[A] (ls: List[A]): List[A] = {
    ls match {
      case Nil => Nil
      case x :: tail => reverseList_Recursive(tail) ::: List(x)
    }
  }

  def reverseList_TailRecursive[A] (ls: List[A]): List[A] = {

    @tailrec
    def reverseList_Helper (finalList: List[A], InputList: List[A]): List[A] =
      InputList match {
        case Nil => finalList
        case x :: tail => reverseList_Helper(x :: finalList, tail)
      }

    reverseList_Helper(Nil, ls)
  }

  def reverseFunctional[A] (ls: List[A]): List[A] = ls./:(List[A]()) { (x, y) => y :: x }


}
