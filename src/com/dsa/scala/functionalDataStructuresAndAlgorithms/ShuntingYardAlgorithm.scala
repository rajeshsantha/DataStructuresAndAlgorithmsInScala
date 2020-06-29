package com.dsa.scala.functionalDataStructuresAndAlgorithms

/**
  * @usecase Shunting Yard algorithm implentation to solve infix to postfix convertion AND postfix evaluation
  * @example
  * Input string is => 5*(2-3)
  * expected output => 523-*
  *
  */

object ShuntingYardAlgorithm {
  def main(args: Array[String]): Unit = {

    println(convertToPostFix("3+4*6".split("").toList).mkString(" "))
    println(convertToPostFix("5*(2-3)".split("").toList).mkString(" "))
    println(convertToPostFix("5*(8-4)".split("").toList).mkString(" "))


    println(evaluateInfix("5 * 2 + 3"))
    println(evaluateInfix("3 + 4 * 6"))
    println(evaluateInfix("5 * ( 2 / 3 )"))
    //println(evaluateInfix( convertToPostFix("5*(2-3)".split("").toList).mkString(" ")))


    /*

        3 4 6 * +
        5 2 3 _ *
        5 8 4 _ *
        13.0
        27.0
        3.333333333333333
     */

  }

  def evaluateInfix(infix: String): Double = evaluatePostFix(convertToPostFix(infix.split(" ").toList))

  def convertToPostFix(infix: List[String]): List[String] = {
    val postFix = List[String]()
    val stack = List[String]()

    val (postFixExpression, stackOfOps) = infix.foldLeft((postFix, stack)) { (tuple, token) =>
      val (postfixqueue, operatorStack) = tuple
      token match {
        case "(" => (postfixqueue, "(" +: operatorStack)
        case ")" => {
          val (beforeTheBracket, rest) = operatorStack.span(operator => operator != "(")
          (postfixqueue ::: beforeTheBracket, rest.tail)
        }
        case "-" =>
          val (higher, lower) = operatorStack.span(op => "/*+-".contains(op))
          (postfixqueue ::: higher, "_" +: lower)
        case "+" =>
          val (higher, lower) = operatorStack.span(op => "/*+".contains(op))
          (postfixqueue ::: higher, "+" +: lower)
        case "*" =>
          val (higher, lower) = operatorStack.span(op => "/*".contains(op))
          (postfixqueue ::: higher, "*" +: lower)
        case "/" =>
          val (higher, lower) = operatorStack.span(op => "/".contains(op))
          (postfixqueue ::: higher, "/" +: lower)
        case _ => (postfixqueue :+ token, operatorStack) //if number


      }
    }
    postFixExpression ::: stackOfOps
  }

  def evaluatePostFix(postFix: List[String]): Double = {

    val nStack = postFix.foldLeft(List[Double]()) { (numberStack, token) =>
      (numberStack, token) match {
        case (a :: b :: t, "+") => (b + a) +: t
        case (a :: b :: t, "*") => (b * a) +: t
        case (a :: b :: t, "/") => (b / a) +: t
        case (a :: b :: t, "-") => (b - a) +: t

        case (_, n) =>
          // println("value to convert to number is " + n)
          n.toDouble +: numberStack

      }

    }
    nStack.head
  }
}
