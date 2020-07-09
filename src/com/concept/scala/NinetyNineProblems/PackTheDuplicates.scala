package com.concept.scala.NinetyNineProblems

object PackTheDuplicates {
  def pack[A](ls: List[A]): List[List[A]] = {
    if (ls.isEmpty) List(List())
    else {
      val (packed, next) = ls span (_ == ls.head) // one symbol at a time
      if (next == Nil) List(packed) // packing completed as there are no elements left
      else
        packed :: pack(next) // append the already packed list with to-be packed list
    }
  }

  def main(args: Array[String]): Unit = {
    val l = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    pack(l)
  }
}
