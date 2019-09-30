package com.concept.scala.NinetyNineProblems

import scala.annotation.tailrec

/**
  * @see Scala 99-Problems
  * @note Scala-99-problems are about,implementing solutions without using builtin method(not applicable to language desgin features)
  *       to understand the language concepts clearly
  * @example scala> length(List(1, 1, 2, 3, 5, 8))
  *          res0: Int = 6
  * @groupname Problem - 4
  *
  */
object NumberOfElements extends App {

  val list1 = List(1, 1, 2, 3, 5, 8)

  val list2 = List(1)

  def builtinListCount[A] (ls: List[A]): Int = ls.length

  // Non-tail recursive function
  def listCountRecursive[A] (ls: List[A]): Int =
    ls match {
      case Nil => 0
      case _ :: tail => 1 + listCountRecursive(tail) // recursion call is not the final action of method, so its not a tail-recursive function
    }

  def listCountTailRecursive[A] (lsx: List[A]): Int = {
    @tailrec
    def countListTailRecHelper[A] (result: Int, ls: List[A]): Int =
      ls match {
        case Nil => result
        case _ :: tail => countListTailRecHelper(result + 1, tail)
      }

    countListTailRecHelper(0, lsx)
  }

  def functionalListCount[A] (ls: List[A]): Int = ls.foldLeft(0) { (x, _) => x + 1 }


  println("Non-tail recursive")

  printResult(list1)
  printResult(list2)
  printResult(List(1)) //  =>  1::Nil

  println("Tail recursive")

  printTailRecResult(list1)
  printTailRecResult(list2)
  printTailRecResult(List(1)) //  =>  1::Nil

  println("functional count")
  printFunctionalCountResult(list1)
  printFunctionalCountResult(list2)
  printFunctionalCountResult(List(1)) //  =>  1::Nil


  def printResult[A] (ls: List[A]) = println(listCountRecursive(ls))

  def printTailRecResult[A] (ls: List[A]) = println(listCountTailRecursive(ls))

  def printFunctionalCountResult[A] (ls: List[A]) = println(functionalListCount(ls))

}
