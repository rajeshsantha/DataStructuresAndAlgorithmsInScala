package com.concept.scala.sequences

// Giving args directly in class declaration
//This is same as implementing constructor in java.
class ArithmeticGenerator (start: Int, difference: Int) extends SequenceGenerator {

  override def generate (total: Int): List[Int] = {
    /**
      *
      * Below Code is imperative(non-functional) style since it uses vars and mutable collections like Array
      *
      * val sequence = Array.fill(total)(0)
      * var x = start
      * for (n <- 0 until total) {
      * sequence(n) = x
      * x += difference
      * }
      *sequence.toList*/
    /**
      * Below is the functional implementation
      */
    (0 until total).map(n => start + n * difference).toList
  }
}
