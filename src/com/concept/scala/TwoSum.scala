package com.concept.scala

/**
  * @author Rajesh
  * @todo Given an array of integers, return indices of the two numbers such that they add up to a specific target.
  *       You may assume that each input would have exactly one solution, and you may not use the same element twice.
  * @example
  * Given nums = [2, 7, 11, 15], target = 9,
  *
  * Because nums[0] + nums[1] = 2 + 7 = 9,
  * return [0, 1]
  */
object TwoSum {

  def main(args: Array[String]): Unit = {
    val nums = Array(1, 7, 8, 2, 5)
    val target = 9

    //val arr =nums.sorted.combinations(2).map(x=>if(x.sum==target) x else 0).filter(x=>x!=0).map(x=>x.asInstanceOf[Array[Int]]).map(c=>(c(0),c(1))).toArray.map(x=>List(x._1,x._2)).flatten
    val itr = twoSumMutiples(nums, target)

    /*for (i <- itr.indices) {
      println(nums.indexOf(itr(i)._1) + " " + nums.indexOf(itr(i)._2))
    }

*/
    itr.map(x => nums.indexOf(x))

  }

  def twoSumMutiples(nums: Array[Int], target: Int): Array[((Int, Int)] =
    nums
      .sorted
      .combinations(2)
      .map(x => if (x.sum == target) x else 0)
      .filter(x => x != 0)
      .map(x => x.asInstanceOf[Array[Int]])
      .map(c => (c(0), c(1)))
      .toArray

  def twoSumSingleSet(nums: Array[Int], target: Int): Array[Int] =
    nums
      .sorted
      .combinations(2)
      .map(x => if (x.sum == target) x else 0)
      .filter(x => x != 0)
      .map(x => x.asInstanceOf[Array[Int]])
      .map(c => (c(0), c(1)))
      .toArray
      .flatMap(x => List(x._1, x._2))


}
