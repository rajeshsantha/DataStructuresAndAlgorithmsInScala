package com.concept.scala.leetcode_30days_challenge_October2020

import scala.collection.mutable

/** *
  *
  * @day 1
  * @todo You have a RecentCounter class which counts the number of recent requests within a certain time frame.
  *       Implement the RecentCounter class:
  *       RecentCounter() Initializes the counter with zero recent requests.
  *       int ping(int t) Adds a new request at time t, where t represents some time in milliseconds, and returns the number of requests that has happened in the past 3000 milliseconds (including the new request). Specifically, return the number of requests that have happened in the inclusive range [t - 3000, t].
  *       It is guaranteed that every call to ping uses a strictly larger value of t than the previous call.
  * @example Example 1:
  *
  *          Input
  *          ["RecentCounter", "ping", "ping", "ping", "ping"]
  *          [[], [1], [100], [3001], [3002]]
  *          Output
  *          [null, 1, 2, 3, 3]
  *
  *          Explanation
  *          RecentCounter recentCounter = new RecentCounter();
  * recentCounter.ping(1);     // requests = [1], range is [-2999,1], return 1
  * recentCounter.ping(100);   // requests = [1, 100], range is [-2900,100], return 2
  * recentCounter.ping(3001);  // requests = [1, 100, 3001], range is [1,3001], return 3
  * recentCounter.ping(3002);  // requests = [1, 100, 3001, 3002], range is [2,3002], return 3
  * @see https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/559/week-1-october-1st-october-7th/3480/
  *      OR
  *      https://leetcode.com/problems/number-of-recent-calls/
  *
  */
class RecentCounter {

  private val pings = new mutable.Queue[Int]

  /** **
    * 68 / 68 test cases passed.
    * Status: Accepted
    * Runtime: 1332 ms
    * Memory Usage: 64.3 MB
    *
    */
  def ping(t: Int): Int = {
    pings += t
    while (pings.front < t - 3000) pings.dequeue
    pings.length
  }

}

/**
  * Your RecentCounter object will be instantiated and called as such:
  * var obj = new RecentCounter()
  * var param_1 = obj.ping(t)
  */