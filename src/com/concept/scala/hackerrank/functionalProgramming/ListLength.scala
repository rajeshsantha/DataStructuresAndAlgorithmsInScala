package com.concept.scala.hackerrank.functionalProgramming

/***
  *
  * @author Rajesh
  * @version 1.0   (FP version to be revised)
  * @todo
  * Count the number of elements in an array without using count, size or length operators (or their equivalents). The input and output portions will be handled automatically by the grader. You only need to write a function with the recommended method signature.
  *  @Input_Format :
  *
  *   A list of  N integers, each on a separate line.
  *
  * @Output_Format:
  *   Output a single integer , the length of the list that was provided as input.
  *
  * @note Use functional programming, avoid imperative programming.
  *
  */
object ListLength extends App {

  //val listArgs = scala.io.Source.stdin.getLines.toList.map(_.trim.toInt)
  val list1 = List(3, 2, 4, 6, 5, 7, 8, 0, 1)

  println(f(list1))

  def f(list: List[Int]): Int = {
    var couter: Int = 0
    for (i <- list) {
      couter += 1
    }
    couter
  }
def f_functional(ls:List[Int])= ls.foldLeft(0){(c,x)=> c+1}

}
