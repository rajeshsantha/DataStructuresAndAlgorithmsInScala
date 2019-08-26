package com.concept.scala.sequences

class FibonacciGenerator extends SequenceGenerator {

  val streamFib: Stream[Int] = 1 #:: 1 #:: streamFib.zip(streamFib.tail).map(t => t._1 + t._2)

  override def generate (total: Int): List[Int] = {

    /**
      * Below Code is imperative(non-functional) style since it uses vars and mutable collections like Array
      *
      * val sequence = Array.fill(total)(0)
      * sequence(0) = 1
      * sequence(1) = 1
      * for (n <- 2 until total) {
      * sequence(n) = sequence(n - 1) + sequence(n - 2)
      * }
      *sequence.toList
      */

    /**
      * Below is the functional implementation(i.e avoid loops and mutable arrays )
      * This can be done by Scala Streams
      */
    streamFib.take(total).toList

  }
}
