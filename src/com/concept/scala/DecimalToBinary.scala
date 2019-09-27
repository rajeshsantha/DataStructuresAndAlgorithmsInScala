package com.concept.scala
/**
* @author Rajesh
*@example Imperative programming vs functional programming
*/
object DecimalToBinary {
  def main(args: Array[String]): Unit = {

    //println(convertDecimalToBinaryString(8))
    //println(convertDecimalToBinaryStack(8))
    println(convertDecimalToBinaryFunctional(183))

  }


  def convertDecimalToBinaryString(n: Int): String = {
    var x = n
    var binaryString = ""
    while (x > 0) {
      binaryString += (x % 2)
      x = x / 2
    }
    binaryString.reverse

  }

  def convertDecimalToBinaryStack(n: Int): String = {
    var x = n
    var stack = List[Int]()
    while (x > 0) {

      stack = (x % 2) +: stack
      //stack =  stack :+ (x % 2)
      println(stack)
      x = x / 2
    }
    //stack.reverse.mkString
    stack.mkString

  }

  def convertDecimalToBinaryFunctional(n: Int): String = {
    val divideBy2 = Iterator.iterate(n)(_ / 2)
    divideBy2
      .takeWhile(_ > 0)
      .map(_ % 2)
      .mkString
      .reverse
  }

}
