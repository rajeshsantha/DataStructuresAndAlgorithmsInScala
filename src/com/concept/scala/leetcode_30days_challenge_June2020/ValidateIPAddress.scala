package com.concept.scala.leetcode_30days_challenge_June2020

/** **
  * Day 16
  *
  * @see https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/541/week-3-june-15th-june-21st/3362/
  *      OR
  *      https://leetcode.com/problems/validate-ip-address/
  *
  *
  *      Write a function to check whether an input string is a valid IPv4 address or IPv6 address or neither.
  *
  *      IPv4 addresses are canonically represented in dot-decimal notation, which consists of four decimal numbers, each ranging from 0 to 255, separated by dots ("."), e.g.,172.16.254.1;
  *
  *      Besides, leading zeros in the IPv4 is invalid. For example, the address 172.16.254.01 is invalid.
  *
  *      IPv6 addresses are represented as eight groups of four hexadecimal digits, each group representing 16 bits. The groups are separated by colons (":"). For example, the address 2001:0db8:85a3:0000:0000:8a2e:0370:7334 is a valid one. Also, we could omit some leading zeros among four hexadecimal digits and some low-case characters in the address to upper-case ones, so 2001:db8:85a3:0:0:8A2E:0370:7334 is also a valid IPv6 address(Omit leading zeros and using upper cases).
  *
  *      However, we don't replace a consecutive group of zero value with a single empty group using two consecutive colons (::) to pursue simplicity. For example, 2001:0db8:85a3::8A2E:0370:7334 is an invalid IPv6 address.
  *
  *      Besides, extra leading zeros in the IPv6 is also invalid. For example, the address 02001:0db8:85a3:0000:0000:8a2e:0370:7334 is invalid.
  *
  *      Note: You may assume there is no extra space or special characters in the input string.
  *
  *      Example 1:
  *      Input: "172.16.254.1"
  *
  *      Output: "IPv4"
  *
  *      Explanation: This is a valid IPv4 address, return "IPv4".
  *      Example 2:
  *      Input: "2001:0db8:85a3:0:0:8A2E:0370:7334"
  *
  *      Output: "IPv6"
  *
  *      Explanation: This is a valid IPv6 address, return "IPv6".
  *      Example 3:
  *      Input: "256.256.256.256"
  *
  *      Output: "Neither"
  *
  *      Explanation: This is neither a IPv4 address nor a IPv6 address.
  *      Accepted      54,688
  *      Submissions      239,350
  *
  */
object ValidateIPAddress {
  def main (args: Array[String]): Unit = {
    val s1 = "172.16.254.1"
    val s2 = "2001:0db8:85a3:0:0:8A2E:0370:7334"
    val s3 = "256.256.256.256"

    println(validIPAddress(s1))
    println(validIPAddress(s2))
    println(validIPAddress(s3))


  }

  def validIPAddress (IP: String): String = {


    if (IP.contains('.')) {
      val isDotCount3 = IP.count(_ == '.') == 3
      val isArrayLength4 = IP.split('.').length == 4
      val isNoDotAtEnd = IP.last != '.'
      val ipValidation = isValidIPV4(IP)

      if (isDotCount3 && isArrayLength4 && isNoDotAtEnd && ipValidation) return "IPV4"
    }
    if (IP.contains(':')) {
      if (IP.count(_ == ':') == 7 && IP.split(':').length == 8 && isValidIPV6(IP)) return "IPV6"
    }
    return "neither"

  }

  def isValidIPV4 (IP: String): Boolean = {
    val strArr = IP.split('.').map(_.toInt)
    val isValidNumber = strArr.map(_.toString.length).forall(_ <= 3)
    val isValidRange = strArr.forall(x => x >= 0 && x <= 255)
    isValidNumber && isValidRange
  }

  def isValidIPV6 (IP: String): Boolean = {
    val strArr = IP.split(':')
    for (p <- strArr) {
      if (p.length() > 4 || p.isEmpty) return false
      for (c <- p.toCharArray) if (!Character.isDigit(c) && !isValidHexa(c)) return false
    }
    IP.charAt(IP.length() - 1) != ':'
  }

  def isValidHexa (a: Char): Boolean = (a >= 'a' && a <= 'f') || (a >= 'A' && a <= 'F')


}
/*

class Solution {
    private boolean isValidHexa(char a) {
        return (a >= 'a' && a <= 'f') || (a >= 'A' && a <= 'F');
    }
    private boolean isValidIPV4(String IP) {
        String[] a = IP.split("\\.");
        if (a.length != 4) return false;
        for (String p : a) {
            if (p.isEmpty() || p.length() > 1 && p.charAt(0) == '0' || p.length() > 3) return false;
            for (char c : p.toCharArray()) if (!Character.isDigit(c)) return false;
            int value = Integer.parseInt(p);
            if (value < 0 || value > 255) return false;
        }
        return IP.charAt(IP.length() - 1) != '.';
    }
    private boolean isValidIPV6(String IP) {
        String[] a = IP.split(":");
        if (a.length != 8) return false;
        for(String p : a) {
            if (p.length() > 4 || p.isEmpty()) return false;
            for (char c : p.toCharArray()) if (!Character.isDigit(c) && !isValidHexa(c)) return false;
        }
        return IP.charAt(IP.length() - 1) != ':';
    }
    public String validIPAddress(String IP) {
        return IP.contains(".") ? isValidIPV4(IP) ? "IPv4" : "Neither" : isValidIPV6(IP) ? "IPv6" : "Neither";
    }
}
 */