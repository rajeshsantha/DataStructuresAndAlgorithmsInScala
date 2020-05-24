package com.dsa.scala.functionalDataStructures

object BubbleSort {
  def main(args: Array[String]): Unit = {
    val array = Array(3, 7, 1, 4, 9, 5, 2)
    println(bubbleSort_iterative(array).mkString("<"))
    println(bubbleSort_functional(array).mkString("<"))
    println(bubbleSort_functional_optimized(array).mkString("<"))

  }

  def bubbleSort_iterative(arr: Array[Int]): Array[Int] = {
    val len = arr.length
    for (i <- 1 until len;
         j <- 0 until len - 1) {

      if (arr(j) > arr(j + 1)) {
        val temp = arr(j)
        arr(j) = arr(j + 1)
        arr(j + 1) = temp
      }
    }
    arr
  }

  def bubbleSort_functional(arr: Array[Int]): Array[Int] = {
    val len = arr.length
    for (_ <- 1 until len;
         j <- 0 until len - 1 if arr(j) > arr(j + 1)) {

      (arr(j), arr(j + 1)) match {
        case (a, b) if a > b =>
          arr(j) = a
          arr(j + 1) = b
      }
    }
    arr
  }

  def bubbleSort_functional_optimized(arr: Array[Int]): Array[Int] = {
    val len = arr.length

    for (i <- 1 until len;
         j <- 0 until len - i if arr(j) > arr(j + 1)) {

      (arr(j), arr(j + 1)) match {
        case (a, b) if a > b =>
          arr(j) = a
          arr(j + 1) = b
      }
    }
    arr
  }

}
