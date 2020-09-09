package scala.leetcode_30days_challenge_September2020

import com.concept.scala.leetcode_30days_challenge_September2020.CompareVersionNumbers.compareVersion

import scala.Util.MyScalaTestUtil

class CompareVersionNumbersTest extends MyScalaTestUtil {

  "results" should "return result according to version number logic" in new {
    compareVersion(version1 = "0.1", version2 = "1.1") shouldBe -1
    compareVersion(version1 = "1.0.1", version2 = "1") shouldBe 1
    compareVersion(version1 = "7.5.2.4", version2 = "7.5.3") shouldBe -1
    compareVersion(version1 = "1.01", version2 = "1.001") shouldBe 0
    compareVersion(version1 = "1.0", version2 = "1.0.0") shouldBe 0
  }
}
