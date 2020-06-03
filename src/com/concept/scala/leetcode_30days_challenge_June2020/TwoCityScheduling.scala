package com.concept.scala.leetcode_30days_challenge_June2020

import com.concept.scala.RunTimeCalculation

/** ***
  * Day 3
  *
  * @see https://leetcode.com/explore/featured/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3349/
  *      OR
  *      https://leetcode.com/problems/two-city-scheduling
  *
  *
  *      There are 2N people a company is planning to interview. The cost of flying the i-th person to city A is costs[i][0], and the cost of flying the i-th person to city B is costs[i][1].
  *
  *      Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.
  *
  *
  *
  *      Example 1:
  *
  *      Input: [[10,20],[30,200],[400,50],[30,20]]
  *      Output: 110
  *      Explanation:
  *      The first person goes to city A for a cost of 10.
  *      The second person goes to city A for a cost of 30.
  *      The third person goes to city B for a cost of 50.
  *      The fourth person goes to city B for a cost of 20.
  *
  *      The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.
  *
  *
  *      Note:
  *
  *      1 <= costs.length <= 100
  *      It is guaranteed that costs.length is even.
  *      1 <= costs[i][0], costs[i][1] <= 1000
  *
  *
  *
  *
  *
  */
object TwoCityScheduling {

  /** *
    * 49 / 49 test cases passed.
    * Status: Accepted
    * Runtime: 488 ms
    * Memory Usage: 51.7 MB
    *
    * Runtime: 496 ms, faster than 66.67% of Scala online submissions for Two City Scheduling.
    * Memory Usage: 50.7 MB, less than 100.00% of Scala online submissions for Two City Scheduling.
    *
    */
  def twoCitySchedCost (costs: Array[Array[Int]]): Int = {
    val sortedCosts = costs.sortBy(x => x.head - x.last)
    var result = 0
    val lengthBy2 = costs.length / 2
    for (i <- costs.indices) {
      if (i < lengthBy2)
        result += sortedCosts(i).head
      else
        result += sortedCosts(i).last
    }
    result

  }

  /** *
    * Runtime: 476 ms, faster than 66.67% of Scala online submissions for Two City Scheduling.
    * Memory Usage: 50.7 MB, less than 100.00% of Scala online submissions for Two City Scheduling.
    *
    * 49 / 49 test cases passed.
    * Status: Accepted
    * Runtime: 476 ms
    * Memory Usage: 50.7 MB
    *
    */
  def twoCitySchedCost_Functional (costs: Array[Array[Int]]): Int = {
    val sortedCosts = costs.sortBy(x => x.head - x.last)
    val lengthBy2 = costs.length / 2
    sortedCosts.slice(0, lengthBy2).foldLeft(0)(_ + _.head) + sortedCosts.slice(lengthBy2, lengthBy2 * 2).foldLeft(0)(_ + _.last)
  }

  def main (args: Array[String]): Unit = {
    val costs = Array(Array(10, 20), Array(30, 200), Array(400, 50), Array(30, 20))

    val totalRuntime = RunTimeCalculation.calculateRunTime(println(twoCitySchedCost(costs)))
    println(s" total run time = $totalRuntime seconds OR ${totalRuntime * 1000} milliseonds")
    val totalRuntime2 = RunTimeCalculation.calculateRunTime(println(twoCitySchedCost_Functional(costs)))
    println(s" total run time = $totalRuntime2 seconds OR ${totalRuntime2 * 1000} milliseonds")

    /*
    110
     total run time = 0.47 seconds OR 470.0 milliseonds
    110
     total run time = 0.013 seconds OR 13.0 milliseonds
     */
  }

}
