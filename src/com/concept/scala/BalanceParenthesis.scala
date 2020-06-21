package com.concept.scala

object BalanceParenthesis {


  def main (args: Array[String]): Unit = {
    println(isBalanced("""" ()))"""))
  }

  def isBalanced (str: String): Boolean = {

    def helper (character: List[Char], flag: Int): Boolean = {

      character match {
        case Nil => flag == 0
        case x :: xs =>
          if (x == '(') helper(xs, flag + 1)
          else if (x == ')') helper(xs, flag - 1)
          else helper(xs, flag)
      }
    }

    helper(str.toList, 0)
  }

}
