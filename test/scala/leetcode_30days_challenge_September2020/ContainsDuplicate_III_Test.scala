package scala.leetcode_30days_challenge_September2020

import com.concept.scala.leetcode_30days_challenge_September2020.ContainsDuplicate_III.containsNearbyAlmostDuplicate

import scala.Util.MyScalaTestUtil

class ContainsDuplicate_III_Test extends MyScalaTestUtil {

  trait ContainsDupllicate3 {
    val testcaseResult1: Boolean = containsNearbyAlmostDuplicate(Array(1, 5, 9, 1, 5, 9), 2, 3)
    val testcaseResult2: Boolean = containsNearbyAlmostDuplicate(Array(1, 0, 1, 1), 1, 2)
    val testcaseResult3: Boolean = containsNearbyAlmostDuplicate(Array(1, 2, 3, 1), 3, 0)

  }

  "each result" should "follow Contains Duplicate III statement" in new ContainsDupllicate3 {
    testcaseResult1 shouldBe false
    testcaseResult2 should be(true)
    testcaseResult3 should be(true)
  }

}
