package com.concept.scala.leetcodeGeneralProblems

/**
  *
  * @see https://leetcode.com/problems/count-primes/
  *
  *      Count the number of prime numbers less than a non-negative number, n.
  *      *
  *      Example:
  *      *
  *      Input: 10
  *      Output: 4
  *      Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
  *
  *
  *      20 / 20 test cases passed.
  *      Status: Accepted
  *      Runtime: 3912 ms
  *      Memory Usage: 63.6 MB
  *
  *      Runtime: 3912 ms, faster than 15.38% of Scala online submissions for Count Primes.
  *      Memory Usage: 63.6 MB, less than 100.00% of Scala online submissions for Count Primes.
  *
  *
  */
object CountPrimes {

  def countPrimes (n: Int): Int = {


    lazy val primes: Stream[Int] = 2 #:: Stream.from(3).filter(num => !primes.takeWhile(_ <= math.sqrt(num)).exists(num % _ == 0))
    primes.takeWhile(_ < n).length


    /*    val prime_boolean: Array[Boolean] = Array.fill[Boolean](n)(true)
        val len = prime_boolean.length
        for (i <- 2 until len if (i * i) < len) {
          if (prime_boolean(i)) {
            //val j = i
            for (x <- i until len if (x * i) < len) {
              prime_boolean(i * x) = false
            }
          }
        }

        prime_boolean.count(_ == true) - 2*/


  }

  def main (args: Array[String]): Unit = {
    println(countPrimes(10))
  }

}
