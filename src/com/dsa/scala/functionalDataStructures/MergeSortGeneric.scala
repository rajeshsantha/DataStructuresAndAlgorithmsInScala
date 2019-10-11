package com.dsa.scala.functionalDataStructures

/**
  * @author Rajesh
  * @todo Implement merge sort
  * @note Use functional programming, avoid imperative programming.
  *
  */

object MergeSortGeneric {
  def main (args: Array[String]): Unit = {
    val inputList = List(1, 9, 2, 7, 3, 6, 8, 5)

    val mergetSort_ASC_int = mergeSort((x: Int, y: Int) => x < y) _
    val mergetSort_DESC_int = mergeSort((x: Int, y: Int) => x > y) _
    val mergetSort_ASC_Double = mergeSort((x: Double, y: Double) => x < y) _
    val mergetSort_DESC_Double = mergeSort((x: Double, y: Double) => x > y) _

    val sortedList_ASC = mergetSort_ASC_int(inputList)
    val sortedList_DESC = mergetSort_DESC_int(inputList)

    println(sortedList_ASC)
    println(sortedList_DESC)
    //val inputListDouble = inputList.asInstanceOf[List[Double]]
    val inputListDouble = inputList.map(_.toDouble)

    val sortedList_ASC_Double = mergetSort_ASC_Double(inputListDouble)
    val sortedList_DESC_Double = mergetSort_DESC_Double(inputListDouble)

    println(sortedList_ASC_Double)
    println(sortedList_DESC_Double)


  }


  def mergeSort[T] (min: (T, T) => Boolean)(ls: List[T]): List[T] = {
    def merge (xs: List[T], ys: List[T]): List[T] = {
      (xs, ys) match {
        case (_, Nil) => xs
        case (Nil, _) => ys
        case (x :: xs1, y :: ys1) =>
          if (min(x, y)) x :: merge(xs1, ys) else y :: merge(xs, ys1)
      }
    }

    val n = ls.length / 2
    if (n == 0) ls
    else {
      val (ys, zs) = ls.splitAt(n)
      merge(mergeSort(min)(ys), mergeSort(min)(zs))
    }
  }
}
