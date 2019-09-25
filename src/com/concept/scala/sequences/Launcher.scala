package com.concept.scala.sequences

/**
  * @author Rajesh
  * @version 1.0
  * @usecase lauching object for all sequence problems
  */
object Launcher {
  def main (args: Array[String]): Unit = {

    val apGen = new ArithmeticGenerator(0, 5)
    println(apGen.generateStr(10))

    val gpGen = new GeometricGenerator(1, 5)
    println(gpGen.generateStr(10))

    val fbGen= new FibonacciGenerator()
    println(fbGen.generateStr(10))
  }
}
