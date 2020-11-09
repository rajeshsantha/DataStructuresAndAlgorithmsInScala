package com.concept.scala.NinetyNineProblems

import scala.annotation.tailrec

/**
  *
  *
  * @see P01
  * @example last(List(1, 1, 2, 3, 5, 8))
  *          res0: Int = 8
  * @groupname Problem - 3
  *
  */
class P01_Impl extends P01_FindTheLastElement {

  override def last_builtin[T](list: List[T]): T = list.last

  /*
  override def last_iterative[T](list: List[T]): T = {
    val lengthOfList = list.length

    if (lengthOfList == 0) throw new NoSuchElementException("No elements in list")
    if (lengthOfList == 1) return list.head
    type T = Int
    //var lastElement = list(lengthOfList - 1)// direct access
    for (i <- list.indices if i == lengthOfList - 1) return list(i)
  }

*/
  @tailrec
  final override def last_functional[T](list: List[T]): T = list match {
    case element :: Nil => element
    case _ :: tail => last_functional(tail)
    case _ => throw new NoSuchElementException("No elements in list")
  }

}

trait P01_FindTheLastElement {
  def last_builtin[T](list: List[T]): T

  // def last_iterative[T](list: List[T]): T

  def last_functional[T](list: List[T]): T
}
