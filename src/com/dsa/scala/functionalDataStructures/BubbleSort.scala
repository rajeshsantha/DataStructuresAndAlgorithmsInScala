package com.dsa.scala.functionalDataStructures


object BubbleSort {
  def main(args: Array[String]): Unit = {

    println(bubbleSort_iterative(Array(3, 7, 1, 4, 9, 5, 2)).mkString("<"))
    println(bubbleSort_functional(Array(3, 7, 1, 4, 9, 5, 2)).mkString("<"))
    println(bubbleSort_functional_optimized(Array(3, 7, 1, 4, 9, 5, 2)).mkString("<"))
    /*
      total number of iterations in bubbleSort_iterative are 36
      1<2<3<4<5<7<9
      total number of iterations in bubbleSort_functional are 10
      1<2<3<4<5<7<9
      total number of iterations in bubbleSort_functional_optimized are 10
      1<2<3<4<5<7<9
    */
  }

  def bubbleSort_iterative(arr: Array[Int]): Array[Int] = {
    var numberOfIterations = 0
    val len = arr.length
    for (i <- 1 until len;
         j <- 0 until len - 1) {
      numberOfIterations += 1
      if (arr(j) > arr(j + 1)) {
        val temp = arr(j)
        arr(j) = arr(j + 1)
        arr(j + 1) = temp
      }
    }
    println(s"total number of iterations in bubbleSort_iterative are $numberOfIterations")
    arr
  }

  def bubbleSort_functional(arr: Array[Int]): Array[Int] = {
    val len = arr.length
    var numberOfIterations = 0
    // using mutable numberOfIterations only to track the number of iterations (which are completely optional)

    for (i <- 1 until len;
         j <- 0 until len - 1 if arr(j) > arr(j + 1)) {
      numberOfIterations += 1
      (arr(j), arr(j + 1)) match {
        case (a, b) if a > b =>
          arr(j) = b
          arr(j + 1) = a
      }
    }
    println(s"total number of iterations in bubbleSort_functional are $numberOfIterations")

    arr
  }

  def bubbleSort_functional_optimized(arr: Array[Int]): Array[Int] = {
    val len = arr.length
    var numberOfIterations = 0
    // using mutable numberOfIterations only to track the number of iterations (which are completely optional)

    for (i <- 1 until len;
         j <- 0 until len - i if arr(j) > arr(j + 1)) {
      numberOfIterations += 1

      (arr(j), arr(j + 1)) match {
        case (a, b) if a > b =>
          arr(j) = b
          arr(j + 1) = a
      }
    }
    println(s"total number of iterations in bubbleSort_functional_optimized are $numberOfIterations")

    arr
  }

}
