package com.dsa.scala

object BubbleSort {

  def main (args: Array[String]): Unit = {

    val intArray = Array(20, 35, -15, 7, 55, 1, -22)

    for (lastUnsortedIndex <- intArray.length - 1 until 0 by -1) {

      for (i <- 0 until lastUnsortedIndex by 1) {

        if (intArray(i) > intArray(i + 1)) {
          swap(intArray, i, i + 1)
        }
      }
    }
    for (i <- intArray) println(i)
  }


  def swap (arr: Array[Int], i: Int, j: Int) = {
    if (i == j) {}
    val temp = arr(i)
    arr(i) = arr(j)
    arr(j) = temp
  }
}
