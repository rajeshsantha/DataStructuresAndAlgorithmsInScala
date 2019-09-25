package com.concept.scala

/**
  * @usecase When you define a function that will work only under specified inputs.
  * @example i)  Divide by zero functionalilty should not accept 0 as denominator
  *          ii) below example function that will not take a list that is less than the size of 2.
  *          
  *
  */
object PartialFunctionVsCompleteFunction {

  val secondElement: PartialFunction[List[Int], Int] = {
    case xs: List[Int] if xs.length >= 2 => xs match {
      case x :: y :: _ => y
    }
  }
  def main(args: Array[String]): Unit = {

    val secondElementOfAList = new PartialFunction[List[Int], Int] {
      def apply(xs: List[Int]) = xs match {
        case x :: y :: _ => y
      }

      def isDefinedAt(xs: List[Int]) = xs.length >= 2

      /*def isDefinedAt(xs: List[Int]) = xs match {
        case x :: y :: _ => true
        case _ => false
      }*/

    }
    val list = List(1)
    println(if (secondElementOfAList.isDefinedAt(list)) secondElementOfAList(list) else "enter the list that have more than 1 element")
    println(secondElement(List(1,2,3,4)))
    println(secondElement(list))

  }
}

