package scala.leetcode_30days_challenge_September2020
import com.concept.scala.leetcode_30days_challenge_September2020.RepeatedSubstringPattern.repeatedSubstringPattern
import scala.Util.MyScalaTestUtil

class RepeatedSubstringPatternTest extends MyScalaTestUtil {


    trait Test_RepeatedSubstringPattern {
      val testcaseResult1:Boolean= repeatedSubstringPattern("aaaaaa")
      val testcaseResult2:Boolean= repeatedSubstringPattern("aba")
      val testcaseResult3:Boolean= repeatedSubstringPattern("abcabcabcabc")
      val testcaseResult4:Boolean= repeatedSubstringPattern("aa")
    }

    "result set" should "return true if there is repeated subtring pattern" in new Test_RepeatedSubstringPattern {
      testcaseResult1 should be(true)
      testcaseResult2 should be(false)
      testcaseResult3 should be(true)
      testcaseResult4 should be (true)


    }


}