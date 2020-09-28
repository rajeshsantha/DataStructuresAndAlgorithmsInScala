package com.concept.scala.NinetyNineProblems

object FindDupliates {
  def main(args: Array[String]): Unit = {
    println(findDuplicates(List(1, 7, 2, 4, 1, 5, 7, 8, 3)).mkString(",")) //1,7
    println(findDuplicatesByGrouping(List(1, 7, 2, 4, 1, 5, 7, 8, 3)).mkString(",")) //1,7
    println(findDuplicatesBuiltin(List(1, 7, 2, 4, 1, 5, 7, 8, 3)).mkString(",")) //1,7
    println(findDuplicateFirstDuplicateInConstanttime(List(1, 7, 2, 4, 1, 5, 7, 8, 3)))
  }

  def findDuplicates(list: List[Int]): List[Int] = {
    val tracker = scala.collection.mutable.HashMap[Int, Int]()
    //build trakcer with hashmap
    list.foreach { i => if (!tracker.contains(i)) tracker.put(i, 1) else tracker.update(i, tracker(i) + 1) }
    //get the duplicates
    tracker.filter(_._2 > 1).keys.toList
  }
  def findDuplicatesByGrouping(list: List[Int]): List[Int] =
    list.groupBy(identity).map(x => (x._1, x._2.length)).filter(_._2 > 1).keys.toList

  def findDuplicatesBuiltin(list: List[Int]): List[Int] = list.distinct diff list

  def findFirstDuplicateInConstanttime(arr: List[Int]): Int = {
    val offset = 1
    var a = 0
    for (i <- arr.indices) a = a ^ (arr(i) + offset) ^ i
    a-offset
  }

}
