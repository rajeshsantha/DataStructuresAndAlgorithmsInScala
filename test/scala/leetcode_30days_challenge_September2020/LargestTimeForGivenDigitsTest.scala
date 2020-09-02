package scala.leetcode_30days_challenge_September2020

import com.concept.scala.leetcode_30days_challenge_September2020.LargestTimeForGivenDigits.largestTimeFromDigits
import scala.Util.MyScalaTestUtil

class LargestTimeForGivenDigitsTest extends MyScalaTestUtil {
  val EMPTY_STRING: String = ""

  trait Test_LargestTimeFromDigits {
    val testcaseResult1: String = largestTimeFromDigits(Array(2, 9, 9, 9))
    val testcaseResult2: String = largestTimeFromDigits(Array(2, 1, 9, 8))
    val testcaseResult3: String = largestTimeFromDigits(Array(1, 2, 3, 4))
    val testcaseResult4: String = largestTimeFromDigits(Array(4, 2, 6, 1))
  }

  "result set" should "largest possible time from combination of 4 digits" in new Test_LargestTimeFromDigits {
    testcaseResult1 should be(EMPTY_STRING)
    testcaseResult2 should be("19:28")
    testcaseResult3 should be("23:41")
    testcaseResult4 should not be "16:42"
    testcaseResult4 should be("21:46")


  }

}
