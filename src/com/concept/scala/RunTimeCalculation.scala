package com.concept.scala

object RunTimeCalculation {


  def calculateRunTime[Type] (operation: => Type): Float = {
    val start = System.currentTimeMillis
    operation
    val end = System.currentTimeMillis
    (end - start) / 1000.toFloat
  }

}
