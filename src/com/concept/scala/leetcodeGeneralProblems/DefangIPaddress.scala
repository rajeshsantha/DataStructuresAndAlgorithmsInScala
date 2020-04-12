package com.concept.scala.leetcodeGeneralProblems

/** *
  *
  * @see https://leetcode.com/problems/defanging-an-ip-address
  *
  *
  *      Given a valid (IPv4) IP address, return a defanged version of that IP address.
  *
  *      A defanged IP address replaces every period "." with "[.]".
  *
  *
  *
  *      Example 1:
  *
  *      Input: address = "1.1.1.1"
  *      Output: "1[.]1[.]1[.]1"
  *      Example 2:
  *
  *      Input: address = "255.100.50.0"
  *      Output: "255[.]100[.]50[.]0"
  *
  *
  *      Constraints:
  *
  *      The given address is a valid IPv4 address.
  *
  *
  *      62 / 62 test cases passed.
  *      Status: Accepted
  *      Runtime: 444 ms
  *      Memory Usage: 50 MB
  */
object DefangIPaddress {

  def main (args: Array[String]): Unit = {

    println(defangIPaddr("1.1.1.1")) // prints 1[.]1[.]1[.]1
  }

  def defangIPaddr (address: String): String =
    address split "" map(char => if (char.trim == ".") "[.]" else char) mkString ""


}
