package com.dsa.scala

object SelectionSort {

  def main (args: Array[String]): Unit = {

    val intArray = Array(20, 35, -15, 7, 55, 1, -22)
    println("**********SelectionSort Scala**********")

    println("Unsorted array")
    for (i <- intArray) println(i)

    for (lastUnsortedIndex <- intArray.length - 1 until 0 by -1) {
      var largest = 0

      for (i <- 0 until lastUnsortedIndex by 1) {
        if (intArray(i) > intArray(largest)) {
          largest=i
        }
      }
      swap(intArray,largest,lastUnsortedIndex)
    }
    println(" Sorted array - By SelectionSort ")
    for (i <- intArray) println(i)
  }

  def swap (arr: Array[Int], i: Int, j: Int) = {
    if (i == j) {}
    val temp = arr(i)
    arr(i) = arr(j)
    arr(j) = temp
  }
}
