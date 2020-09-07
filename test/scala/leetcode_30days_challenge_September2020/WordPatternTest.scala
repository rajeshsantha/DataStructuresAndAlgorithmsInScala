package scala.leetcode_30days_challenge_September2020

import com.concept.scala.leetcode_30days_challenge_September2020.WordPattern._
import scala.Util.MyScalaTestUtil

class WordPatternTest extends MyScalaTestUtil {
  "result set" should "match with pattern given for string" in new {
    wordPattern(pattern = "abba", str = "dog cat cat dog") should be(true)
    wordPattern(pattern = "abba", str = "dog cat cat fish") should be(false)
    wordPattern(pattern = "aaaa", str = "dog cat cat dog") should be(false)
    wordPattern(pattern = "abba", str = "dog dog dog dog") should be(false)
  }

}
