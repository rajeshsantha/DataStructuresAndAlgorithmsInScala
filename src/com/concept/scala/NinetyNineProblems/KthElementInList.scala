package com.concept.scala.NinetyNineProblems

import scala.annotation.tailrec

/**
  * @see Scala 99-Problems
  * @note Scala-99-problems are about,implementing solutions without using builtin method(not applicable to language desgin features)
  *       to understand the language concepts clearly
  * @example scala> nth(2, List(1, 1, 2, 3, 5, 8))
  *          res0: Int = 2
  * @groupname Problem - 3
  *
  */
object KthElementInList extends App {
  val list = List(1, 1, 2, 3, 5, 8)


  def nthBuiltin[A] (n: Int, ls: List[A]): A =
    if (n >= 0) ls(n)
    else throw new NoSuchElementException

  @tailrec
  def nthRecursive[A] (n: Int, ls: List[A]): A = {
    (n, ls) match {
      case (0, h :: _) => h
      case (n, _ :: tail) => nthRecursive(n - 1, tail)
      case (_, Nil) => println("Input List is empty")
        throw new NoSuchElementException

    }
  }

  println(nthRecursive(2, List()))

}
