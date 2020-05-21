package com.dsa.scala.functionalDataStructures

import com.concept.scala.RunTimeCalculation

object BinarySearch {
  def main (args: Array[String]): Unit = {

    val arr = Array(1, 2, 4, 6, 8, 9)
    val target = scala.io.StdIn.readInt()

    val iterativeRuntime = RunTimeCalculation.calculateRunTime {
      println(binarySearch_iterative(arr, target) match {
        case None => s"$target doesn't exist in ${arr.mkString("[", ",", "]")}"
        case Some(index) => s"$target exists at index $index"
      })
    }
    println(s" Iterative binaryseach total run time =  $iterativeRuntime seconds OR ${iterativeRuntime * 1000} milliseonds")

    val tailRecursiveuntime = RunTimeCalculation.calculateRunTime {
      println(binarySearch_tailRec(arr, target) match {
        case None => s"$target doesn't exist in ${arr.mkString("[", ",", "]")}"
        case Some(index) => s"$target exists at index $index"
      })
    }
    println(s" tailRecursive binaryseach total run time =  $tailRecursiveuntime seconds OR ${tailRecursiveuntime * 1000} milliseonds")


    /*
    9 exists at index 5
     Iterative binaryseach total run time =  0.13 seconds OR 130.0 milliseonds
    9 exists at index 5
     tailRecursive binaryseach total run time =  0.001 seconds OR 1.0 milliseonds

     */
  }

  def binarySearch_iterative (arr: Array[Int], target: Int): Option[Int] = {
    var (start, end) = (0, arr.length - 1)
    var mid = start + (end - start) / 2

    while (start <= end) {
      mid = start + (end - start) / 2
      if (arr(mid) == target)
        return Some(mid)
      if (arr(mid) > target) end = mid - 1
      else
        start = mid + 1

    }
    None
  }

  def binarySearch_tailRec (arr: Array[Int], target: Int): Option[Int] = {

    def helper (start: Int, end: Int): Option[Int] = {

      if (start > end) return None
      val mid = start + (end - start) / 2

      arr(mid) match {
        case i if i == target => return Some(mid)
        case i if target > i => helper(mid + 1, end)
        case _ => helper(start, mid - 1)
      }
    }

    helper(0, arr.length - 1)
  }

}
