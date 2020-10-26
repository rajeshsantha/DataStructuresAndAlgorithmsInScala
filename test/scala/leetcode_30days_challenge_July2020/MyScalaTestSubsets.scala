package scala
package leetcode_30days_challenge_July2020


import com.concept.scala.leetcode_30days_challenge_July2020.Subsets._

import scala.Util.MyScalaTestUtil


class MyScalaTestSubsets extends MyScalaTestUtil {

  trait TestSubsetsList {
    val testcaseResult1: List[List[Int]] = subsets(Array(1, 2, 3))
    val testcaseResult2: List[List[Int]] = subsets(Array(1, 2, 3, 3))
    val testcaseResult3: List[List[Int]] = subsets(Array(1))
  }

  
  "result set" should "combinations of all subsets without duplicates" in new TestSubsetsList {
    testcaseResult1 should be(List(List(), List(1), List(2), List(3), List(1, 2), List(1, 3), List(2, 3), List(1, 2, 3)))
    testcaseResult2 should not be (List(List(), List(1), List(2), List(3), List(1, 2), List(1, 3), List(2, 3), List(1, 2, 3)))
    testcaseResult3 should be(List(List(), List(1)))
  }

}
