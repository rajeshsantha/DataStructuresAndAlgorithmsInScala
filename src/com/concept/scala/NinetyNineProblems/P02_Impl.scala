package com.concept.scala.NinetyNineProblems

import scala.annotation.tailrec

/**
  *
  *
  * @see P02
  * @example penultimate(List(1, 1, 2, 3, 5, 8))
  *          res0: Int = 5
  * @groupname Problem - 3
  *
  */

class P02_Impl extends PenultimatElement {
  override def penultimatElement_builtin[T](list: List[T]): T = if (list.nonEmpty) list.init.last else throw new NoSuchElementException

  @tailrec
  final override def penultimatElement_recursive[T](list: List[T]): T =
    list match {
      case penultimatElement :: lastElement :: Nil => penultimatElement
      case head :: tail => penultimatElement_recursive(tail)
      case _ => throw new NoSuchElementException
    }

}

trait PenultimatElement {
  def penultimatElement_builtin[T](list: List[T]): T

  def penultimatElement_recursive[T](list: List[T]): T
}