package com.concept.scala.hackerrank.problemSolving

import scala.io.StdIn

/***
  * @see https://www.hackerrank.com/challenges/grading/problem
  */

object GradingStudents {
  def main(args: Array[String]): Unit = {

//val gradesArray = Array(73,67,38,33)

    val gradesCount = StdIn.readLine.trim.toInt
    val grades = Array.ofDim[Int](gradesCount)
    for (i <- 0 until gradesCount) {
      val gradesItem = StdIn.readLine.trim.toInt
      grades(i) = gradesItem
    }

    val result = gradingStudents(grades)

    println(result.mkString("\n"))

  }


  def gradingStudents(grades: Array[Int]): Array[Int] = {
    val gapFromNext5Multiplier: Int => Int = x=>5-(x % 5)
    val isEligibleGrade: Int => Boolean = _ >= 38
    val isEligibleForIncrement: Int=>Boolean = _ <=2
    val incrementGrade: Tuple2[Int,Int] => Int={
      case (grade:Int, difference:Int) => if(isEligibleGrade(grade) && isEligibleForIncrement(difference))
        grade+difference
      else grade
    }


    grades zip (grades map gapFromNext5Multiplier) map incrementGrade

  }


}
