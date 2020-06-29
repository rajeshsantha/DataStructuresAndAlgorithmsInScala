package com.dsa.scala.functionalDataStructuresAndAlgorithms


object BubbleSort {
  def main(args: Array[String]): Unit = {
    println(bubbleSort_iterative(Array(77, 76, 55, 34, 23, 12, 9, 8, 7, 6, 5, 4, 3, 2, 1)).mkString("<"))
    println(bubbleSort_functional(Array(77, 76, 55, 34, 23, 12, 9, 8, 7, 6, 5, 4, 3, 2, 1)).mkString("<"))
    println(bubbleSort_functional_optimized(Array(77, 76, 55, 34, 23, 12, 9, 8, 7, 6, 5, 4, 3, 2, 1)).mkString("<"))
    /*
      total number of iterations in bubbleSort_iterative are 196
      1<2<3<4<5<6<7<8<9<12<23<34<55<76<77
      total number of iterations in bubbleSort_functional are 105
      1<2<3<4<5<6<7<8<9<12<23<34<55<76<77
      total number of iterations in bubbleSort_functional_optimized are 105
      1<2<3<4<5<6<7<8<9<12<23<34<55<76<77
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

    for (_ <- 1 until len; j <- 0 until len - 1 if arr(j) > arr(j + 1)) {
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

    for (i <- 1 until len; j <- 0 until (len - i) if arr(j) > arr(j + 1)) {
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
