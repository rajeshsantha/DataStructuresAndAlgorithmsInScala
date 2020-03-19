package com.concept.scala

/**
  * @example Imperative programming vs functional programming vs using stack
  */
object DecimalToBinary {
  def main (args: Array[String]): Unit = {

    //println(convertDecimalToBinaryString(8))
    //println(convertDecimalToBinaryStack(8))
    println(convertDecimalToBinaryFunctional(183))
    println(convertDecimalToBinaryFunctional(7))


  }


  def convertDecimalToBinaryString (n: Int): String = {
    var x = n
    var binaryString = ""
    while (x > 0) {
      binaryString += (x % 2)
      x = x / 2
    }
    binaryString.reverse

  }

  def convertDecimalToBinaryStack (n: Int): String = {
    var x = n
    var stack = List[Int]()
    while (x > 0) {

      stack = (x % 2) +: stack
      //stack =  stack :+ (x % 2)
      println(stack)
      x = x / 2
    }
    stack.mkString

  }

  def convertDecimalToBinaryFunctional (n: Int): String = {
    Iterator.iterate(n)(_ / 2)
      .takeWhile(_ > 0)
      .map(_ % 2)
      .mkString
      .reverse
  }

}
